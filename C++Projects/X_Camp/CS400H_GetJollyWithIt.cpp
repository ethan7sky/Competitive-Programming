#include <bits/stdc++.h>
using namespace std;

int main() {
    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t; cin >> t;
    while(t-->0) {
        int n; cin >> n;

        pair<int, int> a[n];
        multiset<int> ms;
        for(int i=0; i<n; i++){
            cin >> a[i].first >> a[i].second;
            ms.insert(a[i].second);
        }
        sort(a, a+n);

        int ans = INT_MAX;
        int m1=0;

        set<int> visited;
        for(int i=0; i<n-1; i++){

            m1 = a[i].first;
            
            ms.erase(a[i].second);
            int m2 = *ms.rbegin();

            ans = min(ans, abs(m1-m2));

            if(visited.find(a[i].first)!=visited.end()){
                ans=0;
                break;
            }
            int greater = *visited.upper_bound(a[i].first);
            int less = *visited.lower_bound(a[i].first);

            cout << less << " " << greater << endl;
            visited.insert(a[i].first);
        }
        cout << ans << endl;
    }
}