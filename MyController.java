package com.classmanagementsystem.controller;

import java.util.Scanner;

import com.classmanagementsystem.service.Services;
import com.classmanagementsystem.serviceimpli.ServiceImplement;

public class MyController {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		Services s=new ServiceImplement();
		
		System.out.println("----------Welcome To Class Management System-----------");
		boolean flag=true;
		while(flag)
		{
			System.out.println("| 1)Add Course:-                                    |");
			System.out.println("| 2)Diaplay Course:-                                |");
			System.out.println("| 3)Add Batch:-                                     |");
			System.out.println("| 4)Display Batch:-                                 |");
			System.out.println("| 5)Add Faculty:-                                   |");
			System.out.println("| 6)Diaplay Faculty:-                               |");
			System.out.println("| 7)Add Student:-                                   |");
			System.out.println("| 8)Display Student:-                               |");
			System.out.println("| 9)Exit:-                                          |");
			
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				s.addCourse();
				break;
			case 2:
				s.displayCourse();
				break;
			case 3:
				s.addBatch();
				break;
			case 4:
				s.displayBatch();
				break;
			case 5:
				s.addFaculty();
				break;
			case 6:
				s.displayFaculty();
				break;
			case 7:
				s.addStudent();
				break;
			case 8:
				s.displayStudent();
				break;
			case 9:
				System.out.println("Thank You.....");
				flag=false;
				break;
			default:
				System.out.println("Invaild Choice");
				break;
					
				
			}
		}
	}

}
