#include <bits/stdc++.h>
using namespace std;

const int MAX_A = 5*1e5;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, c; cin >> n >> c;
    vector<int> a(n);
    int c_cnt = 0;
    for(int i=0; i<n; i++) {
        cin >> a[i];
        c_cnt += (a[i]==c);
    }
    vector<int> dp(MAX_A+1);
    int c_seen = 0;
    int ans = c_cnt;
    for(int i=0; i<n; i++){
        if(a[i]==c) {
            c_seen++;
        } else {
            dp[a[i]] = max(c_seen+1, dp[a[i]]+1);
            ans = max(ans, dp[a[i]] + c_cnt-c_seen);
        }
        // cout << c_cnt << " " << c_seen << " " << ans << "\n";

    }
    cout << ans << "\n";
}