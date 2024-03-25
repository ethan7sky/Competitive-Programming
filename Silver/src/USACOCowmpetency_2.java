import java.io.*;
import java.util.*;

public class USACOCowmpetency_2 {

    static BufferedReader in;
    static StringTokenizer st;
    static int t, n, q, c, a[], pointsto[], query[][];
    static boolean zero[];
    static StringBuilder ans;

    public static void main(String[] args) throws IOException {

        in = new BufferedReader(new InputStreamReader(System.in));
        ans = new StringBuilder();

        t = Integer.parseInt(in.readLine());
        testcases:
        while(t-->0) {
            st = new StringTokenizer(in.readLine());

            n = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            a = new int[n];
            zero = new boolean[n];
            pointsto = new int[n];
            query = new int[q][2];

            st = new StringTokenizer(in.readLine());
            for(int i=0; i<n; i++){
                a[i] = Integer.parseInt(st.nextToken());
                if(a[i]==0) {
                	zero[i] = true;
                	a[i]=1;
                }
            }
            for(int i=0; i<q; i++){
                st = new StringTokenizer(in.readLine());
                query[i][0] = Integer.parseInt(st.nextToken())-1;
                query[i][1] = Integer.parseInt(st.nextToken())-1;
                if(pointsto[query[i][0]]!=0) {
                    ans.append("-1\n");
                    continue testcases;
                }
                pointsto[query[i][0]] = query[i][1];
            }
            //System.out.println(Arrays.toString(a));
            //System.out.println(Arrays.toString(pointsto));

            //check query ranges
//            int currpointsto = 0;
//            for(int i=0; i<n; i++) {
//                if(i<currpointsto) {
//                    if(pointsto[i]==0) pointsto[i]=currpointsto;
//                    else if(pointsto[i] != currpointsto) {
//                        ans.append("-1\n");
//                        continue testcases;
//                    }
//                }
//                else{
//                    currpointsto = pointsto[i];
//                }
//            }
            for(int i=0; i<n; i++) {
            	if(pointsto[i]==0) continue;
            	
            	for(int j=i; j<pointsto[i]; j++) {
            		if(pointsto[j]!=0 && pointsto[j]!=pointsto[i]) {
            			ans.append("-1");
            			return;
            		}
            		pointsto[j] = pointsto[i];
            	}
            	
            	i = pointsto[i];
            }
            //System.out.println(Arrays.toString(pointsto));
            //ans.append("works\n");

            //solve
            
            int lmax=0, rmax=0;
            for(int i=0; i<n; i++) {
            	
            	lmax = Math.max(lmax, a[i]);
            	rmax = Math.max(rmax, a[i]);
            	
            	if(pointsto[i]==0) continue;
            	
            	for(int j=i; j<pointsto[i]; j++) rmax = Math.max(rmax, a[j]);
            	
            	if(lmax < rmax) {
            		
            		boolean foundzero = false;
            		for(int j=i; j>=0; j--) {
            			
            			if(!zero[j]) continue;
            			if(pointsto[j]!=0&&pointsto[j]<pointsto[i]) {
            				ans.append("-1\n");
            				continue testcases;
            			}
            			foundzero = true;
            			a[j] = rmax;
            			break;
            		}
            		
            		if(!foundzero) {
            			ans.append("-1\n");
        				continue testcases;
            		}
            		
            		lmax=rmax;            		
            	}
            	if(zero[pointsto[i]]) a[pointsto[i]] = lmax+1;
            	
            	if(a[pointsto[i]] <= lmax) {
            		ans.append("-1\n");
            		continue testcases;
            	}
            }
            
            StringBuilder sub = new StringBuilder();
            for(int i=0; i<n; i++) {
            	if(a[i] > c) {
            		ans.append("-1\n");
    				continue testcases;
            	}
            	sub.append(a[i]);
            	if(i==n-1) sub.append("\n");
            	else sub.append(" ");
            }
            ans.append(sub);
            
//            
//            int currmax=a[0];
//            for(int i=0; i<n; i++){
//            	if(pointsto[i]==0) continue;
//            	//find last idx of pointsto
//            	int lastidx = pointsto[i]-1;
//            	
//                int lmax=0;
//                int rmax=0;
//                for(int j=0; j<i; j++){
//                    lmax = Math.max(lmax, rmax);
//                }
//            }
        }
        System.out.print(ans);
        
    }
}
