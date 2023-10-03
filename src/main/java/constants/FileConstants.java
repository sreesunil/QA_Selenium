package constants;

import utils.CommonUtils;

public class FileConstants {

	

	public static final String LOGIN_TESTDATA_FILE_PATH = System.getProperty("user.dir")+"/src/main/resources/testdata/LoginTestData.xlsx";
	public static final String LOGIN_TESTDATA_FILE_PATH2 = System.getProperty("user.dir")+"/src/main/resources/testdata/LoginTestData.Properties";	
	public static final String USERMENU_TESTDATA_FILE_PATH = System.getProperty("user.dir")+"/src/main/resources/testdata/UsermenuTestData.Properties";
	public static final String FILE_TO_POST = "C:\\Users\\smann\\OneDrive\\Pictures\\hey bro.png";	
	public static final String PHOTO_TO_UPLOAD = "C:\\Users\\smann\\OneDrive\\Desktop\\Tulip.jpg";
	public static final String REPORT_PATH = System.getProperty("user.dir")+"/src/main/resources/reports/" + CommonUtils.getStringDateAndTimestamp()+ "_SFDC.html";
	public static final String SCREENSHOT_PATH = System.getProperty("user.dir")+"/src/main/resources/reports/" + CommonUtils.getStringDateAndTimestamp()+ "_SFDC.PNG";
	public static final String ACCOUNT_DATA_PATH = System.getProperty("user.dir")+"/src/main/resources/testdata/AccountTestData.Properties";
	public static final String OPPORTUNITY_TESTDATA_FILE_PATH = System.getProperty("user.dir")+"/src/main/resources/testdata/OpportunityTestdataFile.Properties";
	public static final String LEADS_TESTDATA_FILE_PATH = System.getProperty("user.dir")+"/src/main/resources/testdata/LeadsTestData.Properties";
	public static final String CONTACTS_TESTDATA_FILE_PATH = System.getProperty("user.dir")+"/src/main/resources/testdata/ContactTestData.Properties";

	
	}
 