package models;

public class Flight implements Comparable<Flight> {

	private String name;
	private String departure;
	private String arrival;
	private String depDate;
	private int depTime;
	private float duration;
	private float fare;

	public Flight(String name, String departure, String arrival,
			String depDate, int depTime, float duration, float fare) {
		this.departure = departure;
		this.name = name;
		this.arrival = arrival;
		this.depDate = depDate;
		this.depTime = depTime;
		this.duration = duration;
		this.fare = fare;
	}

	public Flight() {
		this.departure = "";
		this.name = "";
		this.arrival = "";
		this.depDate = "";
		this.depTime = 0;
		this.duration = 0;
		this.fare = 0;
	}

	public String getName() {
		return name;
	}

	public String getDeparture() {
		return departure;
	}

	public String getArrival() {
		return arrival;
	}

	public String getDepDate() {
		return depDate;
	}

	public int getDepTime() {
		return depTime;
	}

	public float getDuration() {
		return duration;
	}

	public float getFare() {
		return fare;
	}

	@Override
	public int compareTo(Flight f) {
		return Double.compare(this.fare, f.fare);
	}

	@Override
	public String toString() {
		return "|" + name + "|" + departure + "|" + arrival + "|" + depDate
				+ "|" + depTime + "|" + duration + "|" + fare + "|";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (arrival == null) {
			if (other.arrival != null)
				return false;
		} else if (!arrival.equals(other.arrival))
			return false;
		if (depDate == null) {
			if (other.depDate != null)
				return false;
		} else if (!depDate.equals(other.depDate))
			return false;
		if (depTime != other.depTime)
			return false;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		if (Float.floatToIntBits(duration) != Float
				.floatToIntBits(other.duration))
			return false;
		if (Float.floatToIntBits(fare) != Float.floatToIntBits(other.fare))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival == null) ? 0 : arrival.hashCode());
		result = prime * result + ((depDate == null) ? 0 : depDate.hashCode());
		result = prime * result + depTime;
		result = prime * result
				+ ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + Float.floatToIntBits(duration);
		result = prime * result + Float.floatToIntBits(fare);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
}
