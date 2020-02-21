package com.sosen.service.communication;

import java.util.Properties;

import com.sosen.service.utils.ServiceException;


public class CommunicationManager {
	private static final CommunicationManager MANAGER = new CommunicationManager();
	private Communicator communicator;
	
	private CommunicationManager() {
		
	}
	
	public static CommunicationManager getManager() {
		return MANAGER;
	}
	
	public void initializeCommunicator(Properties configuration) {
		String communicationClass = (String) configuration.get("communication.class");
		if (communicationClass == null) {
			throw new ServiceException("communication.class is not mentioned in service config");
		}
		
		try {
			Class<Communicator> clazz = (Class<Communicator>) Class.forName(communicationClass);
			communicator = clazz.newInstance();
		} catch (Exception e) {
			throw new ServiceException("Error while creating the communicator");
		}
	}
	
	public Communicator getCommunicator() {
		return communicator;
	}
}
