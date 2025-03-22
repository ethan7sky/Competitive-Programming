#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const ll MOD = 1e9+7;

int main() {
    int n; cin >> n;
    ll ans=1;
    for(int i=2*n; i>n; i--){
        ans *= i;
        ans /= 2*n-i+1;
    }
    ans /= n+1;
    ans %= MOD;
    cout << ans << endl;
}