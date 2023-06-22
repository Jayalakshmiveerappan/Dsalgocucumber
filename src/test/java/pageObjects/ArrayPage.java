package pageObjects;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactory;
import utilities.ConfigReader;
import utilities.Elementutils;
//import utilities.ElementsUtils;


public class ArrayPage {
	
		
			public  WebDriver driver=DriverFactory.getdriver();
			Elementutils ac = new Elementutils();
			
			String tryEditorURL=ConfigReader.tryEditorURL();
			
			//Homepage
			@FindBy (xpath="//a[@href='data-structures-introduction']")WebElement getstart_datastructures;
			@FindBy (xpath="//a[@href='array']")WebElement getstart_array;
			@FindBy (xpath="//*[@id='navbarCollapse']//a[contains(text(), 'Data Structures')]")WebElement dropdown;
			@FindBy (xpath="//*[@id='navbarCollapse']//a[contains(@href, '/array')]")WebElement dropdown_array;
			
			//ArrayPage
			@FindBy (xpath="//a[@href='arrays-in-python']")WebElement arraysInPythonLink;
			
			@FindBy (xpath="//a[@href='/tryEditor']")WebElement TryHereLink;
			@FindBy (xpath="//*[@id='answer_form']")WebElement answerform;
			@FindBy (xpath="//textarea[@tabindex='0']")WebElement editorInput;
			@FindBy (xpath="//*[@id='answer_form']/button")
			static WebElement runButton;
			@FindBy (xpath="//*[@class='button']")WebElement submitButton;
			@FindBy (id="output")WebElement output; 
			
			public ArrayPage() {

				PageFactory.initElements(driver, this);
			}
			
			//public  void dropdown_arrayClick()
//			{
//				dropdown.click();
//				dropdown_array.click();
//			}
			
			public void getStartedArray()
			{
				getstart_array.click();

			}
			
//			public String ArrayPageTitle()
//			{
//				String title = driver.getTitle();
//				return title;
//			}
			
			public void ClickOnArraysInPython()
			{
				arraysInPythonLink.click();
			}
			
			public void clickOnTryhereLink(String btname,String destname)
			{
				TryHereLink.click();
			}
			public void enterPythonCode(String sheetname, int rownumber) throws InvalidFormatException, IOException {
				String code = ac.getCodefromExcel(sheetname, rownumber);
				ac.enterCode(code, editorInput);

		}

			public String getExpectedResult(String sheetname, int rownumber) throws InvalidFormatException, IOException {
				String expectedResult = ac.getResultfromExcel(sheetname, rownumber);
				return expectedResult;
			}
			public String getActualResult() {
				ac.waitForElementToappear(output);
				return output.getText();

			}

			public void navigateTotryEditor() {

				driver.get(tryEditorURL);

			}
			public static void clickOnRunButton() {
				runButton.click();

			}

			public String getErrorText() {
				
				String errorMsg = driver.switchTo().alert().getText();
				driver.switchTo().alert().accept();
				return errorMsg;
			}
			/*public void navigateTo(String pagename) {
				String urlName = ConfigReader.geturl(pagename);
				driver.get(urlName);
			}*/
		

		public void navigateTo(String page_name) {
			// TODO Auto-generated method stub
			String urlName = ConfigReader.geturl(page_name);
			driver.get(urlName);
		}

		public String getArrayPageTitle() {
			// TODO Auto-generated method stub
			
				String title = driver.getTitle();
			return title;
		}
			
		

		public void dropdown_Array() {
			// TODO Auto-generated method stub
			
				dropdown.click();
				dropdown_array.click();
				
			}
			
		}
			
		

				
			
		
