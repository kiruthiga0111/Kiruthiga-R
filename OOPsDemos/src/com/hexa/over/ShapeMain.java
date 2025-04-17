package com.hexa.over;

public class ShapeMain {
	
	public static void main(String[] args) {
		Shape shape=new Shape();
		shape.area(2);
		shape.area(4.0);
		int rect= shape.area(2,3);
		System.out.println("rect  "+ rect );
		double triangle= shape.area(2,4.0f);
		System.out.println("triangle  "+ triangle );
		
	}

}
