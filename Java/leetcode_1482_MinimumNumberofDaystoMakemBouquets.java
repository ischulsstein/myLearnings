class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m * k > bloomDay.length) {
            return -1;
        }
        int low = 1, high = (int) 1e9;

        while (low < high) {
            int mid = (low + high) / 2;

            if (boquets(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;      
    }
     private Boolean boquets(int[] bloomDay, int m, int k, int day) {
        int flowers = 0, runs = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flowers++;
                if (flowers == k) {
                    runs++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
            if (runs == m) {
                return true;
            }
        }
        return false;
    }
}