package com.ty.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.dao.PersonDao;
import com.ty.dto.Encounter;
import com.ty.dto.Person;

public class PersonController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean b = true;
		while (b) {
			System.out.println("Add ur details");
			System.out.println("Enter ur name");
			String name = sc.next();
			System.out.println("Enter ur email");
			String email = sc.next();
			System.out.println("Enter ur phone");
			Long phone = sc.nextLong();

			Person person = new Person();
			person.setPatient_name(name);
			person.setEmail(email);
			person.setPhone(phone);

			
			Encounter encounter1= new Encounter();
			Encounter encounter2= new Encounter();
			System.out.println("Welcome to Apollo");
			
			System.out.println(" 1 for the uploding details of 1st patient");
			System.out.println(" 2 for for the uploding details of 2nd patient");
			System.out.println("enter your choice");
			int choice=sc.nextInt();
			if(choice==1) {
			System.out.println("Enter ur name");
			String name1 = sc.next();
			System.out.println("Enter ur age");
			int age = sc.nextInt();
			System.out.println("Enter ur phone");
			long phone1 = sc.nextLong();
			System.out.println("Enter ur address");
			String address = sc.next();
			System.out.println("Enter ur gender");
			String gender = sc.next();
			encounter1.setName(name1);
			encounter1.setAge(age);
			encounter1.setPhoneno(phone1);
			encounter1.setAddress(address);
			encounter1.setGender(gender);
			}
			else {
				System.out.println("Enter ur name");
				String name1 = sc.next();
				System.out.println("Enter ur age");
				int age = sc.nextInt();
				System.out.println("Enter ur phone");
				long phone1 = sc.nextLong();
				System.out.println("Enter ur address");
				String address = sc.next();
				System.out.println("Enter ur gender");
				String gender = sc.next();
				encounter2.setName(name1);
				encounter2.setAge(age);
				encounter2.setPhoneno(phone1);
				encounter2.setAddress(address);
				encounter2.setGender(gender);
			}

			List<Encounter> list4 = new ArrayList<Encounter>();
			list4.add(encounter1);
			list4.add(encounter2);
			person.setEncounter(list4);

			PersonDao dao = new PersonDao();
			dao.savePerson(person);
			System.out.println("Admission is done succesfully");
		}

	}

}
