//package org.ticket;
//
//import java.util.Scanner;
//
//public class Booking {
//	public static void main(String[] args) {
//		System.out.println("Welcome to green Bus");
//		System.out.println("Enter your pickup location:");
//		Scanner sc=new Scanner(System.in);
//		
//		
//		String pick=sc.nextLine();
//		if(pick.equals("chennai")||pick.equals("pondicherry")||pick.equals("bangalore")) {
//			System.out.println("there is bus available at the location...");
//		}else {
//			System.out.println("currently the bus is  unavailable at the location...");		
//		}
//		
//		
//		System.out.println("Enter your dropping location:");
//		String drop=sc.nextLine();
//		
//		if(drop.equals("chennai")||drop.equals("pondicherry")||drop.equals("bangalore")) {
//			System.out.println("there is bus available at the location...");
//		}else {
//			System.out.println("currently the bus is  unavailable at the location...");		
//		}
//		
//		
//		System.out.println("Enter your journey Date:");
//		String date=sc.nextLine();
//		
//		if(date.equals("1-7-24")||date.equals("2-7-24")||date.equals("3-7-24")) {
//			System.out.println("there is bus available on the date specified...");
//		}else {
//			System.out.println("currently the bus is  unavailable at the specified date...");		
//		}
//		
//		System.out.println("             Select your seats             ");
//		int total=20;
//	
//		
//			        int row = 5; 
//			        int seat = 4; 
//
//			       int[][] bus=new int[row][seat];
//			        int value = 1;
//			        for (int i = 0; i < row; i++) {
//			            for (int j = 0; j < seat; j++) {
//			                bus[i][j] = value;
//			                value++;
//			                }
//			        }
//
//			        System.out.println("enter the seat num:");
//			        int me=sc.nextInt();
//			        for (int i = 0; i < row; i++) {
//			            for (int j = 0; j < seat; j++) {
//			                if (j == 2) {
//			                    System.out.print("     "); 
//			                }
//			                System.out.print(bus[i][j]);
//			                if (j < seat - 1 && j != 1) {
//			                    System.out.print(" "); 
//			                }
//			                if(me==bus[i][j)) {
//			                	bus[i][j]= 00;
//			                	
//			                }
//			            System.out.println(); 
//			        }
//			      
//			    
//			        	}		
//			        System.out.println("THE BOOKED SEATS ARE:");
//		     
//			        
//			        
//			       
//			            }
//			        
//			    }
//	
//	
//   
//		
//		
//
//	}
//
//




package org.ticket;

import java.util.Scanner;

public class Booking {
    public static void main(String[] args) {
        System.out.println("Welcome to Green Bus");
        System.out.println("Enter your pickup location:");
        Scanner sc = new Scanner(System.in);

        String pick = sc.nextLine();
        if (pick.equalsIgnoreCase("chennai") || pick.equalsIgnoreCase("pondicherry") || pick.equalsIgnoreCase("bangalore")) {
            System.out.println("There is a bus available at the location...");
        } else {
            System.out.println("Currently, the bus is unavailable at the location...");
        }

        System.out.println("Enter your dropping location:");
        String drop = sc.nextLine();

        if (drop.equalsIgnoreCase("chennai") || drop.equalsIgnoreCase("pondicherry") || drop.equalsIgnoreCase("bangalore")) {
            System.out.println("There is a bus available at the location...");
        } else {
            System.out.println("Currently, the bus is unavailable at the location...");
        }

        System.out.println("Enter your journey date :");
        String date = sc.nextLine();

        if (date.equals("1-7-24") || date.equals("2-7-24") || date.equals("3-7-24")) {
            System.out.println("There is a bus available on the date specified...");
        } else {
            System.out.println("Currently, the bus is unavailable on the specified date...");
        }

        System.out.println("--------------------Select your seats--------------------------");
        int total = 20;

        int row = 5;
        int seat = 4;

        int[][] bus = new int[row][seat];
        int value = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < seat; j++) {
                bus[i][j] = value;
                value++;
            }
        }

        System.out.println("Enter the seat number you want to book:");
        int me = sc.nextInt();
        boolean seatBooked = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < seat; j++) {
                if (j == 2) {
                    System.out.print("     ");
                }
                if (me == bus[i][j]) {
                    bus[i][j] = 0;
                    seatBooked = true;
                }
                System.out.print(bus[i][j] + (j < seat - 1 ? " " : ""));
            }
            System.out.println();
        }

        if (seatBooked) {
            System.out.println("The seat number " + me + " is successfully booked.");
        } else {
            System.out.println("The seat number " + me + " is unavailable.");
        }

        sc.close();
    }
}

