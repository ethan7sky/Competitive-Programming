package algorithms;
import java.util.*;

public class MaximumSubarraySum {
	
	static int[] a = {-1, 3, -2, 5, 3, -5, 2, 2};
	
	public static void main(String[] args) {
		
		System.out.println(calcMaxSubarraySum(a));
		
	}
	
	static int calcMaxSubarraySum(int[] arr) {
		int bestSum = 0;
		int currSum = 0;
		for(int i=0; i<arr.length; i++) {
			currSum = Math.max(0, currSum+arr[i]);
			bestSum = Math.max(bestSum, currSum);
		}
		return bestSum;
	}

}
