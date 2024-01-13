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

WebUI.navigateToUrl('https://truyenteen.me/')

WebUI.waitForElementPresent(findTestObject('Page_TrangChu/button_TurnAdOff'), 5)

WebUI.click(findTestObject('Object Repository/Page_TrangChu/button_TurnAdOff'))

WebUI.mouseOver(findTestObject('NavigationBar/dropdown_iconuser'))

WebUI.click(findTestObject('Object Repository/NavigationBar/link_DangNhap'))

WebUI.setText(findTestObject('Object Repository/Page_DangNhap/input_email'), Email)

WebUI.setText(findTestObject('Object Repository/Page_DangNhap/input_password'), Password)

WebUI.click(findTestObject('Object Repository/Page_DangNhap/button_DangNhap'))

WebUI.click(findTestObject('Object Repository/Page_TrangChu/button_TurnAdOff'))

WebUI.mouseOver(findTestObject('NavigationBar/dropdown_iconuser'))

WebUI.verifyElementPresent(findTestObject('NavigationBar/link_ThongTinUser'), 0)

WebUI.closeBrowser()

