package com.hrmapp.resources;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.hrmapp.base.BaseClass;


public class Listeners extends BaseClass implements ITestListener{

	public static ThreadLocal<ExtentTest> testRep = new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		exTest=exRep.createTest(result.getMethod().getMethodName()).log(Status.INFO, "Test Started");
		testRep.set(exTest);
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		exTest.log(Status.PASS, "Test Passed"+result.getTestName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus()==ITestResult.FAILURE)
		{exTest.log(Status.FAIL,MarkupHelper.createLabel(result.getTestName()+"Test Failed", ExtentColor.RED ));
		exTest.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "Test Failed", ExtentColor.RED));}
		testRep.get().fail(result.getThrowable());
		String imgPath;
		try {
			imgPath = screenShot(BaseClass.getDriver(), result.getName());
			 exTest.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		exRep.flush();
	}

}
