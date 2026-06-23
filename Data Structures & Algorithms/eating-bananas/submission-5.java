class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Upper bound is the largest pile; lower bound is 1
        int maxPile = 0;
        for (int p : piles) {
            maxPile = Math.max(maxPile, p);
        }

        int st = 1, ed = maxPile;
        int ans = maxPile; // track best feasible rate

        while (st <= ed) {
            int mid = st + (ed - st) / 2; // avoid overflow
            if (canFinish(piles, h, mid)) {
                ans = mid;         // mid works; try to find a smaller feasible rate
                ed = mid - 1;
            } else {
                st = mid + 1;      // mid too slow; need higher rate
            }
        }
        return ans; // or return st; both are fine with this invariant
    }

    // Returns true if Koko can finish all piles within h hours at eating rate 'rate'
    private boolean canFinish(int[] piles, int h, int rate) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + rate - 1) / rate; // ceil(p / rate) using ints
            if (hours > h) return false;    // early exit
        }
        return hours <= h;
    }
}