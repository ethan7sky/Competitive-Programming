import java.util.*;
import java.io.*;

public class Prob12 {

    //static String file = "2";    //local    
    //static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t;
    static int c, p;
    static HashMap<String, String[]> map;
    
    public static void main(String[] args)throws IOException{        
        
        //in = new Scanner(new File(file+".in"));            //local
        //out = new PrintWriter(new File("out.txt"));        //local        
        in = new Scanner(System.in);                    //submit
        
        int t = in.nextInt();
        while(t-->0) {
            init();
        	
        }
        
        in.close();        
        //out.close(); //local
        
        //Check.check("out.txt", file+".out");    //local
    }
    
    
    static void init() {        
    
        c = in.nextInt();
        p = in.nextInt();
        
        map = new HashMap<String, String[]>();
        in.nextLine();
        
        for(int i=0; i<c; i++) {
        	String name = in.next();
        	String[] abilities = in.nextLine().substring(1).split(" ");
        	map.put(name, abilities);
        }
        for(int i=0; i<p; i++) {
        	solve();
        }
    }
    
    static void solve() {
        String curr = in.next();
        String[] input = in.nextLine().substring(1).split(" ");
        
        int[] vals = new int[6];
        int i=0;
        for(String s: input) {
        	vals[i] = Integer.parseInt(input[i]);
        	i++;
        }
        Arrays.sort(vals);
        System.out.println(curr);
        
        HashMap<String, Integer> ans = new HashMap<String, Integer>();
        for(i=0; i<6; i++) {
        	ans.put(map.get(curr)[i], vals[5-i]);
        }
        System.out.println("STR: "+ans.get("STR"));
        System.out.println("DEX: "+ans.get("DEX"));
        System.out.println("CON: "+ans.get("CON"));
        System.out.println("INT: "+ans.get("INT"));
        System.out.println("WIS: "+ans.get("WIS"));
        System.out.println("CHA: "+ans.get("CHA"));
    }
}