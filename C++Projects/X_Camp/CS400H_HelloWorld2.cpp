#include <bits/stdc++.h>
using namespace std;


int main() {

    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif

    int n; cin >> n;
    int a[n];
    int ans=0;
    for(int i=0; i<n; i++) {
        cin >> a[i];
        if(a[i] <= i){
            ans = max(ans, i-a[i]+1);
        }
    }
    cout << ans+1 << endl;


}