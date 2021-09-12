package application;

import java.util.Comparator;

public class CovidDataSortByDate implements Comparator<CovidData> {
	@Override
	public int compare(CovidData o1, CovidData o2) {
		String temp1 = o1.stateDt;
		String temp2 = o2.stateDt;
		return temp1.compareTo(temp2);
	}
}
