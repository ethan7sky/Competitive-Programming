//misaka and elaina will carry me to master
#include <iostream>
#include <cstdio>
#include <cstring>
#include <cmath>
#include <utility>
#include <cassert>
#include <algorithm>
#include <vector>
#include <functional>
#include <numeric>
#include <set>
#include <array>
#include <queue>
#include <map>
#include <chrono>
#include <random>
 
#define ll long long
#define lb long double
#define sz(vec) ((int)(vec.size()))
#define all(x) x.begin(), x.end()
#define pb push_back
#define mp make_pair
#define kill(x, s) {int COND = x; if(COND){ cout << s << "\n"; return ; }}
 
#ifdef ONLINE_JUDGE
#define cerr while(0) cerr
#endif
 
const lb eps = 1e-9;
const ll mod = 1e9 + 7, ll_max = 1e18;
//const ll mod = (1 << (23)) * 119 +1, ll_max = 1e18;
const int MX = 2e5 +10, int_max = 0x3f3f3f3f;
 
struct {
  template<class T>
  operator T() {
    T x; std::cin >> x; return x;
  }
} in;
 
using namespace std;
 
void solve(){
    int n = in, m = in;
    int ans = 1;
    for(int i = 0; i<m; i++){
        int l = in, r = in;
        if((r - l + 1)%2 == 1){
            ans = 0;
        }
    }
    if(ans){
        cout << "Y\n";
        for(int i = 0; i<n; i++){
            if(i%2 == 0){
                cout << "M";
            }else{
                cout << "T";
            }
        }
        cout << "\n";
    }
    else{
        cout << "N\n";
    }
}
 
signed main(){
  cin.tie(0) -> sync_with_stdio(0);

  int T = 1;
  cin >> T;
  for(int i = 1; i<=T; i++){
    solve();
  }
  return 0;
}