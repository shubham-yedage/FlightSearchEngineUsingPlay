package utilities;

import models.Flight;

import java.util.Comparator;

public class FareDurationComparator implements Comparator<Flight> {
	@Override
	public int compare(Flight o1, Flight o2) {

		int compare = Float.compare(o1.getFare(), o2.getFare());

		if (compare == 0) {
			return Float.compare(o1.getDuration(), o2.getDuration());
		}
		return compare;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}
}
