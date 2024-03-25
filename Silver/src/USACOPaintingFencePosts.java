import java.util.*;
import java.io.*;

public class USACOPaintingFencePosts {
	
	static int n, p;
	static post[] posts;
	static HashMap<Integer, ArrayList<post>> sameX, sameY;
	static int[][] pointsTo;
	
	static ArrayList<Integer> order;
	
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());

		posts = new post[p];
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(in.readLine());
			posts[i] = new post(i, Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		sameX = new HashMap<Integer, ArrayList<post>>();
		sameY = new HashMap<Integer, ArrayList<post>>();
		
		for(int i=0; i<p; i++) {
			if(!sameX.containsKey(posts[i].x))
				sameX.put(posts[i].x, new ArrayList<post>());
			if(!sameY.containsKey(posts[i].y))
				sameY.put(posts[i].y, new ArrayList<post>());
			sameX.get(posts[i].x).add(posts[i]);
			sameY.get(posts[i].y).add(posts[i]);
		}
		for(ArrayList<post> i: sameX.values()) {
			Collections.sort(i, new yComp());
		}
		for(ArrayList<post> i: sameY.values()) {
			Collections.sort(i, new xComp());
		}
		
		pointsTo = new int[p][4];
		//idx 0 = below, idx 1 = right, idx 2 = up, idx 3 = left
		for(ArrayList<post> i: sameX.values()) {
			int size = i.size();
			for(int j=0; j<size; j++) {
				if(j!=0) {
					pointsTo[i.get(j).id][0] = i.get(j-1).id;
				}
				else pointsTo[i.get(j).id][0] = -1;
				if(j!=size-1) {
					pointsTo[i.get(j).id][2] = i.get(j+1).id;
				}
				else pointsTo[i.get(j).id][2] = -1;
			}
		}
		for(ArrayList<post> i: sameY.values()) {
			int size = i.size();
			for(int j=0; j<size; j++) {
				if(j!=0) {
					pointsTo[i.get(j).id][3] = i.get(j-1).id;
				}
				else pointsTo[i.get(j).id][3] = -1;
				if(j!=size-1) {
					pointsTo[i.get(j).id][1] = i.get(j+1).id;
				}
				else pointsTo[i.get(j).id][1] = -1;
			}
		}
		for(int i=0; i<p; i++) {
			for(int j=0; j<4; j++) {
				System.out.print(pointsTo[i][j]+" ");
			}System.out.println();
		}
		
		order = new ArrayList<Integer>();
		boolean[] v = new boolean[p];
		
		int curr = 0;
		for(int i=0; i<p; i++) {
			order.add(curr);
			if(pointsTo[curr][0]!=-1 && !v[pointsTo[curr][0]]) {
				v[pointsTo[curr][0]] = true;
				curr = pointsTo[curr][0];
			}
			else if(pointsTo[curr][1]!=-1 && !v[pointsTo[curr][1]]) {
				v[pointsTo[curr][1]] = true;
				curr = pointsTo[curr][1];
			}
			else if(pointsTo[curr][2]!=-1 && !v[pointsTo[curr][2]]) {
				v[pointsTo[curr][2]] = true;
				curr = pointsTo[curr][2];
			}
			else if(pointsTo[curr][3]!=-1 && !v[pointsTo[curr][3]]) {
				v[pointsTo[curr][3]] = true;
				curr = pointsTo[curr][3];
			}
		}
		System.out.println(order);
		
		
		
		
		
	}
	static class xComp implements Comparator<post> {
		public int compare(post a, post b) {
			return a.x-b.x;
		}
	}
	static class yComp implements Comparator<post> {
		public int compare(post a, post b) {
			return a.y-b.y;
		}
	}
	
	static class post { 
		int id, x, y;
		public post(int a, int b, int c) {
			this.id = a;
			this.x = b;
			this.y = c;
		}
		public String toString() {
			return id+" "+x+" "+y;
		}
	}
	
}
