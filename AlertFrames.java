package week4.Day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertFrames {

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt"); 
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
WebElement frame = driver.findElement(By.name("iframeResult"));
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("//button[text()='Try it']")).click();	
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
       Alert alert =driver.switchTo().alert();
       alert.sendKeys("Yogalakshmi");
       alert.accept();
       WebElement name = driver .findElement(By.xpath("//p[@id='demo']"));
String GetText = name.getText();
System.out.println(GetText);
if(GetText.contains("Yoga")) {
	System.out.println("Text entered was correct!!");
}
else {
	System.out.println("Text entered was not correct!!");
}
	}

}
