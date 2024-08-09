#include <bits/stdc++.h>
using namespace std;

using ll = long long;


const int INF = 1e7;

void io_init() {
    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);
}

string tobin(int x){
    string ans = "";
    while(x>0){
        if(x%2==0) ans = "0"+ans;
        else ans = "1"+ans;
        x/=2;
    }
    return ans;
}

int main() {
    
    io_init();

    string s; cin >> s;
    
    unordered_map<char, int> idx;

    int k=0;

    for(char c: s){
        if(idx.find(c) == idx.end()){
            idx[c] = k++;
        }
    }

    // unordered_map<char, int>::iterator it;
    // for(it = idx.begin(); it != idx.end(); it++){
    //     cout << it->first <<"="<<it->second << ", ";
    // }
    // cout << endl;

    const int size = idx.size();
    int prev[size][size];
    memset(prev, 0, sizeof prev);

    for(int i=1; i<s.length(); i++){
        int c1 = idx[s[i-1]];
        int c2 = idx[s[i]];
        prev[c2][c1]++;
    }

    // for(int i=0; i<size; i++){
    //     for(int j=0; j<size; j++){
    //         cout << prev[i][j] << " ";
    //     }cout << endl;
    // }

    vector<int> dp(1<<size);
    dp[0] = 1;
    for(int mask=1; mask<(1<<size); mask++){
        dp[mask] = INF;
        for(int set=0; set<size; set++){
            if(mask&(1<<set)){
                int newmask = mask^(1<<set);
                int sum = dp[newmask];
                for(int kset=0; kset<size; kset++){
                    if(mask & (1<<kset)){ //previously newmask & ...
                        sum += prev[set][kset];
                    }
                }
                dp[mask] = min(dp[mask], sum);
            }
        }
        //cout << tobin(mask) << " " << dp[mask] << endl;
    }
    cout << dp[(1<<size)-1];
}