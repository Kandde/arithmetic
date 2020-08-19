package times_1.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * eg.
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author zhaohongxin
 */
public class TwoSum {

    public int[] solution(int[] nums, int target) {
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
