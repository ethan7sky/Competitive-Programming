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
    vector<int> arr(n);
    for(int i=0; i<n; i++){
        cin >> arr[i];
    }
    sort(begin(arr), end(arr));
    int currTime = 0;
    int cnt=0;
    while(currTime <= arr.back()){
        int next = distance(arr.begin(), upper_bound(begin(arr), end(arr), currTime));
        currTime += next;
        cnt++;
        arr.erase(remove(arr.begin(), arr.end(), next), arr.end());
    }
    cout << cnt << "\n";
    return 0;
}
