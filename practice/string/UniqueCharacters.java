import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class UniqueCharacters {
  private String disperse(String input) {
    if (input == null || input.length() == 1) {
      return input;
    }

    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> keys = new ArrayList<>();
    String[] result = new String[input.length()];

    for (int i = 0; i < input.length(); i++) {
      String s = String.valueOf(input.charAt(i));
      if (map.containsKey(s)) {
        map.put(s, map.get(s) + 1);
      } else {
        map.put(s, 1);
      }
    }

    keys.addAll(map.keySet());

    int pointer = 0;
    for (int i = 0; i < input.length(); i++) {
      String element = keys.get(0);
      if (pointer != 0 && element.equals(result[pointer - 1])) {
        return "Not Possible";
      }

      result[pointer] = element;
      map.put(element, map.get(element) - 1);

      if (map.get(element) == 0) {
        map.remove(element);
        keys.remove(element);
      }

      pointer += 2;
      if (pointer >= input.length()) {
        pointer = 1;
      }
    }

    return Arrays.toString(result);
  }

  public static void main(String[] args) {
    UniqueCharacters uc = new UniqueCharacters();
    System.out.println(uc.disperse("aaaabb"));
    System.out.println(uc.disperse("aaabb"));
    System.out.println(uc.disperse("aaaabbcc"));
    System.out.println(uc.disperse("aabbccdef"));
  }
}