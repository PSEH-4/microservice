package com.sosen.service.communication;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sosen.service.AbstractService;
import com.sosen.service.ServiceConfigurationManager;
import com.sosen.service.utils.ServiceException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

@SuppressWarnings("restriction")
public class HttpCommunicator implements Communicator {
	private final HttpServer server;
	private Gson gson = new GsonBuilder().create();

	public HttpCommunicator() throws Exception {
		server = HttpServer.create(new InetSocketAddress(Integer
				.parseInt(ServiceConfigurationManager.getManager().getConfiguration().getProperty("service.port"))), 0);
		server.createContext("/executeapi", new HttpHandler() {
			public void handle(HttpExchange exchg) throws IOException {
				System.out.println(exchg.getRequestURI().getQuery());
				
			    Map<String, String> params = new HashMap<String, String>();
			    for (String param : exchg.getRequestURI().getQuery().split("&")) {
			        String[] entry = param.split("=");
			        if (entry.length > 1) {
			            params.put(entry[0], entry[1]);
			        }else{
			            params.put(entry[0], "");
			        }
			    }
				
				Object output = executeServiceAPI(params);
				String response = gson.toJson(output);
				System.out.println("Sending output " + response);
				exchg.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
				exchg.sendResponseHeaders(200, response.getBytes().length);
				OutputStream os = exchg.getResponseBody();
				os.write(response.getBytes());
				os.close();
			}
		});
	}

	private Object executeServiceAPI(Map<String, String> attributes) {
		try {
			AbstractService service = loadServiceClass();
			String methodName = (String) attributes.get("method");
			Method method = service.getClass().getMethod(methodName, String.class);
			return method.invoke(service, attributes.get("args"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	private AbstractService loadServiceClass() throws Exception {
		String serviceName = ServiceConfigurationManager.getManager().getConfiguration().getProperty("service.main");
		System.out.println("Loading class " + serviceName);
		return (AbstractService) Class.forName(serviceName).newInstance();
	}

	public void start() {
		server.start();
	}
	
	public void stop() {
		server.stop(0);
	}	

	class CommandExecutor extends ThreadPoolExecutor {
		public CommandExecutor() {
			super(1, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
		}
	}
}
