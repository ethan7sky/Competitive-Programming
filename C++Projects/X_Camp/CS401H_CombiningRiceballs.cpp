#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int dp[400][400];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; cin >> n;
    
    for(int i=0; i<n; i++) {
        cin >> dp[i][i];
    }

    int ans = 0;

    for(int len=1; len<=n; len++){
        for(int s=0; s+len-1<n; s++){
            int e = s+len-1;

            bool found = false;
            for(int m=s+1; m<=e; m++){
                if(dp[s][m-1]==dp[m][e] && dp[s][m-1] != 0){
                    dp[s][e] = max(dp[s][e], dp[s][m-1]+dp[m][e]);
                    found = true;
                }
            }

            if(!found && len>2){
                for(int ms=s+1; ms<e; ms++){
                    if(dp[s][ms-1]==0) continue;                    
                    for(int me=ms; me<e; me++){
                        if(dp[me+1][e]==0) continue;
                        if(dp[ms][me]==0) continue;
                        if(dp[s][ms-1] != dp[me+1][e]) continue;
                        dp[s][e] = max(dp[s][e], dp[s][ms-1]+dp[ms][me]+dp[me+1][e]);
                    }
                }
            }

            ans = max(ans, dp[s][e]);
        }
    }

    cout << ans;
}