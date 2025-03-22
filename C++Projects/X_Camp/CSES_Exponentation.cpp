#include<bits/stdc++.h>
using namespace std;
using ll = long long;
const ll MOD = 1e9+7;

ll exp(ll x, ll n, ll m) {
    ll ans = 1;
    ll currPow = x;
    while(n>=1){
        if(n%2==1) ans = ans*currPow%m;
        currPow = currPow*currPow%m;
        n/=2;
    }
    return ans;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int t; cin >> t;
    while(t--){
        int x, n; cin >> x >> n;
        cout << exp(x, n, MOD) << endl;
    }
}