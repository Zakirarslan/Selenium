package com.myfirstseleniumproject;

import org.junit.jupiter.api.*;

public class day02_JunitAnnoations {
    @BeforeAll
    public static void setUpClass(){
        System.out.println("Before All....");
    }
    @AfterAll
    public static void tearDownClass(){
        System.out.println("After All...");
    }
    @BeforeEach
    public void befoeasetUpMethodsch(){
        System.out.println("Before Each...");
    }
    @AfterEach
    public void aftereach(){
        System.out.println("After Each...");
    }

   @Test
    public void test01(){
       System.out.println("Test01");
      }
      @Test
      public void test02(){
          System.out.println("Test02");
      }
    @Test @Disabled
    public void test03(){
        System.out.println("Test03");
    }
    @Test
    public void test04(){
        System.out.println("Test04");
    }
    @Test
    public void test05(){
        System.out.println("Test05");
    }
}
