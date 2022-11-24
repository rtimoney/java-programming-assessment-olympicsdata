package olympics;

import java.util.Comparator;
/*
public class ComparaMedalsByCountry implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}

/**
 * RONAN TIMONEY
 * 40103299
 *
 */


public class ComparaMedalsByCountry implements Comparator<Medal> {

	@Override
	public int compare(Medal o1, Medal o2) {
	
		return o1.getCountry().compareTo(o2.getCountry());
		
		} 
	}

