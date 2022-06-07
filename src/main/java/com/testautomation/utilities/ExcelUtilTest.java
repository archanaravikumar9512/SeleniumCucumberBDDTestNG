package com.testautomation.utilities;

import com.testautomation.managers.FileReaderManager;

public class ExcelUtilTest {

	public static void main(String[] args) {
		// Xls_Reader reader = new Xls_Reader(prop.getProperty("runmanagerfilepath"));
		Xls_Reader reader = new Xls_Reader(
				"C://Users//0027RQ744//eclipse-workspace//WEMS_AutomationTool//src//main//resources//testDataResources//RunManager.xlsx");
		String sheetName = "RunManager";

		int rowCount = reader.getRowCount(sheetName);
		System.out.println("No of rows : " + rowCount);

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String appName = reader.getCellData(sheetName, "Application", rowNum);
			String flag = reader.getCellData(sheetName, "Flag", rowNum);
			if (flag.equals("Yes")) {
				runApplicationTest(appName);
			} else if (flag.equals("No")) {
				System.out.println("Ignore ApplicationTest");
			}
		}
	}

	public static void runApplicationTest(String appName) {

		Xls_Reader reader = new Xls_Reader(FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath());
		// System.out.println("file path="+reader);
		String sheetName = appName;
		int rowCount = reader.getRowCount(sheetName);
		for (int rowNum = 1; rowNum <= rowCount; rowNum++) {
			String testCaseFlag = reader.getCellData(sheetName, "FLAG", rowNum);
			System.out.println("testCaseFlag" + testCaseFlag);
			if (testCaseFlag.equals("Yes")) {
				System.out.println("Run the test case");
			} else {
				System.out.println("Ignore test case");
			}
		}

	}

}
