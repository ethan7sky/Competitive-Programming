import java.util.*;
import java.io.*;

public class USACOReverseEngineering3{
	
	static Scanner in;
	static int t, n, m;
	static LinkedList<String> input;
	static LinkedList<Boolean> output;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		t = in.nextInt();
		for(int i=0;i<t;i++) {
			
			init();
			
			LinkedList<String> input2 = new LinkedList<String>();
			input2.addAll(input);
			while(true) {
				solve();
				if(input.size()==input2.size()) {
					System.out.println("LIE");
					break;
				}
				else {
					if(input.size()<=1) {
						System.out.println("OK");
						break;
					}
					else {
						input2.clear();
						input2.addAll(input);
					}
				}
			}
		}
	}
	static void init() {
		in.nextLine();
		n = in.nextInt();
		m = in.nextInt();
		
		input = new LinkedList<String>();
		output = new LinkedList<Boolean>();
		
		for(int i=0; i<m; i++) {
			input.add(in.next());
			output.add(in.nextInt()==1);
		}
	}
	static void solve() {
		
		for(int index=0; index<n; index++) {
			
			HashSet<Boolean> cnt1outputs = new HashSet<Boolean>();
			HashSet<Boolean> cnt0outputs = new HashSet<Boolean>();
			
			for(int i=0; i<input.size(); i++) {
				if(input.get(i).charAt(index) =='1') cnt1outputs.add(output.get(i));
				else cnt0outputs.add(output.get(i));
			}
			
			//check consistancy of outputs from inputs
			if(cnt1outputs.size()==1) {
				for(int i=0; i<input.size();i++) {
					if(input.get(i).charAt(index)=='1') {
						input.remove(i);
						output.remove(i);
					} 
				}
			}if(cnt0outputs.size()==1) {
				for(int i=0; i<input.size();i++) {
					if(input.get(i).charAt(index)=='0') {
						input.remove(i);
						output.remove(i);
					}
				}
			}
			
		}
	}
}