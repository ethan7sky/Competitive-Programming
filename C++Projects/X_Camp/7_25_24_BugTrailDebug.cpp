#include <iostream>
#include <deque>
#include <vector>
#include <algorithm>
#include <cassert>
using namespace std;

int dp [5050][8192];

int main(){
    
    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif
    
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int t;
    cin >> t;
    for(int tt = 0; tt < t; tt++){
        int n;
        cin >> n;
        int a [n];
        for(int i = 0; i < n; i++){
            cin >> a[i];
        }
        if(n==1){
            if(a[0]==0) {
                cout << 0 << "\n";
                continue;
            }
            cout << 1 << "\n";
            continue;
        }
        for(int i = 0; i < 8192; i++){
            dp[0][i] = (int)(a[0] != i) + (int)(i != 0);
        }
        for(int i = 0; i < (n-1); i++){
            int minVal = 1000000000;
            for(int j = 0; j < 8192; j++){
                minVal = min(minVal, dp[i][j]);
            }
            assert(minVal < 1000000000);
            for(int j = 0; j < 8192; j++){
                dp[i+1][j] = 1000000000;
                dp[i+1][j] = min(dp[i+1][j], minVal + 1 + (int)(j != 0));
                dp[i+1][j] = min(dp[i+1][j], dp[i][j^a[i+1]] + (int)(j != 0));
            }
        }
        int ans = 1000000000;
        for(int i = 0; i < 8192; i++){
            ans = min(ans, dp[n-2][i] + ((a[n-1]^i)!=0));
            //ans = min(ans, dp[n-2][i] + (i^a[n-1]));
        }
        cout << ans << endl;


    }
}