package com.prjct.parking;

class Car {
	private String registrationNumber;
	private String ownerType;
	

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String registrationNumber, String ownerType) {
		super();
		this.registrationNumber = registrationNumber;
		this.ownerType = ownerType;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	@Override
	public String toString() {
		return "Car [registrationNumber=" + registrationNumber + ", ownerType=" + ownerType + "]";
	}

}