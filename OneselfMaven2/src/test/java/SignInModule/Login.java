package SignInModule;

import java.util.HashMap;
import org.baseOneSelf.BaseClass;
import org.locator.Page_Element;
import org.report.Report;

public class Login extends BaseClass implements Page_Element {
	public static  void tc_01Login(HashMap<String,String> userName) throws Throwable {
		Report.Report();
		Report.ReportCreateTestcase("To check whether only the existing user can able to sign in the application.");
		browserLaunch("https://oneself-admin-test.optisolbusiness.com/login");
		
		try {	
			sendkeys(email, userName.get("UserName"));
			sendkeys(password,userName.get("Password"));
			click(signin);
			IsElementDisplayed(table);
			Report.Pass("The admin should be signed in only by the existing users.");
		    } catch (Exception e){
			Report.Fail("The admin should not be signed in only by the existing users.");			
			Report.ReportCooldown();
		    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
