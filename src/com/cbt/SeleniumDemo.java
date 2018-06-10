package com.cbt;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/osmonov/Documents/selenium dependencies/drivers/chromedriver");
	
	WebDriver driver= new ChromeDriver();
	
	driver.get("http://cybertek-bnb.herokuapp.com/");
	String title= driver.getTitle();
	String url= driver.getCurrentUrl();
	System.out.println("Url "+ url);
	System.out.println("Title:"+ title);
	
	if(title.equals("Intro | cybertek-bnb")) {
		System.out.println("Title pass");
	} 
	else {
		System.out.println("Title failed");
	}
	
	Random randomNumber= new Random();
	int num= randomNumber.nextInt(100000);
	String firstName= "Beka";
	String lastName= "Janybekov";
	String email= "bbbb" + num + "@gmail.com";
	String password="123";
	
	driver.findElement(By.linkText("sign up")).click();
	Thread.sleep(1000);
	WebElement fName=driver.findElement(By.name("first-name"));
	fName.sendKeys(firstName);
	WebElement lastName1= driver.findElement(By.name("last-name"));
	lastName1.sendKeys("last-name");
	Thread.sleep(1000);
	lastName1.clear();
	Thread.sleep(1000);
	lastName1.sendKeys("Bond");
	WebElement Email1=	driver.findElement(By.name("email"));
	Email1.sendKeys(email);
	WebElement password1= driver.findElement(By.name("password"));
	password1.sendKeys( password);
    driver.findElement(By.xpath("//button[.='sign up']")).click();
    
    if(driver.getTitle().equals("Sing in | cybertek-bnb")) {
    	System.out.println("Sign up successfully");
    } else {
    	System.out.println("Sign up failed");
    }
    driver.findElement(By.name("email")).sendKeys(email);
    driver.findElement(By.name("password")).sendKeys( password);
    driver.findElement(By.xpath("//button[.='sign in']")).click();
    
    String loggedinTitle = driver.getTitle();
    if (loggedinTitle.equals("Map | cybertek-bnb")) {
    	System.out.println("User signed-in succesfully");
    } else {System.out.println("User signed-in failed");
    }
    driver.findElement(By.linkText("schedule")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("hunt")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("me")).click();
    Thread.sleep(1000);
  
	}
}
