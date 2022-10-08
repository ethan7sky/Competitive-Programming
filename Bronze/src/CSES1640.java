import java.util.*; import java.io.*;
public class CSES1640 {
	
	static int n, x, nums[];
	static String ans;
	static HashMap<Integer, Integer> map;
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		nums = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		map = new HashMap<Integer, Integer> ();
		
		ans = "";
		for(int i=0; i<n; i++) {
			map.put(nums[i], i+1);
		}
		for(int i=0; i<n; i++) {
			if(map.containsKey(x-nums[i]) && i+1 != map.get(x-nums[i])) {
				ans = i+1+" "+map.get(x-nums[i]);
				break;
			}
		}
		if(ans.equals("")) System.out.println("IMPOSSIBLE");
		else System.out.println(ans);
	}
}
