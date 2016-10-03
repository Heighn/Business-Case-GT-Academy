package nl.getthere.model;

public class Averager {
	public int average(int[] numbers){
		if(numbers.length == 0) return 0;
		int sum = 0;
		
		for(int i : numbers){
			sum += i;
		}
		return sum/numbers.length;
	}
	
	public int power(int x, int y){
		int result = 1;
		for(int i = 0; i < y; i++){
			result *= x;
		}
		return result;
	}
}
