package amazon.online_assesment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Search Suggestions System
 * <p>
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 * <p>
 * Return list of lists of the suggested products after each character of searchWord is typed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 * Example 2:
 * <p>
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * Example 3:
 * <p>
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * Example 4:
 * <p>
 * Input: products = ["havana"], searchWord = "tatiana"
 * Output: [[],[],[],[],[],[],[]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= products.length <= 1000
 * There are no repeated elements in products.
 * 1 <= Σ products[i].length <= 2 * 10^4
 * All characters of products[i] are lower-case English letters.
 * 1 <= searchWord.length <= 1000
 * All characters of searchWord are lower-case English letters.
 */

public class SearchSuggestionsSystem {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    if (products == null || products.length == 0) {
      return new ArrayList<>();
    }

    return getSuggestions(products, searchWord);
  }

  private List<List<String>> getSuggestions(String[] products, String searchWord) {
    List<List<String>> suggestions = new ArrayList<>();
    Trie trie = build(products);

    for (int i = 0; i < searchWord.length(); i++) {
      trie = trie.nodes[searchWord.charAt(i) - 'a'];
      if (trie == null) {
        for (int k = i; k < searchWord.length(); k++) {
          suggestions.add(Collections.EMPTY_LIST);
        }
        break;
      }
      suggestions.add(trie.products);
    }

    return suggestions;
  }

  private Trie build(String[] products) {
    Arrays.sort(products);
    Trie trie = new Trie();

    for (String product : products) {
      Trie t = trie;
      for (char c : product.toCharArray()) {
        int i = c - 'a';
        if (t.nodes[i] == null) {
          t.nodes[i] = new Trie();
        }
        t = t.nodes[i];
        if (t.products.size() < 3) {
          t.products.add(product);
        }
      }
    }

    return trie;
  }

  class Trie {
    Trie[] nodes;
    List<String> products;

    Trie() {
      nodes = new Trie[26];
      products = new ArrayList<>();
    }
  }
}
