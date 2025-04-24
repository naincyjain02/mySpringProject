package com.naincy.SpringWebProject.javaProgram;



record User(int id,String name) {}


public class RecordClass {
	public static void main(String[] args) {
		User user1=new User(1,"naincy");
		User user2=new User(1,"naincy");
		 System.out.println(user1.equals(user2));
	}
}
