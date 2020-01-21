package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UltraArrow {
  private static int score(List<String> giftOpenOrdering) {
    Map<String, Integer> countMap = new HashMap<>();
    int score = 0;

    for (String name : giftOpenOrdering) {
      countMap.putIfAbsent(name, 0);
    }

    int i = 1;
    for (String name : giftOpenOrdering) {
      score += Math.pow(i - countMap.get(name) - 1, 2);
      countMap.put(name, i);
      i++;
    }

    int size = giftOpenOrdering.size();
    for (String name : countMap.keySet()) {
      score += Math.pow(size - countMap.get(name), 2);
    }

    return score;
  }

  private static List<String> generateSchedule(Map<String, Integer> numOfGifts) {
    return new ArrayList<>();
  }

  public static void main(String[] args) {
    List<String> names = new ArrayList<>();
    names.add("Bob");
    names.add("Alice");
    names.add("Bob");
    names.add("Charlie");
    names.add("Darren");
    System.out.println(score(names));
  }
}
