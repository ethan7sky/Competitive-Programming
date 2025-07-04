#include <bits/stdc++.h>
using namespace std;

using ll = long long;

const int MOD = 998244353;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int q, k;
    cin >> q >> k;

    vector<ll> dp(k+1, 0);
    dp[0] = 1;

    for(int i=0; i<q; i++){
        char c; cin >> c;
        int x; cin >> x;
        if(c=='+') {
            for(int j=k; j>=x; j--) {
                dp[j] += dp[j-x];
                dp[j] += MOD;
                dp[j] %= MOD;
            }
        } else {
            for(int j=x; j<=k; j++) {
                dp[j] -= dp[j-x];
                dp[j] += MOD;
                dp[j] %= MOD;
            }
        }
        cout << dp[k] << "\n";
    }
}