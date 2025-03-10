import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTests {

    WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();

        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown(){

        driver.quit();
    }

    @Test
    void openHomePageTest()
    {
        String actualTitle = driver.getTitle();
        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }

    @Test
    void openChapterThreeWebFormTest()
    {
        driver.findElement(By.linkText("Web form")).click();

        String webFormUrl = "web-form.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + webFormUrl,currentUrl);
        assertEquals("Web form", title.getText());
    }

    @Test
    void openChapterThreeNavigationTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 3. WebDriver Fundamentals']/../a[@href = 'navigation1.html']")).click();

        String navigationUrl = "navigation1.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + navigationUrl, currentUrl);
        assertEquals("Navigation example", title.getText());
    }

    @Test
    void openChapterThreeDropdownMenuTest()
    {
        driver.findElement(By.linkText("Dropdown menu")).click();

        String dropdownMenuUrl = "dropdown-menu.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + dropdownMenuUrl, currentUrl);
        assertEquals("Dropdown menu", title.getText());
    }

    @Test
    void openChapterThreeMouseOverTest()
    {
        List<WebElement> pageLinks = driver.findElements(By.xpath("//*[@class = 'btn btn-outline-primary mb-2']"));
        pageLinks.get(3).click();

        String mouseOverUrl = "mouse-over.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + mouseOverUrl, currentUrl);
        assertEquals("Mouse over", title.getText());
    }

    @Test
    void openChapterThreeDragAndDropTest()
    {
        driver.findElement(By.linkText("Drag and drop")).click();

        String dragAndDropUrl = "drag-and-drop.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + dragAndDropUrl, currentUrl);
        assertEquals("Drag and drop", title.getText());
    }

    @Test
    void openChapterThreeDrawingInCanvasTest()
    {
        driver.findElement(By.xpath("//a[@href = 'draw-in-canvas.html']")).click();

        String drawingInCanvasUlr = "draw-in-canvas.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + drawingInCanvasUlr, currentUrl);
        assertEquals("Drawing in canvas", title.getText());
    }

    @Test
    void openChapterThreeLoadingImagesTest()
    {
        driver.findElement(By.xpath("//a[@href = 'loading-images.html']")).click();

        String loadingImagesUrl = "loading-images.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + loadingImagesUrl, currentUrl);
        assertEquals("Loading images", title.getText());
    }

    @Test
    void openChapterThreeSlowCalculatorTest()
    {
        driver.findElement(By.xpath("//a[@href = 'slow-calculator.html']")).click();

        String slowCalculatorUrl = "slow-calculator.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + slowCalculatorUrl, currentUrl);
        assertEquals("Slow calculator", title.getText());
    }

    @Test
    void openChapterFourLongPageTest()
    {
        driver.findElement(By.xpath("//a[@href = 'long-page.html']")).click();

        String longPageUrl = "long-page.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + longPageUrl, currentUrl);
        assertEquals("This is a long page", title.getText());
    }

    @Test
    void openChapterFourInfiniteScrollTest()
    {
        driver.findElement(By.xpath("//a[@href = 'infinite-scroll.html']")).click();

        String infiniteScrollUrl = "infinite-scroll.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + infiniteScrollUrl, currentUrl);
        assertEquals("Infinite scroll", title.getText());
    }

    @Test
    void openChapterFourShadowDomTest()
    {
        driver.findElement(By.xpath("//a[@href = 'shadow-dom.html']")).click();

        String shadowDomUrl = "shadow-dom.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + shadowDomUrl, currentUrl);
        assertEquals("Shadow DOM", title.getText());
    }

    @Test
    void openChapterFourCookiesTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[@href = 'cookies.html']")).click();

        String cookiesUrl = "cookies.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + cookiesUrl, currentUrl);
        assertEquals("Cookies", title.getText());
    }

    @Test
    void openChapterFourFramesTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[@href = 'frames.html']")).click();

        String framesUrl = "frames.html";
        String currentUrl = driver.getCurrentUrl();
//        WebElement frameBody = driver.findElement(By.xpath("//frame[@name= 'frame-body']"));
//        driver.switchTo().frame(frameBody);
//        WebElement title = driver.findElement(By.xpath("//p[@class = 'lead']/b"));

        assertEquals(BASE_URL + framesUrl, currentUrl);
//                assertEquals("Lorem ipsum", title.getText());
    }

    @Test
    void openChapterFourIFrameTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[@href = 'iframes.html']")).click();

        String iFrameUrl = "iframes.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + iFrameUrl, currentUrl);
        assertEquals("IFrame", title.getText());
    }


    @Test
    void openChapterFourDialogBoxesTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[@href = 'dialog-boxes.html']")).click();

        String dialogBoxesUrl = "dialog-boxes.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + dialogBoxesUrl, currentUrl);
        assertEquals("Dialog boxes", title.getText());
    }

    @Test
    void openChapterFourWebStorageTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[@href = 'web-storage.html']")).click();

        String webStorageUrl = "web-storage.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + webStorageUrl, currentUrl);
        assertEquals("Web storage", title.getText());
    }

    @Test
    void openChapterFiveGeolocationTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 5. Browser-Specific Manipulation']/../a[@href = 'geolocation.html']")).click();

        String geolocationUrl = "geolocation.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + geolocationUrl, currentUrl);
        assertEquals("Geolocation", title.getText());
    }

    @Test
    void openChapterFiveNotificationsTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 5. Browser-Specific Manipulation']/../a[@href = 'notifications.html']")).click();

        String notificationsUrl = "notifications.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + notificationsUrl, currentUrl);
        assertEquals("Notifications", title.getText());
    }

    @Test
    void openChapterFiveGetUserMediaTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 5. Browser-Specific Manipulation']/../a[@href = 'get-user-media.html']")).click();

        String getUserMediaUrl = "get-user-media.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + getUserMediaUrl, currentUrl);
        assertEquals("Get user media", title.getText());
    }

    @Test
    void openChapterFiveMultilanguageTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 5. Browser-Specific Manipulation']/../a[@href = 'multilanguage.html']")).click();

        String multilanguageUrl = "multilanguage.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + multilanguageUrl, currentUrl);
        assertEquals("", title.getText());
    }

    @Test
    void openChapterFiveConsoleLogsTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 5. Browser-Specific Manipulation']/../a[@href = 'console-logs.html']")).click();

        String consoleLogsUrl = "console-logs.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + consoleLogsUrl, currentUrl);
        assertEquals("Console logs", title.getText());
    }

    @Test
    void openChapterSevenLoginFormTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 7. The Page Object Model (POM)']/../a[@href = 'login-form.html']")).click();

        String loginFormUrl = "login-form.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + loginFormUrl, currentUrl);
        assertEquals("Login form", title.getText());
    }

    @Test
    void openChapterSevenSlowLoginFormTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 7. The Page Object Model (POM)']/../a[@href = 'login-slow.html']")).click();

        String slowLoginFormUrl = "login-slow.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + slowLoginFormUrl, currentUrl);
        assertEquals("Slow login form", title.getText());
    }

    @Test
    void openChapterEightRandomCalculatorTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 8. Testing Framework Specifics']/../a[@href = 'random-calculator.html']")).click();

        String randomCalculatorUrl = "random-calculator.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + randomCalculatorUrl, currentUrl);
        assertEquals("Random calculator", title.getText());
    }

    @Test
    void openChapterNineDownloadFilesTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 9. Third-Party Integrations']/../a[@href = 'download.html']")).click();

        String downloadFilesUrl = "download.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + downloadFilesUrl, currentUrl);
        assertEquals("Download files", title.getText());
    }

    @Test
    void openChapterNineABTestingTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 9. Third-Party Integrations']/../a[@href = 'ab-testing.html']")).click();

        String aBTestingUrl = "ab-testing.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + aBTestingUrl, currentUrl);
        assertEquals("A/B Testing", title.getText());
    }

    @Test
    void openChapterNineDataTypesTest()
    {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 9. Third-Party Integrations']/../a[@href = 'data-types.html']")).click();

        String dataTypesUrl = "data-types.html";
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + dataTypesUrl, currentUrl);
        assertEquals("Data types", title.getText());
    }

}
