#include <bits/stdc++.h>
using namespace std;

using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int s, n;
    cin >> s >> n;

    map<int, vector<pair<int, int>>> items;
    for(int i=0; i<n; i++) {
        int v, w, k; cin >> v >> w >> k;
        if(w<=s && k>0) {
            items[w].push_back({v, k});
        }
    }
    
    vector<vector<ll>> dp(items.size()+1, vector<ll>(s+1, INT_MIN));
    dp[0][0] = 0;
    int w_idx = 1;
    for(auto& [w, vec] : items) {
        sort(vec.begin(), vec.end(), greater<pair<int, int>>());
        for(int i=0; i<=s; i++) {
            dp[w_idx][i] = dp[w_idx-1][i];
            int t_idx = 0;
            int t_used = 0;
            int tot_used = 0;
            ll cost = 0;
            while((tot_used+1)*w <= i && t_idx < vec.size()) {
                tot_used++;
                cost += vec[t_idx].first;
                t_used++;

                if(dp[w_idx-1][i-tot_used*w] != INT_MIN) {
                    dp[w_idx][i] = max(dp[w_idx][i], dp[w_idx-1][i-tot_used*w] + cost);
                }

                if(t_used==vec[t_idx].second){
                    t_used=0;
                    t_idx++;
                }
            }
        }
        w_idx++;
    }

    ll ans=0;
    for(int i=0; i<=s; i++) {
        ans = max(ans, dp[items.size()][i]);
    }
    cout << ans << '\n';
}