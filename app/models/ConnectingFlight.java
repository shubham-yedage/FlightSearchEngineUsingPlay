package models;

public class ConnectingFlight extends Flight {
	public String connFlightName;
	public String connLoc;
	public float connFlightDuration;
	public float connFlightFare;
	public int conDepTime;

	public ConnectingFlight(String name, String departure, String arrival,
			String depDate, int depTime, float duration, float fare,
			String connFlightName, String connLoc, int conDepTime,
			float connFlightDuration, float connFlightFare) {
		super(name, departure, arrival, depDate, depTime, duration, fare);
		this.connFlightName = connFlightName;
		this.connLoc = connLoc;
		this.connFlightDuration = connFlightDuration;
		this.connFlightFare = connFlightFare;
		this.conDepTime = conDepTime;
	}

	public ConnectingFlight(String name, String departure, String arrival,
			String depDate, int depTime, float duration, float fare) {
		super(name, departure, arrival, depDate, depTime, duration, fare);
		this.connFlightName = "";
		this.connLoc = "";
		this.conDepTime = 0;
		this.connFlightDuration = 0;
		this.connFlightFare = 0;
	}

	public int getConDepTime() {
		return conDepTime;
	}

	public void setConDepTime(int conDepTime) {
		this.conDepTime = conDepTime;
	}

	public float getConnFlightDuration() {
		return connFlightDuration;
	}

	public void setConnFlightDuration(float connFlightDuration) {
		this.connFlightDuration = connFlightDuration;
	}

	public float getConnFlightFare() {
		return connFlightFare;
	}

	public void setConnFlightFare(float connFlightFare) {
		this.connFlightFare = connFlightFare;
	}

	public String getConnFlightName() {
		return connFlightName;
	}

	public void setConnFlightName(String connFlightName) {
		this.connFlightName = connFlightName;
	}

	public String getConnLoc() {
		return connLoc;
	}

	public void setConnLoc(String connLoc) {
		this.connLoc = connLoc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + conDepTime;
		result = prime * result + Float.floatToIntBits(connFlightDuration);
		result = prime * result + Float.floatToIntBits(connFlightFare);
		result = prime * result
				+ ((connFlightName == null) ? 0 : connFlightName.hashCode());
		result = prime * result + ((connLoc == null) ? 0 : connLoc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConnectingFlight other = (ConnectingFlight) obj;
		if (conDepTime != other.conDepTime)
			return false;
		if (Float.floatToIntBits(connFlightDuration) != Float
				.floatToIntBits(other.connFlightDuration))
			return false;
		if (Float.floatToIntBits(connFlightFare) != Float
				.floatToIntBits(other.connFlightFare))
			return false;
		if (connFlightName == null) {
			if (other.connFlightName != null)
				return false;
		} else if (!connFlightName.equals(other.connFlightName))
			return false;
		if (connLoc == null) {
			if (other.connLoc != null)
				return false;
		} else if (!connLoc.equals(other.connLoc))
			return false;
		return true;
	}

}
