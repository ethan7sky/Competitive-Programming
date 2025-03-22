#include <bits/stdc++.h>
using namespace std;

int dp[250][250];

int main() {

    freopen("248.in", "r", stdin);
    freopen("248.out", "w", stdout);

    int n; cin >> n;

    for(int i=0; i<n; i++){
        cin >> dp[i][i];
    }

    int ans = 0;
    for(int len=1; len<=n; len++){
        for(int s=0; s+len-1<n; s++){
            int e = s+len-1;

            for(int m=s; m<e; m++){
                if(dp[s][m]==dp[m+1][e] && dp[s][m]!=0){
                    dp[s][e] = max(dp[s][e], dp[s][m]+1);
                    ans = max(ans, dp[s][e]);
                }
            }
        }
    }

    cout << ans << endl;
}