package com.example.core.helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ReadConfigPropertyFile {
    private static Properties properties;
    private static FileOutputStream fileOut;
    private static FileInputStream fileIn;

    public static String propertiesFilePath ="src\\test\\java\\com\\example\\core\\configs.properties";
    static String projectPath = System.getProperty("user.dir") + "\\";

    public static String getPropertyValue(String atrName){
        String value = null;
        try(FileInputStream input = new FileInputStream(propertiesFilePath)){
            Properties properties = new Properties();
            properties.load(input);
            value = properties.getProperty(atrName);

        }catch(Exception ex)
        {
            System.out.println(ex);
            System.out.println(ex.getMessage());
        }
        return value;
    }

    public static void setPropertiesFile() {
        properties = new Properties();
        try {
            //Khởi tạo giá trị cho đối tượng của class FileInputStream
            fileIn = new FileInputStream(projectPath + propertiesFilePath);
            //Load properties file
            properties.load(fileIn);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

     //Xây dựng hàm Get Value từ Key của file properties đã setup bên trên
     public static String getPropValue(String KeyProp) {
        String value = null;
        try {
            //get values from properties file
            value = properties.getProperty(KeyProp);
            System.out.println(value);
            return value;
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return value;
    }

    //Xây dựng hàm Set Value với Key tương ứng vào trong file properties đã setup bên trên
    public static void setPropValue(String KeyProp, String Value) {
        try {
            //Khởi tạo giá trị cho đối tượng của class FileOutputStream
            fileOut = new FileOutputStream(projectPath + propertiesFilePath);
            //Load properties file hiện tại và thực hiện mapping value với key tương ứng
            properties.setProperty(KeyProp, Value);
            //Lưu key và value vào properties file
            properties.store(fileOut, "Set new value in properties file");
            System.out.println("Set new value in file properties success.");
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

}
