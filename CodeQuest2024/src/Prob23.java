import java.util.*;
import java.io.*;

public class Prob23 {

    static String file = "11";    //local    
    static PrintWriter out;        //local    
    static Scanner in;            
    static int t, n, m, sx, sy, ex, ey;
    static char grid[][];
    static int used[][];
    static String og[];
    static Map<Integer, Integer>[] rotors = new HashMap[7];

    
    public static void main(String[] args) throws IOException{        
        
//         in = new Scanner(new File("Prob" + file+".in"));            //local
//         out = new PrintWriter(new File("out.txt"));        //local        
        in = new Scanner(System.in);                    //submit
        out = new PrintWriter(System.out);  //submit 
        
        int t = in.nextInt();
        
        in.nextLine();
        while(t-- > 0) {
            init();
        }
        
        in.close();        
        out.close(); 
        
//         Check.check("out.txt", "Prob"+file+".out");    //local
    }
    
    static void init() {  
    	int min = in.next().equals("TRUE") ? 0 : 1; 
    	n = in.nextInt();
    	int[] dat = new int[n];
    	for(int i = 0; i < n; i++) {
    		String s = in.next();
    		dat[i] = Integer.parseInt(s.substring(0, 2))*4 + Integer.parseInt(s.substring(3))/15;
//    		System.out.println(dat[i]);
    	}
    	
    	if(min == 0) {
    		System.out.println("NONE");
    		return;
    	}
    	
    	min = 0;
    	//min is the max of the minimum threat levels
    	// 0 = NONE, 1 = LOW, 2 = MEDIUM, 3 = HIGH
    	if(n >= 12) {
    		min = Math.max(1, min);
    	}
    	
    	if(n >= 24) {
    		min = Math.max(2, min);
    	}
    	
    	if(n >= 36) {
    		min = 3;
    	}
    	
    	int maxCont = 0;
    	int count = 0;
    	for(int i = 1; i < n; i++) {
    		if(dat[i] - dat[i-1] == 1 || dat[i]-dat[i-1]==97) {
    			count++;
    		} else {
    			count = 0;
    		}
    		
    		maxCont = Math.max(maxCont, count+1);
    	}
    	
//    	System.out.println("maxCont " + maxCont);
    	
    	if(maxCont >= 4) {
    		min = Math.max(1, min);
    	}
    	
    	if(maxCont >= 8) {
    		min = Math.max(2, min);
    	}
    	
    	if(maxCont >= 12) {
    		min = Math.max(3, min);
    	}
    	
    	
    	int enterTimes = 0;
    	for(int i = 1; i < n; i++) {
    		if(dat[i] - dat[i-1] != 1) {
    			enterTimes++;
    		} 
    		
    	}
    	enterTimes++;
//    	System.out.println(enterTimes);
    	
    	if(enterTimes >= 4) {
    		min = Math.max(2, min);
    	}
    	
    	if(enterTimes >= 8) {
    		min = 3;
    	}
    	
    	if(min == 0) {
    		System.out.println("NONE");
    	} else if(min == 1) {
    		System.out.println("LOW");
    	} else if(min == 2) {
    		System.out.println("MEDIUM");
    	} else if(min == 3) {
    		System.out.println("HIGH");
    	}
    }
    
   
}
