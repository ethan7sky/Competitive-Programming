#include <bits/stdc++.h>
using namespace std;
#define int long long

int32_t main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n, m; cin >> n >> m;
    vector<int> a;
    for(int i=1; i<=n; i++) {
        int x; cin >> x;
        if(i*m-x >= 0){
            a.push_back(i*m-x);
        }
    }
    
    vector<int> dp;
    for (int i : a) {
        int pos = upper_bound(dp.begin(), dp.end(), i) - dp.begin();
        if (pos == dp.size()) {
            dp.push_back(i);
        } else {
            dp[pos] = i;
        }
    }
    
    cout << (n-dp.size());
}