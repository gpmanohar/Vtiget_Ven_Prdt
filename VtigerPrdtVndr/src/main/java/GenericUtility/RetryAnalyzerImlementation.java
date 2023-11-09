package GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImlementation implements IRetryAnalyzer{

	int count = 0;
	int retrycount = 3;
	
	public boolean retry(ITestResult arg0) {
		while(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}

	
	
}
