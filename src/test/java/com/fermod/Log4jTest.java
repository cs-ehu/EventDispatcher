package com.fermod;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTest {

	private static final Logger LOGGER = LogManager.getLogger(Log4jTest.class);

	public static void main(String[] args) {

		while(true) {
			LOGGER.trace("Trace log message");
			LOGGER.debug("Debug log message");
			LOGGER.info("Info log message");
			LOGGER.warn("Warn log message");
			LOGGER.error("Error log message");
			LOGGER.fatal("Fatal log message");
			System.out.println();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}

	}

}
