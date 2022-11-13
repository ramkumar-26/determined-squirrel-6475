package com.crimetime.usecases;

import java.io.IOException;
import java.util.Scanner;

import com.crimetime.exception.PoliceException;
import com.crimetime.model.Police;

public class MainApp {
	public static void main(String[] args) throws PoliceException, IOException {
		
		//welcome message
		System.out.println("Welcome To CrimeTime!"); 
		System.out.println("One place to manage all the Crimes and Criminals!!");
		
		MainApp m = new MainApp();
		
		m.mainMenu(); 
		m.homePageInput();
		
	}
		
	
	public  void homePageInput() throws PoliceException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any Option:");
		int input = sc.nextInt();
		
		switch(input) {
		case 1:
			PoliceFunctions new_login = new PoliceFunctions();
			new_login.policeLogin();
			break;
		case 2: 
			PoliceFunctions new_data = new PoliceFunctions();
			new_data.AddPolice();
			break;
		case 3: 
			System.out.println("Thank You! (Exited)");
			return;
		default:
			System.out.println("Wrong Input");
			mainMenu();
			homePageInput();
			break;
		}
	}
	
	public  void mainMenu() {
		System.out.println("========================================");
		System.out.println("|	      CrimeTime		       |");
		System.out.println("========================================");
		System.out.println("|  1.Police Inspector Login            |");
		System.out.println("|  2.New Inspector? Register!          |");
		System.out.println("|  3.Exit                              |");
		System.out.println("========================================");
	}
	
	
	
}
