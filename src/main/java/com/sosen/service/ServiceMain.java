package com.sosen.service;

import java.util.Properties;

import com.sosen.service.communication.CommunicationManager;

public class ServiceMain {
	
	
	public static void main(String[] args) {
		new ServiceMain().start();
		
	}

	public void start() {
		Properties configuration = ServiceConfigurationManager.getManager().getConfiguration();
		System.out.println("Loaded configurations...");
		CommunicationManager.getManager().initializeCommunicator(configuration);
		System.out.println("Communicator initialized...");
		CommunicationManager.getManager().getCommunicator().start();
		System.out.println("Communicator started on port " + ServiceConfigurationManager.getManager().getConfiguration().getProperty("service.port"));
	}
	
	public void stop() {
		CommunicationManager.getManager().getCommunicator().stop();
	}
}
