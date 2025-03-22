import java.util.*;
import java.io.*;

public class USACOTargetPractice2 {
	
	static final int NEGOFFSET = (int)1e5+100;
	static int CURRENT_POSITION = NEGOFFSET, CURRENT_ANS=0;
	static int T, C;
	static boolean hasTarget[] = new boolean[NEGOFFSET*2];
	static char[] cmds;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] pref = new int[NEGOFFSET*2];
	static int[] offsetL = new int[NEGOFFSET*2];
	static int[] offsetLL = new int[NEGOFFSET*2];
	static int[] offsetRR = new int[NEGOFFSET*2];
	static int[] offsetR = new int[NEGOFFSET*2];
	static int ansP, ansL, ansLL, ansR, ansRR;
	static int posL, posLL, posR, posRR;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		T = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<T; i++) {
			int targetPos = Integer.parseInt(st.nextToken());
			targetPos += NEGOFFSET;
			hasTarget[targetPos] = true;
		}
		
		cmds = in.readLine().toCharArray();
		
		for(char i: cmds) {
			if(i=='L') {
				CURRENT_POSITION--;
			}else if(i=='R') {
				CURRENT_POSITION++;
			} else {
				if(hasTarget[CURRENT_POSITION]) {
					if(pref[CURRENT_POSITION]==0) CURRENT_ANS++;
					pref[CURRENT_POSITION]++;
				}
			}
		}
		
		posL = CURRENT_POSITION-1;
		posLL = CURRENT_POSITION - 2;
		posR = CURRENT_POSITION+1;
		posRR = CURRENT_POSITION + 2;
		
		ansP = CURRENT_ANS;
		
		for(int idx=C-1; idx>=0; idx--) {
			
			char cmd = cmds[idx];
//			System.out.println(cmd);
			if(cmd=='L') {
				//update
				posL++;
				posLL++;
				posR++;
				posRR++;
				CURRENT_POSITION++;
				//turn into F
				CURRENT_ANS = Math.max(CURRENT_ANS, ansP+ansR + ((hasTarget[CURRENT_POSITION] && pref[CURRENT_POSITION]==0&&offsetR[CURRENT_POSITION]==0) ? 1 : 0));
				//turn into R
				CURRENT_ANS = Math.max(CURRENT_ANS, ansP+ansRR);
			}else if(cmd=='R') {
				//update
				posL--;
				posLL--;
				posR--;
				posRR--;
				CURRENT_POSITION--;
				//turn into F
//				System.out.println(ansP+" "+ansL+" "+(pref[CURRENT_POSITION]==0&&offsetL[CURRENT_POSITION]==0));
				CURRENT_ANS = Math.max(CURRENT_ANS, ansP+ansL + ((hasTarget[CURRENT_POSITION] && pref[CURRENT_POSITION]==0&&offsetL[CURRENT_POSITION]==0) ? 1 : 0));
				//turn into L
				CURRENT_ANS = Math.max(CURRENT_ANS, ansP+ansLL);
			}else {
				//update
				if(hasTarget[CURRENT_POSITION]) {
					pref[CURRENT_POSITION]--;
//					System.out.println("pref of current pos is "+pref[CURRENT_POSITION]);
					if(pref[CURRENT_POSITION]==0) {
						ansP--;
						if(offsetLL[CURRENT_POSITION]==-1) {
							offsetLL[CURRENT_POSITION]=1;
							ansLL++;
						}if(offsetL[CURRENT_POSITION]==-1) {
							offsetL[CURRENT_POSITION]=1;
							ansL++;
						}if(offsetR[CURRENT_POSITION]==-1) {
							offsetR[CURRENT_POSITION]=1;
							ansR++;
						}if(offsetRR[CURRENT_POSITION]==-1) {
							offsetRR[CURRENT_POSITION]=1;
							ansRR++;
						}
						//TODO: should update the offset arrays here.
					}
				}
				//F -> L
				CURRENT_ANS = Math.max(CURRENT_ANS, ansP+ansL);
				//F -> R
				CURRENT_ANS = Math.max(CURRENT_ANS, ansP+ansR);
				//update
				if(hasTarget[posL]) {
					if(pref[posL]==0 && (offsetL[posL]==0||offsetL[posL]==-1)) {
						ansL++;
						offsetL[posL]=1;
					} else if(pref[posL]==0){
						offsetL[posL]=-1;
					}
				}
				if(hasTarget[posR]) {
					if(pref[posR]==0 && (offsetR[posR]==0||offsetR[posR]==-1)) {
						ansR++;
						offsetR[posR]=1;
					} else if(pref[posR]==0){
						offsetR[posR]=-1;
					}
				}
				if(hasTarget[posLL]) {
					if(pref[posLL]==0 && (offsetLL[posLL]==0||offsetLL[posLL]==-1)) {
						ansLL++;
						offsetLL[posLL]=1;
					} else if(pref[posLL]==0){
						offsetLL[posLL]=-1;
					}
				}
				if(hasTarget[posRR]) {
					if(pref[posRR]==0 && (offsetRR[posRR]==0||offsetRR[posRR]==-1)) {
						ansRR++;
						offsetRR[posRR]=1;
					} else if(pref[posRR]==0){
						offsetRR[posRR]=-1;
					}
				}
//				System.out.println(idx);
//				System.out.println(ansLL+" "+ansL+" "+ansR+" "+ansRR);
			}
//			System.out.println(CURRENT_ANS);
		}
		
		System.out.println(CURRENT_ANS);
	}
}
