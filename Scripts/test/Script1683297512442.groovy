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
import java.util.Random as Random

WebUI.openBrowser('')

WebUI.navigateToUrl('https://ecommerce-test.softmetrixgroup.com/')

WebUI.deleteAllCookies()

WebUI.maximizeWindow()

WebUI.refresh()

WebUI.click(findTestObject('Footer/divCountryLanguage'))

WebUI.click(findTestObject('CountryLanguage/select_en-PT'))

WebUI.click(findTestObject('Header/iconGuestProfile'))

WebUI.click(findTestObject('LoginPage/buttonRegisterNewAccount'))

WebUI.setText(findTestObject('LoginPage/inputFirstName'), 'Smoke')

WebUI.setText(findTestObject('LoginPage/inputLastName'), 'Test')

static String generateRandomEmail(int length) {
    String allowedChars = 'abcdefghijklmnopqrstuvwxyz0123456789'

    StringBuilder email = new StringBuilder()

    Random random = new Random()

    for (int i = 0; i < length; i++) {
        email.append(allowedChars.charAt(random.nextInt(allowedChars.length())))
    }
    
    email.append('@gmail.com')

    return email.toString()
}

// Generate random string for email prefix
String randomEmail = generateRandomEmail(10)
	println(randomEmail)

WebUI.setText(findTestObject('LoginPage/inputEmailRegister'), randomEmail)

String password = "SmokeTest123@"

WebUI.setText(findTestObject('LoginPage/inputPasswordRegister'), password)

WebUI.setText(findTestObject('LoginPage/inputConfirmPasswordRegister'), password)

WebUI.click(findTestObject('LoginPage/inputEmailRegister'))

WebUI.click(findTestObject('LoginPage/svgShowPasswordLogin'))

WebUI.click(findTestObject('LoginPage/svgShowConfirmPasswordRegister'))

WebUI.click(findTestObject('LoginPage/buttonCreateAnAccount'))