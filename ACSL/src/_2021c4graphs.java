import java.util.*;
import java.io.*;

public class _2021c4graphs {
	
	static Scanner in;
	static int t;
	static HashMap<Integer, String> map;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			initmap();
			String[] s = in.nextLine().split(" ");
			t = Integer.parseInt(s[0]);
			for(int j=1; j<s.length; j++) {
				map.put(s[j].charAt(0)-'0', 
						map.get(s[j].charAt(0)-'0')+(s[j].charAt(1)-'0'));
			}
			
			for(int j: map.keySet()) {
				//System.out.println(j+" -- "+map.get(j));
			}
			
			if(t==1) func1();
			else if(t==2) func2();
			else func3();
			
		}
	}
	static void initmap() {
		map = new HashMap<Integer, String>();
		for(int i=1; i<=9; i++) map.put(i, "");
	}
	static void func1() {
		int cnt = 0;
		for(int key: map.keySet()) {
			char[] vals = map.get(key).toCharArray();
			for(char val: vals) {
				if(key==val-'0') cnt++;
				
				char[] vals2 = map.get(val-'0').toCharArray();
				for(char val2: vals2) if(val2-'0'==key) cnt++;
			}
		}
		System.out.println(cnt/2);
	}
	static void func2() {
		
		int anskey = 10;
		int maxlen = 0;
		for(int key:map.keySet()) {
			if(key<anskey&&map.get(key).length()>maxlen) {
				maxlen = map.get(key).length();
				anskey = key;
			}
		}
		int sum = 0;
		char[] a = map.get(anskey).toCharArray();
		for(char c: a) sum+=anskey*10+(c-'0');
		System.out.println(sum);
	}
	static void func3() {
		int cnt = 0;
		for(int key: map.keySet()) {
			
			char[] vals = map.get(key).toCharArray();
			for(char val: vals) cnt += map.get(val-'0').length();
		}
		System.out.println(cnt);
	}
}
