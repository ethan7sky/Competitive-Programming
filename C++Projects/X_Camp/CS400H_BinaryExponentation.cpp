#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const ll MOD = 1e9+7;
ll a, b;

int main(){
    cin >> a >> b;

    bitset<64> bs(b);
    string s = bs.to_string();

    ll ans = 1;
    ll curr = a;
    for(int i=63; i>=0; i--){
        if(s[i]=='1'){
            ans *= curr;
            ans %= MOD;
        }
        curr *= curr;
        curr %= MOD;
    }

    cout << ans << endl;    
}