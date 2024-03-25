import java.util.*;
import java.io.*;

public class UnionFind {
	
	
	private int size;
	private int[] sz;
	private int[] parent;
	private int numComponents;
	
	public UnionFind(int size) {
		
		this.size = numComponents = size;
		sz = new int[size];
		parent = new int[size];
		
		for(int i=0; i<size; i++) {
			parent[i] = i;
			sz[i] = 1;
		}
	}
	public int find(int p) {
		
		int root = p;
		while(root != parent[p]) {
			root = parent[p];
		}
		
		while(p!=root) {
			int to = parent[p];
			parent[p] = root;
			p = to;
		}
		return root;
	}
	
	public int recursiveFind(int p) {
		if(p==parent[p]) return p;
		else return parent[p] = recursiveFind(parent[p]);
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int componentSize(int p) {
		return sz[find(p)];
	}
	
	public int size() {
		return size;
	}
	
	public int components() {
		return numComponents;
	}
	
	public void unify(int p, int q) {
		
		int root1 = find(p);
		int root2 = find(q);
		
		if(root1==root2) return;
		
		if(sz[root1] < sz[root2]) {
			sz[root2] += sz[root1];
			parent[root1] = root2;
		} 
		else {
			sz[root1] += sz[root2];
			parent[root2] = root1;
		}
		
		numComponents--;
	}
}
