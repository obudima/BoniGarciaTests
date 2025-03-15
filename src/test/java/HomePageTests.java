import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Открытие всех страницх во всех разделах")
    void openAllLinks() throws InterruptedException{
        int qtyLinks = 0;
        List<WebElement> chapters = driver.findElements(By.cssSelector("h5.card-title"));
        for (WebElement chapter : chapters) {
            List<WebElement> links = chapter.findElements(By.xpath("./../a"));
            qtyLinks +=links.size();
            System.out.println(chapter.getText());
            for (WebElement link : links){
                System.out.println(link.getText());
                link.click();
//                Thread.sleep(1000);
                driver.navigate().back();
            }
        }
        assertEquals(6,chapters.size());
        assertEquals(27,qtyLinks);
    }

    @Test
    @DisplayName("Пример с cssSelector")
    void classesTest(){
        List<WebElement> chapters = driver.findElements(By.cssSelector(".btn.btn-outline-primary.mb-2"));
        assertEquals(27, chapters.size());
    }

    // ДЗ локаторы для всех элементов на web form

    @Test
    @DisplayName("Локаторы на странице Chapter 3. WebDriver Fundamentals / Web form")
    void locatorsWebForm() throws InterruptedException {
        driver.findElement(By.xpath("//h5[text() = '"+"Chapter 3. WebDriver Fundamentals"+"']/../a[@href = '"+ "web-form.html" +"']")).click();

        WebElement title = driver.findElement(By.className("display-6"));
        WebElement textInput = driver.findElement(By.id("my-text-id"));
        WebElement password = driver.findElement(By.name("my-password"));
        WebElement textArea = driver.findElement(By.tagName("textarea"));
        WebElement disabledInput = driver.findElement(By.xpath("//input[@disabled]"));
        WebElement disabledInputLabel = disabledInput.findElement(By.xpath("./parent::label[@class='form-label w-100']")); // xpath parent
        WebElement readOnlyInput = driver.findElement(By.cssSelector("input[value='Readonly input']"));
        WebElement readOnlyInputLabel = readOnlyInput.findElement(By.xpath("./ancestor::label")); // xpath ancestor
        WebElement linkReturnToIndex = driver.findElement(By.linkText("Return to index"));
        WebElement dropDownSelect = driver.findElement(By.cssSelector(".form-select"));
        WebElement dropDownDatalist = driver.findElement(By.cssSelector("[name='my-datalist']"));
        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        WebElement fileInputLabel = fileInput.findElement(By.xpath("./.."));
        WebElement checkboxChecked = driver.findElement(By.cssSelector("#my-check-1"));
        WebElement checkboxDefault = driver.findElement(By.cssSelector("#my-check-2"));
        WebElement radioChecked = driver.findElement(By.id("my-radio-1"));
        WebElement radioDefault = driver.findElement(By.id("my-radio-2"));
        WebElement buttonSubmit = driver.findElement(By.cssSelector("button"));
        WebElement colorPicker = driver.findElement(By.cssSelector("input[type='color']"));
        WebElement colorPickerLabel = colorPicker.findElement(By.xpath("./parent::label"));
        WebElement datePicker = driver.findElement(By.xpath("//label[normalize-space(text())='Date picker']/input"));
        WebElement exampleRange = driver.findElement(By.cssSelector(".form-range"));
        WebElement exampleRangeLabel = exampleRange.findElement(By.xpath("./parent::label"));
        WebElement linkBoniGarcia = driver.findElement(By.partialLinkText("Boni"));

        textInput.sendKeys("Text Input Test");
        password.sendKeys("P@ssWord");
        textArea.sendKeys("Text Area Test");
        dropDownSelect.click();
        dropDownDatalist.click();
        checkboxChecked.click();
        checkboxDefault.click();
        radioChecked.click();
        radioDefault.click();
        datePicker.sendKeys("03.15.2025");
        title.click();

        assertAll(
                () -> assertEquals("Web form", title.getText()),
                () -> assertThrows(ElementNotInteractableException.class, () -> disabledInput.sendKeys("Disable Input Test")),
                () -> assertEquals("Disabled input", disabledInputLabel.getText()),
                () -> assertEquals("Readonly input", readOnlyInputLabel.getText()),
                () -> assertEquals("Return to index", linkReturnToIndex.getText()),
                () -> assertEquals("File input", fileInputLabel.getText()),
                () -> assertEquals("Color picker", colorPickerLabel.getText()),
                () -> assertEquals("Example range", exampleRangeLabel.getText()),
                () -> assertEquals("Boni García", linkBoniGarcia.getText())
        );
        buttonSubmit.click();
        Thread.sleep(500);
        WebElement newTitle = driver.findElement(By.cssSelector("h1.display-6"));
        assertEquals("Form submitted", newTitle.getText());
    }

}
