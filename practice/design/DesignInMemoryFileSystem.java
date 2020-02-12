package design;

import java.util.*;

/**
 * Design In-Memory File System
 *
 * Design an in-memory file system to simulate the following functions:
 *
 * ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is
 * a directory path, return the list of file and directory names in this directory. Your output (file and directory
 * names together) should in lexicographic order.
 *
 * mkdir: Given a directory path that does not exist, you should make new directory according to the path. If the middle
 * directories in the path don't exist either, you should create them as well. This function has void return type.
 *
 * addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create
 * that file containing given content. If the file already exists, you need to append given content to original content.
 * This function has void return type.
 *
 * readContentFromFile: Given a file path, return its content in string format.
 *
 * Example:
 *
 * Input:
 * ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 *
 * Output:
 * [null,[],null,null,["a"],"hello"]
 *
 * Explanation:
 * filesystem
 *
 * Note:
 *
 * You can assume all file or directory paths are absolute paths which begin with / and do not end with / except that
 * the path is just "/".
 * You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file
 * content or list a directory or file that does not exist.
 * You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in
 * the same directory.
 */

public class DesignInMemoryFileSystem {
  private Node root;

  public DesignInMemoryFileSystem() {
    root = new Node("/");
  }

  public List<String> ls(String path) {
    Set<String> set = new TreeSet<>();
    String[] splitPath = path.split("/");
    Node node = root;
    for (String objectName : splitPath) {
      // if a given objetName is a dir, go to the directory
      // if a given objectName is a file in the current directory, break
      if (objectName.length() != 0) {
        if (node.directories.containsKey(objectName)) {
          node = node.directories.get(objectName);
        } else if (node.files.containsKey(objectName)) {
          set.add(objectName);
          return new ArrayList<>(set);
        } else {
          return new ArrayList<>();
        }
      }
    }
    set.addAll(node.directories.keySet());
    set.addAll(node.files.keySet());
    return new ArrayList<>(set);
  }

  public void mkdir(String path) {
    // Assuming that the path provided is always valid
    // The last node in the path won't be a already existing file in that directory
    // "/a/b/c" -> "", "a", "b", "c"
    String[] splitPath = path.split("/");
    Node node = root;
    for (String objectName : splitPath) {
      if (objectName.length() != 0) {
        // current dir contains this dir
        // or it does not contain this dir, then we create it
        if (!node.directories.containsKey(objectName)) {
          Node newDir = new Node(objectName);
          node.directories.put(objectName, newDir);
        }
        node = node.directories.get(objectName);
      }
    }
  }

  public void addContentToFile(String filePath, String content) {
    // tracerse to the directory tha contains the file
    Node node = getDiretoryContainingFile(filePath);
    // check whether the file exists, it not create it
    String[] splitPath = filePath.split("/");
    String fileName = splitPath[splitPath.length - 1];
    node.files.put(fileName, node.files.getOrDefault(fileName, "") + content);
  }

  public String readContentFromFile(String filePath) {
    Node node = getDiretoryContainingFile(filePath);
    // check whether the file exists, if not create it
    String[] splitPath = filePath.split("/");
    String fileName = splitPath[splitPath.length - 1];
    return node.files.getOrDefault(fileName, "");
  }

  private Node getDiretoryContainingFile(String filePath) {
    String[] splitPath = filePath.split("/");
    Node node = root;
    for (int i = 0; i < splitPath.length - 1; i++) {
      String objectName = splitPath[i];
      if (objectName.length() != 0) {
        if (!node.directories.containsKey(objectName)) {
          node.directories.put(objectName, new Node(objectName));
        }
        node = node.directories.get(objectName);
      }
    }
    return node;
  }

  private static class Node {
    String directoryName;
    Map<String, Node> directories;
    Map<String, String> files;
    Node (String dName) {
      directoryName = dName;
      directories = new HashMap<>();
      files = new HashMap<>();
    }
  }
}
