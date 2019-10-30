class ZeroMatrix {
  public static void main(String[] args) {
      ZeroMatrix main = new ZeroMatrix();
    int[][] m = {{0}};
    int[][] n;

    n = main.zeroMatrix(m);
    for (int i = 0; i < n.length; i++) {
      for (int j = 0; j < n[0].length; j++) {
        System.out.print(n[i][j] + " ");
      }
      System.out.println();
    }
  }

  int[][] zeroMatrix(int[][] m) {
    if (m.length == 0 || m[0].length == 0) return m;
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        if (m[i][j] == 0) {
          m[0][j] = 0;
          m[i][0] = 0;
        }
      }
    }

    for (int i = 0; i < m.length; i++) {
      if (m[i][0] == 0) {
        for (int j = 1; j < m[0].length; j++) {
          m[i][j] = 0;
        }
      }
    }

    for (int j = 0; j < m[0].length; j++) {
      if (m[0][j] == 0) {
        for (int i = 1; i < m.length; i++) {
          m[i][j] = 0;
        }
      }
    }

    return m;
  }
}