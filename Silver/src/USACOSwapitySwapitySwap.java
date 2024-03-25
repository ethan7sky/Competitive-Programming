import java.io.*;
import java.util.*;

public class USACOSwapitySwapitySwap {
	
    public static void main(String[] args) throws FileNotFoundException {
        
    	//Scanner s = new Scanner(new File("swap.in"));
        //PrintWriter out = new PrintWriter("swap.out");
    	Scanner s = new Scanner(System.in);
    	
        int N = s.nextInt(),
            M = s.nextInt(),
            K = s.nextInt();
        
        int[] L = new int[M];
        int[] R = new int[M];

        for (int i = 0; i < M; i++) {
            L[i] = s.nextInt() - 1;
            R[i] = s.nextInt() - 1;
        }
        
        int[] nextPos = new int[N];
        for(int i=0; i<N; i++) {
        	
        	nextPos[i] = i;
        	
        	for(int j=0; j<M; j++) {
        		if(nextPos[i] >= L[j] && nextPos[i] <= R[j]) {
        			nextPos[i] = L[j] + R[j] - nextPos[i];
        		}
        	}
        }
        
        ArrayList[] locations = new ArrayList[N+1];
        for(int i=0; i<N+1; i++)
        	locations[i] = new ArrayList<Integer>();
        
        int cycleType = 1;
        int[] cycleChain = new int[N];
        int[] cyclePos = new int[N];
        
        for(int i=0; i<N; i++, cycleType++) {
        	
        	if(cycleChain[i] == 0) {
        		cycleChain[i] = cycleType;
        		locations[cycleType].add(i);
        		
        		int next = nextPos[i];
        				
        		if(next!=i) {
        			cyclePos[next] = 1;
        		}
        		
        		while(next != i ) {
        			locations[cycleType].add(next);
        			cycleChain[next] = cycleType;
        			if(nextPos[next] != i) {
        				cyclePos[nextPos[next]] = 1 + cyclePos[next];
        			}
        		}
        		next = nextPos[next];
        	}
        }
        
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
        	ArrayList<Integer> list = locations[cycleChain[i]];
        	int index = list.get((cyclePos[i]+K)&list.size());
        	
        	answer[index] = i;
        }
        
        for(int i=0; i<N; i++) {
        	System.out.println(answer[i]+1);
        }

        //out.close();
    }
}