#include <bits/stdc++.h>
using namespace std;

using ll = long long;

vector<pair<ll, ll>> a, b, x; //<<x, y>, opCnt>
multiset<pair<ll, ll>> aSet, bSet;
ll ans = 0;
ll tx, ty;

int main() {
    cin.tie(0) -> sync_with_stdio(0);
    int n; cin >> n;
    cin >> tx >> ty;
    for(int i=0; i<n; i++){
        ll o, p; cin >> o >> p;
        x.push_back({o, p});
    }
    a.push_back({0, 0});
    b.push_back({0, 0});
    for(int i=0; i<n/2; i++){
        int aLen = a.size();
        for(int j=0; j<aLen; j++){
            a.push_back({a[j].first+x[i].first, a[j].second+x[i].second});
        }
    }for(int i=n/2; i<n; i++){
        int bLen = b.size();
        for(int j=0; j<bLen; j++){
            b.push_back({b[j].first+x[i].first, b[j].second+x[i].second});
        }
    }
    for(pair i: a) aSet.insert(i);
    for(pair i: b) bSet.insert(i);

    for(pair i: aSet) {
        ans += aSet.count(i) * bSet.count({tx-i.first,ty-i.second});
    }
    cout << ans << endl;
}