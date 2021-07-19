class Solution {



  public int triangleNumber(int[] nums) {
    int res  = 0;

    Arrays.sort(nums);

    for (int i = 2; i < nums.length; i++) {
      int l = 0, r = i - 1;
      while (l < r) {
        if (nums[l] + nums[r] > nums[i]) {
          ans += (r - l);
          r--;
        }
        else {
          l++;
        }
      }
    }

    return res;
  }
}
