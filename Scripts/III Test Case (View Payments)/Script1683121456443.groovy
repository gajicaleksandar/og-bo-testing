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

WebUI.click(findTestObject('BackOffice/divViewPaymentsPage'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/buttonAddNewPaymentMethod'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/divFirstSelectPaymentMethod'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/buttonContinue'))

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/BackOffice/ViewPayments/inputCardHolder'), 'CL-BRW2')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/inputCardNumber'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/BackOffice/ViewPayments/inputCardNumber'), '1111-1111-1111-1111')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/spanMonthDropdown'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/li4SelectMonth'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/spanYearDropdown'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/li2027SelectYear'))

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/BackOffice/ViewPayments/inputCVV'), '252')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/spanAddressDropdown'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/liFirstSelectAddress'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/buttonSave'))

WebUI.verifyElementVisible(findTestObject('BackOffice/ViewPayments/assertVisiblePaymentMethod'))

WebUI.verifyElementVisible(findTestObject('BackOffice/ViewPayments/assertCardNumber'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/span2EditMethod'))

WebUI.delay(2)

WebUI.click(findTestObject('BackOffice/ViewPayments/inputCardNumber'))

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/BackOffice/ViewPayments/inputCardNumber'), '2222-2222-2222-2222')

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/BackOffice/ViewPayments/inputCardNumber'), '2222-2222-2222-2222')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/spanMonthDropdown'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/li5SelectMonth'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/spanYearDropdown'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/li2026SelectYear'))

WebUI.delay(2)

WebUI.click(findTestObject('BackOffice/ViewPayments/inputCVV'))

WebUI.setText(findTestObject('Object Repository/BackOffice/ViewPayments/inputCVV'), '242')

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/BackOffice/ViewPayments/inputCVV'), '242')

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/spanAddressDropdown'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/liFirstSelectAddress'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/buttonSave'))

WebUI.verifyElementVisible(findTestObject('BackOffice/ViewPayments/assertNewCardNumber'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/button2Remove'))

WebUI.click(findTestObject('Object Repository/BackOffice/ViewPayments/buttonAcceptDeleteMethod'))

WebUI.verifyElementNotPresent(findTestObject('BackOffice/ViewPayments/assertVisiblePaymentMethod'), 2)

