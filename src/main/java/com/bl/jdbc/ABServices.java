package com.bl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ABServices {
	Constants constants;
	AddressBookDBService addreeAddressBookDBService;
	Connection connection;
	List<Contacts> contactList = new ArrayList<Contacts>();

	public ABServices() {
		constants = new Constants();
		addreeAddressBookDBService = AddressBookDBService.init();
		connection = addreeAddressBookDBService.getConnection();

		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* DATABASE */

	public void getAllContactsData() {
		try {
			PreparedStatement ps = connection.prepareStatement(constants.FETCH_CONTACTS);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Contacts contact = new Contacts();
				contact.setId(rs.getInt("id"));
				contact.setFirstName(rs.getString("firstname"));
				contact.setLastName(rs.getString("lastname"));
				contact.setAddress(rs.getString("address"));
				contact.setCity(rs.getString("city"));
				contact.setState(rs.getString("state"));
				contact.setZip(rs.getString("zip"));
				contact.setPhonenumber(rs.getString("phonenumber"));
				contact.setEmail(rs.getString("email"));
				contactList.add(contact);
			}

			contactList.forEach(c -> {
				System.out.println("ID : " + c.getId());
				System.out.println("Firstname : " + c.getFirstName());
				System.out.println("Lastname : " + c.getLastName());
				System.out.println("Address : " + c.getAddress());
				System.out.println("City : " + c.getCity());
				System.out.println("State : " + c.getState());
				System.out.println("Zip code : " + c.getZip());
				System.out.println("Phone number : " + c.getPhonenumber());
				System.out.println("Email-Id : " + c.getEmail());
				System.out.println("<--------------------------------------------------->");
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
