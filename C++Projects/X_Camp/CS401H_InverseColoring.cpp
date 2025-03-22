#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MOD = 998244353;
ll dp[501][501]; //idx, max continuous len

int main() {
    int n, k;
    cin >> n >> k;

    dp[0][0] = 1;
    for(int i=1; i<=n; i++){
        for(int len=1; len<=i; len++){
            for(int j = i-len; j<i; j++){
                dp[i][len] += dp[j][min(j, len)];
                dp[i][len] %= MOD;
            }
        }
    }
    for(int i=n; i>=1; i--){
        dp[n][i] -= dp[n][i-1];
        dp[n][i] %= MOD;
        if(dp[n][i]<0) dp[n][i] += MOD;
    }

    ll ans = 0;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            if(i*j<k){
                ans += dp[n][i] * dp[n][j];
                ans %= MOD;
            }
        }
    }
    ans *= 2;
    ans %= MOD;

    cout << ans;
}