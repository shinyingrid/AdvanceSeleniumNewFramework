package Generic_Utilities_AS;

import org.python.antlr.PythonParser.return_stmt_return;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer
{
	int count=0;
	int retrylimit=3;
	
	public boolean retry(ITestResult result)
	{
		if(count<retrylimit)
		{
			count++;
			return true;
		}
		return false;
	}
}
