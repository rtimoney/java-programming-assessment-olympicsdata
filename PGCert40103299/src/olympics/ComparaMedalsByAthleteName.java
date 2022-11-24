package olympics;

import java.util.Comparator;

public class ComparaMedalsByAthleteName implements Comparator<Medal> {

	@Override
	public int compare(Medal o1, Medal o2) {
	
		return o1.getAthlete().compareTo(o2.getAthlete());
		
		} 
	}

