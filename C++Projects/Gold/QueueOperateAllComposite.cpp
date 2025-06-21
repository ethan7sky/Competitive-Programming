#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const ll MOD = 998244353;

ll mod_inverse(ll a);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<pair<ll, ll>> funcs;
    int currToDel = 0;

    ll inva = 1, invb = 0;
    ll a = 1, b = 0;

    int q; cin >> q;
    while(q--) {
        int t; cin >> t;
        if(t==0) {
            //add
            ll _a, _b;
            cin >> _a >> _b;
            funcs.emplace_back(_a, _b);
            a *= _a;
            a %= MOD;
            b *= _a;
            b %= MOD;
            b += _b;
            b %= MOD;
        }else if(t==1) {
            //delete
            //y=ax+b
            //(y-b)*mod_inverse(a) = x
            if(currToDel < funcs.size()) {
                auto [_a, _b] = funcs[currToDel++];
                ll inv = mod_inverse(_a);

                _b *= -1;
                _b *= inv;
                _b %= MOD; while(_b<0) _b+=MOD;


                _a = inv;
                _a *= inva; _a %= MOD; while(_a<0) _a+=MOD;
                _b *= inva; _b %= MOD; while (_b<0) _b+=MOD;

                _b += invb; _b %= MOD; while (_b<0) _b+=MOD;

                inva=_a;
                invb=_b;

                // cout << inva << " " << invb << "\n";
            }
        }else{
            //eval
            ll x; cin >> x;
            ll invAns = (inva*x+invb)%MOD;
            ll ans = (a*invAns+b)%MOD;
            while(ans<0) ans+=MOD;
            cout << ans << "\n";
        }  
    }
}

ll mod_inverse(ll a) {
    ll m = MOD;
    ll x = 1, y = 0;

    ll q, t;
    while(a>1) {
        q = a/m;
        t = m;
        m = a%m;
        a=t;
        t=y;
        y=x-q*y;
        x=t;
    }
    if(x<0) x+= MOD;
    return x;
}