class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0, end = 0;
        for(int weight: weights) {
            start = Math.max(start, weight);
            end += weight;
        }

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            boolean tag = checkCanDelivery(weights, mid, days);
            if(tag) {
                end = mid;
            }else {
                start = mid;
            }
        }

        if(checkCanDelivery(weights, start, days)) {
            return start;
        }

        return end;

    }

    public boolean checkCanDelivery(int[] weights, int capcity, int days) {
        int count = 0;
        int sum = 0;
        for(int weight: weights) {
            sum += weight;
            // if(weight > capcity) {
            //     return false;
            // }
            if(sum > capcity) {
                count ++;
                sum = weight;
            }
            if(sum == capcity) {
                count ++;
                sum = 0;
            }
            if(count > days) return false;
        }
        if(sum != 0) count++;

        return count <= days;

    }

    // public boolean checkCanDelivery(int[] weights, int capcity, int days) {
    //     int count = 0;
        
    //     for(int i = 0; i < weights.length;) {

    //         int j = i;
    //         int sum = 0;
    //         while(j < weights.length && sum + weights[j] <= capcity) {
    //             sum += weights[j];
    //             j++;
    //         }
    //         count++;
    //         if(count > days) return false;
    //         i = j;
    //     }

    //     return true;

    // }
}

