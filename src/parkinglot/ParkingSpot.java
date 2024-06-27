package parkinglot;

import parkinglot.vehicle.*;

public class ParkingSpot {
	private final int spotNumber;
	private final VehicleType vehicletype;
	private Vehicle parkedVehicle;

	public ParkingSpot(int spotNumber, VehicleType type) {
		this.spotNumber = spotNumber;
		this.vehicletype = type;
	}

	public boolean isAvailable() {
		return parkedVehicle == null;
	}

	public void parkVehicle(Vehicle vehicle) {
		if (isAvailable() && vehicle.getType() == vehicletype) {
			parkedVehicle = vehicle;
		} else {
			throw new IllegalArgumentException("Invalid Vehicle type or spot is already occupied");
		}
	}

	public void unparkVehicle() {
		parkedVehicle=null;
	}
	public int getSpotNumber() {
		return spotNumber;
	}

	public VehicleType getVehicleType() {
		return vehicletype;
	}

	public Vehicle getParkedVehicle() {
		return parkedVehicle;
	}
}
