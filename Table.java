package week4.Day1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Table {

	public static void main(String[] args)  {
		
		//http://www.leafground.com/pages/table.html
WebDriverManager.chromedriver().setup(); 
ChromeDriver driver = new ChromeDriver();
driver.manage().window().maximize(); 
driver.get("http://www.leafground.com/pages/table.html"); 
WebElement table = driver.findElement(By.id("table_id"));


List <WebElement> listrows = table.findElements(By.xpath("//tbody/tr"));
System.out.println("Count of number of Rows - "+listrows.size());
List<WebElement> listCol = driver.findElements(By.xpath("//table[@id='table_id']//td"));
System.out.println("Count of number of Columns -  "+listCol.size());

//Get the Progress Value of "Learn to interact 	with Elements "
WebElement Progress = driver.findElement(By.xpath("//td[text()='Learn to interact with Elements']//following-sibling::td[1]"));
System.out.println("ProgressValue of 'Learn to interact with Elements' -  "+Progress.getText());



List <WebElement> percentage = table.findElements(By.xpath("//table[@id='table_id']//tr[*]/td[2]"));
List<Integer> list = new LinkedList<Integer>();
for (WebElement value : percentage) {
	String val = value.getText();
	String i = val.replaceAll("%","");
	
	int val1=Integer.parseInt(i); 
	
	list.add(val1);
	Collections.sort(list);
	Collections.min(list);
	}
System.out.println(list);


Integer n =list.get(0);
driver.findElement(By.xpath("//td[text()='"+n+"%']/following-sibling::td/input")).click();
//td[@class='sorting_1']

}

}

