# LearningSpring-SpringBoot
a hands-on Spring and SpringBoot exercise of the tutoral from ken.kousen from an oreilly workshop
# If you find any errors or codes that can be improved, please kindly let me know at: t.hsuanhsieh@gmail.com

# Tutorial Information

- Title: Building SpringFramework and Spring Boot Project
- Tutorial time: April 11 & 12, 2023
- Lecture Material: http://www.kousenit.com/springboot/
- Lecture Solution: https://github.com/kousen/spring-and-spring-boot
- Lecturer: Ken Kousen
- Email: ken.kousen@kousenit.com
- Website: http://kousenit.org

## Table of Contents

1. Creating a New Project
2. Add a Rest Controller
3. Building a REST client
4. Accessing the Google Geocoder
5. Using the JDBC template
6. Implementing the CRUD layer using JPA
7. Using Spring Data

## 1. Creating a New Project 

We build a Gradle project for a simple Spring MVC structure which has Model, Controller, and View java-src-wise. Testing-wise we have Unit test for Controllers, and then integration test using MockMVC test. 

## 2. Add a Rest Controller

Add a HelloRestController.java and Greeting.java(a POJO). What we are doing here is simply sending an HTTP request( by ourselves manually, we are hitting the URL by ourselves and pretend we're clients haha) to the URL "/rest" And the RestController handles this request with @RequestParam and returns a response with a new Greeting object(which is defined in another class, Greeting.java). 

## 3. Building a REST client

This exercise uses the new reactive web client( WebClient) to access a RESTful web service. The template converts the response into an object for the rest of the system. Older Spring application, RestTemplate, is being gradually replaced with WebClient. WebClient returns responses of type Mono and Flux. They are "promises" that return a single object (for Mono) or a collection (for Flux) of objects.

## 4. Accessing the Google Geocoder

Google provides a free geocoding web service that converts addresses into geographical coordinates. This exercise uses the WebClient to access the Google geocoder and converts the responses into Java objects.

## 5. Using the JDBC template

Spring provides a class called JdbcTemplate in the org.springframework.jdbc.core package. All it needs in order to work is a data source. It removes almost all the boilerplate code normally associated with JDBC. In this exercise, you’ll use the JdbcTemplate to implement the standard CRUD (create, read, update, delete) methods on an entity.

## 6. Implementing the CRUD layer using JPA

The Java Persistence API (JPA) is a layer over the so-called persistence providers, the most common of which is Hibernate. With regular Spring, configuring JPA requires several beans, including an entity manger factory and a JPA vendor adapter. Fortunately, in Spring Boot, the presence of the JPA dependency causes the framework to implement all of that for you.

## 7. Using Spring Data

The Spring Data JPA project makes it incredibly easy to implement a DAO layer. You extend the proper interface, and the underlying infrastructure generates all the implementations for you.
