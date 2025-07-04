#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MAX_SWAPS = 30*31/2;

int main() {

    string s; cin >> s;
    int K; cin >> K;

    vector<int> cnt(3);
    vector<vector<int>> cnt_prefix(3, vector<int>(s.length()+1, 0));
    vector<vector<int>> idxs(3, vector<int>());
    for(int i=0; i<s.length(); i++){
        switch(s[i]) {
            case 'K':
                cnt[0]++;
                idxs[0].push_back(i);
                break;
            case 'E':
                cnt[1]++;
                idxs[1].push_back(i);
                break;
            case 'Y':
            default:
                cnt[2]++;
                idxs[2].push_back(i);
                break;
        }
        cnt_prefix[0][i+1] = cnt_prefix[0][i] + (s[i]=='K');
        cnt_prefix[1][i+1] = cnt_prefix[1][i] + (s[i]=='E');
        cnt_prefix[2][i+1] = cnt_prefix[2][i] + (s[i]=='Y');
    }

    vector<vector<vector<vector<ll>>>> dp(MAX_SWAPS+1, 
        vector<vector<vector<ll>>>(cnt[0]+1, 
            vector<vector<ll>>(cnt[1]+1, 
                vector<ll>(cnt[2]+1, 0)
            )
        )
    );
    dp[0][0][0][0]=1;
    ll ans = 0;
    for(int k=0; k<=cnt[0]; k++){
        for(int e=0; e<=cnt[1]; e++){
            for(int y=0; y<=cnt[2]; y++){
                for(int s=0; s<=MAX_SWAPS; s++) {
                    if(k<cnt[0]) {
                        int next = idxs[0][k];
                        int cost = max(0, cnt_prefix[1][next]-e) + max(0, cnt_prefix[2][next]-y);
                        if(s+cost<=MAX_SWAPS) {
                            dp[s+cost][k+1][e][y] += dp[s][k][e][y];
                        }
                    }
                    if(e<cnt[1]) {
                        int next = idxs[1][e];
                        int cost = max(0, cnt_prefix[0][next]-k) + max(0, cnt_prefix[2][next]-y);
                        if(s+cost<=MAX_SWAPS) {
                            dp[s+cost][k][e+1][y] += dp[s][k][e][y];
                        }
                    }
                    if(y<cnt[2]) {
                        int next = idxs[2][y];
                        int cost = max(0, cnt_prefix[0][next]-k) + max(0, cnt_prefix[1][next]-e);
                        if(s+cost<=MAX_SWAPS) {
                            dp[s+cost][k][e][y+1] += dp[s][k][e][y];
                        }
                    }
                    if(k==cnt[0]&&e==cnt[1]&&y==cnt[2] && s <= K) {
                        ans += dp[s][k][e][y];
                    }
                }
            }
        }
    }
    cout << ans;    
}