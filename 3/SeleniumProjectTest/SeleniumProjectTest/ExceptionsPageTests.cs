using NUnit.Framework;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium;
using WebDriverManager.DriverConfigs.Impl;


namespace SeleniumProjectTest
{
    public class ExceptionsPageTests
    {
        //Xpath, Css, id, classname, name, tagname
        IWebDriver driver;

        [SetUp]
        public void StartBrowser()
        {

            new WebDriverManager.DriverManager().SetUpDriver(new ChromeConfig());
            this.driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
        }

        [Test]
        public async Task AddNewRowWaitAsync()
        {
            driver.Url = "https://practicetestautomation.com/practice-test-exceptions/";
            driver.FindElement(By.Id("add_btn")).Click();
            driver.FindElement(By.XPath("//*[@id=\"row2\"]/input"), 5);
            var row2 = driver.FindElement(By.XPath("//*[@id=\"row2\"]/input"));
            Assert.IsTrue(row2.Displayed);

            driver.Close();
        }  
    }
}
