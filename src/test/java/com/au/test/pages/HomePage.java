package com.au.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.au.utility.BaseTest;

public class HomePage extends BaseTest{
	// url: https://www.amazon.in/
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchEng;
	
	
	public void SearchEngine() {
		searchEng.click();
		searchEng.clear();
		searchEng.sendKeys("mobile phone");
	}

}
