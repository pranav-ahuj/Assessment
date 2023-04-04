package Practice.sample;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Task2 {
	
	  
        public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://mail.aol.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("pranavahuja11@aol.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@id='login-passwd']")).click();
		driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys("halfstory@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement iframelement = driver.findElement(By.xpath("//nav[@role='navigation']"));
		driver.switchTo().frame(iframelement);
		driver.findElement(By.xpath("//div//a[contains(text(),'Compose')]")).click();
		driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys("pranavahuja11@aol.com");
		driver.findElement(By.xpath("//input[@data-test-id='compose-subject']")).sendKeys("Damco");
		driver.findElement(By.xpath("(//button[@aria-label='Bulleted List'])[1]")).click();
		driver.findElement(By.xpath("(//button[@aria-label='Bulleted List'])[2]")).click();
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("Line one \n Line two \n Line three");
		WebElement file1 = driver.findElement(By.xpath("//button[@title='Attach files']"));
		file1.click();
		file1.sendKeys("C:\\Users\\prana\\OneDrive\\Image1.jpg");
		driver.findElement(By.xpath("//button[@title='Send this email']")).click();
		driver.findElement(By.xpath("//button[@title='Close notification']")).click();
		driver.get("https://mail.aol.com/d/search/referrer=unread&keyword=is%253Aunread&accountIds=1&excludefolders=ARCHIVE?reason=newaccount");
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//span[contains(text(),'Damco')]")).click();
		String subject = driver.findElement(By.xpath("//span[@data-test-id='message-group-subject-text']")).getText();
		Assert.assertEquals("Subject is matching", "Damco", subject);
		System.out.println("Subject is matching");
		WebElement iframelement2 = driver.findElement(By.xpath("(//div[@role='toolbar'])[3]"));
		driver.switchTo().frame(iframelement2);
		driver.findElement(By.xpath("//button[@title='Download']")).click();
		String downloadPath = "C:\\Users\\prana\\Downloads";
		Assert.assertTrue(isFileDownloaded(downloadPath, "Image1.jpg"));
		System.out.println("File is downloaded");
        driver.close();
		}
        public static boolean isFileDownloaded(String downloadPath, String fileName) {
    		boolean flag = false;
    	    File dir = new File(downloadPath);
    	    File[] dir_contents = dir.listFiles();
    	  	    
    	    for (int i = 0; i < dir_contents.length; i++) {
    	        if (dir_contents[i].getName().equals(fileName))
    	            return flag=true;
    	            }

    	    return flag;
    	}
       }
