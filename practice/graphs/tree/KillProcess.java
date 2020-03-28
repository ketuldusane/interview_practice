package graphs.tree;

import java.util.*;

/**
 * Kill Process
 * <p>
 * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
 * Each process only has one parent process, but may have one or more children processes. This is just like a tree
 * structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be
 * distinct positive integers.
 * <p>
 * We use two list of integers to represent a list of processes, where the first list contains PID for each process and
 * the second list contains the corresponding PPID.
 * <p>
 * Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that
 * will be killed in the end. You should assume that when a process is killed, all its children processes will be
 * killed. No order is required for the final answer.
 * <p>
 * Example 1:
 * Input:
 * pid =  [1, 3, 10, 5]
 * ppid = [3, 0, 5, 3]
 * kill = 5
 * Output: [5,10]
 * Explanation:
 * 3
 * /   \
 * 1     5
 * /
 * 10
 * Kill 5 will also kill 10.
 * Note:
 * The given kill id is guaranteed to be one of the given PIDs.
 * n >= 1.
 */

public class KillProcess {
  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < pid.size(); i++) {
      int process = pid.get(i);
      int parent = ppid.get(i);

      Set<Integer> set = map.getOrDefault(parent, new HashSet<>());
      set.add(process);

      map.put(parent, set);
    }

    if (!map.containsKey(kill)) {
      return new ArrayList<>(Arrays.asList(kill));
    }

    List<Integer> ans = new ArrayList<>();
    ans.add(kill);
    getKilledProcesses(map, ans, kill);
    return ans;
  }

  private void getKilledProcesses(Map<Integer, Set<Integer>> map, List<Integer> ans, int kill) {
    if (map.containsKey(kill)) {
      Set<Integer> set = map.get(kill);
      for (int i : set) {
        ans.add(i);
        getKilledProcesses(map, ans, i);
      }
    }
  }
}
