package com.sosen.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class ServiceConfigurationManager {

	private static final ServiceConfigurationManager manager = new ServiceConfigurationManager();

	private Properties configuration = new Properties();

	private ServiceConfigurationManager() {
		try {
			readConfiguration();
		} catch (Exception e) {
			throw new RuntimeException("Error while reading configuration, exiting...", e);
		}
	}

	private void readConfiguration() throws Exception {
		configuration.load(new FileReader(new File("src/main/resources/service.config")));
	}

    public Properties getConfiguration() {
		return configuration;
	}

	public static ServiceConfigurationManager getManager() {
		return manager;
	}
}
