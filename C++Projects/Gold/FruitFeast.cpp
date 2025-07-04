#include <bits/stdc++.h>
using namespace std;

int main() {

    freopen("feast.in", "r", stdin);
    freopen("feast.out", "w", stdout);

    int t, a, b; cin >> t >> a >> b;
    vector<int> dp(t+1, 0);
    dp[0] = 1;
    for(int i=1; i<=t; i++){
        if(i>=a) dp[i] |= dp[i-a];
        if(i>=b) dp[i] |= dp[i-b];
    }
    vector<int> div2(1, 0);
    for(int i=1; i<=t; i++){
        if(dp[i]) div2.push_back(i/2);
    }
    sort(div2.begin(), div2.end());

    int ans = 0;
    for(int i=0; i<=t; i++) {
        if(dp[i]) {
            int idx = upper_bound(div2.begin(), div2.end(), t-i)-div2.begin();
            idx--; // find the largest element less than or equal to t-i
            if(idx<0) idx=0;
            if(idx<div2.size()) {
                // cout << "i: " << i << ", div2[idx]: " << div2[idx] << '\n';
                ans = max(ans, i + div2[idx]);
            }
        }
    }
    cout << ans << '\n';
}