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

WebUI.openBrowser('https://www.service.nsw.gov.au/')

WebUI.setText(findTestObject('search bar'), 'Apply for a number plate')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/button search'))

WebUI.verifyElementText(findTestObject('Object Repository/result'), '91 results found for ‘Apply for a number plate’')

WebUI.navigateToUrl('https://www.service.nsw.gov.au/service-centre')

//verify result data using parameter
//we can update data directly in the GlobalVariable if we want to search the other suburb

WebUI.setText(findTestObject('Object Repository/placeholder suburb'), (GlobalVariable.serviceCentre))

WebUI.click(findTestObject('Object Repository/button search location'))

WebUI.delay(20)

result = WebUI.getText(findTestObject('Object Repository/resultDataForSuburb'))

if(result.contains('Marrickville Service Centre'))
{
	println ("PASSED")
}else {
	KeywordUtil.markFailedAndStop("no data found")
}

println (result)
