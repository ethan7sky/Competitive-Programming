#include <bits/stdc++.h>
using namespace std;

using ll = long long;

ll ans = 0;

int main(){
    cin.tie(0) -> sync_with_stdio(0);
    int n, k; cin >> n >> k;

    set<int> ranges;
    
    for(int i=0; i<n; i++){
        int x; cin >> x;
        x+=11; x/=12;
        ranges.insert(x);
    }

    vector<int> years;
    for(int i: ranges) years.emplace_back(i);
    sort(years.begin(), years.end());
    ans = years.size();
    int prev = 0;
    vector<int> spaces;
    // cout << ans << endl;
    for(int i: years) {
        // cout << i << endl;
        spaces.emplace_back(i-prev-1);
        // cout << i-prev << endl;
        prev = i;
    }

    // for(int i: spaces) {
    //     cout << i << endl;
    // }

    int needToAdd = (int)ans+1-k;
    sort(spaces.begin(), spaces.end());
    for(int i=0; i<spaces.size()&&i<needToAdd; i++){
        ans += spaces[i];
    }
    ans *= 12;
    cout << ans << endl;
}