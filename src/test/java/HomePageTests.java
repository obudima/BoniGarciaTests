import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTests {

    WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown(){

        driver.quit();
    }

    @Test
    @DisplayName("Открытие главной страницы")
    void openHomePageTest()
    {
        String actualTitle = driver.getTitle();
        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }

    @ParameterizedTest(name = "Открытие страницы {0} / {1}")
    @CsvFileSource(resources = "/testdata.csv", numLinesToSkip = 1)
    void openLinksByXPath(String chapterName, String title, String url)
    {
        driver.findElement(By.xpath("//h5[text() = '"+chapterName+"']/../a[@href = '"+ url +"']")).click();

        String currentUrl = driver.getCurrentUrl();
        WebElement actualTitle = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + url,currentUrl);
        assertEquals(title, actualTitle.getText());
    }

    // FRAMES
    @Test
    @DisplayName("Открытие страницы Chapter 4. Browser-Agnostic Features / Frames")
    void openChapterFourFramesTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[@href = 'frames.html']")).click();

        String framesUrl = "frames.html";
        String currentUrl = driver.getCurrentUrl();
        // попытки переключить фрейм
//        WebElement frameBody = driver.findElement(By.xpath("//frame[@name= 'frame-body']"));
//        driver.switchTo().frame(frameBody);
//        WebElement frameElement = driver.findElement(By.cssSelector("frame[name='frame-header']"));
//        WebElement frameElement = driver.findElement(By.cssSelector("frame[name='frame-body']"));
//        driver.switchTo().frame(frameElement);
//        WebElement title = driver.findElement(By.xpath("//p[@class = 'lead']/b"));

        assertEquals(BASE_URL + framesUrl, currentUrl);
//        assertEquals("Lorem ipsum", title.getText());
    }

    // Пустой тайтл
    @Test
    @DisplayName("Открытие страницы Chapter 5. Browser-Specific Manipulation / Multilanguage")
    void openChapterFiveMultilanguageTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 5. Browser-Specific Manipulation']/../a[@href = 'multilanguage.html']")).click();

        String multilanguageUrl = "multilanguage.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + multilanguageUrl, currentUrl);
        assertEquals("", title.getText());
    }
}
