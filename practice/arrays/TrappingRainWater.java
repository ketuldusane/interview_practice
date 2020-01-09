package arrays;

/**
 * Trapping Rain Water
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
 * (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */

public class TrappingRainWater {
  public int trap(int[] height) {
    int[] a = new int[height.length];
    int[] b = new int[height.length];

    int amax = 0, bmax = 0;
    for (int i = 0, j = a.length - 1; i < a.length; i++, j--) {
      amax = Math.max(amax, height[i]);
      a[i] = Math.abs(height[i] - amax);

      bmax = Math.max(bmax, height[j]);
      b[j] = Math.abs(height[j] - bmax);
    }

    int ans = 0;
    for (int i = 0; i < a.length; i++) {
      ans += Math.min(a[i], b[i]);
    }

    return ans;
  }
}
