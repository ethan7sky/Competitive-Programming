import java.io.*;
import java.util.*;

public class USACOLivestockLineup {
	
	for(int i = 0; i < n; i++) {
		
		sum = -1;
		
		int minl = bales[i];
		int radius = 1;
		for(int j = i; j >= 0; j--) {
			if(bales[j] >= minl) {
				sum++;
				minl = Math.min(bales[j]-radius, minl);
				radius++;
				
			}
		}
		
		int maxr = bales[i];
		radius = 1;
		for(int j = i; j < n; j++) {
			if(bales[j] <= maxr) {
				sum++;
				maxr = Math.max(bales[j]+radius, maxr);
				radius++;
				
			}
		}
		
		max = Math.max(max, sum);
	}
	System.out.println(max);

}
