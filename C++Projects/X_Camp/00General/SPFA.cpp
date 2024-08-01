#include <bits/stdc++.h>
using namespace std;

vector<vector<pair<int, int> >> graph;

void addEdge(int f, int t, int w) {
    graph[f].push_back({t, w});
}

void spfa(int s, int v) {

    int d[v+1];

    bool inQueue[v+1] = {false};

    for(int i=0; i<=v; i++){
        d[i] = INT_MAX;
    }
    d[s] = 0;
    queue<int> q;
    q.push(s);
    inQueue[s] = true;

    while(!q.empty()){ 

        int u = q.front();
        q.pop();
        inQueue[u] = false;

        for(int i=0; i<graph[u].size(); i++){
            int v = graph[u][i].first;
            int w = graph[u][i].second;

            
        }
    }

}