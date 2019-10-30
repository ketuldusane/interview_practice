class MagicIndex {
  int magicIndex(int[] a) {
    return magicIndex(a, 0, a.length - 1);
  }

  int magicIndex(int[] a, int start, int end) {
    if (end < start) return -1;
    int mid = (start + end) / 2;
    if (a[mid] == mid) {
      return mid;
    }
    // search left
    int leftIndex = Math.min(mid - 1, a[mid]);
    int left = magicIndex(a, start, leftIndex);
    if (left >= 0) return left;
    
    // search right
    int rightIndex = Math.max(mid + 1, a[mid]);
    int right = magicIndex(a, rightIndex, end);
    return right;
  }

  public static void main(String[] args) {
    int[] a = new int[] {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};

    MagicIndex m = new MagicIndex();
    System.out.println(m.magicIndex(a));
  }
}