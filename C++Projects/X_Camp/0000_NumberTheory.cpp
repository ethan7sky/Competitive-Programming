#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MOD = 1e9+7;

ll exp(ll x, ll n, ll m) {
	assert(n >= 0);
	x %= m;  // note: m * m must be less than 2^63 to avoid ll overflow
	ll res = 1;
	while (n > 0) {
		if (n % 2 == 1) { res = res * x % m; }
		x = x * x % m;
		n /= 2;
	}
	return res;
}
 
const int MAX_N = 1e4;
ll inv[MAX_N+1];

void euclid_inv() {
    inv[1] = 1;
    for(int i=2; i<=MAX_N; i++){
        inv[i] = MOD - (ll)(MOD/i)*inv[MOD%i]%MOD;
    }
}

void exp_inv() {
    inv[1] = 1;
    for(int i=2; i<=MAX_N; i++){
        inv[i] = exp(i, MOD-2, MOD);
    }
}

int main() {

    return 0;
}