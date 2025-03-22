#include <bits/stdc++.h>
using namespace std;
using ll = long long;
#define ff first;
#define ss second;

const ll MOD = 1e9+7;
const ll INV2MOD = 500000004;

int main(){
    ll n; cin >> n;

    // vector<pair<ll, ll>> divisors;
    // divisors.push_back({1, 1});
    // for(int i=2; i*i<=n; i++){
    //     if(n%i==0){
    //         ll cnt=0;
    //         while(n%i==0){
    //             cnt++;
    //             n/=i;
    //         }
    //         divisors.push_back({i, cnt});
    //     }
    // }

    ll ans=0;
    ll curr=1;
    while(curr<=n){
        ll freq = n/curr;
        ll ceil = n/freq;

        ll add = ((((((freq%MOD)*((ceil-curr+1)%MOD))%MOD)*((curr+ceil)%MOD))%MOD)*INV2MOD)%MOD;
        ans = (ans+add)%MOD;

        curr = ceil+1;
    }
    cout << ans << endl;
}