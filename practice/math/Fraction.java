package math;

public class Fraction {
  public String fractionToDecimal(int numerator, int denominator) {
    if (denominator == 0) return "";

    double ans = numerator / denominator;
    String sAns = Double.toString(ans);

    StringBuilder sb = new StringBuilder();
    System.out.println(sAns);
    sb.append(sAns.split("[.]")[0]);
    sb.append('.');

    char[] c = sAns.split("[.]")[1].toCharArray();
    boolean repeat = false;
    for (int i = 0; i < c.length - 1; i++) {
      if (c[i] == c[i + 1]) {
        repeat = true;
      } else {
        if (repeat) {
          sb.append("(" + c[i] + ")");
          repeat = false;
        } else {
          sb.append(c[i]);
        }
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Fraction c = new Fraction();
    c.fractionToDecimal(1, 2);
  }
}