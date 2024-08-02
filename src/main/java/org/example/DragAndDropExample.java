package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropExample {
    public static void main(String[] args) {
        // WebDriver'ı başlat
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Test edilecek URL'ye git
            driver.get("https://example.com/drag_and_drop");

            // Kaynak ve hedef elementleri bul
            WebElement sourceElement = driver.findElement(By.id("draggable"));
            WebElement targetElement = driver.findElement(By.id("droppable"));

            // Actions nesnesi oluştur ve dragAndDrop işlemini gerçekleştir
            Actions actions = new Actions(driver);
            actions.dragAndDrop(sourceElement, targetElement).perform();

            // Başarılı bir şekilde sürükleyip bıraktığımızı doğrulamak için hedef elementi kontrol et
            String targetText = targetElement.getText();
            if (targetText.equals("Dropped!")) {
                System.out.println("Test Passed: Element successfully dragged and dropped.");
            } else {
                System.out.println("Test Failed: Drag and drop operation failed.");
            }
        } finally {
            // Tarayıcıyı kapat
            driver.quit();
        }
    }
}
