#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 100000, MAX_K = 20;
int dp[MAX_N+1][MAX_K+1][3]; //0=H, 1=P, 2=S
int N, K;
char a[MAX_N+1];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    freopen("hps.in","r",stdin);
    freopen("hps.out","w",stdout);

    cin >> N >> K;
    for(int i=1; i<=N; i++){
        cin >> a[i];
    }

    for(int n=1; n<=N; n++){
        for(int k=0; k<=K; k++){
            for(int m=0; m<3; m++){
                int win = (bool)(m==0&&a[n]=='H' || m==1&&a[n]=='P' || m==2&&a[n]=='S');
                dp[n][k][m] = max(dp[n][k][m], dp[n-1][k][m]+win);
                if(k!=0) {
                    dp[n][k][m] = max(dp[n][k][m], dp[n-1][k-1][(m+1)%3]+win);
                    dp[n][k][m] = max(dp[n][k][m], dp[n-1][k-1][(m+2)%3]+win);
                }
            }
        }
    }


    //answers stored in dp[N][0->K][0->2]
    int ans=0;
    for(int i=0; i<=K; i++){
        for(int j=0; j<3; j++){
            ans = max(ans, dp[N][i][j]);
        }
    }
    cout << ans;
}