package LevelTest;
import java.util.*;
import java.io.*;
public class A_CombinationSum {

  static int n, k;
  static int[] a;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    k = in.nextInt();
    a = new int[n];
    for(int i=0; i<n; i++){
      a[i] = in.nextInt();
    }

    boolean works = findSum(0, 0);    
    System.out.println(works?"Yes":"No");
  }
  static boolean findSum(int idx, int currSum){
    if(currSum == k) return true;
    if(idx>=n) return false;
    boolean x = findSum(idx+1, currSum+a[idx]);
    boolean y = findSum(idx+1, currSum);
    return x||y;
  }
}