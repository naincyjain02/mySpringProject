package com.naincy.SpringWebProject.javaProgram;







public class SealedClass {
	 public static void main(String[] args) {
	        Vehicle v1 = new Car();
	        Vehicle v2 = new Bike();

	        v1.drive(); // Output: Driving a car
	        v2.drive(); // Output: Riding a bike

	        
	        if (v1 instanceof Car c) {
	            System.out.println("It's a Car with sealed inheritance.");
	        }

	        if (v2 instanceof Bike b) {
	            System.out.println("It's a Bike and can be extended further.");
	        }
	    }
}
