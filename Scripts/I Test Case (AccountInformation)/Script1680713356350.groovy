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

WebUI.click(findTestObject('LoginPage/buttonRegisterNewAccount'))

WebUI.setText(findTestObject('LoginPage/inputFirstName'), 'Smoke')

WebUI.setText(findTestObject('LoginPage/inputLastName'), 'Test')

String randomEmail = generateRandomEmail(10)

println(randomEmail)

WebUI.setText(findTestObject('LoginPage/inputEmailRegister'), randomEmail)

String password = 'SmokeTest123@'

String newPassword = 'Test123@'

WebUI.setText(findTestObject('LoginPage/inputPasswordRegister'), password)

WebUI.setText(findTestObject('LoginPage/inputConfirmPasswordRegister'), password)

WebUI.click(findTestObject('LoginPage/inputEmailRegister'))

WebUI.click(findTestObject('LoginPage/svgShowPasswordLogin'))

WebUI.click(findTestObject('LoginPage/svgShowConfirmPasswordRegister'))

WebUI.click(findTestObject('LoginPage/buttonCreateAnAccount'))

String randomEmail2 = generateRandomEmail(10)

println('Generated new mail: ' + randomEmail2)

boolean isPresentAllertWindowRegistration = WebUI.waitForAlert(5)

if (isPresentAllertWindowRegistration == true) {
    println('Alert window is present. Email exist')

    WebUI.clearText(findTestObject('LoginPage/inputEmailRegister'))

    WebUI.setText(findTestObject('LoginPage/inputEmailRegister'), randomEmail2)

    WebUI.click(findTestObject('LoginPage/buttonCreateAnAccount'))
} else {
    println('Alert window is not present. Email does not exist')
}

WebUI.delay(3)

WebUI.click(findTestObject('Header/iconUserProfile'))

WebUI.click(findTestObject('Header/divAccountInformationBO'))

WebUI.click(findTestObject('BackOffice/divViewMyOrdersPage'))

WebUI.click(findTestObject('BackOffice/divViewPaymentsPage'))

WebUI.click(findTestObject('BackOffice/divAutoshipPage'))

WebUI.click(findTestObject('BackOffice/divPrivacyCommunicationPage'))

WebUI.click(findTestObject('BackOffice/divAccountInformationPage'))

WebUI.click(findTestObject('BackOffice/AccountInformation/pAddressInformationLabel'))

WebUI.click(findTestObject('BackOffice/AccountInformation/AddressInformation/pAddNewAddress'))

WebUI.setText(findTestObject('BackOffice/AccountInformation/AddressInformation/inputAddressTitle'), 'test address')

WebUI.setText(findTestObject('BackOffice/AccountInformation/AddressInformation/inputFirstName'), 'smoke')

WebUI.setText(findTestObject('BackOffice/AccountInformation/AddressInformation/inputLastName'), 'test')

WebUI.setText(findTestObject('BackOffice/AccountInformation/AddressInformation/inputPhoneNumber'), '305 345 345')

WebUI.setText(findTestObject('BackOffice/AccountInformation/AddressInformation/inputStreetAddress'), 'test1')

WebUI.setText(findTestObject('BackOffice/AccountInformation/AddressInformation/inputApartment'), '1')

WebUI.click(findTestObject('BackOffice/AccountInformation/AddressInformation/divCountryDropdown'))

WebUI.click(findTestObject('BackOffice/AccountInformation/AddressInformation/divPortugalSelectCountry'))

WebUI.click(findTestObject('BackOffice/AccountInformation/AddressInformation/divSelectStateDropdown'))

WebUI.click(findTestObject('BackOffice/AccountInformation/AddressInformation/div1SelectState'))

WebUI.setText(findTestObject('BackOffice/AccountInformation/AddressInformation/inputCity'), 'Lisboa')

WebUI.setText(findTestObject('BackOffice/AccountInformation/AddressInformation/inputZipOrPostalCode'), '5000')

WebUI.click(findTestObject('BackOffice/AccountInformation/AddressInformation/buttonSave'))

WebUI.verifyElementVisible(findTestObject('BackOffice/AccountInformation/AddressInformation/assertAddressTitle'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BackOffice/AccountInformation/pAccountInformationLabel'))

WebUI.click(findTestObject('BackOffice/AccountInformation/AccountInformation/pUpdatePassword'))

WebUI.setText(findTestObject('BackOffice/AccountInformation/AccountInformation/inputEnterOldPassword'), password)

WebUI.setText(findTestObject('BackOffice/AccountInformation/AccountInformation/inputEnterNewPassword'), newPassword)

WebUI.setText(findTestObject('BackOffice/AccountInformation/AccountInformation/inputReEnterNewPassword'), newPassword)

WebUI.click(findTestObject('BackOffice/AccountInformation/AccountInformation/buttonSave'))

WebUI.delay(3)

WebUI.click(findTestObject('BackOffice/AccountInformation/AccountInformation/buttonAddMobilePhone'))

WebUI.delay(3)

WebUI.setText(findTestObject('BackOffice/AccountInformation/AccountInformation/inputMobilePhoneNumber'), '305 345 345')

WebUI.click(findTestObject('BackOffice/AccountInformation/AccountInformation/buttonSave'))

WebUI.verifyElementVisible(findTestObject('BackOffice/AccountInformation/AddressInformation/assertPhoneNumber'))

WebUI.click(findTestObject('BackOffice/AccountInformation/AccountInformation/buttonRemoveMobilePhoneNumber'))

WebUI.click(findTestObject('BackOffice/AccountInformation/AccountInformation/buttonAcceptRemovePhoneNumber'))

WebUI.click(findTestObject('Header/iconUserProfile'))

WebUI.click(findTestObject('Header/pLogOut'))

WebUI.click(findTestObject('Header/iconGuestProfile'))

if (isPresentAllertWindowRegistration == true) {
    WebUI.setText(findTestObject('LoginPage/inputEmailLogin'), randomEmail2)
} else {
    WebUI.setText(findTestObject('LoginPage/inputEmailLogin'), randomEmail)
}

WebUI.setText(findTestObject('LoginPage/inputPasswordLogin'), newPassword)

WebUI.click(findTestObject('LoginPage/svgShowPasswordLogin'))

WebUI.click(findTestObject('LoginPage/buttonSignIn'))

WebUI.delay(5)

WebUI.click(findTestObject('Header/iconUserProfile'))

WebUI.click(findTestObject('Header/divAccountInformationBO'))

WebUI.click(findTestObject('BackOffice/AccountInformation/pAccountInformationLabel'))

WebUI.click(findTestObject('BackOffice/AccountInformation/AccountInformation/pUpdatePassword'))

WebUI.setText(findTestObject('BackOffice/AccountInformation/AccountInformation/inputEnterOldPassword'), newPassword)

WebUI.setText(findTestObject('BackOffice/AccountInformation/AccountInformation/inputEnterNewPassword'), password)

WebUI.setText(findTestObject('BackOffice/AccountInformation/AccountInformation/inputReEnterNewPassword'), password)

WebUI.click(findTestObject('BackOffice/AccountInformation/AccountInformation/buttonSave'))

WebUI.click(findTestObject('Header/iconUserProfile'))

WebUI.click(findTestObject('Header/pLogOut'))

WebUI.verifyElementVisible(findTestObject('Header/iconGuestProfile'), FailureHandling.STOP_ON_FAILURE)

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

