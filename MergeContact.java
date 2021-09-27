package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.className("inputLogin")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//label[text()='Password']/following::input")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.xpath("(//div[@class='frameSectionHeader'])[3]")).click();
		driver.findElement(By.xpath("(//ul[@class='shortcuts']//a)[4]")).click();
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following::a")).click();
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		driver.switchTo().window(winList.get(1));
		System.out.println("Switched window1 title: " + driver.getTitle());
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a")).click();
		driver.switchTo().window(winList.get(0));
		System.out.println("Reverted to main window title: " + driver.getTitle());
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> winSet2 = driver.getWindowHandles();
		List<String> winList2 = new ArrayList<String>(winSet2);
		driver.switchTo().window(winList2.get(1));
		System.out.println("Switched window2 title: " + driver.getTitle());
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//a")).click();
		driver.switchTo().window(winList.get(0));// u can use winList2.get(0) also both has same value
		System.out.println("Reverted to main window title: " + driver.getTitle());
		//System.out.println(winList + "\n" + winList2);
		driver.findElement(By.className("buttonDangerous")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		// TargetLocator switchTo = driver.switchTo();
		System.out.println("Title of the page: " + driver.getTitle());

	}

}
