#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; cin >> n;

    vector<ll> idx[n+1];

    for(int i=0; i<n; i++){
        ll x; cin >> x;
        idx[x].push_back(i);
    }

    ll sum = 0;

    for(int i=1; i<=n; i++){
        if(idx[i].size()<2) continue;

        for(int j=0; j<idx[i].size()-1; j++){
            sum += (j+1)*(idx[i][j+1]-idx[i][j]-1)*(idx[i].size()-(j+1));
        }
    }

    cout << sum << endl;

}