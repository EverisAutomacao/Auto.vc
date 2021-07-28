package com.everis.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ConviteElements {

	public ConviteElements(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Convide seus amigos']/..")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Convide seus amigos']")
	public WebElement btnConvidar;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.TabHost/android.widget.LinearLayout/android.widget.FrameLayout/com.android.internal.widget.ViewPager/android.widget.RelativeLayout/com.android.internal.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.Button[1]")
	//@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.google.android:id/chooser_copy_button']")
	@iOSXCUITFindBy(xpath = "//*[contains(@name, 'Copy')]")
	public WebElement btnCopiar;
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.TabHost/android.widget.LinearLayout/android.widget.FrameLayout/com.android.internal.widget.ViewPager/android.widget.RelativeLayout/com.android.internal.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.Button[1]
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.TabHost/android.widget.LinearLayout/android.widget.FrameLayout/com.android.internal.widget.ViewPager/android.widget.RelativeLayout/com.android.internal.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.Button[1]
	//android:id/chooser_copy_button
	//@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.google.android:id/chooser_copy_button']")
	
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.TabHost/android.widget.LinearLayout/android.widget.FrameLayout/com.android.internal.widget.ViewPager/android.widget.RelativeLayout/com.android.internal.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.Button[1]
	//@AndroidFindBy(xpath = "//android.widget.TextView[@text='Copiar']") xpath antigo
	//android:id/chooser_copy_button
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gmail']")
	@iOSXCUITFindBy(xpath = "//*[contains(@name, 'Gmail')]")
	public WebElement btnGmail;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.google.android.gm:id/subject_content']")
	@iOSXCUITFindBy(xpath = "//*[contains(@name, 'Gmail')]")
	public WebElement appGmail;
	
	
}