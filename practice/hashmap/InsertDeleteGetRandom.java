package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Insert Delete GetRandom O(1)
 Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 Example:

 // Init an empty set.
 RandomizedSet randomSet = new RandomizedSet();

 // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 randomSet.insert(1);

 // Returns false as 2 does not exist in the set.
 randomSet.remove(2);

 // Inserts 2 to the set, returns true. Set now contains [1,2].
 randomSet.insert(2);

 // getRandom should return either 1 or 2 randomly.
 randomSet.getRandom();

 // Removes 1 from the set, returns true. Set now contains [2].
 randomSet.remove(1);

 // 2 was already in the set, so return false.
 randomSet.insert(2);

 // Since 2 is the only number in the set, getRandom always return 2.
 randomSet.getRandom();
 */

public class InsertDeleteGetRandom {
  Map<Integer, Integer> map;
  List<Integer> list;
  Random random;
  int index = 0;

  public static void main(String[] args) {
    String[] cmds = new String[]{
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert","insert",
        "insert","insert","insert","insert","insert","insert","insert","insert","getRandom","getRandom","getRandom",
        "getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom",
        "getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom",
        "getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom",
        "getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom",
        "getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom",
        "getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom",
        "getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom",
        "getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom",
        "getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom",
        "getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom",
        "getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove","remove",
        "remove","remove","remove","remove","remove"};

    int[] vals = new int[]{
        1000000000,1000000001,1000000002,1000000003,1000000004,1000000005,1000000006,1000000007,1000000008,1000000009,
        1000000010,1000000011,1000000012,1000000013,1000000014,1000000015,1000000016,1000000017,1000000018,1000000019,
        1000000020,1000000021,1000000022,1000000023,1000000024,1000000025,1000000026,1000000027,1000000028,1000000029,
        1000000030,1000000031,1000000032,1000000033,1000000034,1000000035,1000000036,1000000037,1000000038,1000000039,
        1000000040,1000000041,1000000042,1000000043,1000000044,1000000045,1000000046,1000000047,1000000048,1000000049,
        1000000050,1000000051,1000000052,1000000053,1000000054,1000000055,1000000056,1000000057,1000000058,1000000059,
        1000000060,1000000061,1000000062,1000000063,1000000064,1000000065,1000000066,1000000067,1000000068,1000000069,
        1000000070,1000000071,1000000072,1000000073,1000000074,1000000075,1000000076,1000000077,1000000078,1000000079,
        1000000080,1000000081,1000000082,1000000083,1000000084,1000000085,1000000086,1000000087,1000000088,1000000089,
        1000000090,1000000091,1000000092,1000000093,1000000094,1000000095,1000000096,1000000097,1000000098,1000000099,
        -1000000000,-1000000001,-1000000002,-1000000003,-1000000004,-1000000005,-1000000006,-1000000007,-1000000008,
        -1000000009,-1000000010,-1000000011,-1000000012,-1000000013,-1000000014,-1000000015,-1000000016,-1000000017,
        -1000000018,-1000000019,-1000000020,-1000000021,-1000000022,-1000000023,-1000000024,-1000000025,-1000000026,
        -1000000027,-1000000028,-1000000029,-1000000030,-1000000031,-1000000032,-1000000033,-1000000034,-1000000035,
        -1000000036,-1000000037,-1000000038,-1000000039,-1000000040,-1000000041,-1000000042,-1000000043,-1000000044,
        -1000000045,-1000000046,-1000000047,-1000000048,-1000000049,-1000000050,-1000000051,-1000000052,-1000000053,
        -1000000054,-1000000055,-1000000056,-1000000057,-1000000058,-1000000059,-1000000060,-1000000061,-1000000062,
        -1000000063,-1000000064,-1000000065,-1000000066,-1000000067,-1000000068,-1000000069,-1000000070,-1000000071,
        -1000000072,-1000000073,-1000000074,-1000000075,-1000000076,-1000000077,-1000000078,-1000000079,-1000000080,
        -1000000081,-1000000082,-1000000083,-1000000084,-1000000085,-1000000086,-1000000087,-1000000088,-1000000089,
        -1000000090,-1000000091,-1000000092,-1000000093,-1000000094,-1000000095,-1000000096,-1000000097,-1000000098,
        -1000000099,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
        0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1000000000,
        1000000001,1000000002,1000000003,1000000004,1000000005,1000000006,1000000007,1000000008,1000000009,1000000010,
        1000000011,1000000012,1000000013,1000000014,1000000015,1000000016,1000000017,1000000018,1000000019,1000000020,
        1000000021,1000000022,1000000023,1000000024,1000000025,1000000026,1000000027,1000000028,1000000029,1000000030,
        1000000031,1000000032,1000000033,1000000034,1000000035,1000000036,1000000037,1000000038,1000000039,1000000040,
        1000000041,1000000042,1000000043,1000000044,1000000045,1000000046,1000000047,1000000048,1000000049,1000000050,
        1000000051,1000000052,1000000053,1000000054,1000000055,1000000056,1000000057,1000000058,1000000059,1000000060,
        1000000061,1000000062,1000000063,1000000064,1000000065,1000000066,1000000067,1000000068,1000000069,1000000070,
        1000000071,1000000072,1000000073,1000000074,1000000075,1000000076,1000000077,1000000078,1000000079,1000000080,
        1000000081,1000000082,1000000083,1000000084,1000000085,1000000086,1000000087,1000000088,1000000089,1000000090,
        1000000091,1000000092,1000000093,1000000094,1000000095,1000000096,1000000097,1000000098,1000000099,-1000000000,
        -1000000001,-1000000002,-1000000003,-1000000004,-1000000005,-1000000006,-1000000007,-1000000008,-1000000009,
        -1000000010,-1000000011,-1000000012,-1000000013,-1000000014,-1000000015,-1000000016,-1000000017,-1000000018,
        -1000000019,-1000000020,-1000000021,-1000000022,-1000000023,-1000000024,-1000000025,-1000000026,-1000000027,
        -1000000028,-1000000029,-1000000030,-1000000031,-1000000032,-1000000033,-1000000034,-1000000035,-1000000036,
        -1000000037,-1000000038,-1000000039,-1000000040,-1000000041,-1000000042,-1000000043,-1000000044,-1000000045,
        -1000000046,-1000000047,-1000000048,-1000000049,-1000000050,-1000000051,-1000000052,-1000000053,-1000000054,
        -1000000055,-1000000056,-1000000057,-1000000058,-1000000059,-1000000060,-1000000061,-1000000062,-1000000063,
        -1000000064,-1000000065,-1000000066,-1000000067,-1000000068,-1000000069,-1000000070,-1000000071,-1000000072,
        -1000000073,-1000000074,-1000000075,-1000000076,-1000000077,-1000000078,-1000000079,-1000000080,-1000000081,
        -1000000082,-1000000083,-1000000084,-1000000085,-1000000086,-1000000087,-1000000088,-1000000089,-1000000090,
        -1000000091,-1000000092,-1000000093,-1000000094,-1000000095,-1000000096,-1000000097,-1000000098,-1000000099
    };

    InsertDeleteGetRandom insertDeleteGetRandom = new InsertDeleteGetRandom();
    for (int i = 0; i < cmds.length; i++) {
      if (i == 399) {
        System.out.println();
      }
      switch (cmds[i]) {
        case "insert":
          boolean ins = insertDeleteGetRandom.insert(vals[i]);
          break;
        case "getRandom":
          int rand = insertDeleteGetRandom.getRandom();
          break;
        case "remove":
          boolean rem = insertDeleteGetRandom.remove(vals[i]);
          break;
      }
    }
  }

  /** Initialize your data structure here. */
  public InsertDeleteGetRandom() {
    map = new HashMap<>();
    list = new ArrayList<>();
    random = new Random();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (map.containsKey(val)) return false;
    map.put(val, index);
    list.add(index, val);
    index++;
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (!map.containsKey(val)) return false;
    int idx = map.get(val);
    int lastVal = list.get(list.size() - 1);
    if (lastVal != val) {
      map.put(lastVal, idx);
      list.set(idx, lastVal);
    }
    map.remove(val);
    list.remove(index - 1);
    index--;
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return list.get(random.nextInt(list.size()));
  }
}
