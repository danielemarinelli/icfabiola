package pages;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import base.BaseTest;

public class MyAccount extends BaseTest{

	
	public String credentials(String customerid, String username, String password) throws Exception {
		
		System.out.println(driver.getTitle());
		WebDriverWait wait_username = new WebDriverWait(driver, 10);
		wait_username.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locators.getProperty("user_name_field")))));
		Thread.sleep(1000);
		driver.findElement(By.xpath(locators.getProperty("customerid_field"))).sendKeys(customerid);
		driver.findElement(By.xpath(locators.getProperty("user_name_field"))).sendKeys(username);
		Thread.sleep(1000);
		//System.out.println("Inserted on user name");
		driver.findElement(By.xpath(locators.getProperty("pw_field"))).sendKeys(password);
		Thread.sleep(1000);
		//System.out.println("Inserted on password");
		driver.findElement(By.xpath(locators.getProperty("access_button"))).click();
		//System.out.println("Clicked on Access Button");
		Thread.sleep(6000);
		try {
			if(driver.findElement(By.xpath(locators.getProperty("initial_pop_up_message"))).isDisplayed()) {
				Thread.sleep(1000);
				driver.findElement(By.xpath(locators.getProperty("download_doc"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(locators.getProperty("checkbox"))).click();
				Thread.sleep(1000);
				System.out.println("A school communication is available. It is dowloaded in the relative folder. Be sure to open it and read it");
			}else {
				System.out.println("No new school communication are available");
			}
		} catch (Exception e) {
			
			System.out.println("Element is not present, hence not displayed as well!!");
			System.out.println();
			//System.out.println("Exception in finding the element:" + e.getMessage());
		}
		
		String name = driver.findElement(By.xpath(locators.getProperty("student_name"))).getText();
		System.out.println(name);
		return name;
		//Assert.assertEquals(name,"MARINELLI FRANCESCO","Student name isn't correct!!");
		
	}
	
	public String myAbsences(String name) throws Exception {
		
		driver.findElement(By.xpath(locators.getProperty("assenze"))).click();
		System.out.println("Absence page!!");
		Thread.sleep(5000);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.xpath(locators.getProperty("header"))), "Elenco assenze giustificate"));  //.visibilityOf(driver.findElement(By.xpath(locators.getProperty("header")))));
		String header = driver.findElement(By.xpath(locators.getProperty("header"))).getText();
		//System.out.println(a);
		List<WebElement> rows = driver.findElements(By.xpath(locators.getProperty("rows_absence")));
		System.out.println("TOTAL NUMBER ABSENCE for student --> "+name+ " are: "+rows.size());
		System.out.println();
		for(WebElement row : rows) {
	        //assertEquals("expected text", e.getText());
			System.out.println(row.getText());
			System.out.println("-----");
	    }
		return header;
	}
	
	
	public int myWork() throws Exception {
		
		driver.findElement(By.xpath(locators.getProperty("class_register"))).click();
		//System.out.println("Class Work Page!!");
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath(locators.getProperty("class_daily_work"))).getText());	
		driver.findElement(By.xpath(locators.getProperty("class_daily_work"))).click();
		Thread.sleep(5000);
		List<WebElement> rows = driver.findElements(By.xpath(locators.getProperty("work_table")));
		//System.out.println(rows.size());
		for(WebElement row : rows) {
			System.out.println(row.getText());
			System.out.println("-----");
	    }
		return rows.size();
	}
	
	public int todayDate() {
		System.out.println("TODAY IS --->> "+driver.findElement(By.xpath(locators.getProperty("day_name"))).getText()
				+" "+driver.findElement(By.xpath(locators.getProperty("day_number"))).getText()
				+" "+driver.findElement(By.xpath(locators.getProperty("month"))).getText());
		Date today = Calendar.getInstance().getTime();
        System.out.println(today);
        String todayInString = today.toString();
        String todaySplit[] = todayInString.split(" ");
        int a = Integer.parseInt(todaySplit[2])-Integer.parseInt(driver.findElement(By.xpath(locators.getProperty("day_number"))).getText());
        return a;
	}
	
	public void schoolToFamilyMessages() throws Exception {
		driver.findElement(By.xpath(locators.getProperty("communications"))).click();
		Thread.sleep(2000);
		/*driver.findElement(By.xpath(locators.getProperty("arrowDownCommunicationPage"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(locators.getProperty("TypeOfCommunicationToSearch"))).click();
		driver.findElement(By.xpath(locators.getProperty("TypeOfCommunicationToSearch"))).sendKeys("Scuola/famiglia");
		driver.findElement(By.xpath(locators.getProperty("TypeOfCommunicationToSearch"))).sendKeys(Keys.ENTER);*/
		List<WebElement> communicationsSchoolSentToFamily  = driver.findElements(By.xpath(locators.getProperty("info_school_to_family")));
		System.out.println("School sent "+communicationsSchoolSentToFamily.size() +" or more communications to the family...");
		//int numberOfCommunicationsSchoolSentToFamily 
		
	}

}
