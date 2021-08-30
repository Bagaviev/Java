
// https://leetcode.com/problems/single-number/

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class task136 {
    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null)
                map.put(nums[i], false);
            else
                map.put(nums[i], true);
        }
        return getKeyByValue(map, false);
    }

    public static void main(String[] args) {
        int result = singleNumber(new int[] {6, 8, 8, 6, 1, 1, 7});
        System.out.println(result);
    }
}
