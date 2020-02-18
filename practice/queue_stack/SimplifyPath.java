package queue_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Simplify Path
 * <p>
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * <p>
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the
 * directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
 * <p>
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single
 * slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the
 * canonical path must be the shortest string representing the absolute path.
 * <p>
 * Example 1:
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * <p>
 * Example 2:
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go
 * <p>
 * Example 3:
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * <p>
 * Example 4:
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * <p>
 * Example 5:
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * <p>
 * Example 6:
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 */

public class SimplifyPath {
  public String simplifyPath(String path) {
    /*
      Special characters in path:
      /: dir change
        stack empty? it is root
        stack.peek() == '/' continue
        / is the last character of the path continue
      .: current contents of dir
        . continue
      ..: go up one level
        stack.size() == 1: continue
        pop / and pop dir

      Parsing of dir name:
        maintain a sb and keep on appending if dir is a character
    */
    Deque<String> stack = new ArrayDeque<>();
    Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
    for (String dir : path.split("/")) {
      if (dir.equals("..") && !stack.isEmpty()) {
        stack.pop();
      } else if (!skip.contains(dir)) {
        stack.push(dir);
      }
    }
    StringBuilder ans = new StringBuilder();
    for (String dir : stack) {
      ans.insert(0, "/" + dir);
    }
    return (ans.length() == 0) ? "/" : ans.toString();
  }
}
