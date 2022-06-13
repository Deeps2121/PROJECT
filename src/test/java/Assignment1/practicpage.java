package Assignment1;


import java.util.ArrayList;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class practicpage {
    WebDriver driver;
	String url =" https://www.rahulshettyacademy.com/AutomationPractice/";
	
	@Before
	public void setup()                                                                                                             
		
{	
			
   driver = new ChromeDriver();
   driver.manage().deleteAllCookies();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   driver.get(url);
}
			
	

    @Test 
    // 1.Radio Button Selection
    
    public void radiobutton()
    
    {
    WebElement radiobtnselect = driver.findElement(By.xpath("//input[@value= 'radio2']"));  
    radiobtn2.click();
    Assert.assertEquals(true,radio2.isSelected());
    System.out.println("radio button 2 is selected");
    }
    
    
    @Test
    //2.DropDownHandling
    
    public void dropDown() throws InterruptedException
    {
    WebElement dropDownselect = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
    Select optionselect =new Select(dropDownselect);
    optionselect.selectByVisibleText("3");
    Thread.sleep(3000);
    }
    	
      @Test
      //3.CheckBoxSelection
      
      public void CheckboxSelection()
      {
      WebElement checkBox = driver.findElement(By.xpath("//input[@id= 'checkBoxOption1']"));
      Checkboxselect.click();
      Thread.sleep(3000);
      }
    
    @Test
    //4.WindowSwitching
    
    public void Switchwindow()
    {
    
    WebElement OpenWindow = driver.findElement(By.xpath("//button[@id= 'openwindow']"));
    OpenWindow.click();
    ArrayList<String>handles = new ArrayList<String>(driver.getWindowHandles());
   	String ParentWindowID = handles.get(0);
    String ChildWindowID1 = handles.get(1);
    	
    driver.switchTo().window(ChildWindowID1);
    System.out.println("Child Window Title is" + driver.getTitle());
    String Url = "https://WWW.qaclickacademy.com/";
    Assert.assertEquals("URL is not matching", Url , driver.getCurrentUrl());
    System.out.println("URL is matching");
    driver.close();    	
    	
    }
    
    @Test
    //5.AlertHandling
    
    public void alertHandling() throws InterruptedException
    {
    WebElement textbox = driver.findElement(By.xpath("//input[@id= 'name']"));
    textbox.sendKeys("Hi Deepali");
    WebElement alertbtn = driver.findElement(By.xpath("//input[@id= alertbtn']"));
    alertbtn.click();
    Alert alert = driver.switchTo().alert();
    Thread.sleep(3000);
    Assert.assertEquals(true,alert.getText().contains("Hii Deepali"));
    System.out.println("alert.getText().containstext \"Hii\" ");
    alert.accept();
    }
    
		
	
    @After
	
	public void tearDown()
	
	{
    	driver.quit();
	}


           }

	
	
		
	
	








