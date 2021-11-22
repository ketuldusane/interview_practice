import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class meanmode {
    public static float[] meanAndMaxMode(float[] inputArr) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Map<Float, Integer> map = new HashMap<>();
        float runningSum = 0;
        int maxFrequency = Integer.MIN_VALUE;
        for (float num : inputArr) {
            int frequency = map.getOrDefault(num, 0);
            frequency++;
            map.put(num, frequency);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
            runningSum += num;
        }

        // we run through the map again to check if more than 1 number has the same frequency
        List<Float> maxFrequencyNumbers = new ArrayList<>();
        for (float num : map.keySet()) {
            if (map.get(num) == maxFrequency) {
                maxFrequencyNumbers.add(num);
            }
        }
        Collections.sort(maxFrequencyNumbers);

        float mean = runningSum / inputArr.length;
        float mode = maxFrequencyNumbers.get(0);

        return new float[]{
                Float.parseFloat(decimalFormat.format(mean)),
                Float.parseFloat(decimalFormat.format(mode))};
    }
}