package com.hexa.inheritance;

public class InherDemo {

	public static void main(String[] args) {
		Vehicle vehicle= new Vehicle("RX100", 90000);
		vehicle.printDetails();
		
		Car car=new Car("TATA",140000,"light");
		car.printDetails();
		car.showAccessories();

	}

}
