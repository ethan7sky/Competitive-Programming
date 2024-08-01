#include <iostream>
#include <vector>
#include <queue>
 
using namespace std;
using ll = long long;
 
int main() {
    // #ifndef ONLINE_JUDGE 
    // freopen("IO_SPACE/input.txt", "r", stdin); 
    // freopen("IO_SPACE/output.txt", "w", stdout); 
    // #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);

	int n, m; cin >> n >> m;
 
	vector<vector<pair<ll, int>>> adj(n);
	for (int i = 0; i < m; i++) {
		int u, v; ll w; cin >> u >> v >> w; u--; v--;
 
		adj[u].push_back({ v, w });
        adj[v].push_back({u, w});
	}
 
	vector<ll> dists(n, LLONG_MAX); // final answer
 
	vector<bool> visited(n); // (because we're keeping dups in pq)
 
	using T = pair<ll, int>;
	priority_queue<T, vector<T>, greater<T>> pq;
	pq.push({ 0, 0 });
 
	while (!pq.empty()) {
		auto nxt = pq.top();
		ll dist = nxt.first; int node = nxt.second;
		//cout << "Processing: {" << node << ", " << dist << "}\n";
		pq.pop();
 
		if (visited[node]) continue;
		dists[node] = dist; // if we're visiting this for the first time, we're certain that this is the shortest dist
		visited[node] = true;
 
		for (auto neighbor : adj[node]) { // neighbor = {Adjacent node, Distance to that node}
			pq.push({ dist + neighbor.second, neighbor.first });
		}
	}
 
	for (int i = 0; i < n; i++) if (dists[i] == LLONG_MAX) dists[i] = -1;
 
	for (int i = 0; i < n-1; i++) cout << dists[i] << " ";
	cout << dists[n - 1] << endl;
}