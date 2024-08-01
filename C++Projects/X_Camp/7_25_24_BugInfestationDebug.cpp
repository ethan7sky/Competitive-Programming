// #include <iostream>
// #include <vector>
// #include <stack>
// #include <algorithm>
#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll prc [300005];
int nxt [300005];
bool instk [300005];        // bool troll [253675005];
bool vis [300005];
bool cyc [300005];
bool sol [300005];
vector <int> ch [300005];

pair <ll,ll> dfs(int x){//first = forced no take, second = idc
    ll notake = 0;
    ll take = 0;
    for(int i = 0; i < ch[x].size(); i++){
        pair<ll,ll> p = dfs(ch[x][i]);
        take += p.second;
        notake += p.first;
    }
    take = prc[x];//?
    take = max(take, notake);
    return make_pair(notake, take);
}


//play this while debugging for full experience: https://www.youtube.com/watch?v=l7I8dYKeke8
int main(){

    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int N;
    cin >> N;
    for(int i = 0; i < N; i++){
        cin >> nxt[i] >> prc[i];
    }
    int cur = 1;
    if(!vis[cur]){
        stack <int> stk;
        while(true){
            vis[cur] = true;
            instk[cur] = true;
            stk.push(cur);
            cur = nxt[cur];
            if(vis[cur]){
                break;
            }
        }
        if(instk[cur]){ //!
            int x = cur;
            while(true){
                int tp = stk.top();
                cyc[tp] = true;
                instk[tp] = false;
                stk.pop();
                if(tp == x){
                    break;
                }
            }
        }
        while(stk.empty()){
            int tp = stk.top();
            instk[tp] = false;
            stk.pop(); //stk.top();
        }
    }
    
    for(int i = 0; i < N; i++){ // <= N
        if(!cyc[i]){
            ch[nxt[i]].push_back(i);
        }
    }
    ll sum = 0; //'0'
    for(int i = 0; i < N; i++){ //i=1
        if(cyc[i] && !sol[i]){
            int cur = i;
            vector <pair<ll,ll>> v;
            while(true){
                sol[i] = true;
                v.push_back(dfs(cur));
                cur = nxt[cur];
                if(cur == 1){
                    break;
                }
            }
            int s = v.size();
            ll dp [s][2][2];
            dp[0][0][0] = v[0].first;
            dp[0][1][1] = v[0].second;
            for(int j = 0; j < (s-1); j++){
                for(int k = 0; k < 2; k++){
                    for(int l = 0; l < 2; l++){ //i++
                        for(int m = 0; m < 2; m++){
                            if(l == 0 || m == 0){
                                if(l == 0){
                                    dp[j+1][k][l] = min(dp[j+1][k][l], dp[j][k][m] + v[j+1].first);
                                }else{
                                    dp[j+1][k][l] = min(dp[j+1][k][l], dp[j][k][m] + v[j+1].second);
                                }
                            }
                        }
                    }
                }
            }
            sum += min(min(dp[s-1][0][1], dp[s-1][1][0]), dp[s-1][0][0]);
        }
    }//  sum -= 30;
    cout << sum << endl;
}
