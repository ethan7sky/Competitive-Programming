import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class USACOPaintingFencePosts2 {
	
	static StringTokenizer st;
	static BufferedReader in;
	static StringBuilder sb;
	
	static int N, P;
	static HashMap<Integer, fencePost> fencePosts;
	static HashMap<Integer, ArrayList<fencePost>> xFencePosts, yFencePosts;
	static ArrayList<Integer> adj[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		fencePosts = new HashMap<Integer, fencePost>();
		xFencePosts = new HashMap<Integer, ArrayList<fencePost>>();
		yFencePosts = new HashMap<Integer, ArrayList<fencePost>>();
		adj = new ArrayList[P];
		for(int i=0; i<P; i++) adj[i] = new ArrayList<Integer>();
		
		for(int i=0; i<P; i++) {
			st = new StringTokenizer(in.readLine());
			
			fencePost curr = new fencePost(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), i);
			
			fencePosts.put(i, curr);
			
			
			if(!xFencePosts.containsKey(curr.x)) {
				xFencePosts.put(curr.x, new ArrayList<fencePost>());
			}xFencePosts.get(curr.x).add(curr);
			
			if(!yFencePosts.containsKey(curr.y)) {
				yFencePosts.put(curr.y, new ArrayList<fencePost>());
			}yFencePosts.get(curr.y).add(curr);
		}
		
		for(Entry i: xFencePosts.entrySet()) {
			Collections.sort((ArrayList)i.getValue(), new yComparator());
			ArrayList<fencePost> temp = (ArrayList) i.getValue();
			for(int j=0; j<temp.size(); j+=2) {
				int a = temp.get(j).id;
				int b = temp.get(j+1).id;
				adj[a].add(b);
				adj[b].add(a);
			}
			
		}
		for(Entry i: yFencePosts.entrySet()) {
			Collections.sort((ArrayList)i.getValue(), new xComparator()); 
			ArrayList<fencePost> temp = (ArrayList) i.getValue();
			for(int j=0; j<temp.size(); j+=2) {
				int a = temp.get(j).id;
				int b = temp.get(j+1).id;
				adj[a].add(b);
				adj[b].add(a);
			}
		}
		
//		for(ArrayList i: adj) {
//			System.out.println(i);
//		}
		
		int[] postOrder = new int[P+1];
		long[] prefixSum = new long[P+1];
		HashMap<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
		
		int prevCow = 0;
		int currCow = 0;
		int currIdx = 1;
		
		while(true) {
			for(int i: adj[currCow]) {
				if(i==prevCow) continue;
//				System.out.println(currCow+" is adj to "+i);
				
				long dist = fencePosts.get(currCow).x - fencePosts.get(i).x + fencePosts.get(currCow).y - fencePosts.get(i).y;
				dist = Math.abs(dist);
				prefixSum[currIdx] = dist + prefixSum[currIdx-1];
				prevCow = currCow;
				currCow = i;
				postOrder[currIdx] = i;
				currIdx++;
				break;
			}
			if(currCow == 0) break;
		}
		
//		System.out.println(Arrays.toString(postOrder));
//		System.out.println(Arrays.toString(prefixSum));
		
		for(int i=0; i<=P; i++) {
			idxMap.put(postOrder[i], i);
		}
		
//		System.out.println(idxMap);
		
		
		sb = new StringBuilder();
		
		int diffArray[] = new int[P+1];
		int diffStartCnt = 0;
		
		while(N-->0) {
			
			st = new StringTokenizer(in.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			//edge cases
			
			if(x1==x2) {
				if(xFencePosts.get(x1)!= null) {
					int idx1 = Collections.binarySearch(xFencePosts.get(x1), new fencePost(-1, y1, -1), new yComparator());
					int idx2 = Collections.binarySearch(xFencePosts.get(x2), new fencePost(-1, y2, -1), new yComparator());
					
					if(idx1<0 && idx2<0) {
//						System.out.println("HERE");
						idx1 = -idx1-1;
						idx2 = -idx2-1;
						if(idx1==idx2 && idx1%2==1) {
//							System.out.println("BREAK");
							continue;
						}
					}
//					
//					if(Collections.binarySearch(xFencePosts.get(x1), new fencePost(-1, y1, -1), new yComparator())
//							== Collections.binarySearch(xFencePosts.get(x2), new fencePost(-1, y2, -1), new yComparator())) {
//						System.out.println("BREAK");
//						continue;
//					}
				}
			}
			if(y1==y2) {
				if(yFencePosts.get(y1)!=null) {
					
					int idx1 = Collections.binarySearch(yFencePosts.get(y1), new fencePost(x1, -1, -1), new xComparator());
					int idx2 = Collections.binarySearch(yFencePosts.get(y2), new fencePost(x2, -1, -1), new xComparator());
					
					if(idx1<0 && idx2<0) {
						idx1 = -idx1-1;
						idx2 = -idx2-1;
						if(idx1==idx2 && idx1%2==1) {
//							System.out.println("BREAK");
							continue;
						}
					}
					
//					if(Collections.binarySearch(yFencePosts.get(y1), new fencePost(x1, -1, -1), new xComparator())
//							== Collections.binarySearch(yFencePosts.get(y2), new fencePost(x2, -1, -1), new xComparator())) {
//						System.out.println("BREAK");
//						continue;
//					}
				}
			}
			
			
			
			int[] adj1Idx = new int[2];
			int[] adj2Idx = new int[2];
			int[] adj1Dist = new int[2];
			int[] adj2Dist = new int[2];
			
			//start pos
			int idx1;
			if(xFencePosts.get(x1) == null) {
				idx1 = -1;
			}
			else idx1 = Collections.binarySearch(xFencePosts.get(x1), 
					new fencePost(-1, y1, -1), new yComparator());
			if(idx1>=0) {
				adj1Idx[0] = idxMap.get(xFencePosts.get(x1).get(idx1).id);
				adj1Idx[1] = adj1Idx[0];
			} else {
				int newIdx = -idx1-1;
				if(newIdx%2==0) {
					idx1 = Collections.binarySearch(yFencePosts.get(y1),
							new fencePost(x1, -1, -1), new xComparator());
					idx1 = -idx1-1;
					
					fencePost post1 = yFencePosts.get(y1).get(idx1-1);
					fencePost post2 = yFencePosts.get(y1).get(idx1);

					adj1Dist[0] = Math.abs(post1.x-x1);
					adj1Dist[1] = Math.abs(post2.x-x1);
					
					adj1Idx[0] = idxMap.get(post1.id);
					adj1Idx[1] = idxMap.get(post2.id);
					//part of horizontal segment
				} else {
					fencePost post1 = xFencePosts.get(x1).get(newIdx-1);
					fencePost post2 = xFencePosts.get(x1).get(newIdx);

					adj1Dist[0] = Math.abs(post1.y-y1);
					adj1Dist[1] = Math.abs(post2.y-y1);
					
					adj1Idx[0] = idxMap.get(post1.id);
					adj1Idx[1] = idxMap.get(post2.id);
				}
			}
			
			//end pos
			int idx2;
			if(xFencePosts.get(x2) == null) {
				idx2 = -1;
			}
			else idx2 = Collections.binarySearch(xFencePosts.get(x2), 
					new fencePost(-1, y2, -1), new yComparator());
			if(idx2>=0) {
				adj2Idx[0] = idxMap.get(xFencePosts.get(x2).get(idx2).id);
				adj2Idx[1] = adj2Idx[0];
			} else {
				int newIdx = -idx2-1;
				if(newIdx%2==0) {
					idx2 = Collections.binarySearch(yFencePosts.get(y2),
							new fencePost(x2, -1, -1), new xComparator());
					idx2 = -idx2-1;
					
					fencePost post1 = yFencePosts.get(y2).get(idx2-1);
					fencePost post2 = yFencePosts.get(y2).get(idx2);

					adj2Dist[0] = Math.abs(post1.x-x2);
					adj2Dist[1] = Math.abs(post2.x-x2);
					
					adj2Idx[0] = idxMap.get(post1.id);
					adj2Idx[1] = idxMap.get(post2.id);
					//part of horizontal segment
				} else {
					fencePost post1 = xFencePosts.get(x2).get(newIdx-1);
					fencePost post2 = xFencePosts.get(x2).get(newIdx);

					adj2Dist[0] = Math.abs(post1.y-y2);
					adj2Dist[1] = Math.abs(post2.y-y2);
					
					adj2Idx[0] = idxMap.get(post1.id);
					adj2Idx[1] = idxMap.get(post2.id);
				}
			}
			
			
//			System.out.println();
//			System.out.println(idxMap);
//			System.out.println(Arrays.toString(adj1Idx));
//			System.out.println(Arrays.toString(adj1Dist));
//			System.out.println(Arrays.toString(adj2Idx));
//			System.out.println(Arrays.toString(adj2Dist));
//			
//			//calc distances
//			System.out.println(Arrays.toString(postOrder));
//			System.out.println(Arrays.toString(prefixSum));
			
			
			long minDist = Long.MAX_VALUE;
			int ansStartIdx = 0, ansEndIdx = 0;
			for(int start=0; start<2; start++ ) {
				for(int end=0; end<2; end++ ) {
					long currDist = adj1Dist[start] + adj2Dist[end];
					
					int startIdx = adj1Idx[start];
					int endIdx = adj2Idx[end];
					
					if(startIdx>endIdx) {
						int temp = startIdx;
						startIdx = endIdx;
						endIdx = temp;
					}
					
					long option1 = currDist+prefixSum[endIdx]-prefixSum[startIdx];
					long option2 = currDist+prefixSum[startIdx]+prefixSum[P]-prefixSum[endIdx];
					
					if(option1<minDist) {
						ansStartIdx = startIdx;
						ansEndIdx = endIdx;
						minDist = option1;
					}
					if(option2<minDist) {
						ansStartIdx = endIdx;
						ansEndIdx = startIdx;
						minDist = option2;
					}
				}
			}
			
			if(ansEndIdx < ansStartIdx) {
				diffStartCnt++;
			}
			
			if(ansEndIdx==P) ansEndIdx=-1;
			ansEndIdx++;
//			System.out.println("HEREEEEE  " + ansStartIdx+" "+ansEndIdx);
			
			diffArray[ansStartIdx]++;
			diffArray[ansEndIdx]--;
		}
//		System.out.println(diffStartCnt);
//		System.out.println(Arrays.toString(diffArray));
//		System.out.println(idxMap);
		
		long[] cnt = new long[P+1];
		long total = diffStartCnt;
		for(int i=1; i<=P; i++) {
			total += diffArray[i];
			cnt[i] = total;
		}
		
//		System.out.println(Arrays.toString(cnt));
		
		long[] ans = new long[P];
		for(int i=0; i<P; i++) {
			ans[i] = cnt[idxMap.get(i)];
		}
		
		for(long i: ans) sb.append(i).append("\n");
		
		System.out.print(sb);
		
	}
	
	
	static class xComparator implements Comparator<fencePost> {
		public int compare(fencePost a, fencePost b) {
			return a.x-b.x;
		}
	}
	static class yComparator implements Comparator<fencePost> {
		public int compare(fencePost a, fencePost b) {
			return a.y-b.y;
		}
	}
	static class fencePost { 
		int x, y, id;
		public fencePost(int x, int y, int id) {
			this.x = x;
			this.y = y;
			this.id = id;
		}
		public String toString() {
			return x+" "+y+" "+id;
		}
	}
	
	
}
