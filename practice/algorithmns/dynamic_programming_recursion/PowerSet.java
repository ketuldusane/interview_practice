package algorithmns.dynamic_programming_recursion;

import java.util.ArrayList;

class PowerSet {
  ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
    ArrayList<ArrayList<Integer>> allSets;

    if (set.size() == index) {
      allSets = new ArrayList<ArrayList<Integer>>();
      allSets.add(new ArrayList<Integer>());
    } else {
      allSets = getSubsets(set, index + 1);
      int item = set.get(index);

      ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
      for (ArrayList<Integer> subSet : allSets) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.addAll(subSet);
        temp.add(item);
        a.add(temp);
      }
      allSets.addAll(a);
    }

    return allSets;
  }
}
