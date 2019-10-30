import java.util.Arrays;

class KnightTour {
  int N;
  public static void main(String[] args) {
    KnightTour knightTour = new KnightTour();
    knightTour.N = 8;
    knightTour.solveKT();
  }

  private boolean solveKT() {
    int chessBoard[][] = new int[N][N];

    for (int i = 0; i < N; i++) {
      Arrays.fill(chessBoard[i], -1);
    }

    int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
    int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

    chessBoard[0][0] = 0;

    if (!solveKTUtil(0, 0, 1, chessBoard, xMove, yMove)) {
      System.out.println("no solution");
      return false;
    }

    printSolution(chessBoard); // Implement
    return true;
  }

  private boolean solveKTUtil(int x, int y, int move, int[][] chessBoard,
    int[] xMove, int[] yMove) {
    int next_x;
    int next_y;

    if (move == N * N) {
      return true;
    }

    for (int k = 0; k < N; k++) {
      next_x = x + xMove[k];
      next_y = y + yMove[k];

      if (isSafe(next_x, next_y, chessBoard)) {
        chessBoard[next_x][next_y] = move;
        if (solveKTUtil(next_x, next_y, move + 1, chessBoard, xMove, yMove)) {
          return true;
        } else {
          chessBoard[next_x][next_y] = -1;
        }
      }
    }
    return false;
  }

  private boolean isSafe(int x, int y, int[][] chessBoard) {
    return (x >= 0 && x < N && y >= 0 && y < N && chessBoard[x][y] == -1);
  }

  private void printSolution(int[][] chessBoard) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(chessBoard[i][j] + " ");
      }
      System.out.println();
    }
  }
}