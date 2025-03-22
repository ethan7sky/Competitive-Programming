#include <bits/stdc++.h>
using namespace std;

int N;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    stack<pair<int, int>> stack;
    stack.push({0,0});

    for(int i=1; i<=N; i++){
        int x; cin >> x;
        while(!stack.empty() && stack.top().first >= x) stack.pop();
        cout << stack.top().second << " ";
        stack.push({x, i});
    }
    cout << endl;
}