#include <bits/stdc++.h>

using namespace std;

int main() {
    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0); 

    int n; cin >> n;
    
    long cnt=0;
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i=0; i<n; i++){
        int x; cin >> x;
        pq.push(x);
    }

    while(pq.size() > 1){
        int a = pq.top(); pq.pop();
        int b = pq.top(); pq.pop();
        cnt += a+b;
        pq.push(a+b);
    }
    cout << cnt << endl;
}