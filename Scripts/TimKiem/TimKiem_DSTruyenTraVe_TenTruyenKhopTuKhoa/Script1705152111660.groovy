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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.WebElement as WebElement
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://truyenteen.me/')

WebUI.waitForElementPresent(findTestObject('Page_TrangChu/button_TurnAdOff'), 10)

WebUI.click(findTestObject('Object Repository/Page_TrangChu/button_TurnAdOff'))

WebUI.setText(findTestObject('Object Repository/Page_TimKiem/input_search'), keyword)

WebUI.sendKeys(findTestObject('Object Repository/Page_TimKiem/input_search'), Keys.chord(Keys.ENTER))

WebUI.waitForPageLoad(10)

String currentUrl = WebUI.getUrl()

if(currentUrl == GlobalVariable.url_main) {
	WebUI.comment('Chưa nhập tìm kiếm')
	assert keyword == ''
} else {
	
	int wrongCount = 0;
	
	TestObject paginationButtons = findTestObject('Object Repository/Page_TimKiem/link_listOfPaginationButton')
	
	int numberOfPage = WebUIAbstractKeyword.findWebElements(paginationButtons, 10).size() - 2
	
	for(int k = 1; k <= numberOfPage; k++) {
		if(numberOfPage > 0) {
			WebUI.navigateToUrl(currentUrl + "&&page=" + k)
			WebUI.waitForPageLoad(10)
		}
		
		TestObject linkNameObject = findTestObject('Object Repository/Page_TimKiem/link_TenTruyen')
	
		List<WebElement> elements = WebUIAbstractKeyword.findWebElements(linkNameObject, 10)

		List<WebElement> wrongElements = elements.findAll({ def i ->
			i.getText().toLowerCase().find(keyword) == null
		})
	
		wrongCount += wrongElements.size()
	}

	WebUI.comment("Kết quả mong đợi là")
	assert wrongCount == 0
}

WebUI.closeBrowser()

