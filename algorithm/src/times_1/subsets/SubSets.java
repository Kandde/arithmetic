package times_1.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaohongxin
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        subset(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void subset(List<List<Integer>> result, List<Integer> item, int[] nums, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }
        subset(result, item, nums, index + 1);
        item.add(nums[index]);
        subset(result, item, nums, index + 1);

        item.remove(item.size() - 1);
    }
}
