package queue_stack;

import java.util.Arrays;

/**
 Flood Fill

 An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

 To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

 At the end, return the modified image.

 Example 1:
 Input:
 image = [[1,1,1],[1,1,0],[1,0,1]]
 sr = 1, sc = 1, newColor = 2
 Output: [[2,2,2],[2,2,0],[2,0,1]]
 Explanation:
 From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 by a path of the same color as the starting pixel are colored with the new color.
 Note the bottom corner is not colored 2, because it is not 4-directionally connected
 to the starting pixel.
 Note:

 The length of image and image[0] will be in the range [1, 50].
 The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */

public class FloodFill {
  public static void main(String[] args) {
    int[][] ans= new FloodFill().floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2);
    for (int[] eAns : ans) {
      System.out.println(Arrays.toString(eAns));
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int color = image[sr][sc];
    if (color != newColor) helper(image, sr, sc, color, newColor);
    return image;


/*     Stack<int[]> stack = new Stack<>();
     boolean[][] visited = new boolean[image.length][image[0].length];
     for (int i = 0; i < visited.length; i++) {
       Arrays.fill(visited[i], false);
     }

     int trueColor = image[sr][sc];
     stack.push(new int[]{sr, sc});

     while (!stack.isEmpty()) {
       int[] curr = stack.pop();
       image[curr[0]][curr[1]] = newColor;
       visited[curr[0]][curr[1]] = true;

       if (isValid(curr[0] - 1, curr[1], image) && image[curr[0] - 1][curr[1]] == trueColor && !visited[curr[0] - 1][curr[1]])
         stack.push(new int[]{curr[0] - 1, curr[1]});
       if (isValid(curr[0], curr[1] - 1, image) && image[curr[0]][curr[1] - 1] == trueColor && !visited[curr[0]][curr[1] - 1])
         stack.push(new int[]{curr[0], curr[1] - 1});
       if (isValid(curr[0], curr[1] + 1, image) && image[curr[0]][curr[1] + 1] == trueColor && !visited[curr[0]][curr[1] + 1])
         stack.push(new int[]{curr[0], curr[1] + 1});
       if (isValid(curr[0] + 1, curr[1], image) && image[curr[0] + 1][curr[1]] == trueColor && !visited[curr[0] + 1][curr[1]])
         stack.push(new int[]{curr[0] + 1, curr[1]});
     }
     return image;*/
  }

  private void helper(int[][] image, int r, int c, int tColor, int nColor) {
    if (image[r][c] == tColor) {
      image[r][c] = nColor;
      if (r >= 1) helper(image, r - 1, c, tColor, nColor);
      if (c >= 1) helper(image, r, c - 1, tColor, nColor);
      if (r + 1 < image.length) helper(image, r + 1, c, tColor, nColor);
      if (c + 1 < image[0].length) helper(image, r, c + 1, tColor, nColor);
    }
  }

  private boolean isValid(int i, int j, int[][] image) {
    return (i >= 0 && i < image.length && j >= 0 && j < image[0].length);
  }
}
