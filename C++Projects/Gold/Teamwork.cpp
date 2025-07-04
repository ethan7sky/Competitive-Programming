#include <bits/stdc++.h>
using namespace std;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    freopen("teamwork.in", "r", stdin);
    freopen("teamwork.out", "w", stdout);

    int n, k;
    cin >> n >> k;

    vector<int> a(n);
    for(int i=0; i<n; i++) cin >> a[i];
    vector<int> dp(n, 0);
    dp[0] = a[0];
    for(int i=1; i<n; i++){
        int mx = 0;
        for(int j=i; j>=max(0, i-k+1); j--) {
            mx = max(mx, a[j]);
            if(j>0) dp[i] = max(dp[i], dp[j-1] + mx*(i-j+1));
            else dp[i] = max(dp[i], mx*(i-j+1));
        }
    }
    cout << dp[n-1];
}