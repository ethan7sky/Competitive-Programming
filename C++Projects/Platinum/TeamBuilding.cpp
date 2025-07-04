#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MOD = 1e9+9;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    freopen("team.in", "r", stdin);
    freopen("team.out", "w", stdout);

    int n, m, k;
    cin >> n >> m >> k;

    vector<ll> fj(n), fp(m);

    for(int i=0; i<n; i++) {
        cin >> fj[i];
    }for (int i=0; i<m; i++) {
        cin >> fp[i];
    }
    sort(fj.rbegin(), fj.rend());
    sort(fp.rbegin(), fp.rend());

    vector<vector<vector<ll>>> dp(n+1, vector<vector<ll>>(m+1, vector<ll>(k+1)));

    for(int i=0; i<=n; i++){
        for(int j=0; j<=m; j++) dp[i][j][0] = 1;
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            for(int s=1; s<=k; s++){

                dp[i+1][j+1][s] += dp[i+1][j][s];
                dp[i+1][j+1][s] += dp[i][j+1][s];
                dp[i+1][j+1][s] -= dp[i][j][s];

                if(fj[i]>fp[j]) {
                    dp[i+1][j+1][s] += dp[i][j][s-1];
                }

                dp[i+1][j+1][s] += MOD;
                dp[i+1][j+1][s] %= MOD;
            }
        }
    }

    cout << dp[n][m][k] << "\n";
}