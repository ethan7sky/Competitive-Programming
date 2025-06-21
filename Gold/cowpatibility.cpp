#include <bits/stdc++.h>
using namespace std;

using ll = long long;

const int FLAVORS = 5;

int main(){ 
    // freopen("cowpatibility.in", "r", stdin);
    // freopen("cowpatibility.out", "w", stdout);
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    ll n; cin >> n;

    vector<array<int, FLAVORS>> cows(n);

    for(int i=0; i<n; i++){
        for(int j=0; j<FLAVORS; j++) {
            int x; cin >> x;
            cows[i][j] = x;
        }
        sort(cows[i].begin(), cows[i].end());
    }

    vector<map<array<int, FLAVORS>, int>> common_cnt(FLAVORS);



    ll comp_cnt = 0;
    for(int i=0; i<FLAVORS; i++){
        
    }
}