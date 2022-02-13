package week4.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("http://www.leafground.com/pages/Window.html"); 
	     //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	       driver.findElement(By.id("home")).click();
	      Set <String> window = driver.getWindowHandles();
	      List<String> list = new ArrayList<String>(window);
	       driver.switchTo().window(list.get(1));

	       System.out.println(driver.getCurrentUrl());
	       System.out.println(driver.getTitle());
	       driver.switchTo().window(list.get(0));
      
	       System.out.println(driver.getCurrentUrl());
	       System.out.println(driver.getTitle());
	       driver.quit();
	}

}
