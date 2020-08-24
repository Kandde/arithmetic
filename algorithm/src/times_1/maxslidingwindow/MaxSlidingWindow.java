package times_1.maxslidingwindow;

import java.util.ArrayDeque;

/**
 * @author zhaohongxin
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            if (i >= k - 1) {
                result[i-k-1] = nums[deque.peek()];
                if (i - deque.peek() > k) {
                    deque.removeFirst();
                }
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pop();
            }
            deque.addLast(i);
        }
        return result;
    }
}
