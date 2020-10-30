package com.automation.vedantu.qa.test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.vedantu.qa.base.basePage;
import com.automation.vedantu.qa.pages.LandingPage;

public class AssignmentVed extends basePage {

	@BeforeTest
	public void initialize() throws IOException{
		driver=initializeDriver();
	}

	@Test
	public void TestTalky() throws InterruptedException {
		LandingPage lp= new LandingPage(driver);

		driver.get(prop.getProperty("url1"));

		String url = driver.getTitle();
		System.out.println(("Page is navigated to url:"+ url));

		//choosing room
		lp.chooseRoomName1().sendKeys(prop.getProperty("user1"));	
		System.out.println(("User1 name is entered"));

		//Start a chat button
		lp.startChatButton().click();
		System.out.println(("Room1 is logged in for chatting"));

		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(lp.JoinCallButton())).click();
		Thread.sleep(3000);

		String title1 = driver.getTitle();

		String parentWindowHandler = driver.getWindowHandle(); 
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);

		//2nd instance
		driver.get(prop.getProperty("url2"));

		lp.chooseRoomName2().sendKeys(prop.getProperty("user2"));	
		System.out.println(("User2 name is entered"));

		lp.startChatButton().click();
		System.out.println(("Room2 is logged in for chatting with Room1"));

		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(lp.JoinCallButton())).click();
		Thread.sleep(3000);

		String title2 = driver.getTitle();
		if(title1.equalsIgnoreCase(title2)) {
			System.out.println(("Both clients got connected!!!"));
		}
		else {
			System.out.println(("failure"));
		}
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver=null;
	}

}
