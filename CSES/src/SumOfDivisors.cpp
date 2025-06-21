#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const ll mod = (ll)1e9+7;
const ll MOD_INV_TWO = 500000004; // 2^(-1) mod 1e9+7


ll calc_sum(ll at, ll next) {
    return ((((at+next)%mod)*((next-at+1)%mod))%mod)*MOD_INV_TWO % mod;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);  
    ll n; cin >> n;
    //7+8+9+10 = 34 * 2 = 68 
    // cout << calc_sum(7, 10) << endl;

    ll sum = 0;
    ll at = 1;
    while(at <= n) {
        ll cnt = n / at;
        ll next = n/cnt;
        sum += cnt*calc_sum(at, next) % mod;
        sum %= mod;
        // cout << at << " " << cnt <<  " " << next << " " << sum << endl;
        at = next+1;
    }

    cout << sum;

}