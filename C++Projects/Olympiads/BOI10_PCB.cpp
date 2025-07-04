#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n; cin >> n;

    vector<pair<int, int>> a(n);
    set<int> s;
    int lis = 0;
    for(int i=0; i<n; i++) cin >> a[i].first >> a[i].second;
    sort(a.begin(), a.end(), greater<pair<int, int>>());
    for(int i=0; i<n; i++){
        if(s.upper_bound(a[i].second)==s.end()) lis++;
        else s.erase(s.upper_bound(a[i].second));
        s.insert(a[i].second);
    }
    cout << lis;
}