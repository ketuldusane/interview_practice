package arrays;

import java.util.*;

public class UltraArrow {
  private List<String> schedule;
  private int currScore = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("Alice", 1);
    map.put("Bob", 2);
    map.put("Cheryl", 1);
    map.put("Darrin", 1);
    UltraArrow u = new UltraArrow();
    System.out.println(u.generateSchedule(map) + "  " + u.currScore);
  }

  private int score(List<String> giftOpenOrdering) {
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

  private List<String> generateSchedule(Map<String, Integer> numOfGifts) {
    List<String> names = new ArrayList<>();
    for (String name : numOfGifts.keySet()) {
      for (int i = 0; i < numOfGifts.get(name); i++) {
        names.add(name);
      }
    }
    Collections.sort(names);
    backtrack(names, new ArrayList<>(), new boolean[names.size()]);
    return schedule;
  }

  private void backtrack(List<String> names, List<String> temp, boolean[] visited) {
    if (temp.size() == names.size()) {
      int s = score(temp);
      if (s < currScore) {
        schedule = new ArrayList<>(temp);
        currScore = s;
      }
    } else {
      for (int i = 0; i < names.size(); i++) {
        if (visited[i] || i > 0 && names.get(i).equals(names.get(i - 1)) && !visited[i - 1]) {
          continue;
        }
        temp.add(names.get(i));
        visited[i] = true;
        backtrack(names, temp, visited);
        visited[i] = false;
        temp.remove(temp.size() - 1);
      }
    }
  }
}
