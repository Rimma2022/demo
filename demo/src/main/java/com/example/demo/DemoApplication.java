package com.example.demo;

import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {
	@Autowired
//	private Connector connector;
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Operations: \n" + "0. Exit" + "1. Get info from user table\n" + "2. Get info from Medical\n" + "3. Get info from all tables");

		System.out.println("Enter operation");

		Menu.test();
//		Connector.connect();
//		System.out.println("Enter:");









	}

}
