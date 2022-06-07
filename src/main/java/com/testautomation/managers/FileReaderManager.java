package com.testautomation.managers;

import com.testautomation.dataProviders.ConfigFileReader;
import com.testautomation.dataProviders.JsonDataReader;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReader jsonDataReader;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public ConfigFileReader getConfigReader() {
		return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
	}

	public JsonDataReader getJsonReader() {
		return (jsonDataReader == null) ? jsonDataReader = new JsonDataReader() : jsonDataReader;
	}
}
