#include <bits/stdc++.h>
using namespace std;

using ll = long long;

const int FLAVORS = 5;

int main(){ 
    freopen("cowpatibility.in", "r", stdin);
    freopen("cowpatibility.out", "w", stdout);
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

    vector<map<array<int, FLAVORS>, ll>> common_cnt(FLAVORS);

    for(int i=0; i<n; i++){
        common_cnt[4][cows[i]]++;
        for(int a=0; a<FLAVORS; a++){
            common_cnt[0][{cows[i][a]}]++;
            for(int b=a+1; b<FLAVORS; b++){
                common_cnt[1][{cows[i][a], cows[i][b]}]++;
                for(int c=b+1; c<FLAVORS; c++){
                    common_cnt[2][{cows[i][a], cows[i][b], cows[i][c]}]++;
                    for(int d=c+1; d<FLAVORS; d++){
                        common_cnt[3][{cows[i][a], cows[i][b], cows[i][c], cows[i][d]}]++;
                    }
                }
            }   
        }
    }

    ll comp_cnt = 0;
    for(int i=0; i<FLAVORS; i++){
        for(auto& [flavor_set, cnt] : common_cnt[i]) {
            if(i%2==0) {
                comp_cnt += cnt*(cnt-1)/2;
            } else {
                comp_cnt -= cnt*(cnt-1)/2;
            }
        }
    }
    cout << n*(n-1)/2 - comp_cnt << '\n';
}