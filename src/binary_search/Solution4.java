package binary_search;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * @author: Yidan
 * @create: 2023-10-24 01:02
 **/

public class Solution4 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int index1 = 0;
    int index2 = 0;
    int left = 0;
    int right = 0;
    int mid = (nums1.length + nums2.length) / 2;
    int index = 0;
    while (index1 < nums1.length && index2 < nums2.length) {
      if (nums1[index1] < nums2[index2]) {
        if (index == mid - 1) {
          left = nums1[index1];
        }
        if (index == mid) {
          right = nums1[index1];
        }
        index++;
        index1++;
      } else if (nums1[index1] > nums2[index2]) {
        if (index == mid - 1) {
          left = nums2[index2];
        }
        if (index == mid) {
          right = nums2[index2];
        }
        index++;
        index2++;
      } else {
        if (index == mid - 1) {
          left = nums1[index1];
        }
        if (index == mid) {
          right = nums1[index1];
        }
        index++;
        index1++;

        if (index == mid - 1) {
          left = nums2[index2];
        }
        if (index == mid) {
          right = nums2[index2];
        }
        index++;
        index2++;
      }
    }
    while (index1 < nums1.length) {
      if (index == mid - 1) {
        left = nums1[index1];
      }
      if (index == mid) {
        right = nums1[index1];
      }
      index++;
      index1++;
    }
    while (index2 < nums2.length) {
      if (index == mid - 1) {
        left = nums2[index2];
      }
      if (index == mid) {
        right = nums2[index2];
      }
      index++;
      index2++;
    }
    if ((nums1.length + nums2.length) % 2 == 0) {
      return (left + right) * 1.0 / 2;
    } else {
      return right;
    }
  }
}