package com.prjct.parking;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Application {

	private static List<ParkingSlot> parkingSlots;
	private static CarPark carPark = new CarPark();
	private static ParkingSlot parkingSlot = new ParkingSlot();
	private static List<Car> cars = new ArrayList<>();
	private static final String VISITOR = "V";
	private static final String STAFF = "S";
	private static int visitorSlot = 0;
	private static int staffSlot = 0;
	private static DecimalFormat formatter = new DecimalFormat("00");
	private static Set<Integer> deletedSlot = new HashSet<>();
	private static boolean flag=true;
	public static void main(String args[]) {
		
		startApplication();
		
	}
	private static void startApplication() {
		try(Scanner sc=new Scanner(System.in)){
			
			 System.out.println("enter registration number");
			 String regNum=sc.nextLine();
		    System.out.println("enter person type");
		    String type=sc.nextLine();
			while(flag) {
				int choice=sc.nextInt();
				
				switch (choice) {
				
				case 1:addSlot(type);
					   break;
				case 2:
					parkCar(type, regNum);
				       break;
				case 3:
					removeCar(regNum);
						System.out.println("car is removed");
				       break;
				case 4:Application application=new Application();
				       application.showSlots();
				       break;
				case 5: deleteSlot(parkingSlot.getParkingSlotId()) ;
						System.out.println("slot id deleted");
						break;
				case 6: deleteFromAvailable(parkingSlot.getParkingSlotId()) ;
						System.out.println("Parkingslot is  deleted");
						break;
				
				       
				default:System.out.println("ntr the wrong choice");
					break;
				
			}
		}
		}
			catch (Exception e) {
				System.out.println("invalid input try match");
			}
			
		}
	
	

	private static void addSlot(String slotType) {
		// if(!deletedSlot.isEmpty()) {
		// deletedSlot.iterator().next()
		// }

		// implement set here
		String parkingSlotId = null;
		if ("V".equals(slotType)) {
			parkingSlotId = slotType + formatter.format(++visitorSlot);
		} else if ("S".equals(slotType)) {
			parkingSlotId = slotType + formatter.format(++staffSlot);
		}
	
		parkingSlot.setParkingSlotId(parkingSlotId);
		
		
		carPark.setAvailableParkingSlots(null);

		List<ParkingSlot> availableParkingSlot = carPark.getAvailableParkingSlots();
		if (Objects.isNull(availableParkingSlot)) {
			availableParkingSlot = new ArrayList<>();
		}
		availableParkingSlot.add(parkingSlot);
		
		
		System.out.println(parkingSlotId+" \n"+parkingSlot);
		
		
		
		
	}

	private static void deleteSlot(String slotId) {
		carPark.getAvailableParkingSlots().removeIf(x -> x.getParkingSlotId().equals(slotId));
		
		
	}

	private static String parkCar(String ownerType, String registrationNumber) {
		Car car = new Car();
		car.setOwnerType(ownerType);
		cars.add(car);
		car.setRegistrationNumber(registrationNumber);
		System.out.println(car);
		
		
		List<ParkingSlot> availableParkingSlot = carPark.getAvailableParkingSlots();
		if (Objects.isNull(availableParkingSlot)) {
			parkingSlot.setCar(car);
			System.out.println(parkingSlot);
			List<ParkingSlot> parkingSlots=new ArrayList<>();
			parkingSlots.add(parkingSlot);
			carPark.setAvailableParkingSlots(parkingSlots);
			
		}
		
	 String parkingSlotId = null;
	/*	for (ParkingSlot parkingSlot : carPark.getAvailableParkingSlots()) {
			if (parkingSlot.getParkingSlotId().contains(ownerType)) {
				//parkingSlot.setCar(car);
				//parkingSlots.add(parkingSlot);
				parkingSlotId = parkingSlot.getParkingSlotId();
			}
		}*/
		//Application application=new Application();
		/*application.showSlots();

		String RegNum=car.getRegistrationNumber();
		removeCar(RegNum);
		 */
		/*deleteFromAvailable(parkingSlotId);
		deleteSlot(parkingSlotId);
		*/
		
		return parkingSlotId;
	}

	private static void deleteFromAvailable(String parkingSlotId) {
		carPark.getAvailableParkingSlots().removeIf(x -> x.getParkingSlotId().equals(parkingSlotId));
		
	}

	private static void removeCar(String registrationNumber) {
		String parkingSlotId = null;
		parkingSlots=carPark.getAvailableParkingSlots();
		for (ParkingSlot parkingSlot : parkingSlots) {
			if (parkingSlot.getCar().getRegistrationNumber().equals(registrationNumber)) {
				parkingSlotId = parkingSlot.getParkingSlotId();
				parkingSlot.setCar(null);
				/*List<ParkingSlot> availableParkingSlot = carPark.getAvailableParkingSlots();
				if (Objects.isNull(availableParkingSlot)) {
					availableParkingSlot = new ArrayList<>();
				}
				availableParkingSlot.add(parkingSlot);*/
				

			}
			System.out.println(parkingSlot.getCar());
		}
		deleteFromParked(parkingSlotId);
		cars.removeIf(x -> x.getRegistrationNumber().equals(registrationNumber));
		
	}

	private static void deleteFromParked(String parkingSlotId) {
		parkingSlots.removeIf(x -> x.getParkingSlotId().equals(parkingSlotId));
		
	}

	private void showSlots() {
		parkingSlots=carPark.getAvailableParkingSlots();
		if(carPark.getAvailableParkingSlots() != null) {
		parkingSlots.stream().forEach(x -> {
			System.out.println(x.getParkingSlotId() + " " + x.getParkingSlotId().charAt(0) + " " + "Occupied" + " "
					+ x.getCar().getRegistrationNumber() + " " + x.getCar().getOwnerType());
		});
	 }
		else {
			carPark.getAvailableParkingSlots().stream().forEach(x -> {
			System.out.println(x.getParkingSlotId() + " " + x.getParkingSlotId().charAt(0) + " " + "Not Occupied" + " "
					+ null + " " + null);
		});
			
		}


	}
}
