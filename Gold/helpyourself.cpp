#include<bits/stdc++.h>
using namespace std;

using ll = long long;

const int MOD = 1e9+7;

int main() {
    freopen("help.in", "r", stdin);
    freopen("help.out", "w", stdout);
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n; cin >> n;

    vector<int> events(2*n+1, 0);
    for(int i=0; i<n; i++){
        int l, r; cin >> l >> r;
        events[l]++;
        events[r]--;
    }

    vector<int> pow2(n);
    pow2[0] = 1;
    for(int i=1; i<n; i++){
        pow2[i] = (pow2[i-1] * 2) % MOD;
    }

    ll ans = 0;
    ll cnt = 0;
    for(int i=0; i<=2*n+1; i++){
        cnt += events[i];
        if(events[i]==1) {
            ans += pow2[n-cnt];
            ans %= MOD;
        }
    }

    cout << ans << "\n";
}