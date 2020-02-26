package algorithmns.binary_search;

/**
 * Koko Eating Bananas
 * <p>
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 * <p>
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * Example 2:
 * <p>
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * Example 3:
 * <p>
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 * <p>
 * Note:
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 */

public class KokoEatingBanana {
  public static void main(String[] args) {
    KokoEatingBanana k = new KokoEatingBanana();
    int[] a = {332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
    int H = 823855818;
    System.out.println(k.minEatingSpeed(a, H));
  }

  public int minEatingSpeed(int[] piles, int H) {
    return search(piles, H, 1, 1_000_000_000);
  }

  private int search(int[] piles, int H, int min, int max) {
    while (min < max) {
      int speed = (min + max) / 2;
      if (!possible(piles, H, speed)) {
        min = speed + 1;
      } else {
        max = speed;
      }
    }
    return min;
  }

  private boolean possible(int[] piles, int H, int speed) {
    int time = 0;
    for (int p : piles) {
      time += (p - 1) / speed + 1;
    }
    return time <= H;
  }
}
