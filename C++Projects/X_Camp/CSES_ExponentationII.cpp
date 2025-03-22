#include<bits/stdc++.h>
using namespace std;
using ll = long long;
const ll MOD = 1e9+7;

ll exp(ll x, ll n, ll m) {
    if(x==0 && n==0) return 1;
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
        int a, b, c; cin >> a >> b >> c;
        
        cout << exp(a, exp(b, c, MOD-1), MOD) << endl;
    }
}