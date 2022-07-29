package com.pg.tide.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Logging {
	
	private Logger log = LogManager.getLogger(Logging.class.getName()); 
	
	public Logger getLog()
	{
		return this.log;
	}

}
