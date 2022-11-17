using OpenQA.Selenium.Chrome;
using OpenQA.Selenium;
using WebDriverManager.DriverConfigs.Impl;
using NUnit.Framework;

namespace SeleniumProjectTest
{
    public class LoginPageTests
    {
        IWebDriver driver;

        [SetUp]
        public void StartBrowser()
        {

            new WebDriverManager.DriverManager().SetUpDriver(new ChromeConfig());
            this.driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
        }

        [Test]
        public void LoginSuccess()
        {
            driver.Url = "https://practicetestautomation.com/practice-test-login/";
            driver.FindElement(By.Id("username")).SendKeys("student");
            driver.FindElement(By.Id("password")).SendKeys("Password123");
            driver.FindElement(By.Id("submit")).Click();
           
            var logoutButton = driver.FindElement(By.XPath("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a"));
            var loginSuccessLabel = driver.FindElement(By.XPath("//*[@id=\"loop-container\"]/div/article/div[2]/p[1]/strong"));

            // 1. Check url
            Assert.That(driver.Url, Is.EqualTo("https://practicetestautomation.com/logged-in-successfully/"));

            // 2. Check logout button
            Assert.IsTrue(logoutButton.Displayed);

            // 3. Check login messsage
            Assert.That(loginSuccessLabel.Text, Is.EqualTo("Congratulations student. You successfully logged in!"));

            driver.Close();

        }

        [Test]
        public void IncorrectUserLogin()
        {
            driver.Url = "https://practicetestautomation.com/practice-test-login/";
            driver.FindElement(By.Id("username")).SendKeys("incorrectUser");
            driver.FindElement(By.Id("password")).SendKeys("Password123");
            driver.FindElement(By.Id("submit")).Click();
            var errorMessage = driver.FindElement(By.Id("error")).Text;

            Assert.That(errorMessage, Is.EqualTo("Your username is invalid!"));

            driver.Close();
        }

        [Test]
        public void IncorrectPasswordLogin()
        {
            driver.Url = "https://practicetestautomation.com/practice-test-login/";
            driver.FindElement(By.Id("username")).SendKeys("student");
            driver.FindElement(By.Id("password")).SendKeys("incorrectPassword");
            driver.FindElement(By.Id("submit")).Click();
            var errorMessage = driver.FindElement(By.Id("error")).Text;

            Assert.That(errorMessage, Is.EqualTo("Your password is invalid!"));

            driver.Close();
        }
    }
}