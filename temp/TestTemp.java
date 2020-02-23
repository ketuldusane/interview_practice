import java.util.*;

class TestTemp {
  public static void main(String[] args) {
    String[] words = new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
    int maxWidth = 16;
    List<String> ans = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    int currSize = 0;
    for (int i = 0; i < words.length; i++) {
      if (currSize <= maxWidth) {
        int newSize = currSize + words[i].length();
        if (temp.size() != 0) {
          newSize++;
        }
        if (newSize <= maxWidth) {
          temp.add(words[i]);
          currSize = newSize;
        } else {
          String justified = adjust(temp, currSize - temp.size() + 1, maxWidth);
          ans.add(justified);
          temp.clear();
          temp.add(words[i]);
          currSize = words[i].length();
        }
      }
    }
    ans.add(adjustLast(temp, maxWidth));
  }

  private static String adjust(List<String> temp, int size, int maxSize) {
    StringBuilder sb = new StringBuilder();
    int requiredSpaces = maxSize - size;
    int tempSpace = (requiredSpaces % 2 == 0) ? requiredSpaces : requiredSpaces + 1;
    int tempLoc = ((temp.size() - 1) % 2 == 0) ? temp.size() : temp.size() - 2;
    int factor = tempSpace / tempLoc;
    for (String s : temp) {
      sb.append(s);
      if (requiredSpaces > 0) {
        int k = Math.min(factor, requiredSpaces);
        for (int i = 0; i < k; i++) {
          sb.append(" ");
          requiredSpaces--;
        }
      }
    }
    return sb.toString();
  }

  private static String adjustLast(List<String> temp, int maxSize) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < temp.size(); i++) {
      sb.append(temp.get(i));
      if (i != temp.size() - 1) {
        sb.append(" ");
      }
    }
    int size = sb.length();
    for (int i = 0; i < maxSize - size; i++) {
      sb.append(" ");
    }
    return sb.toString();
  }
}