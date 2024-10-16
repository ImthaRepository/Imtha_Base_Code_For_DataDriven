package Data_Driven_Excel;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_Case extends Base_Class{
//	@BeforeMethod
//	  public void URL_Run() {
//		driver.get(baseURL);
//	}
	
	@Test (dataProvider = "Login_Data_Manual")
	 public void TC_001(String user,String pass,String exp) {
	System.out.println(user + pass+ exp);	
	
	String expectTitle="Welcome User!";
	String ActualTitle=driver.getTitle();
	
	if (exp.equalsIgnoreCase("Valid")) {
		
		if (expectTitle.equals(ActualTitle)) {
			//Logout Click
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	} else if (exp.equalsIgnoreCase("invalid")) {
		if (expectTitle.equals(ActualTitle)) {
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
	} 
	
	}
	
	@DataProvider (name="Login_Data")
	public String[][] fetchData() {
		String loginData[][]= {
				
				{"imtha@ymail.com","imtha@123","Valid"},
				{"imtha@yahomail.","imtha123","invalid"},
				{"imtha@yymail.com","imtha@1233","invaid"}
		};
		return loginData;
		
	}
	
	public static String projPath = System.getProperty("user.dir");
	@DataProvider (name="Login_Data_Excel")
	public String [][] getData() throws IOException{
		String path=projPath+"\\ExcelFile\\fortest.xlsx";
	
		XLUtils xlutil=new XLUtils();
		int totalrows=xlutil.getRowCount(path, "Sheet1");
		int totalcols=xlutil.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[totalrows][totalcols];
		for (int i = 1; i <=totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
			loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
	
	 @DataProvider (name="Login_Data_Manual")
     public String [][] getDataManual() throws IOException{
		 
		 String path =projPath+"\\ExcelFile\\Sample Login.xlsx";
  		
  		int startRows=1;
  		int Endrows=5;
  		int startCols=0;
  		int Endcols=3;
  		
  		XLUtils xlutil=new XLUtils();
  		String loginData[][]=new String[Endrows][Endcols];
  		for (int i = startRows; i <=Endrows; i++) {	
  			for (int j = startCols; j < Endcols; j++) {		
  			loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
  			}
  		}
  		return loginData;
  		}

}
