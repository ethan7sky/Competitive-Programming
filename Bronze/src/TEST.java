import java.util.*;
import java.io.*;

public class USACOAirCownditioning {
	
	static Scanner in;
	static int n, a[], ans;
  	static ArrayList<Integer> up, dn;
  
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		init();
	}
  
  	static void init(){
      	n = in.nextInt();
      	a = new int[n];
      	for(int i=0; i<n; i++) a[i] = in.nextInt();
      	
      	up = new ArrayList<Integer>();
      	dn = new ArrayList<Integer>();
      
      	for(int i=0; i<n; i++){
          
          	int df = a[i] - in.nextInt();
          	
          	if(df > 0) { dn.add(df); up.add(0);}
          	else if(df < 0) { dn.add(0); up.add(-df);}
          	else { dn.add(0); up.add(0); } 
        }
      	
      //	System.out.println(dn);
      //	System.out.println(up);
      	
        solve(dn);
      	solve(up);
        
      	
      	System.out.println(ans);
    }
  	
  	static void solve(ArrayList<Integer> list) {
  		
  		if(list.size() == 0) return;
  		
  		int min = list.get(0);
  		for(int i=0; i<list.size(); i++) {
  			min = Math.min(min, list.get(i));
  		}
  		
  		ans += min;
  		
  		for(int i=0; i<list.size(); i++) {
  			list.set(i, list.get(i)-min);
  		}
  		
  		ArrayList<Integer> temp = new ArrayList<Integer>();
  		for(int i=0; i<list.size(); i++) {
  			if(list.get(i) == 0) {
  				solve(temp);
  				temp.clear();
  			}
  			else temp.add(list.get(i));
  		}
  		
  		solve(temp);
  		
  	}
}

/*
10
6 10 6 2 1 4 0 6 3 1
8 7 5 3 7 4 9 10 2 0
*/