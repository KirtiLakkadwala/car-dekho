package com.jspiders.cardekho_case_study_jdbc.operation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class CarOperation {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static int result;
	private static ResultSet resultSet;
	private static Properties properties = new Properties();
	private static FileInputStream file;
	private static String filePath = "C:\\Users\\Sonali\\eclipse-workspace\\cardekho_case_study_jdbc\\resources\\db_info.properties";
	private static String query;
	
	private static void openConnection()
   {
	   try {
		file = new FileInputStream(filePath);
		properties.load(file);
		Class.forName(properties.getProperty("driverPath"));
		connection = DriverManager.getConnection
				(properties.getProperty("dburl"), properties);
		} catch (Exception e) {
		   e.printStackTrace();
	   } 
	}
   
   private static void closeConnection()
   {
	   try {
		   if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (file != null) {
				file.close();
			}
			if (result != 0) {
				result = 0;
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
   
   
   public void addCarDetails() 
   {
	   try {
			openConnection();
			System.out.println("How many car details you want to add ? ");
			Scanner scanner  = new Scanner(System.in);
			int choice = scanner.nextInt();
			for (int i = 1; i <= choice; i++) {
				
				System.out.println("Enter Id :");
				int car_id = scanner.nextInt();
				System.out.println("Enter Name :");
				String name = scanner.next();
				System.out.println("Enter Model :");
				String model = scanner.next();
				System.out.println("Enter Brand :");
				String brand = scanner.next();
				System.out.println("Enter Fuel Type :");
				String fuel_type = scanner.next();
				System.out.println("Enter Price :");
				long price = scanner.nextLong();
				
				query = "insert into car_details "
						+ "values(?,?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, car_id);
				preparedStatement.setString(2,name);
				preparedStatement.setString(3,model);
				preparedStatement.setString(4,brand);
				preparedStatement.setString(5,fuel_type);
				preparedStatement.setLong(6,price);
				result = preparedStatement.executeUpdate();
				System.out.println("Query OK, " + result 
						+ " row(s) affected.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	   
	}
   
   public void removeCarDetails()
   {
	   try {
		   getAllCarDetails();
		   openConnection();
		   Scanner scanner = new Scanner(System.in);
		   System.out.println("\nEnter Your Car Id: ");
		   int id = scanner.nextInt();
		   query = "delete from car_details where car_id = ?";
		   preparedStatement = connection.prepareStatement(query);
		   preparedStatement.setInt(1,id);
		   result = preparedStatement.executeUpdate();
		   System.out.println("Query OK, " + result 
					+ " row(s) affected.");
	  } catch (Exception e) {
		e.printStackTrace();
	  } finally {
		closeConnection();
	  }
   }
   
 public void getAllCarDetails() {
	   try {
		   openConnection();
		   query = "select * from car_details";
		   preparedStatement = connection.prepareStatement(query);
		   resultSet = preparedStatement.executeQuery();
		   while(resultSet.next()) {
			   System.out.println(resultSet.getString(1) + " "
					             + resultSet.getString(2)  + " "
					             + resultSet.getString(3)  + " "
					             + resultSet.getString(4)  + " "
					             + resultSet.getString(5)  + " "
					             + resultSet.getString(6));
		   }
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		closeConnection();
	}
}
   
   public void searchByName()
	{
	   try {
		   openConnection();
		   query = "select * from car_details where name= ? ";
		   preparedStatement = connection.prepareStatement(query);
		   Scanner scanner = new Scanner(System.in);
		   System.out.println("\nEnter Your Car Name: ");
		   String name = scanner.next(); 
		   preparedStatement.setString(1,name);
		   resultSet = preparedStatement.executeQuery();
		   while(resultSet.next()) {
			   System.out.println(resultSet.getString(1) + " "
					             + resultSet.getString(2)  + " "
					             + resultSet.getString(3)  + " "
					             + resultSet.getString(4)  + " "
					             + resultSet.getString(5)  + " "
					             + resultSet.getString(6));
		   }
	  } catch (Exception e) {
		e.printStackTrace();
	  } finally {
			closeConnection();
	  }
	}
   
   public void searchByBrand()
	{
	   try {
		   openConnection();
		   query = "select * from car_details where brand= ? ";
		   preparedStatement = connection.prepareStatement(query);
		   Scanner scanner = new Scanner(System.in);
		   System.out.println("\nEnter Your Car Brand: ");
		   String brand = scanner.next(); 
		   preparedStatement.setString(1,brand);
		   resultSet = preparedStatement.executeQuery();
		   while(resultSet.next()) {
			   System.out.println(resultSet.getString(1) + " "
					             + resultSet.getString(2)  + " "
					             + resultSet.getString(3)  + " "
					             + resultSet.getString(4)  + " "
					             + resultSet.getString(5)  + " "
					             + resultSet.getString(6));
		   }
	  } catch (Exception e) {
		e.printStackTrace();
	  } finally {
			closeConnection();
	  }
	}
   
   public void searchByFuelType()
   {
	   try {
		   openConnection();
		   query = "select * from car_details where fuel_type= ? ";
		   preparedStatement = connection.prepareStatement(query);
		   Scanner scanner = new Scanner(System.in);
		   System.out.println("\nEnter Your Car Fuel Type: ");
		   String fuel_type = scanner.next(); 
		   preparedStatement.setString(1,fuel_type);
		   resultSet = preparedStatement.executeQuery();
		   while(resultSet.next()) {
			   System.out.println(resultSet.getString(1) + " "
					             + resultSet.getString(2)  + " "
					             + resultSet.getString(3)  + " "
					             + resultSet.getString(4)  + " "
					             + resultSet.getString(5)  + " "
					             + resultSet.getString(6));
		   }
	   } catch (Exception e) {
		e.printStackTrace();
	   } finally {
			closeConnection();
	   }
   }
   
   public void editCarDetails()
   {
	   try {
		   getAllCarDetails();
		   openConnection();
		   preparedStatement = connection.prepareStatement(query);
		   query = "update car_details set fuel_type = ? where car_id= ?";
		   Scanner scanner = new Scanner(System.in);
           System.out.println("\nEnter your Fuel Type: ");
		   String fuel_type = scanner.next();
		   System.out.println("\nEnter Your Car Id: ");
		   int c_id = scanner.nextInt();
		   preparedStatement.setString(1,fuel_type);
		   preparedStatement.setInt(2,c_id);
		   result = preparedStatement.executeUpdate();
		   System.out.println("Query OK, " + result 
					+ " row(s) affected."); 
	  } catch (Exception e) {
		e.printStackTrace();
	  } finally {
			closeConnection();
	  }
   }
   
}
