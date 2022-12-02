package com.ty.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.dao.BranchDao;
import com.ty.dao.HospitalDao;
import com.ty.dao.PersonDao;
import com.ty.dto.Address;
import com.ty.dto.Branch;
import com.ty.dto.Encounter;
import com.ty.dto.Hospital;
import com.ty.dto.Items;
import com.ty.dto.MedOrder;
import com.ty.dto.Person;

public class Controller {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HospitalDao dao = new HospitalDao();
		Hospital hospital = new Hospital();
		BranchDao branchdao = new BranchDao();
		Person person = new Person();
		PersonDao personDao = new PersonDao();
		System.out.println("Enter the Choice 1----Hospital,2-----Person");
		switch (sc.nextInt()) {
		case 1:
			System.out.println("Enter the hospital name");
			hospital.setHospital_name(sc.next());
			boolean a = true;
			List<Branch> listB = new ArrayList<Branch>();
			while (a) {
				System.out.println("Press 1-choose branch,2-Noooooo");
				switch (sc.nextInt()) {
				case 1:
					Branch branches = new Branch();
					Address address = new Address();
					System.out.println("Enter the branch name");
					branches.setBranch_name(sc.next());
					System.out.println("Enter the Phone");
					branches.setPhone(sc.nextLong());

					System.out.println("Enter the location");
					address.setCity(sc.next());
//					address.setBranches(branches);
					branches.setAdd(address);
					listB.add(branches);
					break;
				default:
					a = false;
					break;
				}
			}
			hospital.setBranch(listB);
			dao.saveHospital(hospital);
			System.out.println("Saved");
			break;
		case 2:
			System.out.println("Enter the person name");
			person.setPatient_name(sc.next());
			System.out.println("Enter the phone");
			person.setPhone(sc.nextLong());
			List<Encounter> listE = new ArrayList<Encounter>();
			List<MedOrder> listM = new ArrayList<MedOrder>();
			List<Items> listT = new ArrayList<Items>();
			boolean b = true;
			while (b) {
				System.out.println("1---Encounter,2---Noooooo");
				switch (sc.nextInt()) {
				case 1:
					Encounter encounter = new Encounter();
					System.out.println("Enter the Reason");
					encounter.setReason(sc.next());
				//	encounter.setBranch(branchdao.saveBranch(branch));
					boolean c = true;
					while (c) {
						System.out.println("1---create medorder,2---Nooooo");
						switch (sc.nextInt()) {
						case 1:
							MedOrder medorder = new MedOrder();
							System.out.println("Enter The details");
							medorder.setName(sc.next());
							boolean d = true;
							while (d) {
								System.out.println("1--To add tablets,2---Nooooo");
								switch (sc.nextInt()) {
								case 1:
									Items tablets = new Items();
									System.out.println("Enter the name");
									tablets.setName(sc.next());
									System.out.println("Enter the quantity");
									tablets.setDetails(sc.next());
									System.out.println("Enter the price");
									tablets.setPrice(sc.nextInt());
									listT.add(tablets);
									break;

								default:
									d = false;
									
								}
							}
							medorder.setItems(listT);
							listM.add(medorder);
							break;
						default:
							c = false;
							
						}
					}
					encounter.setMedorder(listM);
					listE.add(encounter);
					break;

				default:b=false;
					
				}

			}
			person.setEncounter(listE);
			personDao.savePerson(person);
			System.out.println("saved");
			break;
			
		}
	}
}


