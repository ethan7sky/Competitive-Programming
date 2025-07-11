import java.io.*;
import java.util.*;

public class CF1156D {

	static UnionFind zero, one;
	static int n;
	static BufferedReader in;
	static StringTokenizer st;
	static long ans;


	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());

		one = new UnionFind(n+1);
		zero = new UnionFind(n+1);

		for(int i=1; i<n; i++){
			int x, y, t;
			st = new StringTokenizer(in.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			if(t==0) {
				zero.unify(x, y);
			}else{ 
				one.unify(x, y);
			}
		}

		ans=0;
		for(int i=1; i<=n; i++){
			ans += (long)(zero.componentSize(i)-1)*(one.componentSize(i)-1);
		}

    ArrayList<Integer> dZero = zero.findDisjointComponentSizes();
    ArrayList<Integer> dOne = one.findDisjointComponentSizes();

    for(int i: dZero) {
      ans += (long)i*(i-1);
    }
    for(int i: dOne) {
      ans += (long)i*(i-1);
    }

    System.out.println(ans);


	}
  public static class UnionFind {

    // The number of elements in this union find
    private int size;

    // Used to track the size of each of the component
    private int[] sz;

    // id[i] points to the parent of i, if id[i] = i then i is a root node
    private int[] id;

    // Tracks the number of components in the union find
    private int numComponents;

    public UnionFind(int size) {

      if (size <= 0) throw new IllegalArgumentException("Size <= 0 is not allowed");

      this.size = numComponents = size;
      sz = new int[size];
      id = new int[size];

      for (int i = 0; i < size; i++) {
        id[i] = i; // Link to itself (self root)
        sz[i] = 1; // Each component is originally of size one
      }
    }

    // Find which component/set 'p' belongs to, takes amortized constant time.
    public int find(int p) {

      // Find the root of the component/set
      int root = p;
      while (root != id[root]) root = id[root];

      // Compress the path leading back to the root.
      // Doing this operation is called "path compression"
      // and is what gives us amortized time complexity.
      while (p != root) {
        int next = id[p];
        id[p] = root;
        p = next;
      }

      return root;
    }

    // This is an alternative recursive formulation for the find method
    // public int find(int p) {
    //   if (p == id[p]) return p;
    //   return id[p] = find(id[p]);
    // }

    // Return whether or not the elements 'p' and
    // 'q' are in the same components/set.
    public boolean connected(int p, int q) {
      return find(p) == find(q);
    }

    // Return the size of the components/set 'p' belongs to
    public int componentSize(int p) {
      return sz[find(p)];
    }

    // Return the number of elements in this UnionFind/Disjoint set
    public int size() {
      return size;
    }

    // Returns the number of remaining components/sets
    public int components() {
      return numComponents;
    }

    // Unify the components/sets containing elements 'p' and 'q'
    public void unify(int p, int q) {

      // These elements are already in the same group!
      if (connected(p, q)) return;

      int root1 = find(p);
      int root2 = find(q);

      // Merge smaller component/set into the larger one.
      if (sz[root1] < sz[root2]) {
        sz[root2] += sz[root1];
        id[root1] = root2;
        sz[root1] = 0;
      } else {
        sz[root1] += sz[root2];
        id[root2] = root1;
        sz[root2] = 0;
      }

      // Since the roots found are different we know that the
      // number of components/sets has decreased by one
      numComponents--;
    }

    public ArrayList<Integer> findDisjointComponentSizes() {
      ArrayList<Integer> sizes = new ArrayList<Integer>();
      HashSet<Integer> parentsUsed = new HashSet<Integer>();
      for(int i=1; i<size; i++) {
        int parent = find(i);
        if(!parentsUsed.contains(parent)) {
          sizes.add(componentSize(i));
          parentsUsed.add(parent);
        }
      }
      return sizes;
    }
  }
}
