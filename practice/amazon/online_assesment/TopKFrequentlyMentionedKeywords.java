package amazon.online_assesment;

import java.util.*;

/**
 * Top K Frequently Mentioned Keywords
 * <p>
 * AMAZON Online Assesment
 * <p>
 * Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to
 * least frequently mentioned.
 * <p>
 * The comparison of strings is case-insensitive. If keywords are mentioned an equal number of times in reviews, sort
 * alphabetically.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * k = 2
 * keywords = ["anacell", "cetracular", "betacellular"]
 * reviews = [
 * "Anacell provides the best services in the city",
 * "betacellular has awesome services",
 * "Best services provided by anacell, everyone should use anacell",
 * ]
 * <p>
 * Output:
 * ["anacell", "betacellular"]
 * <p>
 * Explanation:
 * "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
 * Example 2:
 * <p>
 * Input:
 * k = 2
 * keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
 * reviews = [
 * "I love anacell Best services; Best services provided by anacell",
 * "betacellular has great services",
 * "deltacellular provides much better services than betacellular",
 * "cetracular is worse than anacell",
 * "Betacellular is better than deltacellular.",
 * ]
 * <p>
 * Output:
 * ["betacellular", "anacell"]
 * <p>
 * Explanation:
 * "betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but
 * "anacell" is lexicographically smaller.
 */

public class TopKFrequentlyMentionedKeywords {
  public static void main(String[] args) {
    TopKFrequentlyMentionedKeywords t = new TopKFrequentlyMentionedKeywords();
    List<String> keywords = Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell");
    List<String> reviews = Arrays.asList("I love anacell Best services; Best services provided by anacell",
        "betacellular has great services",
        "deltacellular provides much better services than betacellular",
        "cetracular is worse than anacell",
        "Betacellular is better than deltacellular.");
    System.out.println(t.mostPopularKeywords(keywords, reviews, 2));
  }

  public List<String> mostPopularKeywords(List<String> keywords, List<String> reviews, int k) {
    if (k < 1) {
      return new ArrayList<>();
    }

    Map<String, Integer> keywordFrequency = getKeywordsAndTheirFrequency(new HashSet<>(keywords), reviews);
    PriorityQueue<String> queue = new PriorityQueue<>(
        (s1, s2) -> keywordFrequency.get(s1).equals(keywordFrequency.get(s2)) ?
            s2.compareTo(s1) : keywordFrequency.get(s1) - keywordFrequency.get(s2)
    );

    for (String keyword : keywordFrequency.keySet()) {
      queue.offer(keyword);
      if (queue.size() > k) {
        queue.poll();
      }
    }

    List<String> ans = new ArrayList<>();
    while (!queue.isEmpty()) {
      ans.add(0, queue.poll());
    }

    return ans;
  }

  private Map<String, Integer> getKeywordsAndTheirFrequency(Set<String> keywords, List<String> reviews) {
    Map<String, Integer> keywordFrequency = new HashMap<>();
    for (String review : reviews) {
      String[] r = review.split("\\s+");
      Set<String> visited = new HashSet<>();
      for (String str : r) {
        String s = str.toLowerCase();
        if (!visited.contains(s) && keywords.contains(s)) {
          keywordFrequency.put(s, keywordFrequency.getOrDefault(s, 0) + 1);
          visited.add(s);
        }

      }
    }
    return keywordFrequency;
  }
}
