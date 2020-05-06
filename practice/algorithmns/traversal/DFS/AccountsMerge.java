package algorithmns.traversal.DFS;

import java.util.*;

/**
 * Accounts Merge
 * <p>
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a
 * name, and the rest of the elements are emails representing emails of the account.
 * <p>
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email
 * that is common to both accounts. Note that even if two accounts have the same name, they may belong to different
 * people as people could have the same name. A person can have any number of accounts initially, but all of their
 * accounts definitely have the same name.
 * <p>
 * After merging the accounts, return the accounts in the following format: the first element of each account is the
 * name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 * <p>
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John",
 * "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John",
 * "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John',
 * 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Note:
 * <p>
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 */

public class AccountsMerge {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    if (accounts == null || accounts.size() == 0) {
      return new ArrayList<>();
    }

    Map<String, String> name = new HashMap<>();
    Map<String, Set<String>> emails = new HashMap<>();

    for (List<String> account : accounts) {
      String accName = account.get(0);
      for (int i = 1; i < account.size(); i++) {
        if (!emails.containsKey(account.get(i))) {
          emails.put(account.get(i), new HashSet<>());
        }
        name.put(account.get(i), accName);

        if (i == 1) {
          continue;
        }

        emails.get(account.get(i)).add(account.get(i - 1));
        emails.get(account.get(i - 1)).add(account.get(i));
      }
    }

    Set<String> visited = new HashSet<>();
    List<List<String>> ans = new ArrayList<>();

    for (String email : name.keySet()) {
      if (!visited.contains(email)) {
        List<String> list = new ArrayList<>();
        dfs(emails, email, visited, list);
        Collections.sort(list);
        list.add(0, name.get(email));
        ans.add(list);
      }
    }

    return ans;
  }

  private void dfs(Map<String, Set<String>> emails, String email, Set<String> visited, List<String> list) {
    visited.add(email);
    list.add(email);

    for (String e : emails.get(email)) {
      if (!visited.contains(e)) {
        dfs(emails, e, visited, list);
      }
    }
  }
}
