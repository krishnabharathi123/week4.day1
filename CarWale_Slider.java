package week4.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarWale_Slider {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.carwale.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("//div[@class='o-cXBIhK o-cOktWz
		// o-brXWGL']//div")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("//span[text()='Used']")).click();
		driver.findElement(By.xpath("//div[@class='o-cXBIhK o-cOktWz o-brXWGL']//div[2]")).click();
		driver.findElement(By.xpath("//input[@placeholder='City, eg: Mumbai']")).sendKeys("Chennai");
		Actions builder = new Actions(driver);
		Thread.sleep(2000);
		WebElement chennai = driver.findElement(By.xpath("//mark[text()='Chennai']"));

		/*
		 * WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(20));
		 * wt.until(ExpectedConditions.elementToBeSelected(chennai));
		 */
		builder.moveToElement(chennai).click().perform();
		WebElement slider1 = driver.findElement(By.xpath("//button[@role='slider']"));
		WebElement slider2 = driver.findElement(By.xpath("//button[@role='slider'][2]"));
		// builder.clickAndHold(slider1).dragAndDropBy(slider1, 624, 397).perform();
		// builder.clickAndHold(slider2).dragAndDropBy(slider2, 764, 397).perform();

		int i = 10;
		while (i <= 100) {
			builder.clickAndHold(slider1).dragAndDropBy(slider1, i, 0).perform();
			String sliderVal1 = slider1.getAttribute("aria-valuenow");
			// System.out.println(sliderVal1);
			if (sliderVal1.equals("4")) {

				break;
			}
			i = i + 10;
		}
		System.out.println("Offset value of slider1 " + slider1.getLocation());
		String MinAmt = driver.findElement(By.xpath("//input[@placeholder='Min']")).getAttribute("value");
		System.out.println("Minimum amount in lakhs: " + MinAmt);
		int j = -10;
		while (j >= -100) {
			builder.clickAndHold(slider2).dragAndDropBy(slider2, j, 0).perform();
			String sliderVal2 = slider2.getAttribute("aria-valuenow");
			// System.out.println(sliderVal2);
			if (sliderVal2.equals("12")) {

				break;

			}
			i = i - 10;
		}
		System.out.println("Offset value of slider2 " + slider2.getLocation());
		String MaxAmt = driver.findElement(By.xpath("//input[@placeholder='Max']")).getAttribute("value");
		System.out.println("Maximum amount in lakhs: " + MaxAmt);
	}

}
