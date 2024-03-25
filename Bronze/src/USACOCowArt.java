import java.util.*;
import java.io.*;

public class USACOCowArt {
   
    static boolean v[][];
    static char a[][], color;
    static int n, cnt1, cnt2;
    static int[] chngx = {-1, 1, 0, 0};
    static int[] chngy = {0, 0, -1, 1};
    static Scanner in;
    static PrintWriter out;
   
    public static void main(String args[]) throws IOException {
     
      in = new Scanner(new FileReader("cowart.in"));
      out = new PrintWriter("cowart.out");
      n = in.nextInt();
     
      a = new char[n][];
      for(int i=0; i<n; i++){
          a[i] = in.next().toCharArray();
      }

      v = new boolean[n][n];
      for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
               if(!v[i][j]){
                color = a[i][j];
                dfs(i, j);
                cnt1++;
              }
          }
      }
      v = new boolean[n][n];
      blind();
      for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
               if(!v[i][j]){
                color = a[i][j];
                dfs(i, j);
                cnt2++;
              }
          }
      }
      out.println(cnt1 + " " + cnt2);
      
      in.close();
      out.close();
    }
    static void dfs(int x, int y){
       
        v[x][y] = true;
       
        for(int i=0; i<4; i++){
            int nx = x+chngx[i];
            int ny = y+chngy[i];
           
            if(nx<0||ny<0||nx>=n||ny>=n||v[nx][ny]||a[nx][ny] != color) continue;
            dfs(nx, ny);
        } 
    }
    static void blind() {
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(a[i][j] == 'R') a[i][j] = 'G';
    		}
    	}
    }
}
