package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.internal.observers.ForEachWhileObserver;

public class GetNamesFromTable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.chittorgarh.com/");
		WebElement stockMarket = driver.findElement(By.id("navbtn_stockmarket"));
		stockMarket.click();
		WebElement nskBulkDeals = driver.findElement(By.linkText("NSE Bulk Deals"));
		nskBulkDeals.click();
		WebElement Table = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered table-')]"));
		List<WebElement> rows = Table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		List<String> dup = new ArrayList<String>();

		for (int i = 0; i < rows.size(); i++) {
			// System.out.println(i);

			List<WebElement> col = rows.get(i).findElements(By.tagName("td"));
			
			for (int j = 2; j == col.size() - 6; j++) {
				String text = col.get(j).getText();

				dup.add(text);
				//System.out.println(text);

			}

		}
		System.out.println(dup.size());
		System.out.println(dup);
		Set<String> set = new LinkedHashSet<String>(dup);
		System.out.println(set);
		System.out.println(set.size());
		if (dup.size() == set.size()) {
			System.out.println("THe duplicates are not present");
		} else {
			System.out.println("The duplicates are present");
		}

	}
}