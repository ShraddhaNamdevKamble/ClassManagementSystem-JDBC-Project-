package com.classmanagementsystem.serviceimpli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.classmanagementsystem.connection.MyConnection;
import com.classmanagementsystem.service.Services;

public class ServiceImplement implements Services{

	Scanner sc=new Scanner(System.in);
	@Override
	public void addCourse() {
		try {
			
			//create course table
			//create table course(cid int primary key,cname varcahr(50))
			Connection connection=MyConnection.getConncetion();
			
			System.out.println("Enter Course Id:");
			int cid=sc.nextInt();
			
			System.out.println("Enter Course Name:");
			String cname=sc.next();
			
			
			String sql="insert into course values(?,?)";
			PreparedStatement psmt=connection.prepareStatement(sql);
			psmt.setInt(1,cid);
			psmt.setString(2,cname);
			
			psmt.execute();
			System.out.println("Success..");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void displayCourse() {
		try {
			Connection connection=MyConnection.getConncetion();
			
			String sql="select * from course ;";
			ResultSet rs=connection.prepareStatement(sql).executeQuery();
			while(rs.next())
			{
				System.out.println("Course Id:"+rs.getInt(1));
				System.out.println("Course Name:"+rs.getString(2));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void addBatch() {
		try {
			
			//Create batch table 
			//create table batch(bid int primary key,bname varchar(50),cid int,foreign key(cid)references course(cid));
			
			Connection conncetion=MyConnection.getConncetion();
			
			String sql="insert into batch values(?,?,?);";
			System.out.println("Enter batch id:");
			int bid=sc.nextInt();
			
			System.out.println("Enter batch name:");
			String bname=sc.next();
			System.out.println("Choose course from the follwing:-");
			displayCourse();
			int cid=sc.nextInt();
			
			PreparedStatement psmt=conncetion.prepareStatement(sql);
			psmt.setInt(1, bid);
			psmt.setString(2, bname);
			psmt.setInt(3, cid);
			
			psmt.execute();
			System.out.println("Successfully Inserted Batch Details..");
			
			
			
		} catch (Exception e) {
		
			System.out.println(e);
		}
		
	}

	@Override
	public void displayBatch() {
		try {
			
			Connection connection=MyConnection.getConncetion();
			
			String sql="select batch.bid,batch.bname,course.cid,course.cname from batch inner join course on batch.cid=course.cid";
			ResultSet rs=connection.prepareStatement(sql).executeQuery();
			while(rs.next())
			{
				System.out.println("Batch Id:"+rs.getInt(1));
				System.out.println("Batch Name:"+rs.getString(2));
				System.out.println("Course Id:"+rs.getInt(3));
				System.out.println("Course Name:"+rs.getString(4));
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
	}

	@Override
	public void addFaculty() {
		try {
			
			//create faculty table
			//create table faculty(fid int primary key,fname varchar(50),bid int,foreign key(bid)references batch(bid));
			Connection connection=MyConnection.getConncetion();
			
			String sql="insert into faculty values(?,?,?)";
			System.out.println("Enter faculty is:");
			int fid=sc.nextInt();
			System.out.println("Enter faculty name:");
			String fname=sc.next();
			System.out.println("Choose batch from follwing:- ");
			displayBatch();
			int bid=sc.nextInt();
			
			PreparedStatement psmt=connection.prepareStatement(sql);
			psmt.setInt(1, fid);
			psmt.setString(2, fname);
			psmt.setInt(3, bid);
			
			psmt.execute();
			System.out.println("Successfully Inserted Faculty Details");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void displayFaculty() {
		try {
			
			Connection connection=MyConnection.getConncetion();
			String sql="Select faculty.fid,faculty.fname,batch.bid,batch.bname,course.cid,course.cname from faculty inner join batch on faculty.bid=batch.bid inner join course on batch.cid=course.cid;";
			ResultSet rs=connection.prepareStatement(sql).executeQuery();
			while(rs.next())
			{
				System.out.println("Faculty Id:"+rs.getInt(1));
				System.out.println("Faculty Name:"+rs.getString(2));
				System.out.println("Batch Id:"+rs.getInt(3));
				System.out.println("Batch Name:"+rs.getString(4));
				System.out.println("Course Id:"+rs.getInt(5));
				System.out.println("Course Name:"+rs.getString(6));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void addStudent() {
		try {
			
			Connection connection=MyConnection.getConncetion();
			String sql="insert into student values(?,?,?);";
			System.out.println("Enter Student Id:");
			int sid=sc.nextInt();
			System.out.println("Enter Student Name:");
			String sname=sc.next();
			System.out.println("Choose Faculty From Follwing:-");
			displayFaculty();
			int fid=sc.nextInt();
			
			PreparedStatement psmt=connection.prepareStatement(sql);
			psmt.setInt(1, sid);
			psmt.setString(2, sname);
			psmt.setInt(3, fid);
			
			psmt.execute();
			System.out.println("Successfully Inserted Student Details.");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void displayStudent() {
		try {
			
			Connection connection=MyConnection.getConncetion();
			String sql="select student.sid,student.sname,faculty.fid,faculty.fname,batch.bid,batch.bname,course.cid,course.cname from student inner join faculty on student.fid=faculty.fid inner join batch on faculty.bid=batch.bid inner join course on batch.cid=course.cid";
			ResultSet rs=connection.prepareStatement(sql).executeQuery();
			while(rs.next())
			{
				System.out.println("Student Id:"+rs.getInt(1));
				System.out.println("Student Name:"+rs.getString(2));
				System.out.println("Faculty Id:"+rs.getInt(3));
				System.out.println("Faculty Name:"+rs.getString(4));
				System.out.println("Batch Id:"+rs.getInt(5));
				System.out.println("Batch Name:"+rs.getString(6));
				System.out.println("Course Id:"+rs.getInt(7));
				System.out.println("Course Name:"+rs.getString(8));

			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
