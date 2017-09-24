package com.hybridframeword.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTest {
  @Test
  public void loginMethodTest(){
	  System.out.println("login Method Test1");
	  Assert.assertTrue(true);
	  
	  
  }
  
  @Test
  public void createcontactTest(){
	  System.out.println("Create Contact Test");
	  Assert.assertTrue(false);
	  
	  
  }
  @Test
  public void deletecontactTest(){
	  System.out.println("delete contact Test");
	  Assert.assertTrue(true);
	  
  }
  @Test
  public void readContact(){
	  System.out.println("read contact Test");
	  Assert.assertTrue(false);
	  
  }
}
