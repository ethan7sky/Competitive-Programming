#include <bits/stdc++.h>
using namespace std;

using ll = long long;

const int MAX_N = 100;
ll T, N, tC, tM;
array<ll, 3> a[MAX_N];

bool works(ll m) {

    // c >= a(tC-x) + b(tM-y)

    if(m >= tC-1+tM-1) return 1;

    ll cMin = max(0LL, m-(tM-1)), cMax = min(m, tC-1);
    
    for(int i=0; i<N; i++){
        
        // give as much upgrades to tC

        ll LHS = a[i][2]-a[i][0]*tC-a[i][1]*(tM-m);
        ll chng = a[i][1]-a[i][0];
        if(chng>0) {
            cMax = min(cMax, LHS/chng);
        } else if(chng < 0) {
            if(LHS>=0) continue;
            chng = -chng;
            LHS = -LHS;
            cMin = max(cMin, (ll)(LHS+chng-1)/chng);
        } else{
            if(a[i][2] < a[i][0] * (tC+tM-m)) {
                return 0;
            }
        }

        // cout << cMin << " " << cMax << endl;
    }
    return cMin <= cMax;
}

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while(T--) {
        cin >> N >> tC >> tM;
        
        for(int i=0; i<N; i++){
            cin >> a[i][0] >> a[i][1] >> a[i][2];
        }

        ll low=0, high=tC+tM-2, mid;
        ll ans = -1;

        while(low<=high) {
            mid = (low+high)/2;
            if(works(mid)) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        cout << ans << endl;

        // cout << works(5) << endl;
    }
}