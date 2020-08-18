package medianoftwosortedarrays;

/**
 * todo
 *
 * @author zhaohongxin
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        double result = 0;
        double result2;
        int i = 0, j = 0;
        if (size % 2 == 1) {
            while (true) {
                if (i == nums1.length) {
                    return nums2[size/2 - i];
                }
                if (j == nums2.length) {
                    return nums1[size/2 - j];
                }
                if (nums1[i] < nums2[j]) {
                    result = nums2[j];
                    i++;
                } else {
                    result = nums1[i];
                    j++;
                }
                if (i + j == size/2 + 1) {
                    return result;
                }
            }
        }
        if (size % 2 == 0) {
            while (true) {
                if (i == nums1.length) {
                    return (nums2[size/2 - i] + nums2[size/2 + 1 - i])/2;
                }
                if (j == nums2.length) {
                    return (nums2[size/2 - i] + nums2[size/2 + 1 - i])/2;
                }
                if (nums1[i] < nums2[j]) {
                    result2 = result;
                    result = nums2[j];
                    i++;
                } else {
                    result2 = result;
                    result = nums1[i];
                    j++;
                }
                if (i + j == size/2 + 1) {
                    return (result + result2)/2;
                }
            }
        }
        return result;
    }
}
