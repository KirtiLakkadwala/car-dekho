package com.jspiders.cardekho_case_study_jdbc.main;

import java.util.Scanner;

import com.jspiders.cardekho_case_study_jdbc.operation.CarOperation;

public class CarDekhoMenu {
	private static CarOperation operation = new CarOperation();
	private static boolean exit = true;

	public static void main(String[] args) {
		while (exit) {
			carDekhoMenu();
		}
	}
	
	public static void carDekhoMenu() {
		System.out.println("\n================== Menu =======================");
		System.out.println("1.Add Car Details");
		System.out.println("2.Search Car Details");
		System.out.println("3.Upadte Car Details");
		System.out.println("4.Delete Car Details");
		System.out.println("5.Exit");
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEnter your choice: ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("===============Menu==========\n" 
		                        + "1.Add Car Details \n" 
					            + "2.Remove Car Details \n"
					            + "3.Go Back Main Menu");
			System.out.println("\nEnter your choice: ");
			int choice1 = scanner.nextInt();
			switch (choice1) {
			case 1:
				operation.addCarDetails();
				break;
			case 2:
				operation.removeCarDetails();
				break;
			case 3:
				carDekhoMenu();
				break;
			default:
				System.out.println("\nInvalid choice.Try again..!!");
				break;
			}
			break;
		case 2:
			System.out.println("=======Menu======\n" 
		                       + "1.Search Car By Name \n" 
					           + "2.Search Car By Brand \n"
					           + "3.Search Car By Fuel Type \n" 
					           + "4.All Cars \n" 
					           + "5.Go Back To Main Menu");
			int choice2 = scanner.nextInt();
			switch (choice2) {
			case 1: {
				operation.searchByName();
				break;
			}
			case 2: {
				operation.searchByBrand();
				break;
			}
			case 3: {

				operation.searchByFuelType();
				break;
			}
			case 4: {
				operation.getAllCarDetails();
			}
			case 5: {
				carDekhoMenu();
				break;
			}
			default: {
				System.out.println("Invaild choice");
			}
				break;
			}
			break;
		case 3:
			operation.editCarDetails();
			break;
		case 4:
			operation.removeCarDetails();
			break;
		case 5:
			System.out.println("Thank you..!!");
			exit = false;
			scanner.close();
			break;

		default:
			System.out.println("\nInvalid choice. Try again..!!");
			break;
		}

	}
}

