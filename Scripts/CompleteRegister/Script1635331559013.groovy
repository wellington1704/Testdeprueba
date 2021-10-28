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

WebUI.callTestCase(findTestCase("Test Cases/Test"), [:], FailureHandling.STOP_ON_FAILURE);

TestData registerdata = findTestData("registerdata");

int rows = registerdata.getRowNumbers();

String firstName;
String lastName;
String email;
String telefono;
String password;
String adress;
String city;
String postCode;


for(int i = 1; i<= rows; i++) {
	String status = registerdata.getObjectValue('ejecutar', i).toString();
	//if status = true
	if(status.equalsIgnoreCase("TRUE")) {
	
		//if the email bar is present
		if(accion.present("//legend[contains(text(),'Your Personal Details')]")) {
			
			firstName = registerdata.getObjectValue('firstName', i).toString();
			lastName = registerdata.getObjectValue("lastName", i).toString();
			email = registerdata.getObjectValue("email", i).toString();
			telefono = registerdata.getObjectValue("telefono", i).toString();
			password = registerdata.getObjectValue("password", i).toString();
			adress = registerdata.getObjectValue("adress", i).toString();
			city = registerdata.getObjectValue("city", i).toString();
			postCode = registerdata.getObjectValue("postCode", i).toString();
			
			accion.agregarPuntoDeVerificacion("Register Screen is displayed", true, true);
			
			//insert data
			accion.setText("//input[@id='input-payment-firstname']", firstName);
			
			//WebUI.scrollToElement(accion.makeTestObjectFromXpath("//*[@id='proceed-link']"), 0)
			
			accion.setText("//input[@id='input-payment-lastname']", lastName);
			
			//WebUI.scrollToElement(accion.makeTestObjectFromXpath("//select[@id='input-payment-zone']"), 0)
			 
			accion.setText("//input[@id='input-payment-email']", email);
			
			accion.setText("//input[@id='input-payment-telephone']", telefono);
			
			accion.setText("//input[@id='input-payment-password']", password);
			
			accion.setText("//input[@id='input-payment-confirm']", password);
			
			accion.setText("//input[@id='input-payment-address-1']", adress);
			
			accion.setText("//input[@id='input-payment-city']", city);
			
			accion.setText("//input[@id='input-payment-postcode']", postCode);
			
			//WebUI.scrollToElement(accion.makeTestObjectFromXpath("//input[@id='button-register']"), 0)
			
			accion.click("//select[@id='input-payment-zone']");
			
			accion.click("//option[@value='3513']");
			
			accion.click("//input[@name='agree']");
			
			WebUI.scrollToElement(accion.makeTestObjectFromXpath("//h4[contains(text(),'Step 6: Confirm Order')]"), 0)
			
			accion.click("//input[@id='button-register']");
			
			accion.click("//input[@id='button-shipping-address']");
			
			accion.click("//input[@id='button-shipping-method']");		
			
			accion.click("//input[@name='agree']");
			
			accion.click("//input[@id='button-payment-method']");
			
			//click confirm order
		
			accion.click("//input[@id='button-confirm']");
			
			//if this element appear
			if(accion.present("//p[contains(text(),'Your order has been successfully processed!')]")) {
				
				accion.click("//a[@class='btn btn-primary");
				
				accion.agregarPuntoDeVerificacion("The order has been made", true, true);
			
			}
			else {
				accion.agregarPuntoDeVerificacion("Element is not in the page", true, true);
			}
		
		}
		else {
			accion.agregarPuntoDeVerificacion("Register Screen isn't displayed", true, true);
		
		}
	}
}