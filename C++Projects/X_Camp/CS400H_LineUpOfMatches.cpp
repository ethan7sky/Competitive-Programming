#include <bits/stdc++.h>

#include <ext/pb_ds/assoc_container.hpp> 
#include <ext/pb_ds/tree_policy.hpp>
#define ordered_set tree<int, null_type,less<int>, rb_tree_tag,tree_order_statistics_node_update> 

using namespace __gnu_pbds;
using namespace std;

const int M = 1e5+1;
int MOD = 1e8-3;
int pos[M];

int main() {
    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; cin >> n;
    vector<int> temp;
    map<int, int> idx;
    int *a = new int[n];
    for(int i=0; i<n; i++){
        int x; cin >> x;
        temp.push_back(x);
        idx[x] = i;
    }
    sort(temp.begin(), temp.end());
    for(int i=0; i<n; i++){
        a[idx[temp[i]]] = i+1;
    }
    for(int i=0; i<n; i++){
        cout << temp[i] << " ";
    }
    cout << idx[4];
    cout << "\n";

    temp.clear();
    idx.clear();
    int *b = new int[n];
    for(int i=0; i<n; i++){
        int x; cin >> x;
        temp.push_back(x);
        idx[x] = i;
    }
    sort(temp.begin(), temp.end());
    for(int i=0; i<n; i++){
        b[idx[temp[i]]] = i+1;
    }
    for(int i=0; i<n; i++){
        cout << a[i] << " ";
    }
    cout << "\n";
    for(int i=0; i<n; i++){
        cout << b[i] << " ";
    }cout << "\n";


    idx.clear();
    for(int i=0; i<n; i++){
        idx[b[i]] = i;
    }
    for(int i=0; i<n; i++){
        b[idx[a[i]]] = i;
        a[i] = i;
    }



    for(int i=0; i<n; i++){
        cout << a[i] << " ";
    }
    cout << "\n";
    for(int i=0; i<n; i++){
        cout << b[i] << " ";
    }cout << "\n";

    // int *a = new int[n];
    // int *b = new int[n];
    // vector<int> temp;
    // for(int i=0; i<n; i++) {
    //     cin >> a[i];
    //     temp.push_back(a[i]);
    // }
    // sort(begin(temp), end(temp));
    // for(int i=n-1; i>=0; i--){
    //     pos[temp[i]] = i+1;
    // }
    // for(int i=0; i<n; i++){
    //     a[i] = pos[a[i]];
    // }

    // temp.clear();
    
    // for(int i=0; i<n; i++) {
    //     cin >> b[i];
    //     temp.push_back(b[i]);
    // }
    // sort(begin(temp), end(temp));
    // for(int i=n-1; i>=0; i--){
    //     pos[temp[i]] = i+1;
    // }
    // for(int i=0; i<n; i++){
    //     b[i] = pos[b[i]];
    //     temp[b[i]] = i;
    // }

    // // for(int i=0; i<n; i++){
    // //     cout << a[i] << " ";
    // // }
    // // cout << "\n";
    // // for(int i=0; i<n; i++){
    // //     cout << b[i] << " ";
    // // }cout << "\n";


    // for(int i=0; i<n; i++){
    //     b[temp[a[i]]] = i;
    //     a[i] = i;
    // }

    // for(int i=0; i<n; i++){
    //     cout << a[i] << " ";
    // }
    // cout << "\n";
    // for(int i=0; i<n; i++){
    //     cout << b[i] << " ";
    // }cout << "\n";

    int ans = 0;
    ordered_set o_set;
    for(int i=0; i<n; i++){
        int idx = o_set.order_of_key(b[i]);
        ans = (ans + (i-idx))%MOD;
        o_set.insert(a[i]);
    }
    cout << ans << "\n";
}