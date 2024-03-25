import java.util.*;
import java.io.*;

public class USACOWheresBessie {
	
	static int[] cx = {0, 0, -1, 1};
	static int[] cy = {1, -1, 0, 0};
	static int n;
	static char[][] a;
	static boolean[][] v;
	static ArrayList<answers> ans;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("where.in"));
		out = new PrintWriter("where.out");
		
		n = in.nextInt();
		
		a = new char[n][];
		for(int i=0; i<n; i++) {
			a[i] = in.next().toCharArray();
		}
		v = new boolean[n][n];
		ans = new ArrayList<answers>();
		
		for(int sx=0; sx<n; sx++) {
			for(int ex=sx; ex<n; ex++) {
				for(int sy=0; sy<n; sy++) {
					for(int ey=sy; ey<n; ey++) {
						
						HashMap<Character, pair> colors = new HashMap<>();
						for(int i=sx; i<=ex; i++) {
							for(int j=sy; j<=ey; j++) {
								if(colors.containsKey(a[i][j])) {
									colors.put(a[i][j], colors.get(a[i][j]).addCnt());
								}
								else colors.put(a[i][j], new pair(i, j, 1));
							}
						}
						if(colors.size()==2) {
							v = new boolean[n][n];
							HashMap<Character, Integer> regions = new HashMap<Character, Integer>();
							for(char c: colors.keySet()) regions.put(c, 0);
							for(int i=sx; i<=ex; i++) {
								for(int j=sy; j<=ey; j++) {
									if(!v[i][j]) {
										floodFill(a[i][j], i, j, sx, ex, sy, ey);
										regions.put(a[i][j], regions.get(a[i][j])+1);
									}
								}
							}
							Collection<Integer> vals = regions.values();
							ArrayList<Integer> values = new ArrayList<>(vals);
							if(values.get(0)==1&&values.get(1)>1 || values.get(1)==1&&values.get(0)>1) {

								ans.add(new answers(sx, ex, sy, ey));
							}
//							boolean works = false;
//							for(char c: colors.keySet()) {
//								pair curr = colors.get(c);
//								if(floodFill(c, curr.x, curr.y, sx, ex, sy, ey)==curr.cnt) {
//									works = true;
//								}
//							}
//							if(works) {
//								ans.add(new answers(sx, ex, sy, ey));
//							}
						}
					}
				}
			}
		}
		ArrayList<answers> ans2 = (ArrayList<answers>)ans.clone();
		for(answers i: ans) {
			for(answers j: ans) {
				if(i.equals(j)) continue;
				if(ans2.contains(i) && i.isWithin(j)) ans2.remove(i);
				if(ans2.contains(j)&&j.isWithin(i)) ans2.remove(j);
			}
		}
		out.println(ans2.size());
		
		in.close();
		out.close();
	}
	static int floodFill(char color, int x, int y, int sx, int ex, int sy, int ey) {
		if(x<sx||y<sy||x>ex||y>ey) return 0;
		if(v[x][y]) return 0;
		if(a[x][y] != color) return 0;
		else {
			v[x][y] = true;
			int currCnt = 1;
			for(int i=0; i<4; i++) {
				currCnt += floodFill(color, x+cx[i], y+cy[i], sx, ex, sy, ey);
			}
			return currCnt;
		}
	}
	static class answers{
		int sx, ex, sy, ey;
		public answers(int a, int b, int c, int d) {
			this.sx = a;
			this.ex = b;
			this.sy = c;
			this.ey = d;
		}
		public String toString() {
			return sx+" "+ex+" "+sy+" "+ey;
		}
		public boolean equals(answers that) {
			return this.sx==that.sx && this.ex==that.ex&&this.sy==that.sy&&this.ey==that.ey;
		}
		public boolean isWithin(answers that) {
			return this.sx>=that.sx && this.sy>=that.sy && this.ex<=that.ex && this.ey<=that.ey;
		}
	}
	static class pair{
		int x, y, cnt;
		pair(int i, int b, int c){
			this.x = i;
			this.y = b;
			this.cnt = c;
		}
		public String toString() {
			return x+" "+y+" "+cnt;
		}
		public pair addCnt() {
			this.cnt++;
			return this;
		}
	}
}
