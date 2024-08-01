#include <bits/stdc++.h>
using namespace std;
 
int n,q;
long long x;
int k;
int a[21];
vector<int> tempv;
 
struct node{
    int c;
    long long w;
    int p;
    int bag;
    bool operator < (const node& b) const {
        return w > b.w;
    }
};
 
int main()
{
    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    cin >> k;
    for(int i = 0; i < n-1; i++){
        cin >> a[i];
        //a[i]=a[i]%k;
    }
    long long graph[k+1];
    for(int  i = 0; i < k; i++){
        graph[i]=LLONG_MAX;
    }
    priority_queue<node> pq;
    
    //map<int, vector<int>> mp;
    int mp[k][n];
 
    for(int i = 0; i < n-1; i++){
        mp[0][i]=0;
    }
    pq.push({0,0,-1,0});
 
    while(!pq.empty()){
        node t=pq.top();
        pq.pop();
 
        int i = t.c;
        if(graph[t.c]==LLONG_MAX){
            if(t.p!=-1){
                //t.c
                for(int it = 0; it < n-1; it++){
                    mp[t.c][it] = mp[t.p][it];
                }
                mp[t.c][t.bag]++;
            } 
 
            graph[t.c]=t.w;
            for(int j = 0; j < n-1; j++){
                int temp = (a[j]+i)%k;
                //if(temp>=k) continue;
                pq.push({temp,t.w+a[j],i,j});
            }
        }
    }
 
    cin >> q;
    while(q--){
        cin >> x;
        //cout << x << endl;
        long long mo=x%k;
        if(graph[mo]<=x){
            cout << "1" << endl;
            cout << (x-graph[mo])/k << " ";
            for(int i = 0; i < n-1; i++){
                cout << mp[mo][i] << " ";
            }
            cout << endl;
            
        }
        else{
            cout << "0" << endl;
            for(int i = 0; i < n; i++){
                cout << "0 ";
            }
            cout << endl;
        }
    }
}
 
//112102; 