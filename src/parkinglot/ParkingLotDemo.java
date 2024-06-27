package parkinglot;

import java.util.HashMap;
import java.util.Map;

import parkinglot.vehicle.Car;
import parkinglot.vehicle.MotorCycle;
import parkinglot.vehicle.Truck;
import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

public class ParkingLotDemo {

	public static void main(String[] args) {
		ParkingLot parkingLot = ParkingLot.getInstance();
		Map<VehicleType, Integer> level1 = new HashMap<VehicleType, Integer>();
		level1.put(VehicleType.CAR, 40);
		level1.put(VehicleType.MOTORCYCLE, 40);
		level1.put(VehicleType.TRUCK, 20);
		
		Map<VehicleType, Integer> level2 = new HashMap<VehicleType, Integer>();
		level2.put(VehicleType.CAR, 30);
		level2.put(VehicleType.MOTORCYCLE, 10);
		level2.put(VehicleType.TRUCK, 10);


		parkingLot.addLevel(new Level(1, level1));
		parkingLot.addLevel(new Level(2, level2));

		Vehicle car = new Car("ABC124");
		Vehicle bike = new MotorCycle("TN72E1234");
		Vehicle truck = new Truck("TN65BA2456");

		parkingLot.parkVehicle(car);
		parkingLot.parkVehicle(bike);
		parkingLot.displayAvailblity();
	}

}
