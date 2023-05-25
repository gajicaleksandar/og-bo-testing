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

WebUI.click(findTestObject('BackOffice/divViewMyOrdersPage'))

WebUI.click(findTestObject('BackOffice/ViewMyOrders/svg1ViewDetailOrder'))

WebUI.delay(3)

WebUI.verifyElementVisible(findTestObject('BackOffice/ViewMyOrders/assertViewOrder'))

WebUI.click(findTestObject('BackOffice/ViewMyOrders/buttonGoBackDetailOrder'))

String invoice_number = WebUI.executeJavaScript('return JSON.parse(JSON.parse(localStorage.getItem(\'persist:og\')).orderHistory).orders.content[0].invoice_number;', 
    null)

println(invoice_number)

WebUI.click(findTestObject('BackOffice/ViewMyOrders/button1RepeatOrder'))

WebUI.click(findTestObject('BackOffice/ViewMyOrders/RepeatOrder/iconUpQuantity'))

WebUI.click(findTestObject('BackOffice/ViewMyOrders/RepeatOrder/buttonCheckout'))

WebUI.click(findTestObject('BackOffice/ViewMyOrders/RepeatOrder/buttonCheckout'))

WebUI.delay(5)

String urlCheckout = WebUI.getUrl()

println(urlCheckout)

if (urlCheckout.contains('checkout')) {
    println('Checkout page is opened')
} else {
    println('Checkout page is not opened')

    WebUI.delay(3)

    WebUI.click(findTestObject('BackOffice/ViewMyOrders/button1RepeatOrder'))

    WebUI.click(findTestObject('BackOffice/ViewMyOrders/RepeatOrder/iconUpQuantity'))

    WebUI.click(findTestObject('BackOffice/ViewMyOrders/RepeatOrder/buttonCheckout'))

    WebUI.click(findTestObject('BackOffice/ViewMyOrders/RepeatOrder/buttonCheckout'))

    WebUI.delay(3)
}

if (invoice_number.contains('US')) {
    //USA
    println('This order is from: USA - ' + invoice_number)

    WebUI.setText(findTestObject('CheckoutPage/Contact Information/inputPhoneNumberContact'), '8065464645')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingFirstName'), 'smoke')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingLastName'), 'test')

    WebUI.clearText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputPhoneNumberShipping'), FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputPhoneNumberShipping'), '065464645')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingAddress'), '3240 Arville St')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingApartment'), 'apartment test 1')

    WebUI.click(findTestObject('CheckoutPage/Shipping Addres/Shipping/divStateDropdown'))

    WebUI.click(findTestObject('CheckoutPage/Shipping Addres/Shipping/div2SelectState'))

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputCity'), 'Las Vegas')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingPostalCode'), '89102')

    WebUI.click(findTestObject('CheckoutPage/Shipping Addres/buttonContinueToPayment'))

    WebUI.click(findTestObject('CheckoutPage/divCreditCardMethod'))

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCardNumber'), '4444333322221111')

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCardHolder'), 'John Smith')

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCardExpire'), '02/25')

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCvv'), '657')

    WebUI.click(findTestObject('CheckoutPage/buttonPayNow'))

    WebUI.delay(15)
} else if (invoice_number.contains('AU')) {
    println('This order is from: Autralia - ' + invoice_number)

    WebUI.setText(findTestObject('CheckoutPage/Contact Information/inputPhoneNumberContact'), '255504321')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingFirstName'), 'smoke')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingLastName'), 'test')

    WebUI.clearText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputPhoneNumberShipping'), FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputPhoneNumberShipping'), '55504321')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingAddress'), '3240 Arville St')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingApartment'), 'apartment test 1')

    WebUI.click(findTestObject('CheckoutPage/Shipping Addres/Shipping/divStateDropdown'))

    WebUI.click(findTestObject('CheckoutPage/Shipping Addres/Shipping/div2SelectState'))

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputCity'), 'Sydney')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingPostalCode'), '5374')

    WebUI.click(findTestObject('CheckoutPage/Shipping Addres/buttonContinueToPayment'))

    WebUI.click(findTestObject('CheckoutPage/divCreditCardMethod'))

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCardNumber'), '4242424242424242')

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCardHolder'), 'CL-BRW2')

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCardExpire'), '02/25')

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCvv'), '657')

    WebUI.click(findTestObject('CheckoutPage/buttonPayNow'))

    WebUI.delay(15)
} else if (invoice_number.contains('ZA')) {
    WebUI.setText(findTestObject('Object Repository/CheckoutPage/Contact Information/inputPhoneNumberContact'), '633423534')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingFirstName'), 'smoke')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingLastName'), 'test')

    WebUI.clearText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputPhoneNumberShipping'), FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputPhoneNumberShipping'), '33423534')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingAddress'), '3240 Arville St')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingApartment'), 'apartment test 1')

    WebUI.click(findTestObject('CheckoutPage/Shipping Addres/Shipping/divStateDropdown'))

    WebUI.click(findTestObject('CheckoutPage/Shipping Addres/Shipping/div2SelectState'))

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputCity'), 'Pretoria')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingPostalCode'), '0002')

    WebUI.click(findTestObject('CheckoutPage/Shipping Addres/buttonContinueToPayment'))

    WebUI.click(findTestObject('CheckoutPage/divCreditCardMethod'))

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCardNumber'), '4000000000000002')

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCardHolder'), 'CL-BRW2')

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCardExpire'), '02/25')

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCvv'), '657')

    WebUI.click(findTestObject('CheckoutPage/buttonPayNow'))

    WebUI.delay(15)
} else {
    println('This order is from: Europe - ' + invoice_number)

    WebUI.setText(findTestObject('Object Repository/CheckoutPage/Contact Information/inputPhoneNumberContact'), '305345345')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingFirstName'), 'smoke')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingLastName'), 'test')

    WebUI.clearText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputPhoneNumberShipping'), FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputPhoneNumberShipping'), '05345345')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingAddress'), '3240 Arville St')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingApartment'), 'apartment test 1')

    WebUI.click(findTestObject('CheckoutPage/Shipping Addres/Shipping/divStateDropdown'))

    WebUI.click(findTestObject('CheckoutPage/Shipping Addres/Shipping/div2SelectState'))

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputCity'), 'Lisboa')

    WebUI.setText(findTestObject('CheckoutPage/Shipping Addres/Shipping/inputShippingPostalCode'), '9630')

    WebUI.click(findTestObject('CheckoutPage/Shipping Addres/buttonContinueToPayment'))

    WebUI.click(findTestObject('CheckoutPage/divCreditCardMethod'))

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCardNumber'), '4000020951595032')

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCardHolder'), 'CL-BRW2')

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCardExpire'), '02/25')

    WebUI.delay(2)

    WebUI.setText(findTestObject('CheckoutPage/Payment Methods/inputCvv'), '657')

    WebUI.click(findTestObject('CheckoutPage/buttonPayNow'))

    WebUI.delay(15)
}

//Uzimamo status code za 3d secure
String script = null

try {
    script = WebUI.executeJavaScript('return JSON.parse(JSON.parse(localStorage.getItem(\'persist:og\')).checkout).paymentResponse.status_code;', 
        null)
}
catch (Exception e) {
    WebUI.comment("Error while loading script: $e.message")
} 

if ((script == null) || script.equals('')) {
    script = '0'
}

statusCode = Integer.parseInt(script)

if (statusCode == 0) {
    println('Script: ' + script)

    WebUI.delay(10)

    WebUI.click(findTestObject('Page ThreeDS ACS Emulator (SafeCharge)/button3dsSuccessAuthentication'))

    WebUI.delay(10)

    WebUI.click(findTestObject('Page ThreeDS ACS Emulator (SafeCharge)/button3dsSubmitRedirect'))

    WebUI.click(findTestObject('Page ThreeDS ACS Emulator (SafeCharge)/buttonSendAnywayAllert'))

    WebUI.verifyElementVisible(findTestObject('Header/iconUserProfile'))
} else {
    println('Script: ' + script)

    WebUI.verifyElementVisible(findTestObject('Header/iconUserProfile'))
}

//Proveravamo Order Numbers sa FP i u BO da li se poklapaju
String orderScriptFP = WebUI.executeJavaScript('return JSON.parse(JSON.parse(localStorage.getItem(\'persist:og\')).checkout).paymentResponse.order_number;', 
    null)

orderNumberFP = Integer.parseInt(orderScriptFP)

println('Order Number Finish-Payment: ' + orderNumberFP)

WebUI.verifyElementVisible(findTestObject('Header/iconUserProfile'))

WebUI.verifyElementVisible(findTestObject('FinishPaymentPage/h1Congratulations'))

WebUI.click(findTestObject('Object Repository/FinishPaymentPage/buttonYourOrders'))

WebUI.delay(5)

String orderScriptBO = WebUI.executeJavaScript('return JSON.parse(JSON.parse(localStorage.getItem(\'persist:og\')).orderHistory).orders.content[0].order_number;', 
    null)

orderNumberBO = Integer.parseInt(orderScriptBO)

println('Order Number BO: ' + orderNumberBO)

if (orderNumberFP == orderNumberBO) {
    println((((('Order Numbers match. ' + orderNumberFP) + ' ') + ' - ') + ' ') + orderNumberBO)

    WebUI.click(findTestObject('BackOffice/ViewMyOrders/svg1ViewDetailOrder'))

    WebUI.click(findTestObject('BackOffice/ViewMyOrders/buttonGoBackDetailOrder'))

    WebUI.click(findTestObject('BackOffice/ViewMyOrders/ahrefFirstInvoiceBO'))
} else {
    println((((('Error: Order Numbers do not match. ' + orderNumberFP) + ' ') + ' - ') + ' ') + orderNumberBO)
}

assert orderNumberFP == orderNumberBO

WebUI.click(findTestObject('BackOffice/ViewMyOrders/ahrefFirstInvoiceBO'))

