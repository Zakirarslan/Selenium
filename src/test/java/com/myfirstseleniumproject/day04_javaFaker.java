package com.myfirstseleniumproject;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class day04_javaFaker {

    @Test
    public void javaFakerTest(){


        Faker faker = new Faker();

        //Firstname
        System.out.println("firstName = " + faker.name().firstName());

        //Lastname

        String fakeUsername = faker.name().username();

        //title
        System.out.println(faker.name().title());

        //city
        System.out.println(faker.address().city());

        //state
        System.out.println(faker.address().state());

        //country
        System.out.println(faker.address().country());

        System.out.println(faker.name().bloodGroup());

        System.out.println(faker.harryPotter().book());


        System.out.println(faker.funnyName().name());



    }
}