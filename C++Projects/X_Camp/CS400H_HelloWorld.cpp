#include <bits/stdc++.h>
using namespace std;

int main() {

    int n; cin >> n;
    pair<int, int> a[n];
    for(int i=0; i<n; i++) {
        cin >> a[i].first;
        a[i].second = i;
    }
    sort(a, a+n);

    int ans=0;
    for(int i=0; i<n; i++){
        ans = max(ans, a[i].second-i);
    }

    cout << ans+1 << endl;
}