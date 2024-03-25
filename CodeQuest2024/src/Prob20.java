import java.util.*;
import java.io.*;

public class Prob20 {

    //static String file = "2";    //local    
    //static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t;
    static double a1, b1, c1, i1, j1, k1, a2, b2, c2, i2, j2, k2;
    
    public static void main(String[] args)throws IOException{        
        
        //in = new Scanner(new File(file+".in"));            //local
        //out = new PrintWriter(new File("out.txt"));        //local        
        in = new Scanner(System.in);                    //submit
        
        int t = in.nextInt(); in.nextLine();
        
        while(t-->0) {
            init();
        }
        
        in.close();        
        //out.close(); //local
        
        //Check.check("out.txt", file+".out");    //local
    }
    
    
    static void init() {        
    
    	String[] line1 = in.nextLine().split(",");
    	if(line1.length<6) {
    		System.out.println("Miss");
    		return;
    	}
    	a1 = Double.parseDouble(line1[0]);
    	b1 = Double.parseDouble(line1[1]);
    	c1 = Double.parseDouble(line1[2]);
    	i1 = Double.parseDouble(line1[3]);
    	j1 = Double.parseDouble(line1[4]);
    	k1 = Double.parseDouble(line1[5]);
    	String[] line2 = in.nextLine().split(",");
    	if(line2.length<6) {
    		System.out.println("Miss");
    		return;
    	}
    	a2 = Double.parseDouble(line2[0]);
    	b2 = Double.parseDouble(line2[1]);
    	c2 = Double.parseDouble(line2[2]);
    	i2 = Double.parseDouble(line2[3]);
    	j2 = Double.parseDouble(line2[4]);
    	k2 = Double.parseDouble(line2[5]);

        solve();

    	System.out.println(a1+" "+b1+" "+c1+" "+i1+" "+j1+" "+k1);
    	System.out.println(a2+" "+b2+" "+c2+" "+i2+" "+j2+" "+k2);
        
    }
    
    static void solve() {
    	
    	if(i1==0 && i2==0) {
    		if(a1 != a2) {
    			System.out.println("Miss");
    			return;
    		}
    	}
    	if(j1==0 && j2==0) {
    		if(b1 != b2) {
    			System.out.println("Miss");
    			return;
    		}
    	}
    	if(k1==0 && k2==0) {
    		if(c1 != c2) {
    			System.out.println("Miss");
    			return;
    		}
    	}
    	
    	HashSet<Double> xanswers = new HashSet<Double>();
    	HashSet<Double> yanswers = new HashSet<Double>();
    	HashSet<Double> zanswers = new HashSet<Double>();
    	
    	
    	if(i1==0) {
    		findX(a1, i1);
    	}
    	if(j1==0) {
    		
    	}
    	if(k1==0) {
    		
    	}
    	if(i2==0) {
    		
    	}
    	if(j2==0) {
    		
    	}
    	if(k2==0) {
    		
    	}
    	
    	
    	
    	
        
    	//equation 1 is x = a1+i1*t = a2+i2*s
    	//equation 2 is y = b1+j1*t = b2+j2*s
    	
    	double a1_2 = a1*j2;	
    	double i1_2 = i1*j2;
    	double a2_2 = a2*j2;
    	double i2_2 = i2*j2;
    	
    	double b1_2 = b1*i2;	
    	double j1_2 = j1*i2;
    	double b2_2 = b2*i2;
    	double j2_2 = j2*i2;
//    	
//    		System.out.println(a1_2+" "+i1_2+" "+a2_2+" "+i2_2);
//    	System.out.println(b1_2+" "+j1_2+" "+b2_2+" "+j2_2);
    	
    	double suba1 = a1_2-b1_2;
    	double subi1 = i1_2-j1_2;
    	double suba2 = a2_2-b2_2;
//    	
//    	System.out.println(suba1+" + "+subi1+"t = "+suba2);
    	
    	//solve for t
    	
    	double tcoef = subi1;
    	double num = suba2 - suba1;
    	
//    	System.out.println(tcoef+"t = "+num);

    	//check division by 0!
    	if(tcoef==0) {
    		System.out.println("Miss");
    		return;
    	}
    	double tans = num/tcoef;
//    	System.out.println(tans);
    	
    	//find s
    	//check division by 0!
    	if(i2_2==0) {
    		System.out.println("Miss");
    		return;
    	}
    	double sans = ((double)a1_2+i1_2*tans-a2_2)/i2_2;
//    	System.out.println(sans);
    	
    	if(Math.round((c1+k1*tans)*100000) == Math.round((c2+k2*sans)*100000)) {
    		double xans = a1+i1*tans;
    		double yans = b1+j1*tans;
    		double zans = c1+k1*tans;
    		
    		String xres = String.format("%.2f", xans);
    		String yres = String.format("%.2f", yans);
    		String zres = String.format("%.2f", zans);
    		
    		System.out.println(xres+","+yres+","+zres);
    		
    	}
    	else {
    		System.out.println("Miss");
    		return;
    	}
    }
    
    static double[] solveSystemOfEquations(double a1, double i1, double b1, double j1, double a2, double i2, double b2, double j2) {
    	//a1 + i1*t = b1 + b2*s
    	//b2 + i2*t = b2 + j2*s
    	
    	double a1_2 = a1*j2;	
    	double i1_2 = i1*j2;
    	double a2_2 = a2*j2;
    	double i2_2 = i2*j2;
    	
    	double b1_2 = b1*i2;	
    	double j1_2 = j1*i2;
    	double b2_2 = b2*i2;
    	double j2_2 = j2*i2;

    	double suba1 = a1_2-b1_2;
    	double subi1 = i1_2-j1_2;
    	double suba2 = a2_2-b2_2;

    	//solve for t
    	
    	double tcoef = subi1;
    	double num = suba2 - suba1;
    	
    	if(tcoef==0) {
    		return null;
    	}
    	
    	double tans = num/tcoef;
    	double sans = ((double)a1_2+i1_2*tans-a2_2)/i2_2;
    	
    	double[] ans = new double[] {tans, sans};
    	return ans;
    }
    static double solveEquation() {
    	return 0.0;
    }
    static double findX() {
    	
    }
    static double findY() {
    	
    }
    static double findZ() {
    	
    }
}