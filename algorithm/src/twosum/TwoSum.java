package twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaohongxin
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(32);
        for(int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i ++) {
            int tmpTarget = target - nums[i];
            if (map.containsKey(tmpTarget) && map.get(tmpTarget) != i) {
                return new int[] {i, map.get(tmpTarget)};
            }
        }
        return null;
    }

}
