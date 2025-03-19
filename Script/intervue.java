import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class intervue {
    public static void main(String[] args) {
    	
    	
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-win64\\chromedriver.exe");
        //THE ABOVE PATH NEEDS TO BE CHANGED TO THELOCATION WHERE YOU HAVE DOWNLOADED AND EXTRACTED CHROMEPATH
        
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.intervue.io/"); // Open Intervue Website
        driver.manage().window().maximize();   //  Maximize browser

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Click the first Login button (top-right corner) in the SAME TAB
            WebElement firstLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'loginBtn')]")));
            
            // ✅ Force Login to Open in Same Tab
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].removeAttribute('target');", firstLoginButton);
            firstLoginButton.click();
            System.out.println("✅ Clicked on the first Login button!");

            // Wait for the second page to load
            wait.until(ExpectedConditions.urlToBe("https://www.intervue.io/access-account"));
            System.out.println("✅ Second page loaded: " + driver.getCurrentUrl());

            // Define X, Y Coordinates (Adjust as needed)
            int x = 941; 
            int y = 465; 

            //  Click at (X, Y) using JavaScript
            String script = "var element = document.elementFromPoint(arguments[0], arguments[1]);" +
                            "if (element) { element.click(); return element.innerText; } else { return 'No element found'; }";

            String elementText = (String) js.executeScript(script, x, y);

            System.out.println("✅ Clicked at coordinates: (" + x + ", " + y + ")");
            System.out.println("🔍 Text at clicked location: " + elementText);
            
                     
            // Wait until the login page is fully loaded
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_email")));

            // Find username and password fields
            WebElement usernameField = driver.findElement(By.id("login_email"));
            WebElement passwordField = driver.findElement(By.id("login_password"));
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

                 
            
         // Create an instance of the Credentials class
            Credentials credentials = new Credentials();

            // Enter credentials using getters
            usernameField.sendKeys(credentials.getUsername());
            passwordField.sendKeys(credentials.getPassword());

           
            // Click the login button
            loginButton.click();
            System.out.println("✅ Successfully clicked on the login button!");

            // Wait for the dashboard page to load after login
            wait.until(ExpectedConditions.urlContains("dashboard"));
            System.out.println("✅ Successfully logged in!");

            // Wait for the search bar icon to be clickable
            WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'HeaderSearch__SearchLensIconWrap-sc-1140h69-2')]")));

            // Create Actions class instance
            Actions actions = new Actions(driver);

            // Hover over the search icon
            actions.moveToElement(searchIcon).build().perform();
          //  Thread.sleep(2000); // Small delay to visually confirm hover
            System.out.println("✅ Mouse hovered over the search bar!");

            // Click on the search bar icon
            searchIcon.click();
            System.out.println("✅ Clicked on the search bar!");
 
            Thread.sleep(2000); // Small delay to visually confirm hover

            
            // Type 'hello' in the search input box
            driver.switchTo().activeElement().sendKeys("hello");
            
            Thread.sleep(2000); // Small delay to visually confirm hover

            System.out.println("✅ Successfully typed 'hello' in the search bar!");

            // Wait for the dynamic search result to appear
            WebElement dynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'search through interviews and assignments')]")));

            // Click on the dynamic search result
            dynamicElement.click();
            System.out.println("✅ Successfully clicked on the dynamic search result!");

            // Wait for the profile dropdown element to be visible
            WebElement profileDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'ProfileHeader__StyedDropdownHoverLink')]")));

            // Click on the profile dropdown
            profileDropdown.click();
            System.out.println("✅ Successfully clicked on the profile dropdown!");

            Thread.sleep(1000); // Small delay to ensure dropdown is visible

            // Wait for the Logout button to appear
            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '/logout')]")));

            // Click on the Logout button
            logoutButton.click();
            System.out.println("✅ Successfully clicked on Logout!");

            
            
       
            Thread.sleep(3000); // Wait to observe result
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();

            // Take a screenshot when login fails
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String screenshotPath = "E:\\screenshot.png"; // Change this to your desired location
                File destinationFile = new File(screenshotPath);
                Files.copy(screenshot.toPath(), destinationFile.toPath());
                System.out.println("🖼 Screenshot taken: " + screenshotPath);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
}}