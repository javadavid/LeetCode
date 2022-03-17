// https://www.lintcode.com/problem/183/

class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int start = 1;
        int end = Integer.MIN_VALUE;

        for(int len : L) {
            // start = Math.min(start, len);
            end = Math.max(end, len);
        }


        while(start + 1 < end) {

            int mid = start + (end - start) / 2;

            if(checkCanCut(L, mid, k)) {
                start = mid;
            }else {
                end = mid;
            }
        }
     
        if(checkCanCut(L, end, k)) {
            return end;
        }

        if(checkCanCut(L, start, k)) {
            return start;
        }


        return 0;

    }

    public boolean checkCanCut(int[] L, int cap, int k) {
        int count = 0;
        for(int wood: L) {
            count = count + wood/cap;
        }
        return count >= k;
    }
}