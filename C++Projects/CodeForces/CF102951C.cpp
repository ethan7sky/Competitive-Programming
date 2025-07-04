#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n; cin >> n;
    
    vector<int> idx(n);
    for(int i=0; i<n; i++) {
        int x; cin >> x;
        idx[x] = i;
    }
    vector<int> a(n);
    for(int i=0; i<n; i++){
        int x; cin >> x;
        a[i] = idx[x];
    }

    int lcs = 0;
    vector<int> dp;
    for(int i=0; i<n; i++){
        int idx = lower_bound(dp.begin(), dp.end(), a[i]) - dp.begin();
        if(idx>=dp.size()) {
            dp.push_back(a[i]);
        } else{
            dp[idx] = a[i];
        }
    }
    cout << dp.size();
}