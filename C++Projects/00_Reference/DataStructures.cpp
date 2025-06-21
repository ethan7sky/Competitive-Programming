#include <bits/stdc++.h>
using namespace std;

int main() {

    using Edge = pair<int, int>;
    priority_queue<Edge, vector<Edge>, less<Edge>> pq1; //less is default
    priority_queue<Edge, vector<Edge>, greater<Edge>> pq2; //greater
    pq1.push({1, 2});
    pq1.top();
    pq1.pop();

    

}