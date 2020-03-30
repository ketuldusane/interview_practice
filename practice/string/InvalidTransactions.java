package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Invalid Transactions
 * <p>
 * A transaction is possibly invalid if:
 * <p>
 * the amount exceeds $1000, or;
 * if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
 * Each transaction string transactions[i] consists of comma separated values representing the name, time (in minutes),
 * amount, and city of the transaction.
 * <p>
 * Given a list of transactions, return a list of transactions that are possibly invalid.  You may return the answer in
 * any order.
 * <p>
 * Example 1:
 * Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * Output: ["alice,20,800,mtv","alice,50,100,beijing"]
 * Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60
 * minutes, have the same name and is in a different city. Similarly the second one is invalid too.
 * <p>
 * Example 2:
 * Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * Output: ["alice,50,1200,mtv"]
 * <p>
 * Example 3:
 * Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * Output: ["bob,50,1200,mtv"]
 * <p>
 * Constraints:
 * transactions.length <= 1000
 * Each transactions[i] takes the form "{name},{time},{amount},{city}"
 * Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
 * Each {time} consist of digits, and represent an integer between 0 and 1000.
 * Each {amount} consist of digits, and represent an integer between 0 and 2000.
 */

public class InvalidTransactions {
  public List<String> invalidTransactions(String[] transactions) {
    List<String> ans = new ArrayList<>();
    Map<String, List<Transaction>> map = groupByName(transactions);

    for (String name : map.keySet()) {
      List<Transaction> list = map.get(name);

      for (int i = 0; i < list.size(); i++) {
        if (invalid(list, list.get(i))) {
          ans.add(list.get(i).toString());
        }
      }
    }

    return ans;
  }

  private boolean invalid(List<Transaction> list, Transaction t) {
    if (t.val > 1000) {
      return true;
    }
    for (Transaction o : list) {
      if (o == t) {
        continue;
      }

      if (Math.abs(o.time - t.time) <= 60 && !o.loc.equals(t.loc)) {
        return true;
      }
    }
    return false;
  }

  private Map<String, List<Transaction>> groupByName(String[] transactions) {
    Map<String, List<Transaction>> map = new HashMap<>();
    for (String t : transactions) {
      Transaction tran = new Transaction(t);
      if (!map.containsKey(tran.name)) {
        map.put(tran.name, new ArrayList<>());
      }
      map.get(tran.name).add(tran);
    }
    return map;
  }

  private static class Transaction {
    String str;
    String name;
    int time;
    int val;
    String loc;

    Transaction(String str) {
      this.str = str;
      String[] t = str.split(",");
      name = t[0];
      time = Integer.parseInt(t[1]);
      val = Integer.parseInt(t[2]);
      loc = t[3];
    }

    @Override
    public String toString() {
      return str;
    }
  }

  /*
  // Slow Solution
  public List<String> invalidTransactions(String[] transactions) {
    List<String> ans = new ArrayList<>();
    boolean[] fraud = new boolean[transactions.length];
    for (int i = 0; i < transactions.length; i++) {
      String[] transaction = transactions[i].split(",");

      if (Integer.parseInt(transaction[2]) > 1000) {
        fraud[i] = true;
      }

      for (int j = i + 1; j < transactions.length; j++) {
        String[] nextTran = transactions[j].split(",");
        if (Math.abs(Integer.parseInt(nextTran[1]) - Integer.parseInt(transaction[1])) <= 60
            && nextTran[0].equals(transaction[0])
            && !nextTran[3].equals(transaction[3])) {
          fraud[i] = true;
          fraud[j] = true;
        }
      }
    }

    for (int i = 0; i < transactions.length; i++) {
      if (fraud[i]) {
        ans.add(transactions[i]);
      }
    }

    return ans;
  }
  */
}
