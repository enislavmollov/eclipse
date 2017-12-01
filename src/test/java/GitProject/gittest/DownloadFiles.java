package GitProject.gittest;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadFiles {
  @Test
  public void f() {
	  
	  String exePath = "/Users/Shared/Jenkins/Home/chromedriver";
		//String exePath = "C:\\Program Files (x86)\\Jenkins\\workspace\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
	  
	  driver.get("https://cleanwp.quikfox-lab.com/app/capeCapital.ipa");
	  
	  String tmpFolderPath = System.getProperty("java.io.tmpdir");
	  String expectedFileName = "capeCapital.ipa";
	  File file = new File(tmpFolderPath + expectedFileName);
	  if (file.exists())
	      file.delete();
	  // Start downloading here.
	 //wait.until((ExpectedCondition<Boolean>) WebDriver -> file.exists());
	  // Do what you need.
	  
	  
	  System.out.println("Download");
	  
  }
}
