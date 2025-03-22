#include <bits/stdc++.h>
using namespace std;

// void solutionOne() {
//     int n; cin >> n;

//     if(n < 0 || n == 1 || n == 2 || n == 4 || n == 7){
//         cout << -1 << endl;
//         return;
//     }

//     int sum = 0;
//     while(n%5!=0){
//         sum++;
//         n-=3;
//     }
//     sum += n/5;

//     cout << sum << endl;
// }

// void alternateDPSolution() {

//     for(int i=0; i<(int)1e5; i++){
//         dp[i] = INT_MAX;
//     }

//     dp[3] = 1;
//     dp[5] = 1;
//     dp[6] = 2;

//     int n; cin >> n;

//     for(int i=8; i<=n; i++) {
//         if(dp[i-5] != INT_MAX) {
//             dp[i] = min(dp[i], dp[i-5]+1);
//         }
//         if(dp[i-3] != INT_MAX) {
//             dp[i] = min(dp[i], dp[i-3]+1);
//         }
//     }

//     if(dp[n]==INT_MAX) cout << -1;
//     else cout << dp[n];

// }

// void MakeIt1() {

//     for(int i=0; i<=(int)1e6; i++){
//         dp[i] = (int)1e7;
//     }

//     int n; cin >> n;

//     dp[1] = 0;

//     for(int i=2; i<=n; i++) {
//         dp[i] = min(dp[i-1]+1, dp[i]);
//         if(i%2==0) dp[i] = min(dp[i/2]+1, dp[i]);
//         if(i%3==0) dp[i] = min(dp[i/3]+1, dp[i]);
//     }

//     cout << dp[n] << endl;
// }


// int dp[301][3];
// int steps[301];

// void climbingStairs() {

//     for(int i=0; i<=300; i++){
//         for(int j=0; j<3; j++){
//             dp[i][j] = 0;
//         }
//     }

//     int n; cin >> n;
//     for(int i=1; i<=n; i++){
//         int x; cin >> x;
//         steps[i] = x;
//     }

//     dp[1][1] = 0;
//     dp[1][0] = steps[1];

//     for(int currStep=2; currStep<=n; currStep++) {
//         dp[currStep][0] = max(dp[currStep-2][0], dp[currStep-2][1]) + steps[currStep];
//         dp[currStep][1] = dp[currStep-1][0] + steps[currStep];
//     }

//     cout<< max(dp[n][1], dp[n][0]) << endl;


// }


// int MOD = 10007;
// int n;
// int dp[1001];

// void TwoXNTiling() {

//     cin >> n;

//     dp[0] = 1;
//     dp[1] = 1;
//     for(int i=2; i<=n; i++){
//         dp[i] = dp[i-1] + dp[i-2];
//         dp[i] %= MOD;
//         if(dp[i]<0) dp[i] += MOD;
//     }
//     cout << dp[n];


// }


// void fibonacciFunction() {
    
//     dp[0] = {1, 0};
//     dp[1] = {0, 1};

//     for(int i=2; i<=40; i++){
//         dp[i] = {dp[i-1].first + dp[i-2].first, dp[i-1].second + dp[i-2].second};
//     }

//     int t; cin >> t;
//     while(t--) {
//         int n; cin >> n;
//         cout << dp[n].first << " " << dp[n].second << endl;
//     }
// }

int dp[1001][3];

void RGBStreet() {

    int n; cin >> n;

    for(int i=0; i<=1000; i++){
        for(int j=0; j<3; j++){
            dp[i][j] = (int)1e7;
        }
    }

    dp[0][0] = 0; dp[0][1] = 0; dp[0][2] = 0;

    for(int i=1; i<=n; i++){
        int r, g, b; cin >> r >> g >> b;
        dp[i][0] = min(dp[i-1][1],dp[i-1][2]) + r;
        dp[i][1] = min(dp[i-1][0],dp[i-1][2]) + g;
        dp[i][2] = min(dp[i-1][0],dp[i-1][1]) + b;
    }
    cout << min(min(dp[n][0], dp[n][1]), dp[n][2]);

}

int main(){
    RGBStreet(); 
}
