package org.runner;

import java.util.HashMap;
import org.Dataprovider.DataProviderUtils;
import org.baseOneSelf.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SignInModule.Login;

public class Run extends BaseClass {

	@BeforeClass
	public void test1() {
		System.out.println("Starting");
	}

	@Test(dataProvider ="Sheet1",dataProviderClass = DataProviderUtils.class,priority =1)
	public void testScenario_1(HashMap<String,String> testdata) throws Throwable {
		Login.tc_01Login(testdata);
	}
}
