#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll dist(pair<int, int> a, pair<int, int> b) {
    return (ll)(a.first-b.first)*(a.first - b.first) + (ll)(a.second-b.second)*(a.second - b.second);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    freopen("radio.in", "r", stdin);
    freopen("radio.out", "w", stdout);

    int n, m; cin >> n >> m;
    pair<int, int> f, b;
    cin >> f.first >> f.second;
    cin >> b.first >> b.second;

    vector<pair<int, int>> fa(n+1);
    vector<pair<int, int>> ba(m+1);

    map<int, pair<int, int>> dir = {
        {'E', {1, 0}},
        {'N', {0, 1}}, 
        {'W', {-1, 0}},
        {'S', {0, -1}} 
    };

    fa[0] = f; ba[0] = b;
    string s; cin >> s;
    for(int i=1; i<=n; i++){
        fa[i] = {fa[i-1].first + dir[s[i-1]].first, fa[i-1].second + dir[s[i-1]].second};
    }
    cin >> s;
    for(int i=1; i<=m; i++){
        ba[i] = {ba[i-1].first + dir[s[i-1]].first, ba[i-1].second + dir[s[i-1]].second};
    }

    vector<vector<ll>> dp(n+2, vector<ll>(m+2, INT_MAX));
    for(int i=0; i<=n; i++ ){
        for(int j=0; j<=m; j++){
            dp[i+1][j+1] = dist(fa[i], ba[j]);
        }
    }
    dp[1][1] = 0;
    for(int i=1; i<=n+1; i++){
        for(int j=1; j<=m+1; j++){
            if(i==1 && j==1) continue;
            dp[i][j] += min({dp[i-1][j], dp[i][j-1], dp[i-1][j-1]});
        }
    }
    cout << dp[n+1][m+1] << '\n';

}