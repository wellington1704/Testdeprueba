import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import utileria.accion as accion

//Open Browser
WebUI.openBrowser("http://opencart.abstracta.us/")
WebUI.maximizeWindow();

//Search Iphone
if(accion.present("//a[contains(text(),'Your Store')]")) {
	accion.click("//input[@name='search']");
	accion.setText("//input[@name='search']", "iphone")
	accion.click("//span[@class='input-group-btn']");
	accion.agregarPuntoDeVerificacion("The page opened", true, true);
	
}else {
	accion.agregarPuntoDeVerificacion("The page did not open", true, true);
	
}

//Select Item
if(accion.present("//h2[contains(text(),'Search')]")) {
	WebUI.scrollToElement(accion.makeTestObjectFromXpath("//span[contains(text(),'Add to Cart')]"), 0)
	accion.click("//span[contains(text(),'Add to Cart')]");
	
}else {
	accion.agregarPuntoDeVerificacion("error when trying to select item", true, true);
}

//Item verification
accion.click("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']");
if(accion.present("//button[@title='Remove']")) {
	accion.agregarPuntoDeVerificacion("Item added successfullym", true, true);
}else {
	accion.agregarPuntoDeVerificacion("item was not added", true, true);
}

//Checkout y New Customer
accion.click("//span[contains(text(),'Checkout')]");
accion.click("//button[@id='details-button']");
WebUI.scrollToElement(accion.makeTestObjectFromXpath("//*[@id='proceed-link']"), 0)
accion.click("//*[@id='proceed-link']");

//Select register account
accion.click("//*[@name = 'account']");
WebUI.scrollToElement(accion.makeTestObjectFromXpath("//input[@id='button-account']"), 0)
accion.click("//input[@id='button-account']");
