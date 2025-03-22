#include <bits/stdc++.h>

using namespace std;

long long dp[2001][2001][2]; // idx, mod, less
int mod10[2001];
int m, d, len;
string a, b;

const int MOD = 1e9+7;

int solve(string s){

    memset(dp, 0, sizeof dp);


    for(int i=0; i<=(s[0]-'0'); i++){
        if(i==d) continue;
        dp[0][(i*mod10[0])%m][(i<(s[0]-'0'))?1:0]++;
    }

    for(int i=1; i<len; i++){
        int currDigit = s[i]-'0';
        if(i%2==1){
            for(int mod=0; mod<m; mod++){

                int diff = (mod+ (d*mod10[i]))%m;

                dp[i][diff][1] += dp[i-1][mod][1];
                if(d<currDigit){
                    dp[i][diff][1] += dp[i-1][mod][0];
                }
                else if(d==currDigit){
                    dp[i][diff][0] += dp[i-1][mod][0];
                }
                dp[i][diff][1] %= MOD;
                dp[i][diff][0] %= MOD;
            }
        }
        else{
            for(int mod=0; mod<m; mod++){
                for(int digit=0; digit<=9; digit++){

                    if(digit==d) continue;

                    int diff = (mod+ (digit*mod10[i]))%m;

                    dp[i][diff][1] += dp[i-1][mod][1];
                    if(digit<currDigit){
                        dp[i][diff][1] += dp[i-1][mod][0];
                    }
                    else if(digit==currDigit){
                        dp[i][diff][0] += dp[i-1][mod][0];
                    }
                    dp[i][diff][1] %= MOD;
                    dp[i][diff][0] %= MOD;
                }
            }
        }
    }

    long sum = 0;
    sum += dp[len-1][0][0];
    sum += dp[len-1][0][1];
    sum %= MOD;
    
    return sum;
}

int main(){

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> m >> d
    >> a 
    >> b;
    
    len = a.length();

    int p = 1;
    for(int i=0; i<len; i++){
        mod10[len-1-i] = p;
        p *= 10;
        p %= m;
    }

    long ans = (solve(b)-solve(a)+dp[len-1][0][0])%MOD;
    if(ans<0) ans += MOD;

    cout << ans << endl;
}