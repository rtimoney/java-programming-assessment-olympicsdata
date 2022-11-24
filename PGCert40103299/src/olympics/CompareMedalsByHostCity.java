package olympics;

import java.util.Comparator;

/**
 * RONAN TIMONEY
 * 40103299
 *
 */

public class CompareMedalsByHostCity implements Comparator<Medal> {

		@Override
		public int compare(Medal o1, Medal o2) {
		
			return o1.getCity().compareTo(o2.getCity());
			
			} 
		}

