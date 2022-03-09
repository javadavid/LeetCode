class Solution {
    public int findPeakElement(int[] nums) {
        
        int n = nums.length;
        if(n <= 1) return 0;
        
        int start = 0, end = n - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid + 1]) {
                end = mid;
            }else {
                start = mid;
            }
        }
        
        return nums[start] > nums[end] ? start : end;
    }
}




//          p
//             mid            
//                 mid + 1
// -∞                              -∞

// ---------------------------------------------
//                          p
//                 mid + 1
//            mid                 
// -∞                              -∞