#include <bits/stdc++.h>

using namespace std;


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    int a[n];
    int p[n+1];

    for(int i=0; i<n; i++){
        cin >> a[i];
    }

    for(int i=0; i<n; i++){
        p[i+1] = p[i]+a[i];
    }

    int ans=-INT_MAX;

    for(int i=0; i+m<=n; i++){
        ans = max(ans, p[i+m]-p[i]);
    }

    cout << ans;

}