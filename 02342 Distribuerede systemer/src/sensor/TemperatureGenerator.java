package sensor;

import java.util.*;

// used http://www.javapractices.com/topic/TopicAction.do?Id=62 
// but changed to be used in our program

public class TemperatureGenerator {
	final int RANGE_START = 14;
	final int RANGE_END	= 24;
	int tempGen;
	
	public int temperatureGen(){
		Random randomGenerator = new Random();
		getRandomInt(RANGE_START, RANGE_END, randomGenerator);
		return tempGen;
	}
	
	private void getRandomInt(int start, int end, Random random){
		if (start > end){
			throw new IllegalArgumentException("start is greater than end");
		}
		int range = end - start + 1;
		double fraction = range * random.nextDouble();
		tempGen = (int)fraction + start;
	}

}
