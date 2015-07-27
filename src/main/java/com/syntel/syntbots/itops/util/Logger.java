/* Copyright (C) 2015 Syntel and/or its affiliates. All rights reserved.
 *
 */	
/**
 * This is common logger class that internally uses Log4j Logger.
 * @author SureshBabuKonduru
 * @version 1.0
 */
package com.syntel.syntbots.itops.util;

import org.apache.log4j.Priority;


@SuppressWarnings("serial")
public class Logger implements java.io.Serializable {
    private transient org.apache.log4j.Logger logger = null;
    String className="";   
    private boolean debugEnabled = false;
    private boolean infoEnabled = true;
    private boolean warnEnabled = true;
    private boolean errorEnabled = true;
    private boolean fatalEnabled = true;
    private static boolean printEnabled = false;
    
    /**
     *
     * @param name
     */

    /**
     *
     *
     */
    private Logger () {};

    /**
     *
     * @param clazz
     * @return
     */
    public static Logger getLogger(Class clazz) {
    	Logger myLogger = null;
	    if (clazz != null) {
	        myLogger = new Logger();
	        myLogger.logger = org.apache.log4j.Logger.getLogger(clazz);
	        myLogger.setClassName(clazz.getName());
	    }
	    return myLogger;
    }

    /**
     *
     * @param classname
     */
    public void setClassName(String classname) {
	    this.className = classname;
	    return;
    }

    /**
     *
     * @return
     */
    public static Logger getRootLogger() {
	    Logger myLogger =  null;
	    myLogger = new Logger();
	    return myLogger;
    }

    /**
     *
     * @param name
     * @return
     */
    public static Logger getLogger(String name) {
	    Logger myLogger = null;
	    if( name != null ) {
	    	myLogger = new Logger();
	        myLogger.logger = org.apache.log4j.Logger.getLogger(name);
	        myLogger.setClassName(name);
	    }
	    return myLogger;
    }

    /**
     *
     * @param message
     */
	public void debug(java.lang.Object message)  {
		  if (logger == null) {
            logger = org.apache.log4j.Logger.getLogger("NullLogger");
            logger.error ("Logger was reset to null. Creating null logger");
          }
          if ((logger != null) && (debugEnabled)){
        	  
		      logger.debug(message);
          }
	 }

	 /**
	  *
	  * @param message
	  * @param t
	  */
	 public void debug(java.lang.Object message, java.lang.Throwable t) {
		  if (logger == null) {
            logger = org.apache.log4j.Logger.getLogger("NullLogger");
            logger.error ("Logger was reset to null. Creating null logger");
          }
          if ((logger != null) && (debugEnabled)){
		      logger.debug(message, t);
          }
	 }

	 /**
	  *
	  * @param message
	  */
	 public void error(java.lang.Object message) {
		  if (logger == null) {
            logger = org.apache.log4j.Logger.getLogger("NullLogger");
            logger.error ("Logger was reset to null. Creating null logger");
          }
          if ((logger != null) && (errorEnabled)){
		      logger.error(message);
          }
	 }

	 /**
	  *
	  * @param message
	  * @param t
	  */
	 public void error(java.lang.Object message, java.lang.Throwable t) {
		 if (logger == null) {
            logger = org.apache.log4j.Logger.getLogger("NullLogger");
            logger.error ("Logger was reset to null. Creating null logger");
          }
          if ((logger != null) && (errorEnabled)){
		      logger.error(message, t);
          }
	 }

	 /**
	  *
	  * @param message
	  */
	 public void fatal(java.lang.Object message) {
		  if (logger == null) {
            logger = org.apache.log4j.Logger.getLogger("NullLogger");
            logger.error ("Logger was reset to null. Creating null logger");
          }
          if ((logger != null) && (fatalEnabled)){
		      logger.fatal(message);
          }
	 }

	 /**
	  *
	  * @param message
	  * @param t
	  */
	 public void fatal(java.lang.Object message, java.lang.Throwable t) {
		  if (logger == null) {
            logger = org.apache.log4j.Logger.getLogger("NullLogger");
            logger.error ("Logger was reset to null. Creating null logger");
          }
          if ((logger != null) && (fatalEnabled)){
		      logger.fatal(message, t);
          }
	 }

	 /**
	  *
	  * @param message
	  */
	 public void info(java.lang.Object message)         {
          if (logger == null) {
            logger = org.apache.log4j.Logger.getLogger("NullLogger");
            logger.error ("Logger was reset to null. Creating null logger");
          }
          if ((logger != null) && (infoEnabled))
          {
		      logger.info(message);
          }
	 }

	 /**
	  *
	  * @param message
	  * @param t
	  */
	 public void info(java.lang.Object message, java.lang.Throwable t) {
		  if (logger == null) {
            logger = org.apache.log4j.Logger.getLogger("NullLogger");
            logger.error ("Logger was reset to null. Creating null logger");
          }
          if ((logger != null) && (infoEnabled)){
		      logger.info(message,t);
          }
	 }

	 /**
	  *
	  * @param message
	  */
	 public void warn(java.lang.Object message)           {
		  if (logger == null) {
            logger = org.apache.log4j.Logger.getLogger("NullLogger");
            logger.error ("Logger was reset to null. Creating null logger");
          }
          if ((logger != null) && (warnEnabled)){
		      logger.warn(message);
          }
	 }

	 /**
	  *
	  * @param message
	  * @param t
	  */
	 public void warn(java.lang.Object message, java.lang.Throwable t) {
        if (logger == null) {
            logger = org.apache.log4j.Logger.getLogger("NullLogger");
            logger.error ("Logger was reset to null. Creating null logger");
        }
          if ((logger != null) && (warnEnabled)){
          logger.warn(message,t);
          }
	 }

	public void log(String str, int level, Object obj, Throwable t) {
		 if (logger == null) {
            logger = org.apache.log4j.Logger.getLogger("NullLogger");
            logger.error ("Logger was reset to null. Creating null logger");
        }
        if (logger != null){
         logger.log(str, Priority.toPriority(level), obj, t);
        }
	}


      private static transient org.apache.log4j.Logger defaultLogger = org.apache.log4j.Logger.getLogger("Sytem.out");;
      public static void println (String msg) {
         if (defaultLogger == null) {
            defaultLogger = org.apache.log4j.Logger.getLogger("NullLogger");
            defaultLogger.error ("Logger was reset to null. Creating null logger");
         }
         if ((defaultLogger != null) && (printEnabled)){
		      defaultLogger.info(msg);
         }
      }

      public static void println (Object msg) {
         if (defaultLogger == null) {
            defaultLogger = org.apache.log4j.Logger.getLogger("NullLogger");
            defaultLogger.error ("Logger was reset to null. Creating null logger");
         }
         if ((defaultLogger != null) && (printEnabled)){
             defaultLogger.info(msg);
         }
      }


       public static void println (int a) {
         if (defaultLogger == null) {
            defaultLogger = org.apache.log4j.Logger.getLogger("NullLogger");
            defaultLogger.error ("Logger was reset to null. Creating null logger");
         }
         if ((defaultLogger != null) && (printEnabled)){
              defaultLogger.info("int:" + a);
         }
       }


       public static void println (float b) {
         if (defaultLogger == null) {
            defaultLogger = org.apache.log4j.Logger.getLogger("NullLogger");
            defaultLogger.error ("Logger was reset to null. Creating null logger");
         }
         if ((defaultLogger != null) && (printEnabled)){
              defaultLogger.info("float:" + b);
         }
       }

}
