package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class CountOfRowsColumns {

	public void rowsColumnstabl2(ChromeDriver driver) {

		WebElement Table = driver.findElement(By.xpath("//table[@class='attributes-list']"));
		List<WebElement> rows = Table.findElements(By.tagName("tr"));
		int size = rows.size();
		System.out.println("Row Size of second table " + " " + size);

		List<WebElement> col = rows.get(0).findElements(By.tagName("th"));
		
		int size2 = col.size();
		System.out.println("Column Size of second table" + " " + size2);

	}

	public void rowsColumnstabl1(ChromeDriver driver) {
	
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='render']/table//tr"));
		int size2 = rows.size();
		System.out.println("Row Size of first table " + " " + size2);
		List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));
		int size = columns.size();
		System.out.println("Column Size of first table " + " " + size);
	}

	public void totalcloumsrows(ChromeDriver driver) {
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
		int size = rows.size();
		System.out.println("Total rows in the entire page" + " " + size);
		List<WebElement> columns = driver.findElements(By.xpath("//table//tr/th"));
		int size2 = columns.size();
		System.out.println("Total Columns in the entire page" + " " + size2);
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		CountOfRowsColumns obj = new CountOfRowsColumns();

		obj.rowsColumnstabl1(driver);
		obj.rowsColumnstabl2(driver);
		obj.totalcloumsrows(driver);
		driver.close();

	}
}
