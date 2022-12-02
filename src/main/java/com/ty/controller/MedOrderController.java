package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.dao.MedOrderDao;
import com.ty.dto.Items;
import com.ty.dto.MedOrder;

public class MedOrderController {
	public static void main(String[] args) {
		
		MedOrder medorder=new MedOrder();
		medorder.setName("Apollo MedOrder");
		medorder.setDescp("Typhiod related issues");
		medorder.setTotal_bill(500);
		
		Items items1=new Items();
		items1.setName("Paracetamol");
		items1.setPrice(200);
		items1.setDetails("Fever");
		
		
		Items items2=new Items();
		items2.setName("Naxdom");
		items2.setPrice(300);
		items2.setDetails("Headache");
		
		List<Items>ls1=new ArrayList<Items>();
		ls1.add(items2);
		ls1.add(items1);
		
		medorder.setItems(ls1);
		
		MedOrderDao dao=new MedOrderDao();
		dao.saveMedOrder(medorder);

		
				
		
		
		
	}

}
