package easy;
// https://leetcode.com/problems/majority-element/

import java.util.*;
import java.util.stream.Collectors;

public class task169 {
    public int majorityElement(int[] nums) {
        LinkedHashMap<Integer, Integer> map = (LinkedHashMap<Integer, Integer>) sort(init(nums));
        System.out.println(map);
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
        Map.Entry<Integer, Integer> lastEntry = entryList.get(entryList.size() - 1);
        return lastEntry.getKey();
    }

    public static Map<Integer, Integer> init(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            if (map.get(nums[i]) == null)
                map.put(nums[i], cnt);
            else
                map.put(nums[i], map.get(nums[i]) + 1);
        }
        return map;
    }

    public Map<Integer, Integer> sort(Map<Integer, Integer> map) {        // sort Map by value
        Map<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedMap;
    }

    public static void main(String[] args) {
        task169 solution = new task169();
        int[] nums = new int[] {2,2,1,1,1,2,2,3,3,3,3,3,3};
        int result = solution.majorityElement(nums);
        System.out.println(result);
    }
}
