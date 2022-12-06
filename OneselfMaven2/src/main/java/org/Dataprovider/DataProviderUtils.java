package org.Dataprovider;



import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.excelRead.ExcelUtility;
import org.testng.annotations.DataProvider;



public final class DataProviderUtils {
       @DataProvider(name = "Sheet1")
        public static Object[][] getScenarioDetails1(Method method){
            Map<String, HashMap<String, String>> data;
            data = ExcelUtility.readExcelData("Sheet1");            
            return new Object[][] { { data.get(method.getName()) } };
        }
}