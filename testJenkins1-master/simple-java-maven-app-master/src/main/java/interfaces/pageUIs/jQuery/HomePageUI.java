package interfaces.pageUIs.jQuery;

public class HomePageUI {
public static final String HEADER_TEXTBOX_BY_HEADER_NAME = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
public static final String UPLOAD_FILE = "css=input[type='file']";
public static final String IMAGE_FILE_NAME_LOADED = "xpath=//p[@class='name' and text()='%s']";
public static final String START_BUTTON = "css=tbody.files button.start";
public static final String IMAGE_FILE_NAME_UPLOADED = "css=p[class='name'] a[title='%s']";

}
