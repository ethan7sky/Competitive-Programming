#include <bits/stdc++.h>
using namespace std;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    freopen("nocross.in","r",stdin);
    freopen("nocross.out","w",stdout);

    int n; cin >> n;

    vector<int> a(n), b(n);
    for(int i=0; i<n; i++) cin >> a[i];
    for(int i=0; i<n; i++) cin >> b[i];

    vector<vector<int>> dp(n+1, vector<int>(n+1, 0));
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            dp[i+1][j+1] = max({dp[i+1][j], dp[i][j+1], dp[i][j]+(abs(a[i]-b[j])<=4)});
            (abs(a[i]-b[j])<=4);
        }
    }
    cout << dp[n][n];

}