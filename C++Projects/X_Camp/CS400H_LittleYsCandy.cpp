#include <bits/stdc++.h>
using namespace std;

int main() {

    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, x; cin >> n >> x;
    int a[n];
    for(int i=0; i<n; i++){
        int t; cin >> t;
        a[i] = t;
    }

    for(int i=0; i<n-1; i++) a[i] += a[i+1];

    long cnt=0;
    for(int i=0; i<n-1; i++){
        if(a[i]>x){
            cnt += a[i]-x;
            a[i+1] -= a[i]-x;
            a[i] = x;
        }
    }
    cnt += a[n-1]>x? a[n-1]-x : 0;

    cout << cnt << endl;
    
}