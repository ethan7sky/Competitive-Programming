#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MAX_N = 2*1e6;

ll n, m;
vector<ll> a;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    for(ll i=1; i<=n; i++){
        ll x; cin >> x;
        if(i*m >= x){
            a.push_back(i*m-x);
        }
    }

    vector<int> dp;
    
    for(int i: a){
        int pos = upper_bound(dp.begin(), dp.end(), i) - dp.begin();
        if(pos==dp.size()){
            dp.push_back(i);
        }
        else{
            dp[pos] = i;
        }
        
    }

    cout << n-dp.size() << endl;
}