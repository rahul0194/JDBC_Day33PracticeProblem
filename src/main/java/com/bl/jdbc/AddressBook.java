package com.bl.jdbc;

public class AddressBook {

	public static void main(String[] args) {
		System.out.println("**************** Welcome to Address Book Service ****************");
				
		ABServices abService = new ABServices();
		System.out.println("<---------------- Contacts List ---------------->");
		abService.getAllContactsData();
		
	}
}