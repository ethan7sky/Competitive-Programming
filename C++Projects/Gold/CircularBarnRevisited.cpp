#include <bits/stdc++.h>
using namespace std;

using ll = long long;

const int MAX_N = 100;
const int MAX_K = 7;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    freopen("cbarn2.in", "r", stdin);
    freopen("cbarn2.out", "w", stdout);

    int n, k; cin >> n >> k;

    vector<ll> a(n);
    for(int i=0; i<n; i++) cin >> a[i];

    ll ans = 1e18;

    for(int i=0; i<n; i++){
        //open i no matter what
        vector<vector<ll>> dp(MAX_N+MAX_K+2, vector<ll>(MAX_K+2, 1e18));
        dp[0][0] = 0;
        for(int j=0; j<n; j++) {
            for(int l=0; l<=k; l++){
                ll cost = 0;
                for(int m=j+1; m<=n; m++) {
                    dp[m][l+1] = min(dp[m][l+1], dp[j][l]+cost);
                    cost += a[(i+m)%n]*(m-j);
                }
            }
        }
        for(int j=0; j<=k; j++) {
            ans = min(ans, dp[n][j]);
        }
    }
    cout << ans << "\n";

}