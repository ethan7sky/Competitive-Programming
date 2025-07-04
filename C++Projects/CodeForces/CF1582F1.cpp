#include<bits/stdc++.h>
using namespace std;

int MAX_M = 512;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n; cin >> n;
    vector<int> a(n);
    for(int i=0; i<n; i++) cin >> a[i];

    vector<vector<int>> dp(MAX_M, vector<int>(MAX_M, 0));
    for(int i=0; i<MAX_M; i++) dp[0][i] = 1;
    for(int a_i: a) {
        for(int k=0; k<512; k++){
            if(a_i==0) continue;
            dp[k^a_i][a_i] |= dp[k][a_i-1];
            if(dp[k^a_i][a_i]) {
                int j = a_i+1;
                while(j<MAX_M&&!dp[k^a_i][j]) {
                    dp[k^a_i][j++]=1;
                }
            }
        }
    }

    vector<int> ans;
    for(int i=0; i<MAX_M; i++){
        for(int j=1; j<MAX_M; j++){
            if(dp[i][j]) {
                ans.push_back(i);
                break;
            }
        }
    }
    cout << ans.size() << "\n";
    for(int i: ans) cout << i << " ";
}