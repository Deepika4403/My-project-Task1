package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import config.DBConnect;
import model.CreateStoreModel;
import service.StoreService;

public class StoreServiceImpl implements StoreService {
	private String getaddress;
	private String getmobile;

	public void selectStudent() {
		Connection conn = null;
		Statement statement = null;

		String query = "select * from student";

		try {
			// get connection
			conn = DBConnect.getConnection();

			// create statement
			statement = conn.createStatement();

			// execute query
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				String mobile = rs.getString("mobile");

				System.out.println("name : " + name);
				System.out.println("address : " + address);
				System.out.println("mobile : " + mobile);
			}

			// close connection
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void createStudent() {
		Connection conn = null;
		Statement statement = null;
		String query1 ="";

		String s = "{\"name\":\"hi\",\"mobile\":\"9889675667\",\"address\":\"vsp\"}";
		ObjectMapper mapper = new ObjectMapper();

		CreateStoreModel store;
		try {
			store = mapper.readValue(s, CreateStoreModel.class);
			//CreateStoreModel obj = mapper.readValue(s, CreateStoreModel.class);
			query1 = "INSERT INTO STUDENT " + "VALUES ('" + store.getName() + "','" + store.getAddress() + "','"
					+ store.getMobile() + "')";
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		Object obj = JSONValue.parse(s);
//		JSONObject jsonObject = (JSONObject) obj;
//		String name = (String) jsonObject.get("name");
//		String mobile = (String) jsonObject.get("mobile");
//		String address = (String) jsonObject.get("address");
//		System.out.println(name + " " + mobile + " " + address);

		try {
			// get connection
			conn = DBConnect.getConnection();

			// create statement
			statement = conn.createStatement();

			int count = statement.executeUpdate(query1);
			System.out.println("count: " + count);

			// close connection
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void deleteStudentByName() {
		Connection conn = null;
		Statement statement = null;
		String query ="";

		String s = "{\"name\":\"pavan\"}";
		ObjectMapper mapper = new ObjectMapper();

		CreateStoreModel store;
		try {
			store = mapper.readValue(s, CreateStoreModel.class);
			//CreateStoreModel obj = mapper.readValue(s, CreateStoreModel.class);
			//store.setName("pavan");
			query = "Delete from student where name='" + store.getName() + "'";
			//statement=conn.createStatement();
			
			
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		Object obj = JSONValue.parse(s);
//		JSONObject jsonObject = (JSONObject) obj;
//		String name = (String) jsonObject.get("name");
		//String query = "Delete from student where name='" + name + "'";

		try {
			// get connection
			conn = DBConnect.getConnection();

			// create statement
			statement = conn.createStatement();

			int count = statement.executeUpdate(query);
			System.out.println("count: " + count);

			// close connection
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void updateNameByAddress() {
		Connection conn = null;
		Statement statement = null;
		String query2 ="";
		String s = "{\"address\":\"sklm\"}";
		ObjectMapper mapper = new ObjectMapper();
		CreateStoreModel store1 = null;
		try {
			store1 = mapper.readValue(s, CreateStoreModel.class);
		}
			 catch (JsonProcessingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
		
//		Object obj = JSONValue.parse(s);
//		JSONObject jsonObject = (JSONObject) obj;
//		String name = (String) jsonObject.get("name");
//		String address = (String) jsonObject.get("address");
		store1.setName("deepu");

		query2 = "UPDATE student SET name='" + store1.getName() + "'WHERE address='" + store1.getAddress() + "'";
		
		//
		

		try {
			// get connection
			conn = DBConnect.getConnection();

			// create statement
			statement = conn.createStatement();
			//PreparedStatement pstmt = conn.prepareStatement(query2);

			int count = statement.executeUpdate(query2);
			System.out.println("count: " + count);

			// close connection
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}
