import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Problem3 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int t, c;
	static char[] cmds;
	static String[] a;
	static BigInteger ansstring;
	static int ans;
	static BigInteger targets;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		t = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		char[] temp = new char[c*2+1];
		Arrays.fill(temp, '0');
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<t; i++) temp[Integer.parseInt(st.nextToken())+c] = '1';
		BigInteger targets = new BigInteger(new String(temp), 2);
		
		cmds = in.readLine().toCharArray();
		System.out.println(Arrays.toString(cmds));
		
		int idx=c;
		for(int i=0; i<c; i++) {
			if(cmds[i]=='L') idx--;
			else if(cmds[i]=='R') idx++;
		}
		a = new String[c];
		String stringtemp = "";
//		temp = new char[c*2+1];
		for(int i=0; i<c*2+1; i++) stringtemp+="0";
		
		String s;
		for(int i=c-1; i>=0; i--) {
			
			if(cmds[i]=='R') idx--;
			else if(cmds[i]=='L') idx++;
			else stringtemp = stringtemp.substring(0,idx)+"1"+stringtemp.substring(idx+1);
			
			a[i] = stringtemp;
		}
		//System.out.println(Arrays.toString(a));
		
		char[] destroyed = new char[c*2+1];
		Arrays.fill(destroyed, '0');
		int curridx = c;

	}
}
