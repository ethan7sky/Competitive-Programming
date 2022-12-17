import java.util.*;
import java.io.*;

public class CFSmaller {
	
	static int t, q;
	static String string1, string2, alphabet = "abcdefghijklmnopqrstuvwxyz";
	static HashMap<Character, Integer> alpha1, alpha2;
	static BufferedReader in;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		
		for(int i=0; i<t; i++) {
			
			//TEST CASE 1
			init();
			
			q = Integer.parseInt(in.readLine());
			for(int j=0; j<q; j++) {
				
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				int stringnumber = Integer.parseInt(st.nextToken());
				int ktimes = Integer.parseInt(st.nextToken());
				String x = st.nextToken();
				
				//update maps
				
				for(int k=0; k<x.length(); k++) {
					char curr = x.charAt(k);
					if(stringnumber==1) {
						alpha1.put(curr, alpha1.get(curr)+ktimes);
					}
					else if(stringnumber==2) {
						alpha2.put(curr, alpha2.get(curr)+ktimes);
					}
				}
				
				//compare available characters
				
				boolean works = true;
				
				
				string1 = "";
				string2 = "";
				
				for(int k=0; k<26; k++) {
					for(int l=0; l<alpha1.get(alphabet.charAt(k)); l++) {
						string1 += alphabet.charAt(k);
					}
				}
				for(int k=25; k>=0; k--) {
					for(int l=0; l<alpha2.get(alphabet.charAt(k)); l++) {
						string2 += alphabet.charAt(k);
					}
				}
				
				if(string1.compareTo(string2) < 0) {
					System.out.println("YES");
				}
				else System.out.println("NO");
			}
		}
	}
	static void init() throws IOException{
		alpha1 = new HashMap<Character, Integer>();
		alpha2 = new HashMap<Character, Integer>();
		
		for(int i=0; i<26; i++) {
			alpha1.put(alphabet.charAt(i), 0);
			alpha2.put(alphabet.charAt(i), 0);
		}
		alpha1.put('a', 1);
		alpha2.put('a', 1);
	}
}
