package com.myfirstseleniumproject.practices.practices04;

import com.github.javafaker.Faker;
import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q08_MathCaptche extends TestBase {
    @Test
    public void mathCaptcheh(){

        //    Go to https://form.jotform.com/73302671092956
        driver.get("https://form.jotform.com/73302671092956");
        waitFor(1);

        //    Click on start
        driver.findElement(By.id("jfCard-welcome-start")).click();


        //    Enter firstname and lastname
        driver.findElement(By.id("first_1")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.id("last_1")).sendKeys(Faker.instance().name().lastName());
        waitFor(2);

        //    Click on next
        WebElement click=driver.findElement(By.xpath("//*[text()='Next'][1]"));
        clickByJS(click);

        //    Enter email
        driver.findElement(By.id("input_2")).sendKeys(Faker.instance().internet().emailAddress());

        //    Click on next
        driver.findElement(By.xpath("//button[@data-testid='nextButton_1']")).click();
        waitFor(1);

        //    Enter message
        driver.findElement(By.id("input_3")).sendKeys("We are learning Selenium");
        waitFor(1);

        //    Click on next
        driver.findElement(By.xpath("//button[@data-testid='nextButton_2']")).click();
        waitFor(1);

        //    Handle captcha
        driver.switchTo().frame(0);
        waitFor(1);
        WebElement firstN=driver.findElement(By.xpath("//span[@id='number']"));
        int firstNumber=Integer.parseInt(firstN.getText());
        int secondNumber=Integer.parseInt(driver.findElement(By.xpath("//span[@id='number2']")).getText());
        String function=driver.findElement(By.id("function")).getText();

        int result=0;
        if (function.equals("+")) { result = firstNumber + secondNumber;
        } else if (function.equals("-")) { result = firstNumber - secondNumber;
        } else if (function.equals("x")) { result = firstNumber * secondNumber;

        }else  { result = firstNumber / secondNumber;
        }

        //    Click on submit
        driver.findElement(By.id("result")).sendKeys(result+"");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("")).click();


        //    Assert that submission is received
        assertTrue(driver.findElement(By.xpath("//h1")).getText().contains("Thank You!"));

    }
}
