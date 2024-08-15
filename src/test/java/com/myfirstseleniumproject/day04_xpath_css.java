package com.myfirstseleniumproject;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class day04_xpath_css {
    WebDriver driver;
    @BeforeEach
    public void setUp(){

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void javaFakerTest(){
        Faker faker=new Faker();
        //Firstname
        System.out.println("Fake Name"+faker.name().firstName());
    }

    @Test
    public void test01() throws InterruptedException {

        //When user go to the webpage https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //user enter username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

        //user enter password
        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("admin123");

        //click login button
        //   driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement login = driver.findElement(By.tagName("button"));

        if (login.isDisplayed()) {
            driver.findElement(By.tagName("button")).click();
        }

        //isDisplayed for question mark
        WebElement qa = driver.findElement(By.xpath("(//button[@type='button'])[3]"));
        Thread.sleep(5000);
        if (qa.isDisplayed()){

            qa.click();
        }


        //Assert login successfull
        Assertions.assertTrue(qa.isDisplayed());



    }

    @AfterEach
    public void tearDown(){

        driver.quit();
    }
}