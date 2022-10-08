import java.util.*; import java.io.*; 

public class USACODontBeLast {
	
	static Scanner in;
	static PrintWriter out;
	static int n, min1, min2;
	static TreeMap<String, Integer> cows;
	
	public static void main(String[] args) throws IOException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("notlast.in"));
		out = new PrintWriter("notlast.out");
		
		n = in.nextInt();
		
		cows = new TreeMap<String, Integer> ();
		for(int i=0; i<n; i++) {
			String cow = in.next();
			if(cows.containsKey(cow)) {
				cows.put(cow, cows.get(cow)+in.nextInt());
			}
			else {
				cows.put(cow, in.nextInt());
			}
		}
		
		min1 = Integer.MAX_VALUE;
		min2 = Integer.MAX_VALUE;
		
		for(Map.Entry<String, Integer> data : cows.entrySet()) {
			
			int value = data.getValue();
			
			if(value < min1) {
				min2 = min1;
				min1 = value;
			}
			else if(value < min2 && value!=min1) {
				min2 = value;
			}
		}
		
		int cnt = 0;
		String cow = "";
		
		if(min2 == Integer.MAX_VALUE) min2 = min1;
		
		for(Map.Entry<String, Integer> data : cows.entrySet()) {
			if(data.getValue() == min2) {
				cnt++;
				cow = data.getKey();
			}
		}
		
		if(cnt != 1) out.println("Tie");
		else out.println(cow);
		
		
		in.close();
		out.close();
	}
	
}
