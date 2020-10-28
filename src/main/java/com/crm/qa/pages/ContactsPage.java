package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black'][text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement createcontactNewBtn;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement company;
	
	@FindBy(xpath = "//button[@class='ui linkedin button'][text()='Save']")
	WebElement saveBtn;
	
	
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	
	public void createNewContact(String ftName, String ltName, String comp){
		/*Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);*/
		
		createcontactNewBtn.click();
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	
	
	

}
