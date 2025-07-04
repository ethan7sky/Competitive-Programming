#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1e5;
const int MAX_K = 20;
int dp[MAX_N+1][MAX_K+2][3];

int game(char a, char b) {
    if(a==b) return 0;
    if((a=='H' && b=='P') || (a=='P' && b=='S') || (a=='S' && b=='H')) {
        return 0; //lose 
    }return 1;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    freopen("hps.in", "r", stdin);
    freopen("hps.out", "w", stdout);

    int n, k; cin >> n >> k;
    for(int i=1; i<=n; i++){
        char c; cin >> c;
        for(int j=0; j<=k; j++){
            dp[i][j][0] = max(dp[i][j][0], dp[i-1][j][0] + game('H', c));
            dp[i][j][1] = max(dp[i][j][1], dp[i-1][j][1] + game('P', c));
            dp[i][j][2] = max(dp[i][j][2], dp[i-1][j][2] + game('S', c));
            dp[i][j+1][0] = max(dp[i-1][j][1], dp[i-1][j][2]) + game('H', c);
            dp[i][j+1][1] = max(dp[i-1][j][2], dp[i-1][j][0]) + game('P', c);
            dp[i][j+1][2] = max(dp[i-1][j][0], dp[i-1][j][1]) + game('S', c);
        }
    }

    int ans = 0;
    for(int j=0; j<=k; j++) {
        ans = max({ans, dp[n][j][0], dp[n][j][1], dp[n][j][2]});
    }
    cout << ans << "\n";

}
