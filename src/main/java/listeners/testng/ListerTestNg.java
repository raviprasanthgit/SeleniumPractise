package listeners.testng;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class ListerTestNg implements IAnnotationTransformer,IRetryAnalyzer {
	int iRetry=1;

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(this.getClass());
		annotation.setInvocationCount(1);
		if(!testMethod.getName().equals("createLead"))
		{
			annotation.setEnabled(false);
		}

	}

	@Override
	public boolean retry(ITestResult result) {
		if(result.isSuccess()&& iRetry<3)
		{
			iRetry++;
			return true;
		}else
		{
			return false;
		}
	}
}
