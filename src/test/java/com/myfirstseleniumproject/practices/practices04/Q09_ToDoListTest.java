package com.myfirstseleniumproject.practices.practices04;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;

public class Q09_ToDoListTest extends TestBase {
    @Test
    public void toDoList(){

        // Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        // Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        //  Strikethrough all todos.
        // Delete all todos.
        // Assert that all todos are deleted.
    }
}
