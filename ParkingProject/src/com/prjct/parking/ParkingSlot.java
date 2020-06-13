package com.prjct.parking;

class ParkingSlot {

	private String parkingSlotId;
	private Car car;

	
	public ParkingSlot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParkingSlot(String parkingSlotId, Car car) {
		super();
		this.parkingSlotId = parkingSlotId;
		this.car = car;
	}

	public String getParkingSlotId() {

		return parkingSlotId;
	}

	public void setParkingSlotId(String parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}

	

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "ParkingSlot [parkingSlotId=" + parkingSlotId + ", car=" + car + "]";
	}
}