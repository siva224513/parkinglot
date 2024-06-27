package parkinglot.vehicle;

public abstract class Vehicle {
	private String licencePlate;
	private VehicleType vechicleType;

	public Vehicle(String licencePlate, VehicleType type) {
		this.licencePlate = licencePlate;
		this.vechicleType = type;
	}
	public VehicleType getType() {
		return vechicleType;
	}
}
