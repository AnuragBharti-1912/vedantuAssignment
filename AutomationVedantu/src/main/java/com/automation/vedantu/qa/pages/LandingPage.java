package com.automation.vedantu.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.vedantu.qa.base.basePage;

public class LandingPage extends basePage {

	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	public WebDriver driver;

	private By chooseRoom1 =(By.xpath("//input[@class='create-room-form-input']"));
	public WebElement chooseRoomName1() {
		return driver.findElement(chooseRoom1);
	}

	private By startChat = (By.xpath("//button[contains(text(),'Start a chat')]"));
	public WebElement startChatButton() {
		return driver.findElement(startChat);

	}

	private By joincall=(By.xpath("//button[contains(text(),'Join Call')]"));
	public WebElement JoinCallButton() {
		return driver.findElement(joincall);
	}

	private By chooseRoom2 =(By.xpath("//input[@class='create-room-form-input']"));
	public WebElement chooseRoomName2() {
		return driver.findElement(chooseRoom2);
	}
}