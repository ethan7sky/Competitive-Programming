import java.util.*;
import java.io.*;

public class CampContestK {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] s = in.readLine().split("\\+");
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(String i: s) {
			nums.add(Integer.parseInt(i));
		}
		Collections.sort(nums);
		String ans = "";
		for(int i=0; i<nums.size()-1; i++) {
			ans += nums.get(i)+"+";
		}ans += nums.get(nums.size()-1);
		System.out.println(ans);
	}
	
}
