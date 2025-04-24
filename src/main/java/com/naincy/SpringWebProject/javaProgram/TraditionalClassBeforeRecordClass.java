//package com.naincy.SpringWebProject.javaProgram;
//
//import java.util.Objects;
//
//
//class User{
//	private final int id;
//	private final String name;
//	public User(int id,String name) {
//		this.id=id;
//		this.name=name;
//	}
//	public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        User user = (User) obj;
//        return id == user.id && Objects.equals(name, user.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name);
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
//// if we want to find two users are equal or not by values we have to override equals method and this is eliminated by record class
//public class TraditionalClassBeforeRecordClass {
//	public static void main(String[] args) {
//		User user1=new User(1,"naincy");
//		User user2=new User(1,"naincy");
//		 System.out.println(user1.equals(user2));
//	}
//}
