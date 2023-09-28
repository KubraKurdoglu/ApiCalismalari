package requesss.US_17;

import TestNGProje.pages.MusteriPage;
import TestNGProje.pages.UrunYonetimiPage;
import TestNGProje.utilities.ConfigReader;
import TestNGProje.utilities.Driver;
import TestNGProje.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_17_TumTestler {

     @AfterMethod
    public void tearDown() {
        ReusableMethods.extentTest.info("Sayfa kapatılır");
        ReusableMethods.extentReports.flush();
         Driver.closeDriver();
    }

    @Test
    public void TC01() {
        MusteriPage musteriPage = new MusteriPage();
        ReusableMethods.extentReportParametreli("Mustafa Dogan","US_17_TC01");
        Driver.getDriver().get(ConfigReader.getProperty("pearly_Url"));
        ReusableMethods.extentTest.info("Ana sayfaya gidilir");
        ReusableMethods.bekle(1);
        musteriPage.signinTitleMainPage.click();
        Assert.assertTrue(musteriPage.signinTitleMainPage.isDisplayed());
        ReusableMethods.extentTest.pass("SignIn bölümüne ulaşıldığı doğrulanır");
        ReusableMethods.bekle(1);
        musteriPage.signinTitle.click();
        String girilenMailAdresi="talove1070@appxapi.com";
        musteriPage.signinUsername.sendKeys(girilenMailAdresi);

        musteriPage.signinPassword.sendKeys("talove1070@appxapi.com");
        musteriPage.signinButton.click();
        ReusableMethods.bekle(3);
        ReusableMethods.extentTest.info("Kullanıcı adı ve şifre bilgisi ile giriş yapılır");


        UrunYonetimiPage urunYonetimiPage = new UrunYonetimiPage();
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.END).perform();
        urunYonetimiPage.myAccountLink.click();
        ReusableMethods.extentTest.info("My Account sayfasına ulaşılır");
        urunYonetimiPage.storeManager.click();
        ReusableMethods.extentTest.info("Store Manager sayfasına ulaşılır");
        urunYonetimiPage.productsButton.click();
        ReusableMethods.extentTest.info("Products sayfasına ulaşılır");
        urunYonetimiPage.productsButton.click();
        ReusableMethods.bekle(1);
        Assert.assertTrue(urunYonetimiPage.addNewButton.isEnabled());
        ReusableMethods.extentTest.pass("Add new butonunun tıklanabilir olduğu test edilir");
        urunYonetimiPage.addNewButton.click();
        WebElement addNewProductDDM = urunYonetimiPage.simpleProductDDM;
        ReusableMethods.ddmIndex(addNewProductDDM,1);
        Select option = new Select(addNewProductDDM);
        String ddmFirstName= option.getFirstSelectedOption().getText();
        Assert.assertEquals(ddmFirstName,"Variable Product");
        ReusableMethods.extentTest.pass("Variable Product'ın default olarak görüntülendiği test edilir");


    }





    @Test
    public void TC03() {
        MusteriPage musteriPage = new MusteriPage();
        ReusableMethods.extentReportParametreli("Mustafa Dogan","US_17_TC03");
        Driver.getDriver().get(ConfigReader.getProperty("pearly_Url"));
        ReusableMethods.extentTest.info("Ana sayfaya gidilir");
        ReusableMethods.bekle(1);
        musteriPage.signinTitleMainPage.click();
        Assert.assertTrue(musteriPage.signinTitleMainPage.isDisplayed());
        ReusableMethods.extentTest.pass("SignIn bölümüne ulaşıldığı doğrulanır");
        ReusableMethods.bekle(1);
        musteriPage.signinTitle.click();
        String girilenMailAdresi="talove1070@appxapi.com";
        musteriPage.signinUsername.sendKeys(girilenMailAdresi);

        musteriPage.signinPassword.sendKeys("talove1070@appxapi.com");
        musteriPage.signinButton.click();
        ReusableMethods.bekle(3);
        ReusableMethods.extentTest.info("Kullanıcı adı ve şifre bilgisi ile giriş yapılır");

        UrunYonetimiPage urunYonetimiPage = new UrunYonetimiPage();
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.END).perform();
        urunYonetimiPage.myAccountLink.click();
        ReusableMethods.extentTest.info("My Account sayfasına ulaşılır");
        urunYonetimiPage.storeManager.click();
        ReusableMethods.extentTest.info("Store Manager sayfasına ulaşılır");
        urunYonetimiPage.productsButton.click();
        ReusableMethods.extentTest.info("Products sayfasına ulaşılır");
        urunYonetimiPage.addNewButton.click();
        action.sendKeys(Keys.END).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunYonetimiPage.attributesButton);
        ReusableMethods.click(urunYonetimiPage.colorCheckbox);
        ReusableMethods.extentTest.info("Attibutes tıklanır ve gelen pencereden bir renk seçilir");
        String arananRenk = "Black";
        ReusableMethods.ddmVisibleText(urunYonetimiPage.colorSearchBox,arananRenk);

        Assert.assertTrue(urunYonetimiPage.renkYazisi.getText().contains(arananRenk));
        ReusableMethods.extentTest.pass("Actual renk ile seçilen renkin aynı olduğu doğrulanır");

    }
    @Test
    public void TC05() {
        MusteriPage musteriPage = new MusteriPage();
        ReusableMethods.extentReportParametreli("Mustafa Dogan","US_17_TC05");
        Driver.getDriver().get(ConfigReader.getProperty("pearly_Url"));
        ReusableMethods.extentTest.info("Ana sayfaya gidilir");
        ReusableMethods.bekle(1);
        musteriPage.signinTitleMainPage.click();
        Assert.assertTrue(musteriPage.signinTitleMainPage.isDisplayed());
        ReusableMethods.extentTest.pass("SignIn bölümüne ulaşıldığı doğrulanır");
        ReusableMethods.bekle(1);
        musteriPage.signinTitle.click();
        String girilenMailAdresi="talove1070@appxapi.com";
        musteriPage.signinUsername.sendKeys(girilenMailAdresi);

        musteriPage.signinPassword.sendKeys("talove1070@appxapi.com");
        musteriPage.signinButton.click();
        ReusableMethods.bekle(3);
        ReusableMethods.extentTest.info("Kullanıcı adı ve şifre bilgisi ile giriş yapılır");

        UrunYonetimiPage urunYonetimiPage = new UrunYonetimiPage();
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.END).perform();
        urunYonetimiPage.myAccountLink.click();
        ReusableMethods.extentTest.info("My Account sayfasına ulaşılır");
        urunYonetimiPage.storeManager.click();
        ReusableMethods.extentTest.info("Store Manager sayfasına ulaşılır");
        urunYonetimiPage.productsButton.click();
        ReusableMethods.extentTest.info("Products sayfasına ulaşılır");
        urunYonetimiPage.addNewButton.click();
        action.sendKeys(Keys.END).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunYonetimiPage.attributesButton);
        ReusableMethods.click(urunYonetimiPage.sizeCheckbox);
        ReusableMethods.extentTest.info("Attibutes tıklanır ve gelen pencereden bir size seçilir");
        String arananSize = "Large";
        ReusableMethods.ddmVisibleText(urunYonetimiPage.sizeSearchBox,arananSize);
        Assert.assertTrue(urunYonetimiPage.sizeYazisi.getText().contains(arananSize));
        ReusableMethods.extentTest.pass("Actual renk ile seçilen renkin aynı olduğu doğrulanır");

    }
}