package com.automation.vedantu.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.vedantu.qa.utils.TestUtil;

public class basePage {

	public static WebDriver driver;
	public Properties prop;
	public String Path;
	public ChromeOptions options;


	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		Path = new File("").getAbsolutePath();
		FileInputStream fis=  new FileInputStream(Path+ "\\src\\main\\java\\com\\automation\\vedantu\\qa\\config\\file.properties");

		prop.load(fis);
		System.setProperty("webdriver.chrome.driver",Path + "\\drivers\\chromedriver.exe");

		String browsername=prop.getProperty("browser");
		options = new ChromeOptions(); 
		options.addArguments("use-fake-device-for-media-stream");
		options.addArguments("use-fake-ui-for-media-stream");
		if (browsername.equals("chrome")) {
			driver= new ChromeDriver(options);
		}

		DesiredCapabilities caps = new DesiredCapabilities();

		System.out.println(("chrome is logged in"));

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		return driver;
	}

}
