#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9+7;

int main() {
    // #ifndef ONLINE_JUDGE 
    // freopen("IO_SPACE/input.txt", "r", stdin); 
    // freopen("IO_SPACE/output.txt", "w", stdout); 
    // #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; cin >> n;

    vector<vector<int>> com(n, vector<int>(n));
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin >> com[i][j];
        }
    }

    vector<int> dp(1<<n);
    dp[0] = 1;

    for(int mask=0; mask < (1<<n)-1; mask++){
        int cnt = __builtin_popcount(mask);
        for(int j=0; j<n; j++){
            if(com[cnt][j] && !(mask & (1<<j))){
                dp[mask^(1<<j)] += dp[mask];
                dp[mask^(1<<j)] %= MOD;
            }
        }
    }

    cout << dp[(1<<n)-1] << endl;
    return 0;

}
