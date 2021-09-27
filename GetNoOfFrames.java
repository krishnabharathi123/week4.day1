package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetNoOfFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int frameCount = frames.size();
		System.out.println("No of frames in this page are: " + frameCount);// nested frames will not be visisble to the
																			// main page.

	}

}
