class Solution {
    public int search(int[] nums, int target) {
        int start = 0; int end = nums.length -1;
        
        while(start + 1 < end) {
            
            int mid = start + (end - start) / 2;
             
            
            if(nums[mid] == target) {
                return mid;
            }            
            
            if(nums[mid] > nums[end] && target > nums[end]) {
             
                if(nums[mid] < target) {
                    start = mid;
                }else {
                    end = mid;
                }
                continue;
            }
            
            
            if(nums[mid] < nums[end] && target < nums[end]) {
                
                if(nums[mid] < target) {
                    start = mid;
                }else {
                     
                    end = mid;
                }   
                 continue;
            }
         
            if(nums[mid] >= nums[end] && target <= nums[end]) {             
                start = mid;   
                 continue;
            }
            
            if(nums[mid] <= nums[end] && target == nums[end]) {             
                start = mid;       
                 continue;
            }
    
            
            if(nums[mid] <= nums[end] && target > nums[end]) {             
                end = mid;       
                 continue;
            }
            
        }
        
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
    
        return -1;
    
    }
    
}






// mid > end  (rotation list)

//     mid > target  ??
//          target > end (start = mid)   ===>  mid  > end > target
//          target < end (end = mid) ====>  mid > target > end
//     mid < target (start = mid)  =====> target > mid > end


// mid  < end (orginal list)
    
//     mid > target (start = mid)  ====>  target < mid < end
//     mid < target  
//         target > end  (end = mid)  ====>   mid < end < target
//         target < end (start = mid) ====>   mid < target < end
            