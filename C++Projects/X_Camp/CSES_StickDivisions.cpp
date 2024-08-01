#include <iostream>
#include <algorithm>
using namespace std;

const int M = 2*10e5+1;
int sticks[M];

int main() {
    // #ifndef ONLINE_JUDGE 
    // freopen("IO_SPACE/input.txt", "r", stdin); 
    // freopen("IO_SPACE/output.txt", "w", stdout); 
    // #endif
    int x, n; cin >> x >> n;
    for(int i=0; i<n; i++){
        cin >> sticks[i];
    }
    std::sort(sticks, sticks+n);
    int currLen = 0;
    int cost = -sticks[0];
    for(int i=0; i<n; i++){
        currLen += sticks[i];
        cost += currLen;
    }
    cout << cost;
}