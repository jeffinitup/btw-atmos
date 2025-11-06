package eu.ha3.matmos.conv;

import org.apache.logging.log4j.Level;

import static com.jeffyjamzhd.btwatmos.BTWAtmos.LOGGER;

/* x-placeholder */

public class MAtmosConvLogger
{
	final private static String modName = "MAtmos";
	
	public final static int SEVERE = 3;
	public final static int WARNING = 2;
	public final static int INFO = 1;
	public final static int FINE = 0;
	
	private static int refinedness = 1;
	
	public static void setRefinedness(int refinedLevel)
	{
		refinedness = refinedLevel;
	}
	
	public static void fine(String message)
	{
		LOGGER.trace(message);
	}
	
	public static void info(String message)
	{
		LOGGER.info(message);
	}
	
	public static void warning(String message)
	{
		LOGGER.warn(message);
	}
	
	public static void severe(String message)
	{
		LOGGER.fatal(message);
	}
	
	private static void print(String message, String type, int refinedLevel)
	{
		if (refinedLevel >= refinedness)
		{
			System.out.println("(" + modName + ": " + type + ") " + message);
		}
	}
}
