package Extract;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Extract {
	@Test
	public static void extractMovieDetailsImdb() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.imdb.com/title/tt9389998/");
		String releaseDateText = driver.findElement(By.xpath("//a[normalize-space()='Release date']")).getText();
		String releaseDate = driver.findElement(By.xpath("//li[@data-testid='title-details-releasedate']//div[@class='ipc-metadata-list-item__content-container']")).getText();
		String countryOfOriginText = driver.findElement(By.xpath("//button[normalize-space()='Country of origin']")).getText();
		String extCountryOfOrigin = driver.findElement(By.xpath("//a[normalize-space()='India']")).getText();
		String releaseDateExt = "Release date December 17, 2021 (United States)";
		String expectedCountry = "Country of origin India";
		Assert.assertEquals(releaseDateText+releaseDate, releaseDateExt);
		Assert.assertEquals(expectedCountry, countryOfOriginText+extCountryOfOrigin);
		driver.close();
	}

	@Test
	public static void extractMovieDetailsWiki() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		String extReleaseDate = driver
				.findElement(By.xpath("//body[1]/div[3]/div[3]/div[5]/div[1]/table[1]/tbody[1]/tr[12]")).getText();
		String extCountryOfOrigin = driver
				.findElement(By.xpath("//body[1]/div[3]/div[3]/div[5]/div[1]/table[1]/tbody[1]/tr[14]")).getText();
		String expectedCountry = "Country	India";
		System.out.println(extReleaseDate);
		Assert.assertEquals("\n"+expectedCountry, "\n"+extCountryOfOrigin);
		driver.close();
	}
}
