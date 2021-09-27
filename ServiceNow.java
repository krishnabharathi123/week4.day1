package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, WebDriverException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://dev91318.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(driver.findElement(By.id("gsft_main")));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Bharathi@0619");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		//Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Incidents | ServiceNow']")));
		driver.findElement(By.xpath("//h1/following::button")).click();
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowList.get(1));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@role='button' and text()='Aileen Mottern']")).click();
		driver.switchTo().window(windowList.get(0));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='gsft_main']")));
		//driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("autpmation tetsing");
		String incidentNum=driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("Created Incidence code is: "+incidentNum);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@placeholder='Search'][@class='form-control']")).sendKeys(incidentNum,Keys.ENTER);
		String searchedIncident=driver.findElement(By.xpath("//td[@class='vt']")).getText();
		if(incidentNum.equals(searchedIncident)) {
			File src = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Snaps/ServiceNowIncident.png"));
		}
		

	}

}
