package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {
	// Method to create logger object.
	public static Logger getLogger(Class<?> classname) {
		return LogManager.getLogger(classname);
	}

}
