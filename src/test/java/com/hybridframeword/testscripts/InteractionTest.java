package com.hybridframeword.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InteractionTest {
  @Test
  public void createInteractionTest() {
	  WebDriver driver=new FirefoxDriver();
	  System.out.println("create Interaction Test");

	  Assert.assertTrue(true);;
  }
  @Test
  public void assignInteraction(){
	  System.out.println("assign Interaction");
	  Assert.assertTrue(false);
	  
	  
	  
  }
  @Test
  public void transferInteraction(){
	  System.out.println("transfer interaction");
	  Assert.assertTrue(true);
	  
  }
  public void transferInteraction1(){
	  System.out.println("transfer interaction");
	  Assert.assertTrue(true);
	  
  }
}
