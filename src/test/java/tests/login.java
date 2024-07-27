package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.MyAccount;

public class login extends BaseTest{
	
	MyAccount ma = null; 
	String name = null;

	//@Test(dataProvider = "testdata")
	public void NavigateToHomePage(String customerid, String username, String password) throws Exception {
			
		ma = new MyAccount();
		name = (String) ma.credentials(customerid,username,password);
		Assert.assertEquals(name,"MARINELLI FRANCESCO","Student name isn't correct!!");
		
	}
	
	@DataProvider(name="testdata")
	public Object[][] tData(){
		
		return new Object[][] {
			{"97712840582","6446","izzitiello1980"}//,
			//{"fakeID","6999","K!1980!"}
		};
	}
	
	//@Test(dataProvider = "testdata")
	public void absence(String customerid, String username, String password) throws Exception {
		ma = new MyAccount();
		ma.credentials(customerid,username,password);
		String f = ma.myAbsences(name);
		Assert.assertEquals(f,"Elenco assenze giustificate","The page is correct, but some absences aren't giustified!!");
	}

	@Test(dataProvider = "testdata")
	public void dailySchoolWork(String customerid, String username, String password) throws Exception {
		ma = new MyAccount();
		ma.credentials(customerid,username,password);
		int workToDo = ma.myWork();
		Assert.assertNotNull(workToDo, "The work table is empty! No work done!!");
	}
	
	//@Test(dataProvider = "testdata")
	public void today(String customerid, String username, String password) throws Exception {
		ma = new MyAccount();
		ma.credentials(customerid,username,password);
		int numDay= ma.todayDate();
		Assert.assertEquals(numDay, 0);
		
	}
	
	//@Test(dataProvider = "testdata")
	public void InformationSchoolToFamily(String customerid, String username, String password) throws Exception{
		ma = new MyAccount();
		ma.credentials(customerid,username,password);
		ma.schoolToFamilyMessages();
	}
}
