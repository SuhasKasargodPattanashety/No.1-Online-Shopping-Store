package util;

public class Delay {

	public static void waitfor(long seconds)
	{
	 try {
		   long milliSeconds=seconds*1000;
		   Thread.sleep(milliSeconds);
		 } catch (Exception e) 
	       {
			e.printStackTrace();
		   }
	 }
 }
