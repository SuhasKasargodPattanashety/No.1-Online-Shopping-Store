package util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;

public class BackUp {

	@Test
	public void Store_BackUp_Results() throws Exception
	{
		String sDate=null;
		String destPath=null;
		{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy hh-mm-ss");
			sDate=sdf.format(cal.getTime());
			
			destPath=System.getProperty("user.dir")+"/BackUp/TestNG_Results_Backup" + sDate;
			FileUtils.copyDirectory(new File(System.getProperty("user.dir")+"/test-output"), new File(destPath));	
		}
	}
}
