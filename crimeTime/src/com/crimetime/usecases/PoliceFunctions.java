package com.crimetime.usecases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.crimetime.dao.PoliceDao;
import com.crimetime.dao.PoliceDaoImpl;
import com.crimetime.dao.crimeDao;
import com.crimetime.dao.crimeDaoImpl;
import com.crimetime.dao.criminalDao;
import com.crimetime.dao.criminalDaoImpl;
import com.crimetime.exception.CrimeException;
import com.crimetime.exception.CriminalException;
import com.crimetime.exception.PoliceException;
import com.crimetime.model.Crime;
import com.crimetime.model.Criminal;
import com.crimetime.model.InvestigationDetails;
import com.crimetime.model.Police;

public class PoliceFunctions {
	
	//police Login
	public void  policeLogin() throws PoliceException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PoliceID:");
		int police_id = sc.nextInt();
		System.out.println("Enter Password:");
		String password = sc.next();
		
		PoliceDao dao = new PoliceDaoImpl();
		try {
		boolean res = dao.policeLogin(police_id, password);
		if(res) {
			System.out.println("Login Successful!");
			DisplayPoliceMenu();
			PoliceMainInput();
			
		 }
		}catch(PoliceException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	//add police
	public  void AddPolice() throws PoliceException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("POLICE REGISTRATION");
		System.out.println("Enter Police ID:");
		int police_id = sc.nextInt();
		System.out.println("Enter Name:");
		String police_name = sc.next();
		System.out.println("Enter Reporting PoliceStation:\n");
		String reporting_ps = sc.next();
		System.out.println("Enter Password:\n");
		String password = sc.next();
		
		Police p = new Police();
		p.setPolice_id(police_id);
		p.setName(police_name);
		p.setAssigned_policestation(reporting_ps);
		p.setPassword(password);
		p.setAccess_status(null);
		
		PoliceDao dao = new PoliceDaoImpl();
		try {
			int res = dao.addPolice(p);
			if(res==0) {
				throw new PoliceException("Insertion Failed!");
			}else {
				System.out.println("Police Record Added!");
			}
		} catch (PoliceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		MainApp m = new MainApp();
		m.mainMenu();
		m.homePageInput();
	}
	
	
	//police menu
	public void DisplayPoliceMenu() {
		System.out.println("========================================");
		System.out.println("| 1. Register a New Crime              |");
		System.out.println("| 2. Register a new Criminal           |");
		System.out.println("| 3. Display All Crime                 |");
		System.out.println("| 4. Display All Criminal              |");
		System.out.println("| 5. Link  Criminal with  Crime        |");
		System.out.println("| 6. Update a Crime Status             |");
		System.out.println("| 7. Search Crime With Crime ID        |");
		System.out.println("| 8. Seacrh Criminal with Criminal ID  |");
		System.out.println("| 9. Generate Report                   |");
		System.out.println("|10. Logout                            |");
		System.out.println("========================================");
	}
	
	//police input
	public void PoliceMainInput() throws IOException, PoliceException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Any Options:");
		int input = sc.nextInt();
		
		switch (input) {
		case 1:
			AddNewCrime();
			break;
		case 2:
			AddNewCriminal();
			break;
		case 3: 
			DisplayAllCrime();
			break;
		case 4:
			DisplayAllCriminal();
			break;
		case 5:
			LinkCrimeToCriminal();
			break;
		case 6:
			UpdateCrimeStatus();
			break;
		case 7:
			SearchFuntions s = new SearchFuntions();
			s.CrimeWithCrimeID();;
			break;
		case 8:
			SearchFuntions s2 = new SearchFuntions();
			s2.CriminalWithCriminalID();
		    break;
		case 9:
			GenerateReport();
			break;
		case 10:
			System.out.println("Logged Out");
			MainApp m = new MainApp();
			m.mainMenu();
			m.homePageInput();
			break;
		default:
			System.out.println("Wrong Input");
			PoliceMainInput();
		}
	}
	
	//add a new Crime
	public void AddNewCrime() throws IOException, PoliceException {	
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("==========================");
		System.out.println("|  CRIME REGISTRATION!!  |");
		System.out.println("==========================");
		System.out.println("Enter Crime ID: ");
		int crime_id = sc.nextInt();
		System.out.println("Enter Crime Date(YYYY-MM-DD) :");
		String s_date = sc.next();
		
		System.out.println("Enter Short Description:");
		String s_desc = br.readLine();
		
		
		System.out.println("Enter Detailed Description: ");
		String d_desc = br.readLine();
		
		
		System.out.println("Enter Area of Crime:");
		String areaOfCrime = br.readLine();
		
		
		System.out.println("Enter Police Station:");
		String ps = br.readLine();
		
		
		System.out.println("Enter Victim Name:");
		String v_name = br.readLine();
		
		System.out.println("Enter Victim Age:");
		int v_age = sc.nextInt();
		
		
		System.out.println("Enter Victim Gender:");
		String v_gender = sc.next();
		
		
		System.out.println("Enter Victim Mobile Number:");
		String phone_no = br.readLine();
		
		System.out.println("Enter Victim Address:");
		String v_address = br.readLine();
		
		Crime crime = new Crime(crime_id, s_date, s_desc, d_desc, areaOfCrime, ps, v_name, v_age, v_gender, phone_no, v_address);
		
		crimeDao new_crime = new crimeDaoImpl();
		try {
			new_crime.addNewCrime(crime);
			
			//display back the menu
			DisplayPoliceMenu();
			PoliceMainInput();
		}catch(CrimeException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}
	
	//Add a new Criminal
	public void AddNewCriminal() throws IOException, PoliceException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("=============================");
		System.out.println("|  CRIMINAL REGISTRATION!!  |");
		System.out.println("=============================");
		System.out.println("Enter Criminal ID: ");
		int criminal_id = sc.nextInt();
		
		
		System.out.println("Enter Criminal Name:");
		String s_name = br.readLine();
		
		
		System.out.println("Enter Criminal Age: ");
		int c_age = sc.nextInt();
		
		
		System.out.println("Enter Criminal Gender:");
		String gender = br.readLine();
		
		
		System.out.println("Enter marks in criminal face:");
		String fm = br.readLine();
		
		
		System.out.println("Enter First Arrest Place:");
		String arrestLocation = sc.next();
		
		Criminal criminal = new Criminal(criminal_id, s_name, c_age, gender, fm, arrestLocation);
		
		
		
		criminalDao dao = new criminalDaoImpl();
		try {
			dao.addNewCriminal(criminal);
			
			//display back the menu
			DisplayPoliceMenu();
			PoliceMainInput();
			
		}catch(CriminalException e){
			System.out.println(e.getMessage());
			
		}
	}
	
	//Link a new Criminal
	public void LinkCrimeToCriminal() throws PoliceException, IOException {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter Investigation ID:");
		int in_id = sc.nextInt();
		System.out.println("Enter Crime ID:");
		int crime_id = sc.nextInt();
		System.out.println("Enter Criminal ID to be linked with Crime "+crime_id+":");
		int criminal_id=sc.nextInt();
		System.out.println("Investigation Officer ID:");
		int officer_id = sc.nextInt();
		
		
		InvestigationDetails id = new InvestigationDetails(in_id, crime_id, criminal_id, "Unsolved", officer_id);
		
		crimeDao dao = new crimeDaoImpl();
		try {
			dao.linkCriminalWithCrime(id);
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		PressOneorTwo();
		
	}
	
	//update a crime status
	public void UpdateCrimeStatus() throws PoliceException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Crime ID:");
		int crime_id = sc.nextInt();
		System.out.println("Enter Crime Status to be changed(Solved or Unsolved):");
		String status = sc.next();
		
		
		crimeDao dao = new crimeDaoImpl();
		try {
			System.out.println(dao.updateCrimeStatus(crime_id, status));
		}catch(CrimeException e) {
			System.out.println(e.getMessage());
		}
		PressOneorTwo();
		
	}
	
	//View all crime
	public void DisplayAllCrime() throws PoliceException, IOException {
		
		crimeDao dao = new crimeDaoImpl();
		try {
			List<Crime> list = dao.displayAllCrimeDetails();
	
			if(list.size()!=0) {
				System.out.println("CRIME RECORDS!!!");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
				for(int i=0;i<list.size();i++) {
					  Crime c =  list.get(i);

					  System.out.println("Crime [crime_id=" + c.getCrime_id() + ", crime_date=" + c.getCrime_date() + ", short_desc=" + c.getShort_desc()
					+  ", area_of_crime=" + c.getArea_of_crime() + ", policestation_code="
					+ c.getPolicestation_code() + ", victim_name=" + c.getVictim_name() +", v_mobileNumber=" + c.getV_mobileNumber()+ "]");

				  }
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

			}
			PressOneorTwo();
			
		}catch(CrimeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//view all criminal
	public void DisplayAllCriminal() throws PoliceException, IOException {
		
		criminalDao dao = new criminalDaoImpl();
		try {
			List<Criminal> list = dao.displayAllCriminalDetails();
	
			if(list.size()!=0) {
				System.out.println("CRIME RECORDS!!!");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
				for(int i=0;i<list.size();i++) {
					  Criminal c =  list.get(i);

					 System.out.println("Criminal [criminal_id=" + c.getCriminal_id() + ", criminal_name=" + c.getCriminal_name() + ", age=" + c.getAge()
								+ ", gender=" + c.getGender() + ", markInFace=" + c.getMarkInFace() + ", FirstArrestPlace=" + c.getFirstArrestPlace() + "]");
				
				  }
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

			}
			PressOneorTwo();
			
		}catch(CriminalException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//option to logout or previous  menu
	public void PressOneorTwo() throws PoliceException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------");
		System.out.println("|Press 1 to back to main menu! |");
		System.out.println("|Press 2 to logout!            |");
		System.out.println("--------------------------------");
		int input = sc.nextInt();
		MainApp m = new MainApp();
		if(input==1) {
			System.out.println();
		    DisplayPoliceMenu();
		    PoliceMainInput();
		}else if(input==2) {
			System.out.println("Logged Out!");
			System.out.println();
			m.mainMenu();
			m.homePageInput();
		}else {
			System.out.println("Wrong Input! Choose Again.");
			PressOneorTwo();
			
		}
	}
	
	//Generate Report
	public void GenerateReport() throws PoliceException, IOException {
		
		crimeDao dao = new crimeDaoImpl();
		try {
			String[] arr = dao.generateReport();
			System.out.println("=================Report=============");
			System.out.println("Total Number of Crime    :"+arr[0]);
			System.out.println("Crime in Current Month   :"+arr[1]);
			System.out.println("Unsolved Crime           :"+arr[2]);
			System.out.println("Solved Crime             :"+arr[3]);
			
		}catch(CrimeException e) {
			System.out.println(e.getMessage());
		}
		PressOneorTwo();
		
	}
}
