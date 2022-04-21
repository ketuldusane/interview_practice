package udemy;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Truck {

    public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
        long[][] units = new long[boxes.size()][2];
        for (int i = 0; i < boxes.size(); i++) {
            units[i][0] = boxes.get(i);
            units[i][1] = unitsPerBox.get(i);
        }
        PriorityQueue<long[]> queue = new PriorityQueue<>((a, b)-> (int) (b[1] - a[1]));
        queue.addAll(Arrays.asList(units));
        int unitsRequired = 0;

        while (!queue.isEmpty()) {
            long[] top = queue.poll();
            long boxCount = Math.min(truckSize, top[0]);
            unitsRequired += boxCount * top[1];
            truckSize -= boxCount;
            if(truckSize == 0)
                break;
        }
        return unitsRequired;
    }
}
