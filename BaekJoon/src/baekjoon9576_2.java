import java.util.*;

public class baekjoon9576_2 {
	
	static Scanner in;
	static ArrayList<int[]> a;
	static int t, n, m;
	static boolean v[];
	public static void main(String[] args) {
		in = new Scanner(System.in);
		t = in.nextInt();
		while(t-->0) {
			init();
			solve();
		}
	}
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		a = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			a.add(new int[] {x, y});
		}
		
		Collections.sort(a, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1]==o2[1]) return o1[0]-o2[0];
				return o1[1] - o2[1];
			}
		});
		
		v = new boolean[n+1];
	}
	static void solve() {
		
		int cnt = 0;
		for(int[] books:a) {
			for(int i=books[0]; i<=books[1]; i++) {
				if(v[i]) continue;
				v[i] = true;
				cnt++;
				break;
			}
		}
		System.out.println(cnt);
	}
}
