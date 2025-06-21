#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const ll MOD = 1e9 + 7;

ll mod_inverse(ll a) {
    ll m = MOD, x = 0, y = 1;
    if (m == 1) return 0;
    while (a > 1) {
        ll q = a / m;
        ll t = m;
        m = a % m, a = t;
        t = x;
        x = y - q * x;
        y = t;
    }
    if (y < 0) y += MOD;
    return y;
}

ll binary_exponentation(ll base, ll exp) {
    //MOD*MOD must be less than 2^63 to prevent ll overflow
    base %= MOD;
    if(base < 0) base += MOD; // Ensure base is non-negative
    ll result = 1;
    while(exp > 0) {
        if(exp % 2 == 1) {
            result = (result * base) % MOD;
        }
        base = (base * base) % MOD;
        exp /= 2;
    }
    return result;
}

int main() {

    // freopen("sumdiv.in", "r", stdin);
    // freopen("sumdiv.out", "w", stdout);

    ll a, b;
    cin >> a >> b;
    ll ans = 1;

    map<int, int> factors;

    for (ll i = 2; i*i<=a; i++) {
        if(a%i==0) {
            while(a%i==0) {
                a /= i;
                factors[i]++;
            }
        }
    }
    if(a > 1) {
        factors[a]++; //1 + 2 + 3 + 4 + 9 + 12 + 18
    }

    for(auto [factor, cnt] : factors) {
        ans *= (binary_exponentation(factor, cnt*b+1) - 1);
        ans %= MOD;
        ans *= mod_inverse(factor - 1);
        ans %= MOD;
        while(ans < 0) ans += MOD;
    }
    cout << ans;

}