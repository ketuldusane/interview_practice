package algorithmns.traversal;

import java.util.*;

/**
 * Word Ladder II
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s)
 * from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: []
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class WordLadderII {
  public static void main(String[] args) {
    WordLadderII w = new WordLadderII();
    String s = "hit";
    String e = "cog";
    List<List<String>> ans = w.findLadders(s, e, Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    for (List<String> l : ans) {
      System.out.println(l);
    }
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList);
    List<List<String>> ans = new ArrayList<>();
    if (!dict.contains(endWord)) {
      return ans;
    }

    Map<String, List<String>> children = new HashMap<>();
    Map<String, Integer> distance = new HashMap<>();
    List<String> temp = new ArrayList<>();

    dict.add(beginWord);
    bfs(beginWord, endWord, dict, children, distance);
    dfs(ans, dict, temp, beginWord, endWord, children, distance);

    return ans;
  }

  private void dfs(List<List<String>> ans, Set<String> dict, List<String> temp, String next, String endWord, Map<String, List<String>> children, Map<String, Integer> distance) {
    temp.add(next);
    if (endWord.equals(next)) {
      ans.add(new ArrayList<>(temp));
    } else {
      for (String neighbor : children.get(next)) {
        if (distance.get(neighbor) == (distance.get(next) + 1)) {
          dfs(ans, dict, temp, neighbor, endWord, children, distance);
        }
      }
    }
    temp.remove(temp.size() - 1);
  }

  private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> children, Map<String, Integer> distance) {
    // Find neighbors for all words in dictionary
    for (String word : dict) {
      children.put(word, new ArrayList<>());
    }

    Deque<String> queue = new ArrayDeque<>();
    queue.offer(beginWord);
    distance.put(beginWord, 0);

    while (!queue.isEmpty()) {
      int size = queue.size();
      boolean found = false;

      for (int i = 0; i < size; i++) {
        String word = queue.poll();
        int currDistance = distance.get(word);
        List<String> neighbors = getNeighbors(word, dict);

        for (String neighbor : neighbors) {
          children.get(word).add(neighbor);
          if (!distance.containsKey(neighbor)) {
            distance.put(neighbor, currDistance + 1);
            if (endWord.equals(neighbor)) {
              found = true;
            } else {
              queue.offer(neighbor);
            }
          }
        }
      }

      if (found) {
        break;
      }
    }
  }

  private List<String> getNeighbors(String word, Set<String> dict) {
    List<String> ans = new ArrayList<>();
    char[] wordArr = word.toCharArray();

    for (char ch = 'a'; ch <= 'z'; ch++) {
      for (int i = 0; i < wordArr.length; i++) {
        if (wordArr[i] == ch) {
          continue;
        }
        char oldChar = wordArr[i];
        wordArr[i] = ch;
        if (dict.contains(String.valueOf(wordArr))) {
          ans.add(String.valueOf(wordArr));
        }
        wordArr[i] = oldChar;
      }
    }
    return ans;
  }
}
