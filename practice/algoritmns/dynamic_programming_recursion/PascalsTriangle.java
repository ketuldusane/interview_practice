import java.util.ArrayList;
import java.util.List;

class PascalsTriangle {
  public List<List<Integer>> generate(int n) {
    if (n < 0 || n == 0) return null;

    List<List<Integer>> pascalsL = new ArrayList<List<Integer>>();
    for (int i = 0; i < n; i++) {
      List<Integer> l = new ArrayList<>();
      for (int j = 0; j < (i + 1); j++) {
        if (j == 0 || j == i) {
          l.add(1);
        } else {
          int val = pascalsL.get(i - 1).get(j - 1) + pascalsL.get(i - 1).get(j);
          l.add(val);
        }
      }
      pascalsL.add(l);
    }
    return pascalsL;
  }

  public List<Integer> getRow(int rowIndex) {
    List<Integer> currRow = new ArrayList<>();
    List<Integer> prevRow = new ArrayList<>();      
    
    if (rowIndex <= 0 || rowIndex > 33) return currRow;
    
    for (int i = 0; i <= rowIndex; i++) {
      for (int j = 0; j < (i + 1); j++) {
        if (i == j || j == 0) {
          currRow.add(1);
        } else {
          int val = prevRow.get(j - 1) + prevRow.get(j);
          currRow.add(val);
        }
      }
      
      if (i == rowIndex) {
        break;
      }
      
      prevRow = currRow;
      currRow = new ArrayList<>();
    }

    return currRow;
  }

  public static void main(String[] args) {
    PascalsTriangle p = new PascalsTriangle();
    System.out.println(p.getRow(5));
  }
}