import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class USACOFindandReplace {
	
	static Scanner in;
	static int t, ans;
	static HashMap<Character, Character> hs;
	static String a, b;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		t = in.nextInt();
		
		testcases:
		for(int i=0; i<t; i++) {
			a = in.next();
			b = in.next();
			
			hs = new HashMap<Character, Character>();
			for(int j=0; j<a.length(); j++) {
				
				char chara = a.charAt(j);
				char charb = b.charAt(j);
				
				if(hs.containsKey(chara) && hs.get(chara) != charb) {
					System.out.println(-1);
					continue testcases;
				}
				else {
					hs.put(chara, charb);
				}
			}
			
			HashMap<Character, String> reverse = new HashMap<Character, String>();
			
			for(char key: hs.keySet()) {
				char value = hs.get(key);
				
				if(reverse.containsKey(value)) reverse.put(value, reverse.get(value)+(key));
				else reverse.put(value, key+"");
				
			}
			System.out.println(reverse);
			
			ans=0;
			for(char key: reverse.keySet()) {
				ans += reverse.get(key).length();
				if(reverse.get(key).contains(key+"")) ans--;
			}
			
			boolean plus1 = false;
			check:
			for(String value: reverse.values()) {
				for(int j=0; j<value.length(); j++) {
					if(reverse.containsKey(value.charAt(j))) {
						String check = reverse.get(value.charAt(j));
						System.out.println(value.charAt(j)+" "+check);
						for(int k=0; k<check.length(); k++) {
							if(reverse.containsKey(check.charAt(k)) && reverse.get(check.charAt(k)) == value) {
								System.out.println(check.charAt(k));
								plus1 = true;
								break check;
							}
						}
					}
				}
			}
			if(plus1) ans++;
			
			HashSet<Character> check = new HashSet<Character>();
			for(int j=0; j<b.length(); j++) {
				check.add(b.charAt(j));
			}
			if(check.size()==52 && plus1) {
				System.out.println(-1+" NOT ENOUGH CHARS!!!");
			}
			else System.out.println(plus1+" "+ans);
			
			
		}
		
	}
}
