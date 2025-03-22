#include <bits/stdc++.h>

using namespace std;
using ll = long long;

const ll INF = 1e9;
int n;
ll dp[1001][1001][2];//dp[l][r][0/1] (end pos, 0 is left)]
vector<int> a;

int main() {

    freopen("cowrun.in", "r", stdin);
    freopen("cowrun.out", "w", stdout);

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    for(int i=0; i<n; i++) {
        int x; cin >> x;
        a.push_back(x);
    }
    a.push_back(0);
    sort(a.begin(), a.end());

    int idx = find(a.begin(), a.end(), 0) - a.begin();

    for(int i=0; i<1001; i++){
        for(int j=0; j<1001; j++){
            dp[i][j][0] = INF;
            dp[i][j][1] = INF;
        }
    }

    dp[idx][idx][0] = 0;
    dp[idx][idx][1] = 0;

    for(int len = 1; len <= n; len++){
        int s = max(idx-len, 0);
        for(; s<=idx&&s+len<=n; s++){
            int e = s+len;

            int rCows = (s+(n-e))+1;
            ll val1 = dp[s+1][e][0]+abs(a[s]-a[s+1])*rCows;
            ll val2 = dp[s+1][e][1]+abs(a[s]-a[e])*rCows;

            ll val3 = dp[s][e-1][0]+abs(a[e]-a[s])*rCows;
            ll val4 = dp[s][e-1][1]+abs(a[e]-a[e-1])*rCows;

            dp[s][e][0] = min(val1, val2);

            dp[s][e][1] = min(val3, val4);
        }
    }

    cout << min(dp[0][n][0], dp[0][n][1]) << endl;

}