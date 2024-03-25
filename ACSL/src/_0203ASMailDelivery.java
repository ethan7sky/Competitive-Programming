import java.util.*;
import java.io.*;

public class _0203ASMailDelivery {
	
	static TreeSet<pair> odd, even;
	static LinkedList<pair> ocopy, ecopy;
	static BufferedReader in;
	static int k, gate, currgate, currid;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));		
		odd = new TreeSet<pair>();
		even = new TreeSet<pair>();
		
		String[] input = in.readLine().split(", ");
		for(int i=1; i<input.length; i++) {
			int id = Integer.parseInt(input[i].substring(1));
			if(id%2==0) even.add(new pair(input[i].charAt(0), id));
			else odd.add(new pair(input[i].charAt(0), id));
		}
		
		for(int i=0; i<5; i++) {
			solve();
		}
	}
	
	static void solve() throws IOException {
		
		buildHouse();
		
		reset();

		oddvisiting();
		
		if(k>0) evenvisiting();
		
	}
	
	static void buildHouse() throws IOException {
		String[] input = in.readLine().split(", ");
		for(int j=1; j<input.length-2; j++) {
			int id = Integer.parseInt(input[j].substring(1));
			if(id%2==0) even.add(new pair(input[j].charAt(0), id));
			else odd.add(new pair(input[j].charAt(0), id));
		}
		gate = input[input.length-2].charAt(0)-'A'+1;
		k = Integer.parseInt(input[input.length-1]);
	}
	
	static void reset() {
		ocopy = new LinkedList<pair>();
		ocopy.addAll(odd);
		ecopy = new LinkedList<pair>();
		ecopy.addAll(even);
	}
	
	static void oddvisiting() {
		System.out.println("gate = "+gate);
		if(ocopy.size()==0) return;
		int idx = 0;
		for(int i=0; i<ocopy.size(); i++) {
			if(ocopy.get(i).gate >= gate) {
				idx = i;
				break;
			}
		}
		while(true) {
			System.out.println(k+" "+idx+" "+ocopy);
			pair removed = ocopy.remove(idx);
			k--;
			if(k==0) {
				System.out.println(removed);
				return;
			}
			if(ocopy.size()==0) {
				currgate = removed.gate;
				currid = removed.id;
				return;
			}

			if(idx==ocopy.size()) idx=0;
		}
	}
	
	static void evenvisiting() {
		System.out.println("     "+currgate+" "+currid);
		int idx = 0;
		for(int i=0; i<ecopy.size(); i++) {
			if(ecopy.get(i).gate > currgate) {
				idx=i;
				break;
			}
			else if(ecopy.get(i).gate == currgate) {
				if(ecopy.get(i).id>currid) {
					idx = i;
					break;
					
				}
			}
		}
		while(true) {
			System.out.println(k+" "+idx+" "+ecopy);
			pair removed = ecopy.remove(idx);
			k--;
			if(k==0) {
				System.out.println(removed);
				return;
			}
			
			if(idx==ecopy.size()) idx=0;
		}
	}
	
	static boolean isgreater(int a, int b) {
		String x = a+"";
		String y = b+"";
		for(int i=0; i<Math.min(x.length(), y.length()); i++) {
			if(x.charAt(i) > y.charAt(i)) return true;
			if(y.charAt(i) > x.charAt(i)) return false;
		}
		if(x.length() > y.length()) return true;
		return false;
	}
	
	static class pair implements Comparable<pair> {
		
		int gate, id;
		pair(char a, int b){
			gate = a-'A'+1;
			id = b;
		}
		
		public String toString() {
			return gate+" "+id;
		}
		
		@Override
		public int compareTo(_0203ASMailDelivery.pair that) {
			// TODO Auto-generated method stub
			if(this.gate==that.gate) return this.id-that.id;
			return this.gate-that.gate;
		}
		
	}
}
