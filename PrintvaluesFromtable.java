package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class PrintvaluesFromtable {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://html.com/tags/table/");
	List<WebElement> row = driver.findElements(By.xpath("//div[@class='render']//table//tbody/tr"));
	for(int i=0;i<row.size();i++) {
		System.out.println(row.size());
		System.out.println("value of i"+" "+i);
		List<WebElement> col = row.get(i).findElements(By.tagName("td"));
		for(int j=0;j<col.size();j++) {
			System.out.println("value of j"+" "+j);
		if(col.get(j).getText().equals("Market Share")) {
			System.out.println(row.get(i).getText());
		
		}
		else if(col.get(j).getText().equals("Absolute Usage")){
			System.out.println(row.get(i).getText());
		
		}
	}
	
}
}
}