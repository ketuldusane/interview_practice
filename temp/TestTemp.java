import java.util.*;

class TestTemp {
  public static void main(String[] args) {
    TestTemp t = new TestTemp();
    String b = "hit";
    String e = "cog";
    List<List<String>> ans = t.findLadders(b, e, new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog")));
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList);
    int minLen = bfs(beginWord, endWord, dict);
    List<List<String>> ans = new ArrayList<>();
    List<String> temp = new ArrayList();
    temp.add(beginWord);
    backtrack(ans, temp, endWord, dict, new HashSet<>(), minLen, beginWord);
    return ans;
  }

  private void backtrack(List<List<String>> ans, List<String> temp, String endword, Set<String> dict, Set<String> visited, int len, String next) {
    if (temp.size() > len) {
      return;
    } else if (temp.size() == len) {
      if (next.equals(endword)) {
        ans.add(new ArrayList<>(temp));
        return;
      }
    } else {
      for (String neighbor : getNeighbors(next, dict, visited)) {
        temp.add(neighbor);
        backtrack(ans, temp, endword, dict, visited, len, neighbor);
        temp.remove(neighbor);
      }
    }
  }

  private int bfs(String beginWord, String endWord, Set<String> dict) {
    Set<String> visited = new HashSet<>();
    Deque<String> queue = new ArrayDeque<>();
    queue.offer(beginWord);
    int ladder = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String temp = queue.poll();
        if (temp.equals(endWord)) {
          return ladder;
        }
        for (String neighbor : getNeighbors(temp, dict, visited)) {
          queue.offer(neighbor);
        }
      }
      ladder++;
    }
    return -1;
  }

  private List<String> getNeighbors(String word, Set<String> dict, Set<String> visited) {
    List<String> neighbors = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
      char[] w = word.toCharArray();
      for (char c = 'a'; c <= 'z'; c++) {
        if (w[i] == c) {
          continue;
        }
        w[i] = c;
        String temp = new String(w);
        if (dict.contains(temp) && !visited.contains(temp)) {
          neighbors.add(temp);
        }
      }
    }
    return neighbors;
  }
}