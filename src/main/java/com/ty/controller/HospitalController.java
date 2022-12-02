package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.dao.BranchDao;
import com.ty.dao.HospitalDao;
import com.ty.dto.Branch;
import com.ty.dto.Hospital;

public class HospitalController {
	public static void main(String[] args) {

		Hospital hospital = new Hospital();
		hospital.setHospital_name("Apollo");
		hospital.setHead_office("Bangalore");
		hospital.setEmail("apollo123@gmail.com");
		hospital.setPhone(76566565);

		Branch branch1 = new Branch();
		branch1.setBranch_name("Apollo Bannerghatta");
		branch1.setAddress("Banerghatta");
		branch1.setEmail("appoloBa123@gmail.com");
		branch1.setPhone(345655);

		Branch branch2 = new Branch();
		branch2.setBranch_name("Apollo Basvangudi ");
		branch2.setAddress("Basvangudi");
		branch2.setEmail("appoloBasvan123@gmail.com");
		branch2.setPhone(8796);

		List<Branch> list = new ArrayList<Branch>();
		list.add(branch1);
		list.add(branch2);

		hospital.setBranch(list);
		HospitalDao dao1 = new HospitalDao();
		dao1.saveHospital(hospital);
	}

}
