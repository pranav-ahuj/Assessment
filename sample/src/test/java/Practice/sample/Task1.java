package Practice.sample;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1 {
      public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/flights/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//div//p[contains(text(),'Mumbai, India')]")).click();
		driver.findElement(By.xpath("//div[@role='gridcell' and @aria-selected='true']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OKAY, GOT IT!')]")));
		driver.findElement(By.xpath("//button[contains(text(),'OKAY, GOT IT!')]")).click();
		List <WebElement> prices = driver.findElements(By.xpath("//p[@class='blackText fontSize18 blackFont white-space-no-wrap']"));
		ArrayList <Integer> priceint = new ArrayList<Integer>();
		for (WebElement webElement : prices) {
            String name = webElement.getText();
            name = name.replaceAll("[^a-zA-Z0-9]", "");
            name = name.replaceAll(" ", "");
             int i = Integer.parseInt(name);
            priceint.add(i);
            }
		Collections.sort(priceint);
		int element = priceint.get(1);
		System.out.println(element);
		for(int i=1;i<=prices.size();i++) {
			String text = driver.findElement(By.xpath("(//p[@class='blackText fontSize18 blackFont white-space-no-wrap'])["+i+"]")).getText();
			text = text.replaceAll("[^a-zA-Z0-9]", "");
            text = text.replaceAll(" ", "");
			int j = Integer.parseInt(text);
	        if(j==element){
	        	String airlinename = driver.findElement(By.xpath("(//p[@class='boldFont blackText airlineName'])["+i+"]")).getText();
	        	System.out.println("Airline name: "+airlinename +", Price: " + element );
	        }
	        
		}
		driver.close();
			
}

}
