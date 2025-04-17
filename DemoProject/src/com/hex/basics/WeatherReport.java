package com.hex.basics;

public class WeatherReport {
	public static void main(String[] args) {
		String choice="rainy";
		switch(choice.toUpperCase()) {
		case "SUMMER":
			System.out.println("eat icecream");
			break;
		case "RAINY":
			System.out.println("Drink a hot tea");
			break;
		case "WINTER":
			System.out.println("Drink soup");
			break;
		case "SPRING":
			System.out.println("enjoy the beauty of flowers");
			break;
		default:
		case "Rainy":
			System.out.println("wrong choice");
	
		
		}
		
	}

}
