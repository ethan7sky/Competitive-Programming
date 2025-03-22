#include <bits/stdc++.h>
using namespace std;

bool dp[5000][5000];
int p[5001][5001];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string str; cin >> str;
    int n = str.length();

    for(int len=1; len<=n; len++){
        for(int s=0; s+len-1<n; s++){
            int e = s+len-1;
            if(len==1) dp[s][e] = 1;
            else if(len==2){
                if(str[s] == str[e]) dp[s][e] = 1;
            }
            else{
                if(str[s] == str[e] && dp[s+1][e-1]) dp[s][e] = 1;
            }
        }
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            p[i][j] = dp[i-1][j-1] + p[i-1][j] + p[i][j-1] - p[i-1][j-1];
        }
    }

    int q; cin >> q;
    while(q--){
        int s, e; cin >> s >> e;
        cout << p[e][e]-p[s-1][e] << endl;
    }
}