package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import config.DBConnect;
import service.StoreService;
import serviceImpl.StoreServiceImpl;

public class PracticeTest {

	public static void main(String[] args) {
		 //createStudent();
		// updateNameByAddress();
		//deleteStudentByName();
		//selectStudent();
		StoreService object=new StoreServiceImpl();
		//object.createStudent();
		object.updateNameByAddress();
		//object.selectStudent();
		//object.deleteStudentByName();
		
	}

	
}
