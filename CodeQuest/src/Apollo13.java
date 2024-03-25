import java.util.*;
import java.io.*;

public class Apollo13 {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		while(n-->0) {
			double a = in.nextDouble()-180.0;
			double b = in.nextDouble()-180.0;
			double c = in.nextDouble()-180.0;
			
			if(a<0) a+=360.0;
			if(b<0) b+=360.0;
			if(c<0) c+=360.0;
			
			a = Math.round(a*100.0)/100.0;
			b = Math.round(b*100.0)/100.0;
			c = Math.round(c*100.0)/100.0;
			
			String a1 = format(a);
			String a2 = format(b);
			String a3 = format(c);
			
			System.out.println(a1+" "+a2+" "+a3);
		}
	}
	static String format(double a) {
		String ans = a+"";
		if(ans.indexOf(".")==1) ans = "00"+ans;
		else if(ans.indexOf(".")==2) ans = "0"+ans;
		
		if(ans.length()==5) ans += "0";
		return ans;
	}
}
