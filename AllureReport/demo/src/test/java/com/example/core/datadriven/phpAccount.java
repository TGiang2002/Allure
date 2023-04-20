package com.example.core.datadriven;

import org.testng.annotations.DataProvider;

import com.example.core.helper.JsonHelper;

public class phpAccount {
    @DataProvider(name = "accountLogin")
    public static Object accountLoginPhp () {
        return JsonHelper.ReadJsonFromFile("src\\test\\java\\com\\example\\resource\\datas\\phpaccountdata.json");       
    };
}