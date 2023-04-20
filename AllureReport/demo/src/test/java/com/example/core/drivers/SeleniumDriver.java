package com.example.core.drivers;

import org.openqa.selenium.WebDriver;

public interface SeleniumDriver {
    WebDriver createDriver();
    public void setDriverOption(Object options);
    public void setCapabilities(Object capabilities);
}
