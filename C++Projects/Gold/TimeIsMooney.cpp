#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1000;
const int MAX_M = 2000;
const int MAX_T = 1000;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    freopen("time.in", "r", stdin);
    freopen("time.out", "w", stdout);

    int n, m, c;
    cin >> n >> m >> c;

    vector<int> a(n+1);
    for(int i=1; i<=n; i++) {
        cin >> a[i];
    }
    vector<vector<int>> p(n+1, vector<int>());
    for(int i=0; i<m; i++) {
        int x, y; cin >> x >> y;
        p[y].push_back(x);
    }
    
    vector<vector<int>> dp(MAX_T, vector<int>(n+1, -1e9));
    dp[0][1] = 0;
    for(int t=1; t<MAX_T; t++) {
        for(int i=1; i<=n; i++) {
            for(int j: p[i]) {
                dp[t][i] = max(dp[t][i], dp[t-1][j] + a[i]);
            }
        }
    }
    int ans = 0;
    for(int t=1; t<MAX_T; t++){
        ans = max(ans, dp[t][1]-c*t*t);
    }
    cout << ans << "\n";
}