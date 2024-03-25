import java.io.*;
import java.util.*;

public class _1920c4Patolli {
	
	static Scanner in;
	static int pos[] = new int[3], currpos, rollcnt;
	static HashSet<Integer> primes, squares, diagonal;
	static String horizthenverti[] = {"3,8","4,8","5,8","6,8","18,23","18,24","19,23"
			,"19,24","19,25","20,23","20,24","20,25","20,26","21,23","21,24","21,25"
			,"21,27","31,36","32,36","33,36","34,36","46,51","46,52","47,51","47,52"
			,"48,51","48,52","49,51","49,52"};
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		initsets();
		
		for(int i=0; i<5; i++) {
			
			boolean gameover = false;
			StringTokenizer st = new StringTokenizer(in.nextLine());
			pos[0]=Integer.parseInt(st.nextToken());
			pos[1]=Integer.parseInt(st.nextToken());
			pos[2]=Integer.parseInt(st.nextToken());
			currpos = Integer.parseInt(st.nextToken());
			rollcnt = Integer.parseInt(st.nextToken());
			for(int j=0; j<rollcnt; j++) {
				
				int roll = Integer.parseInt(st.nextToken());
				int newpos = currpos+roll;
				
				if(newpos==52) {
					gameover=true;
					break;
				}
				if(newpos>52) continue;
				if(newpos==pos[0]||newpos==pos[1]||newpos==pos[2]) continue;
				
				if(primes.contains(newpos)) {
					int a = 0;
					while(true) {
						if(a==6) break;
						if(newpos+a==pos[0]||newpos+a==pos[1]||newpos+a==pos[2]) break;
						a++;
					}
					newpos+=a;
				}
				if(squares.contains(newpos)) {
					int a = 0;
					while(true) {
						if(a==6) break;
						if(newpos-a==pos[0]||newpos-a==pos[1]||newpos-a==pos[2]) break;
						a++;
					}
					newpos-=a;
				}
				else {
					
				}
				
				
				
				
				
				
			}
			
			
			
			
		}
		
	}
	static void initsets() {
		primes = new HashSet<Integer>();
		squares = new HashSet<Integer>();
		
		for(int i=2; i<=52; i++) {
			boolean prime = true;
			for(int j: primes) {
				if(i%j==0) prime=false;
			}
			if(prime) primes.add(i);
		}
		
		for(int i=3; i<=7; i++) squares.add(i*i);
	}
}
