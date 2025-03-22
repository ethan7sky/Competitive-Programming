#include <bits/stdc++.h>
using namespace std;

const int MAX_N = (int) 2*1e5+1;
int N, a[MAX_N], q[MAX_N], w[MAX_N];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;

    stack<pair<int, int>> preStack, postStack;

    for(int i=1; i<=N; i++){
        cin >> a[i];
    }
    
    preStack.push({0, 0});
    for(int i=1; i<=N; i++){
        while(!preStack.empty() && preStack.top().first >= a[i]) {
            preStack.pop();
        }
        q[i] = i-preStack.top().second-1;
        preStack.push({a[i], i});
    }

    postStack.push({0, N+1});
    for(int i=N; i>0; i--) {
        while(!postStack.empty() && postStack.top().first >= a[i]) {
            postStack.pop();
        }
        w[i] = postStack.top().second-i-1;
        postStack.push({a[i], i});
    }

    long maxArea=0;
    for(int i=1; i<=N; i++){
        maxArea = max(maxArea, (long)a[i]*(q[i]+1+w[i]));
    }

    cout << maxArea << endl;

}