package com.sosen.service.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.sosen.service.ServiceConfigurationManager;
import com.sosen.service.utils.ServiceException;

public abstract class DataProvider {

	protected String executeApi(String api) {
		api += ServiceConfigurationManager.getManager().getConfiguration().getProperty("api.key");
		HttpURLConnection conn = null;
		try {
			URL url = new URL(api);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			StringBuilder sb = new StringBuilder();
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				sb.append(output);
			}

			return sb.toString();

		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
}
