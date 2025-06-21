#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int t; cin >> t;
    while(t--) {
        int n; cin >> n;
        vector<int> a(n);
        vector<map<int, int>> cnt(n);
        for(int i = 0; i < n; i++) {
            cin >> a[i];
            cnt[i][a[i]] = 1;
        }
        for(int i=1; i<n; i++){
            for(auto [g, len] : cnt[i-1]) {
                int newgcd = gcd(g, a[i]);
                cnt[i][newgcd] = max(cnt[i][newgcd], len + 1);
            }
        }
        vector<int> ans(n+1);
        for(int i=0; i<n; i++) {
            for(auto [g, len] : cnt[i]) {
                ans[len] = max(ans[len], g);
            }
        }
        for(int i=1; i<=n; i++) {
            cout << ans[i] << (i == n ? "\n" : " ");
        }
    }

    return 0;
}