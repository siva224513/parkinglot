package parkinglot;

import java.util.*;
import java.util.Map.Entry;

import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

public class Level {
	private final int floor;
	private final List<ParkingSpot> parkingSpots;

	public Level(int floor, Map<VehicleType, Integer> map) {
		this.floor = floor;
		parkingSpots = new ArrayList<>();
		int spotNumber = 0;
		for (Map.Entry<VehicleType, Integer> entry : map.entrySet()) {
			VehicleType vehicle = entry.getKey();
			int count = entry.getValue();

			for (int i = 0; i < count; i++) {
				parkingSpots.add(new ParkingSpot(spotNumber++, vehicle));
			}
		}
	}

	public boolean parkVehicle(Vehicle vehicle) {

		for (ParkingSpot spot : parkingSpots) {
			if (spot.isAvailable() && spot.getVehicleType() == vehicle.getType()) {
				spot.parkVehicle(vehicle);
				return true;
			}
		}
		return false;

	}

	public boolean unparkVehicle(Vehicle vehicle) {
		for (ParkingSpot spot : parkingSpots) {
			if (!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
				spot.unparkVehicle();
				return true;
			}
		}
		return false;

	}

	public void displayAvailablity() {
		System.out.println("Level " + floor + " Availablity");
		for (ParkingSpot spot : parkingSpots) {
			System.out.println("Spot" + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available" : "Occupied"));

		}
	}
}
