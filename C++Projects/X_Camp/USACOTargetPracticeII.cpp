#include <bits/stdc++.h>
using namespace std;

using ll = long long;

ll T, N, X1;
vector<tuple<ll, ll, ll>> coord;
multiset<ll> posM, negM;
ll posCnt, negCnt;
vector<pair<ll, ll>> posP, negP;
vector<ll> close;

void reset() {
    
    coord.clear();
    coord.resize(N);
    posP.clear();
    negP.clear();
    posM.clear();
    negM.clear();
    close.clear();

}

bool checkMinY(ll minY) { //positive slopes

    multiset<ll> posM2 = posM;

    // cout << posP.size() << " " << posM2.size() << endl;

    for(pair point: posP) {
        ll x = point.first, y = point.second;
        if(y<=minY) return false;
        
        long double maxMPossible = (long double)(y-minY)/(x);
        ll floorMaxMPossible = floor(maxMPossible);

        auto it = posM2.upper_bound(floorMaxMPossible);
        if(it==posM2.begin()) return false;
        else {
            it = prev(it);
            posM2.erase(it);
        }
    }
    return true;
}
bool checkMaxY(ll maxY) { //negative slopes
    
    multiset<ll> negM2 = negM;

    for(pair point: negP) {
        ll x = point.first, y = point.second;
        if(y>=maxY) return false;
        
        long double minMPossible = (long double)(y-maxY)/(x);
        ll floorMinMPossible = ceil(minMPossible);

        auto it = negM2.lower_bound(floorMinMPossible);
        
        if(it==negM2.end()) return false;
        else {
            negM2.erase(it);
        }
    }
    return true;
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> T;
    while(T--) {
        cin >> N >> X1;
        
        reset();

        for(auto &[y1, x2, y2]: coord) {
            cin >> y1 >> y2 >> x2;
        } for(int i=0; i<4*N; i++){
            ll m; cin >> m;
            if(m>0) posM.insert(m);
            else negM.insert(m);
        }

        if(posM.size()<N || negM.size()<N){
            cout << "-1\n";
            continue;
        }

        for(auto &[y1, x2, y2]: coord) {
            posP.push_back({x2, y1});
            negP.push_back({x2, y2});
            close.push_back(y1);
            close.push_back(y2);
        }

        posCnt = posM.size() - posP.size();
        negCnt = negM.size() - negP.size();

        sort(close.begin(), close.end());

        for(ll yi: close) {
            if(negCnt>0) {
                negP.push_back({X1, yi});
                negCnt--;
            } else if(posCnt>0) {
                posP.push_back({X1, yi});
                posCnt--;
            }
        }

        ll low = (ll)-1e18, high = (ll)1e18, mid;
        ll ansMinY = -LLONG_MAX;
        while(low<=high) {
            mid = (low+high)/2;
            // cout << mid << endl;
            if(checkMinY(mid)) {
                ansMinY = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        low = (ll)-1e18, high = (ll)1e18, mid;
        ll ansMaxY = LLONG_MAX;
        while(low<=high) {
            mid = (low+high)/2;
            if(checkMaxY(mid)) {
                ansMaxY = mid;
                high = mid-1;
            } else{
                low = mid+1;
            }
        }

        // cout << checkMaxY(8) << endl;
        cout << ansMaxY - ansMinY << "\n";
        

        

        //if ans < 0 then throw an error
        // int x = get<0>(coord[5]);

    }

}