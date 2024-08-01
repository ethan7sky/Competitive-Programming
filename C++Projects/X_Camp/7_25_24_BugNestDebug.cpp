#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

ll n;

ll sim(ll x){
    ll nd = n, tot = 0;
    while(nd){
        if(nd < x) tot += nd, nd = 0;
        else nd -= x, tot += x;
        nd -= nd/10ll;
    }
    return tot;
}

int main(){
    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    ll l = 0, r = n;
    while(l+1ll < r){
        ll m = (l+r+1)/2ll;
        if(sim(m)*2ll >= n) r = m;
        else l = m;
    }
    cout << r << '\n';
}