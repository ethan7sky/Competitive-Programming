import java.util.*;
import java.io.*;

public class Prob22 {

    //static String file = "1";    //local    
    //static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t;
    static int h, w;
    static String[][] a;
    static int[] cx = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] cy = new int[] {1, 1, 1, 0, -1, -1, -1, 0};
    
    public static void main(String[] args)throws IOException{        
        
        //in = new Scanner(new File(file+".in"));            //local
        //out = new PrintWriter(new File("out.txt"));        //local        
        in = new Scanner(System.in);                    //submit
        
        int t = in.nextInt(); in.nextLine();
        
        while(t-->0) {
            init();
            solve();
        }
        
        in.close();        
        //out.close(); //local
        
        //Check.check("out.txt", file+".out");    //local
    }
    
    
    static void init() {        
    
       h = in.nextInt();
       w = in.nextInt();
       
       a = new String[h][w];
       for(int i=0; i<h; i++) {
    	   for(int j=0; j<w; j++) {
    		   a[i][j] = in.next();
    	   }
       }
        
    }
    
    static void solve() {
    	
//    	if(h==1 && w==1) {
//    		if(a[0][0].endsWith("L")) {
//        		int currElevation = Integer.parseInt(a[0][0].substring(0,a[0][0].length()-1));
//        		System.out.println(currElevation+" 0 0");	
//    		}
//    		return;
//    	}
    	
    	ArrayList<answers> ans = new ArrayList<answers>();
    	
    	//check with x backwards to check sorting
    	for(int x=0; x<h; x++) {
    		for(int y=0; y<w; y++) {
    			
    			String curr = a[x][y];
    			if(curr.endsWith("W")) continue;
    			else {
    				
    				int currElevation = Integer.parseInt(curr.substring(0,curr.length()-1));
    				boolean works = true;
    				for(int i=0; i<8; i++) {
    					int newx = x+cx[i];
    					int newy = y+cy[i];
    					
    					if(newx<0||newy<0||newx>=h||newy>=w) continue;
    					
    					String cell = a[newx][newy];
    					cell = cell.substring(0,cell.length()-1);
    					
    					if(currElevation>Integer.parseInt(cell)) {
    						works = false;
    					}
    				}   
    				if(works) {
    					ans.add(new answers(currElevation, x, y));
    				}
    			}
    		}
    	}
    	Collections.sort(ans);
        for(answers i: ans) {
        	System.out.println(i.elevation+" "+i.x+" "+i.y);
        }
    }
    static class answers implements Comparable<answers> {
    	
    	int elevation, x, y;
    	answers(int a, int b, int c) {
    		elevation = a;
    		x = b;
    		y = c;
    	}
    	public String toString() {
    		return elevation+" "+x+" "+y;
    	}
    	
		@Override
		public int compareTo(answers that) {
			// TODO Auto-generated method stub
			if(this.elevation != that.elevation) return this.elevation - that.elevation;
			else {
				if(this.x != that.x) return this.x-that.x;
				else {
					return this.y-that.y;
				}
			}
		}
    	
    }
}