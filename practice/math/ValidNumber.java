package math;

/**
 * Valid Number
 *
 * Validate if a given string can be interpreted as a decimal number.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 *
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before
 * implementing one. However, here is a list of characters that can be in a valid decimal number:
 *
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * Of course, the context of these characters also matters in the input.
 */

public class ValidNumber {
  public boolean isNumber(String s) {
    s = s.trim();
    boolean eFound = false;
    boolean numFound = false;
    boolean numAfterE = false;
    boolean decFound = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        numFound = true;
        numAfterE = true;
      } else if (c == '.') {
        if (eFound || decFound) {
          return false;
        }
        decFound = true;
      } else if (c == 'e') {
        if (eFound || !numFound) {
          return false;
        }
        numAfterE = false;
        eFound = true;
      } else if (c == '-' || c == '+') {
        if (i != 0 && s.charAt(i - 1) != 'e') {
          return false;
        }
      } else {
        return false;
      }
    }
    return numFound && numAfterE;
  }
}
