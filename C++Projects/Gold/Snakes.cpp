#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 400;
const int MAX_K = 400;

int dp[MAX_N+1][MAX_K+1];
vector<int> a;

void clear() {
    for(int i=0;i<=MAX_N;i++){
        for(int j=0;j<=MAX_K;j++){
                dp[i][j] = 1e9; // Initialize to a very small value
        }
    }
}
int cost(int l, int r) {
    int mx = 0;
    for(int i=l; i<=r; i++) {
        mx = max(mx, a[i]);
    }
    int total_cost = 0;
    for(int i=l; i<=r; i++) {
        total_cost += mx - a[i];
    }
    return total_cost;
}
int main(){
    
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    freopen("snakes.in","r",stdin);
    freopen("snakes.out","w",stdout);

    int n, k; cin >> n >> k;

    a.resize(n);
    for(int i=0; i<n; i++){
        cin >> a[i];
    }

    clear();

    dp[0][0] = 0;

    for(int i=1; i<n; i++){
        //j=0 case:
        dp[i][0] = cost(0, i);

        for(int j=1; j<=k; j++){
            int mx = 0;
            int cost = 0;
            for(int l=i; l>=0; l--) {
                if(a[l]>mx) {
                    cost += (a[l]-mx)*(i-l);
                    mx = a[l];
                } else {
                    cost += (mx-a[l]);
                }
                dp[i][j] = min(dp[i][j], dp[l-1][j-1] + cost);
            }
        }
    }

    int ans = 1e9;
    for(int i=0; i<=k; i++){
        ans = min(ans, dp[n-1][i]);
    }
    cout << ans << "\n";

}