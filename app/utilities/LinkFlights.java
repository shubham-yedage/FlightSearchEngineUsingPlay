package utilities;

public class LinkFlights {

	public boolean linkFlights(String arrival, String departure,
			int depTime, float duration, int depTime2) {
		int i=(int) (depTime+(100*duration));
		i=convertInSuitableTimeFormat(i);
		depTime2=convertInSuitableTimeFormat(depTime2);	
		if((arrival.equals(departure))&&(i<depTime2))
		{
			return true;
		}
		
		return false;
	}

	private int convertInSuitableTimeFormat(int time) {
		if(time>2400)
			{
				time=time-2400;
			}
			
			return time;
	}

}
