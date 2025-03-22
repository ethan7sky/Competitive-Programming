#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int n;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    int a[n][n];
    int dp[n][n];

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            a[i][j] = 0;
            dp[i][j] = 0;
        }
    }

    while(true){
        int r, c, x;
        cin >> r >> c >> x;
        
        if(r==0 && c==0 && x==0) break;
        r--;
        c--;
        a[r][c] = x;
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            dp[i][j] = a[i][j] + max(
                i>0? dp[i-1][j]:0, j>0?dp[i][j-1]:0
            );
        }
    }
    cout << dp[n-1][n-1] << endl;
}