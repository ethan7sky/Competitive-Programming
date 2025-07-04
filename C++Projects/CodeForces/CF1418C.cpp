#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 2*1e5;
int dp[MAX_N+1][2][2]; //[player][amt of moves]

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int t; cin >> t;
    while(t--) {
        int n; cin >> n;
        for(int i=0; i<n+1; i++) {
            dp[i][0][0] = dp[i][0][1] = dp[i][1][0] = dp[i][1][1] = MAX_N;
        }
        cin >> dp[0][0][0];
        dp[0][0][1] = MAX_N;
        dp[0][1][0] = MAX_N;
        dp[0][1][1] = MAX_N;
        for(int i=1; i<n; i++) {
            int x; cin >> x;
            dp[i][0][0] = min(dp[i][0][0], min(dp[i-1][1][0], dp[i-1][1][1])+x);
            dp[i][1][0] = min(dp[i][1][0], min(dp[i-1][0][0], dp[i-1][0][1]));
            dp[i][0][1] = min(dp[i][0][1], dp[i-1][0][0]+x);
            dp[i][1][1] = min(dp[i][1][1], dp[i-1][1][0]);
        }
        cout << min(min(dp[n-1][0][0], dp[n-1][0][1]), min(dp[n-1][1][0], dp[n-1][1][1])) << "\n";
    }
}