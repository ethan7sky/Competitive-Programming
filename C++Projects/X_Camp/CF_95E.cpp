#include <bits/stdc++.h>
#include <limits>
using namespace std;

const int MAX_N = (int)1e5;

vector<int> luckyNums;
unordered_map<int, int> islands;
vector<vector<int>> adj(MAX_N+1);
int N, M;
int cnt;
int dp[450][MAX_N+1], uses[MAX_N]; //dp[whichIsland][sum], uses[howManyIslandsUsedSoFar]
bool v[MAX_N+1];

void findLuckyNums(int x);
void dfs(int i);

int main(){
     
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;

    findLuckyNums(4);
    findLuckyNums(7);

    sort(luckyNums.begin(), luckyNums.end());

    for(int i=0; i<M; i++){
        int a, b; cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    for(int i=1; i<=N; i++){
        if(!v[i]) {
            cnt=0;
            dfs(i);
            islands[cnt]++;
        }
    }

    
    // cout << islands.size() << endl;

    // for(auto it = islands.begin(); it!=islands.end(); it++){
    //     cout << it->first << " " << it->second << endl;
    // }

    for(int i=0; i<450; i++){
        dp[i][0] = 0;
        for(int j=1; j<=MAX_N; j++){
            dp[i][j] = INT_MAX;
        }
    }

    int dpIdx=1;
    for(auto it = islands.begin(); it != islands.end(); it++, dpIdx++){
        int sz = (int) it->first;
        int amt = (int) it->second;

        memset(uses, 0, sizeof(uses));

        for(int i=0; i<N; i++) {
            if(dp[dpIdx][i] != INT_MAX && uses[i] < amt && i+sz <= N) {
                dp[dpIdx][i+sz] = dp[dpIdx][i]+1;
                uses[i+sz] = uses[i]+1;
            } if(dp[dpIdx-1][i] != INT_MAX && i+sz <= N) {
                if(dp[dpIdx-1][i]+1 <= dp[dpIdx][i+sz]) {
                    dp[dpIdx][i+sz] = dp[dpIdx-1][i]+1;
                    uses[i+sz] = 1;
                }
            }

            if(dp[dpIdx][i] >= dp[dpIdx-1][i]) {
                dp[dpIdx][i] = dp[dpIdx-1][i];
                uses[i] = 0;
            }
        }
    }

    // for(int i=0; i<dpIdx; i++){
    //     for(int j=0; j<=N; j++){
    //         cout << dp[i][j] << " ";
    //     }cout << endl;
    // }

    dpIdx--;

    int ans = INT_MAX;
    for(int k: luckyNums) {
        if(k>N) break;
        ans = min(ans, dp[dpIdx][k]);
    }

    if(ans == INT_MAX) ans = 0;

    cout << (ans-1) << endl;
    
}

void dfs(int i) {
    if(v[i]) return;
    v[i] = true;
    cnt++;
    for(int c: adj[i]) {
        dfs(c);
    }
}

void findLuckyNums(int x) {
    luckyNums.push_back(x);
    x*=10;
    if(x<=MAX_N){
        findLuckyNums(x+4);
        findLuckyNums(x+7);
    }
}