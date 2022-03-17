class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = -10000;
        int end = 10000;
        
//         for(int element : nums) {
//             start = Math.min(start, element);
//             end = Math.max(end, element);
//         }

        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(checkBigEnough(nums, k, mid)) {
                end = mid;
            }else {
                start = mid;
            }
        }
        
        if(!checkBigEnough(nums, k, end)) {
            return end;
        }

        return start;
    }
    
    boolean checkBigEnough(int [] nums, int k, int mid) {
        int count = 0;
        for(int element : nums) {
            if(element >= mid ) {
                count++;
            }
        }
        
        return count < k;
    }
}