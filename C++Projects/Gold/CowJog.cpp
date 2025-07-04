#include <bits/stdc++.h>
using namespace std;

using ll = long long;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    freopen("cowjog.in","r",stdin);
    freopen("cowjog.out","w",stdout);

    int n, t; cin >> n >> t;
    vector<ll> a(n);
    for(int i=0; i<n; i++){
        ll p, s; cin >> p >> s;
        a.push_back(p+s*t);
    }
    reverse(a.begin(), a.end());

    vector<ll> dp;
    for(int i=0; i<n; i++){
        int idx = upper_bound(dp.begin(), dp.end(), a[i]) - dp.begin();
        if(idx==dp.size()) dp.push_back(a[i]);
        else dp[idx] = a[i];
    }
    cout << dp.size();
}