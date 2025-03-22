#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 300;
int N, M;
int dp[MAX_N][MAX_N];
int maxPreq[MAX_N][MAX_N][MAX_N];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    freopen("pieaters.in","r",stdin);
    freopen("pieaters.out","w",stdout);
    cin >> N >> M;

    for(int i=0; i<M; i++){
        int w, l, r; cin >> w >> l >> r;
        l--; r--;
        for(int j=l; j<=r; j++) {
            maxPreq[j][l][r] = max(maxPreq[j][l][r], w);
        }
    }

    for(int i=0; i<N; i++){
        for(int l=i; l>=0; l--) {
            for(int r=i; r<N; r++) {
                if(l>0) maxPreq[i][l-1][r] = max(maxPreq[i][l-1][r],maxPreq[i][l][r]);
                if(r<N-1) maxPreq[i][l][r+1] = max(maxPreq[i][l][r+1],maxPreq[i][l][r]);
            }
        }
    }

    for(int len=1; len<=N; len++) {
        for(int s=0; s<=N-len; s++){
            int e = s+len-1;

            for(int i=s; i<e; i++){
                dp[s][e] = max(dp[s][e], dp[s][i]+dp[i+1][e]);
            }
            for(int i=s; i<=e; i++){
                if(maxPreq[i][s][e]) {
                    int sum = maxPreq[i][s][e];
                    if(i>s) sum += dp[s][i-1];
                    if(i<e) sum += dp[i+1][e];
                    dp[s][e] = max(dp[s][e], sum);
                }
            }
        }
    }

    cout << dp[0][N-1] << endl;
    
}