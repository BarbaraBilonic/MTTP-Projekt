import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class Tests {
    private WebDriver webDriver;
   private String testURL = "http://demowebshop.tricentis.com/";
    private Random rand=new Random();


    public String generateEmail(){
        int number=rand.nextInt(100);
        StringBuilder sb = new StringBuilder();
        sb.append("ime.prezime").append(number).append("@gmail.com");
        return sb.toString();

    }
   public boolean checkIfExists(String id){
       Boolean isPresent = webDriver.findElements(By.id(id)).size() > 0;
       return isPresent;
   }
    public void login() throws InterruptedException{
        WebElement emailTextBox= webDriver.findElement(By.id("Email"));
        emailTextBox.sendKeys("imeprezime123@gmail.com");
        WebElement passwordTextBox=webDriver.findElement(By.id("Password"));
        passwordTextBox.sendKeys("password123");
        WebElement loginButton= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input\n"));
        Thread.sleep(1000);
        loginButton.click();
    }

    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver","../chromedriver.exe");
        webDriver= new ChromeDriver();
        webDriver.navigate().to(testURL);
    }
    @Test
    public void registrationTest() throws InterruptedException{
        WebElement register=webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a\n"));
        register.click();
        WebElement genderRadioButton=webDriver.findElement(By.id("gender-male"));
        genderRadioButton.click();
        WebElement nameTextBox=webDriver.findElement(By.id("FirstName"));
        nameTextBox.sendKeys("Ime");
        nameTextBox.submit();
        WebElement lastNameTextBox=webDriver.findElement(By.id("LastName"));
        lastNameTextBox.sendKeys("Prezime");
        lastNameTextBox.submit();
        WebElement emailTextBox=webDriver.findElement(By.id("Email"));
        emailTextBox.sendKeys(generateEmail());
        emailTextBox.submit();
        String password="password123";
        WebElement passwordTextBox=webDriver.findElement(By.id("Password"));
        passwordTextBox.sendKeys(password);
        passwordTextBox.submit();
        WebElement confirmPasswordTextBox=webDriver.findElement(By.id("ConfirmPassword"));
        confirmPasswordTextBox.sendKeys(password);
        WebElement registerButton=webDriver.findElement(By.id("register-button"));
        registerButton.click();
        Thread.sleep(1000);
        WebElement continueButton= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input\n"));
        continueButton.click();




    }
    @Test
    public void addToCartCheckoutTest() throws InterruptedException {
       WebElement item= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[2]/h2/a\n"));
        item.click();
        WebElement addToCartButton= webDriver.findElement(By.id("add-to-cart-button-31"));
        addToCartButton.click();
        WebElement shoppingCart= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a\n"));
        shoppingCart.click();
        WebElement selectCountry=webDriver.findElement(By.id("CountryId"));
        selectCountry.sendKeys("Croatia");
        WebElement zipCodeTextBox= webDriver.findElement(By.id("ZipPostalCode"));
        zipCodeTextBox.sendKeys("31000");
        WebElement estimateShippingButton=webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[1]/div[2]/div/div[3]/div[4]/input\n"));
        estimateShippingButton.click();
        WebElement agreeCheckBox=webDriver.findElement(By.id("termsofservice"));
        agreeCheckBox.click();
        WebElement checkoutButton= webDriver.findElement(By.id("checkout"));
        checkoutButton.click();
        login();
        agreeCheckBox=webDriver.findElement(By.id("termsofservice"));
        agreeCheckBox.click();
        checkoutButton= webDriver.findElement(By.id("checkout"));
        checkoutButton.click();
        if(webDriver.findElements(By.id("BillingNewAddress_CountryId")).isEmpty()) {
            WebElement billingAddressCountry = webDriver.findElement(By.id("BillingNewAddress_CountryId"));
            billingAddressCountry.click();
            billingAddressCountry.sendKeys("Croatia");
            WebElement billingAddressCity = webDriver.findElement(By.id("BillingNewAddress_City"));
            billingAddressCity.sendKeys("Osijek");
            WebElement billingAddress = webDriver.findElement(By.id("BillingNewAddress_Address1"));
            billingAddress.sendKeys("Address");
            WebElement billingAddressZipCode = webDriver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
            billingAddressZipCode.sendKeys("31000");
            WebElement billingAddressPhone = webDriver.findElement(By.id("BillingNewAddress_PhoneNumber"));
            billingAddressPhone.sendKeys("123456");
        }
        WebElement continueButton1= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[1]/div[2]/div/input\n"));
        continueButton1.click();
        Thread.sleep(1000);
        WebElement continueButton2= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[2]/div[2]/div/input\n"));
        continueButton2.click();
        Thread.sleep(1000);
        WebElement continueButton3= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/input\n"));
        continueButton3.click();
        Thread.sleep(1000);
        WebElement continueButton4= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[4]/div[2]/div/input"));
        continueButton4.click();
        Thread.sleep(1000);
        WebElement continueButton5= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[5]/div[2]/div/input\n"));
        continueButton5.click();
        Thread.sleep(1000);
        WebElement confirmButton= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[6]/div[2]/div[2]/input\n"));
       confirmButton.click();
       Thread.sleep(1000);
       WebElement continueButtonFinal= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[2]/input\n"));
        continueButtonFinal.click();



    }
    @Test
    public void addItemReview() throws InterruptedException{
        WebElement loginButton= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a\n"));
        loginButton.click();
        login();
        WebElement books= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a\n"));
        books.click();
        WebElement item= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/h2/a\n"));
        item.click();
        WebElement addReview= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[5]/div[2]/a[2]\n"));
        addReview.click();
        WebElement reviewTitle= webDriver.findElement(By.id("AddProductReview_Title"));
        reviewTitle.sendKeys("Review");
        WebElement review= webDriver.findElement(By.id("AddProductReview_ReviewText"));
        review.sendKeys("Book is good");
        WebElement rating= webDriver.findElement(By.id("addproductrating_4"));
        rating.click();
        WebElement submitButton= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/form/div[3]/input\n"));
        submitButton.click();




    }

    @Test
    public void compareProductsTest() throws InterruptedException{
       WebElement electronics= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[3]/a\n"));
       electronics.click();
       WebElement cellPhones= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]/div/h2/a\n"));
       cellPhones.click();
       WebElement smartphone=webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/h2/a\n"));
       smartphone.click();
       WebElement addToCompareListButton= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[8]/input\n"));
       addToCompareListButton.click();
       electronics= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[3]"));
       electronics.click();
       cellPhones= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]/div/h2/a\n"));
       cellPhones.click();
       WebElement usedPhone= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/h2/a\n"));
       usedPhone.click();
       addToCompareListButton= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[8]/input\n"));
       addToCompareListButton.click();


    }

    @Test
    public void searchTest() throws InterruptedException{
       WebElement searchBar= webDriver.findElement(By.id("small-searchterms"));
       searchBar.sendKeys("smartphone");
       searchBar.submit();
       Thread.sleep(1000);
       WebElement item= webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div[2]/h2/a\n"));
       Assert.assertEquals(item.getText(), "Smartphone");
       System.out.print(item.getText());
    }
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        webDriver.quit();
    }


}



