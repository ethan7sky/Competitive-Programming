import java.io.*;
import java.util.*;

public class USACOMazeTacToe_solution {
  int nax = (int) (5 * 1e7);
  int n, ans;
  char[][] board = new char[3][3];
  Cell[][] cells;
  boolean[] seen = new boolean[nax];
  boolean[] added = new boolean[nax];
  Map<String, List<int[]>> adj = new HashMap<>();

  int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

  class Cell {
    char symbol;
    int row, col;

    public Cell(char symbol) {
      this.symbol = symbol;
    }

    public Cell(char symbol, int row, int col) {
      this.symbol = symbol;
      this.row = row;
      this.col = col;
    }
    
  }

  boolean isMoo(String s) {
    return s.equals("MOO") || s.equals("OOM");
  }

  boolean isWinning() {
    for (int r = 0, c = 0; r < 3; r++, c++) {
      String row = "" + board[r][0] + board[r][1] + board[r][2];
      String col = "" + board[0][c] + board[1][c] + board[2][c];
      if (isMoo(row) || isMoo(col)) {
        return true;
      }
    }
    String backSlash = "" + board[0][0] + board[1][1] + board[2][2];
    String slash = "" + board[0][2] + board[1][1] + board[2][0];
    return isMoo(backSlash) || isMoo(slash);
  }

  String encode(int r, int c) {
    return r + "," + c;
  }

  int getStatus() {
    int res = 0;
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        int cur = board[r][c] == '.' ? 0 : board[r][c] == 'M' ? 1 : 2;
        res = res * 3 + cur;
      }
    }
    return res;
  }

  int getStatus(int r, int c) {
    int res = getStatus();
    res = res * 25 + r;
    res = res * 25 + c;
    return res;
  }

  void dfs(int r, int c) {
    String key = encode(r, c);
    int stat = getStatus(r, c);
    if (seen[stat])
      return;
    seen[stat] = true;
    if (isWinning()) {
      int board = getStatus();
      if (!added[board]) {
        ans++;
        added[board] = true;
      }
      return;
    }
    Cell cell = cells[r][c];
    boolean makeMove = (cell.symbol == 'O' || cell.symbol == 'M') && board[cell.row][cell.col] == '.';
    if (makeMove) {
      board[cell.row][cell.col] = cell.symbol;
    }
    for (int[] nei : adj.get(key)) {
      dfs(nei[0], nei[1]);
    }
    if (makeMove) {
      board[cell.row][cell.col] = '.';
    }
  }

  void solve() {
    n = io.nextInt();
    ans = 0;
    cells = new Cell[n][n];
    adj = new HashMap<>();
    int startR = 0, startC = 0;
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        board[r][c] = '.';
      }
    }
    for (int r = 0; r < n; r++) {
      String s = io.next();
      for (int i = 0, c = 0; i < s.length(); i += 3, c += 1) {
        char c1 = s.charAt(i), c2 = s.charAt(i + 1), c3 = s.charAt(i + 2);
        if (c1 == '#' || c1 == '.' || c1 == 'B') {
          cells[r][c] = new Cell(c1);
          if (c1 == 'B') {
            startR = r;
            startC = c;
          }
        } else {
          cells[r][c] = new Cell(c1, c2 - '1', c3 - '1');
        }
      }
    }
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        if (cells[r][c].symbol == '.' || cells[r][c].symbol == '#')
          continue;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { r, c });
        String key = encode(r, c);
        adj.put(key, new ArrayList<>());
        Set<String> seen = new HashSet<>();
        while (!queue.isEmpty()) {
          int[] pt = queue.poll();
          for (int[] d : dirs) {
            int dr = pt[0] + d[0], dc = pt[1] + d[1];
            boolean out = dr < 0 || dc < 0 || dr >= n || dc >= n;
            String neiKey = encode(dr, dc);
            if (out || cells[dr][dc].symbol == '#' || seen.contains(neiKey))
              continue;
            seen.add(neiKey);
            if (cells[dr][dc].symbol != '.') {
              adj.get(key).add(new int[] { dr, dc });
            } else {
              queue.add(new int[] { dr, dc });
            }
          }
        }
      }
    }
    System.out.println(adj);
    dfs(startR, startC);
    io.println(ans);
  }

  /* I/O Template */
  static boolean multiple = false;
  static String task = "";
  static Kattio io;

  public static void main(String[] args) throws IOException {
    if (!task.isEmpty()) {
      io = new Kattio(task);
    } else {
      io = new Kattio();
    }
    int t = 1;
    if (multiple) {
      t = io.nextInt();
    }
    for (int i = 0; i < t; i++) {
      new USACOMazeTacToe_solution().solve();
    }
    io.close();
  }

  static class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;

    // standard input
    public Kattio() {
      this(System.in, System.out);
    }

    public Kattio(InputStream i, OutputStream o) {
      super(o);
      r = new BufferedReader(new InputStreamReader(i));
    }

    // USACO-style file input
    public Kattio(String problemName) throws IOException {
      super(problemName + ".out");
      r = new BufferedReader(new FileReader(problemName + ".in"));
    }

    // returns null if no more input
    public String next() {
      try {
        while (st == null || !st.hasMoreTokens())
          st = new StringTokenizer(r.readLine());
        return st.nextToken();
      } catch (Exception e) {
      }
      return null;
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }
  }
}