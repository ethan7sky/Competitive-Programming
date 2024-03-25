import java.io.*;
import java.util.*;

public class USACOBerryPicking2 {
	static int N, K;
	static int[] B;
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		B = new int[N];
		int max = -1;
		for (int i = 0; i < N; i++) {
			B[i] = in.nextInt();
			max = Math.max(max, B[i]);
		}

		int res = -1;
		for (int i = 1; i <= max; i++) {
			int count = 0;
			int[] leftOver = new int[N];
			for (int j = 0; j < N; j++) {
				count += B[j] / i;
				leftOver[j] = B[j] % i;
			}
			
			System.out.println(count+" "+Arrays.toString(leftOver));
			if (count >= K) {
				// If count can account for both Bessie and Elsie, then we can
				// just allocate K/2 * i to Bessie
				res = Math.max(res, K / 2 * i);
			} else if (count >= K / 2) {
				// If count can only account for Elsie and some of Bessie, then
				// we can take from the leftovers.
				int berries = 0;
				berries += (count - K / 2) * i;
				Arrays.sort(leftOver);
				int ix = leftOver.length - 1;
				for (int j = count - K / 2; j < K / 2; j++) {
					if (ix < 0) continue;
					berries += leftOver[ix--];
				}

				res = Math.max(res, berries);
			}
		}
		System.out.println(res);
	}
}