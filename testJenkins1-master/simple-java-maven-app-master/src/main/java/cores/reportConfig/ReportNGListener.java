package cores.reportConfig;

import cores.common.BaseTest;
import cores.common.GlobalConstants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("---------- " + iTestResult.getName() + " FAILED test ----------");
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        // Lấy được driver
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();


        // Chụp Hình và Đưa vào Report HTML
        String screenshotPath = captureScreenshotasBase64(webDriver, iTestResult.getName()); // trả về tên testcase);
        // Trạng thái của testcase
        Reporter.getCurrentTestResult();
        // Add vào report của testNG ---> Tạo thành 1 đường link
         Reporter.log("<br><a target=\"_blank\" href=\"data:image/png;base64," + screenshotPath + "\">" + "<img src=\"data:image/png;base64," + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
        // Set lại cái này = null để những tescase sau không bị ảnh hưởng
        Reporter.setCurrentTestResult(null);
    }

    public String captureScreenshotasFile(WebDriver driver, String screenshotName) {
        try {
            Calendar calendar = Calendar.getInstance();// Lấy ra thời gian để đặt tên
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenPath = GlobalConstants.PEPORTNG_SCREENSHOT_PATH + screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
            FileUtils.copyFile(source, new File(screenPath));
            return screenPath;
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
            return e.getMessage();
        }
    }

    public String captureScreenshotasBase64(WebDriver driver, String screenshotName){
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        return screenshotBase64;
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
