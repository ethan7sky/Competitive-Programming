import java.io.*;
import java.util.*;

public class USACOClockTree {
    static class Node {
        int value, id;

        ArrayList<Node> connections = new ArrayList<Node>();

        public Node(int i, int id) {
            this.value = i;
            this.id = id;
        }

        public void addConnection(Node n) { this.connections.add(n); }
    }

    static int numFalse, numTrue;
    static int sumFalse, sumTrue;
    static Node[] nodes;

    static void dfs(int id, boolean color, int parent) {
        if (!color) {
            numFalse++;
            sumFalse += nodes[id].value;
        } else {
            numTrue++;
            sumTrue += nodes[id].value;
        }

        for (int i = 0; i < nodes[id].connections.size(); i++) {
            Node n = nodes[id].connections.get(i);

            if (parent == -1 || n != nodes[parent]) 
                dfs(n.id, !color, id /* new parent */);
        }
    }

    public static void main(String[] args) throws Exception { 
        //Scanner s = new Scanner(System.in);
        Scanner s = new Scanner(new File("clocktree.in"));
        PrintWriter out = new PrintWriter("clocktree.out");

        int N = s.nextInt();
        
        int[] x = new int[N];
        for (int i = 0; i < N; i++)
            x[i] = s.nextInt();
        
        nodes = new Node[N];
        for (int i = 0; i < N; i++){
            nodes[i] = new Node(x[i], i);
        }
        
        for (int i = 0; i < N - 1; i++) {
            int a = s.nextInt() - 1,
                b = s.nextInt() - 1;
            
            nodes[a].addConnection(nodes[b]);
            nodes[b].addConnection(nodes[a]);
        }
        
        dfs(0, false, -1);

        if ((sumTrue % 12) == (sumFalse % 12))
            out.println(N);
        else if((sumFalse + 1) % 12 == sumTrue % 12)
            out.println(numTrue);
        else if((sumTrue + 1) % 12 == sumFalse % 12)
            out.println(numFalse);
        else 
            out.println(0);
        
        out.close();
    }
}