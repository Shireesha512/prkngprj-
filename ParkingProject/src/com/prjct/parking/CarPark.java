package com.prjct.parking;

import java.util.List;

class CarPark {
	private List<ParkingSlot> availableParkingSlots;

	public List<ParkingSlot> getAvailableParkingSlots() {
		return availableParkingSlots;
	}

	


	public void setAvailableParkingSlots(List<ParkingSlot> availableParkingSlots) {
		this.availableParkingSlots = availableParkingSlots;
	}

	

	public CarPark() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CarPark(List<ParkingSlot> availableParkingSlots) {
		super();
		this.availableParkingSlots = availableParkingSlots;
	}

	
	@Override
	public String toString() {
		return "CarPark [availableParkingSlots=" + availableParkingSlots + "]";
	}

}
