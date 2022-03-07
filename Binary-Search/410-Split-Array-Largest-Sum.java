
//same question as 1011-Capacity-To-Ship-Packages-Within-D-Days.java, but need to understand the question meanings.
class Solution {
    public int splitArray(int[] nums, int m) {
        
        int start = 0, end = 0;
        
        for(int num : nums) {
            start = Math.max(start, num);
            end += num;
        }
        
        
        while(start + 1 < end) {
            
            int mid = start + (end - start) / 2;
            
            if(check(nums, mid, m)) {
                end = mid;            
            }else {
                start = mid;
            }
            
        }
        
        if(check(nums, start, m)) {
            return start;
        }
        
        return end;
        
    }
    
    
    
    public boolean check(int[] nums, int cap, int m) {
        
        int count = 0, sum = 0;
        
        for(int num : nums) {
            
//             if(num > cap) {
//                 return false;
//             }
            sum = sum + num;
            if(sum > cap) {
                count ++;
                sum = num;
            }
            
            if(sum == cap) {
                count ++;
                sum  = 0;
            }
        }
        
        if(sum > 0) count ++;
        
        return count <= m;
    }
}