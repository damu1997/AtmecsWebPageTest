package com.atmecs.qa.testscript;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.atmecs.qa.helper.CsrPageHelper;
import com.atmecs.qa.testbase.Base;
import com.atmecs.qa.utils.CommonUtils;
import com.atmecs.qa.utils.LogReporter;

/**
 * This class will performs the validation of the total link count and asserting
 * link one by one.
 * 
 * @author Damodaran.Krishnan
 *
 */
public class CsrPageTest extends Base {

	static CommonUtils commutils = new CommonUtils();
	LogReporter logreport = new LogReporter();

	@Test(priority = 0)
	public void validateAllHyperLinkCount() {
		CsrPageHelper.preRequestNavigation(driver, commutils);
		// getting all the link in list
		List<WebElement> allhyperlink = commutils.getListOfWebElement(driver, CsrPageHelper.allHyperLinkgetProperty());
		List<String> listoflink = commutils.convertListFromWebElement(driver, allhyperlink);
		// asserting with the size
		commutils.verifyTrue(allhyperlink.size() == listoflink.size(), "passed");
		logreport.info("AddedIntoList-->" + listoflink.toString());
	}

	@Test(priority = 1)
	public void assertingAllTheLink() { // asserting all the link individually with the header
		CsrPageHelper.assertinglinkHeader(driver, commutils, CsrPageHelper.davLinkgetProperty(),
				CsrPageHelper.davHeadergetProperty());
		CsrPageHelper.assertinglinkHeader(driver, commutils, CsrPageHelper.sjudeLinkgetProperty(),
				CsrPageHelper.sjudeHeadergetProperty());
		CsrPageHelper.assertinglinkHeader(driver, commutils, CsrPageHelper.scfLinkgetProperty(),
				CsrPageHelper.scfHeadergetProperty());
		CsrPageHelper.assertinglinkHeader(driver, commutils, CsrPageHelper.ncfLinkgetProperty(),
				CsrPageHelper.ncfHeadergetProperty());
		CsrPageHelper.assertinglinkHeader(driver, commutils, CsrPageHelper.hfhLinkgetProperty(),
				CsrPageHelper.hfhHeadergetProperty());

	}

}
