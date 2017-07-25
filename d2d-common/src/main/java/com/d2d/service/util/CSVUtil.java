package com.d2d.service.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class CSVUtil {

	 private static CSVUtil csvUtil;

	 private CSVUtil() {
	 }

	 public static CSVUtil getInstanse() {
		 if (csvUtil == null) {
			 csvUtil = new CSVUtil();
		 }
		 return csvUtil;
	 }
	 
	 public List<String []> readCSV(String path) {
		 CSVReader reader = null;
		 try {
			 reader = new CSVReader(new FileReader(path));
		     List<String []> rows = reader.readAll();
		     return rows;
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }finally{
			 try {
				 if(reader != null){
					 reader.close();
				 }
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
	     return null;
	 }
	 
	 public static void main(String[] args) {
		List<String[]> rows = CSVUtil.getInstanse().readCSV("e:/Coupons.csv");
		for (String[] row : rows) {
			System.out.println(row[0] + " - " + row[1]);
		}
	}
}
