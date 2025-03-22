#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll gcd(ll a, ll b) {
    if(a==0) return b;
    return gcd(b%a, a);
}

ll works(ll a, ll b, ll c, ll d) {

    if(gcd(a, b) != gcd(c, d)) return -1;

    ll ans = 0;
    while(c!=a || d!=b) {
        if(c<a || d<b) return -1;
        if(c>d) {
            if(d<b || (c-a)/d==0) return -1;
            ans += (c-a)/d;
            c -= ((c-a)/d)*d;
        } else if (c<d){
            if(c<a || (d-b)/c==0) return -1;
            ans += (d-b)/c;
            d -= ((d-b)/c)*c;
        } else {
            if(a==c && b==d) return ans;
            else return -1;
        }
    }
    return ans;
}

int main(){
    cin.tie(0) -> sync_with_stdio(0);
    ll t; cin >> t;
    while(t--) {
        ll a, b, c, d;
        cin >> a >> b >> c >> d;
        // cout << gcd(a, b) << " " << gcd(c, d) << endl;
        cout << works(a, b, c, d) << "\n";
    }
}