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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://ecommerce-test.softmetrixgroup.com/')

WebUI.deleteAllCookies()

WebUI.maximizeWindow()

WebUI.refresh()

String shopVersion = WebUI.getText(findTestObject('Footer/shopVersion'))

println('Version of origin/test is: ' + shopVersion)

WebUI.click(findTestObject('Footer/divCountryLanguage'))

WebUI.click(findTestObject('CountryLanguage/select_en-PT'))

WebUI.click(findTestObject('Header/iconGuestProfile'))

WebUI.setText(findTestObject('LoginPage/inputEmailLogin'), 'smoketest@gmail.com')

WebUI.setText(findTestObject('LoginPage/inputPasswordLogin'), 'SmokeTest123@')

WebUI.click(findTestObject('LoginPage/svgShowPasswordLogin'))

WebUI.click(findTestObject('LoginPage/buttonSignIn'))

WebUI.click(findTestObject('Header/iconUserProfile'))

WebUI.click(findTestObject('Header/divAccountInformationBO'))

WebUI.click(findTestObject('BackOffice/divAutoshipPage'))

WebUI.delay(3)

String StringlastAutoshipNumber = WebUI.getText(findTestObject('BackOffice/Autoship/divLastAutosahipNumber'))

println(StringlastAutoshipNumber)

int lastAutoshipNumber = StringlastAutoshipNumber.toInteger()

println(lastAutoshipNumber)

WebUI.click(findTestObject('BackOffice/Autoship/buttonNewAutoship'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonFirstAddProduct'))

WebUI.click(findTestObject('BackOffice/Autoship/divHeaderAutoshipBag'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonUpQuantity'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonProceedToShippingDate'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonSelectTodayDate'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonProceedToShippingAddress'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonCheckFirstShippingAddress'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonProceedToPaymentInfo'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonCheckFirstPaymentMethod'))

WebUI.delay(2)

WebUI.click(findTestObject('BackOffice/Autoship/inputCVV'))

WebUI.delay(2)

WebUI.setText(findTestObject('BackOffice/Autoship/inputCVV'), '333')

WebUI.click(findTestObject('BackOffice/Autoship/buttonConfirmCvv'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonUpQuantity'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonSaveAutoship'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonFirstEditAutoship'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonUpQuantity'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonSaveAutoship'))

WebUI.delay(2)

WebUI.click(findTestObject('BackOffice/Autoship/inputCVV'))

WebUI.delay(2)

WebUI.setText(findTestObject('BackOffice/Autoship/inputCVV'), '333')

WebUI.click(findTestObject('BackOffice/Autoship/buttonConfirmCvv'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonFirstEditAutoship'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonSwitchAutoship'))

WebUI.click(findTestObject('BackOffice/Autoship/buttonSaveAutoship'))

WebUI.delay(3)

//int assertNewAutoshipNumber = lastAutoshipNumber + 1
//
//println('Last Autopship Number' + lastAutoshipNumber)

String StringlastNewAutoshipNumber = WebUI.getText(findTestObject('BackOffice/Autoship/divLastAutosahipNumber'))

	int lastNewAutoshipNumber = StringlastNewAutoshipNumber.toInteger()

	println('Last New Autoship Number: ' + lastNewAutoshipNumber)

assert lastAutoshipNumber != lastNewAutoshipNumber

if (lastAutoshipNumber != lastNewAutoshipNumber) {
    println('New Autoship Order is created: ' + lastNewAutoshipNumber)
	
} else {
    println('New Autoship Order isnt created')
}

WebUI.click(findTestObject('BackOffice/Autoship/buttonFirstRemoveAutoship'))

WebUI.delay(4)