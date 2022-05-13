package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LafGroundTable {
	public void Rowscolumns(ChromeDriver driver) {
		List<WebElement> colums = driver.findElements(By.tagName("th"));
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		System.out.println("Row size" + " " + rows.size());
		System.out.println("column size" + " " + colums.size());
	}

	public void getvalue(ChromeDriver driver) {
		WebElement table = driver.findElement(By.xpath("//table"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			List<WebElement> colums = rows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < colums.size(); j++) {
				if (colums.get(j).getText().equals("Learn to interact with Elements")) {
					System.out.println(colums.get(1).getText());
				}
			}
		}
	}

	public void getleastvalue(ChromeDriver driver) {

		List<WebElement> col = driver.findElements(By.xpath("//table//td[2]"));
		List<String> sort = new ArrayList<String>();
		for (int i = 0; i < col.size(); i++) {
			sort.add(col.get(i).getText());

		}
		Collections.reverse(sort);
		Set<String> set = new LinkedHashSet<String>(sort);
		System.out.println(set);
		for (String eachvalue : set) {
			if (eachvalue.equalsIgnoreCase("20%")) {
				driver.findElement(By.xpath("//table//tr[6]//input[@name='vital']")).click();
				System.out.println("the element is clicked ");
			}
		}
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		LafGroundTable obj = new LafGroundTable();
		// obj.Rowscolumns(driver);
		// obj.getvalue(driver);
		obj.getleastvalue(driver);
	}

}
