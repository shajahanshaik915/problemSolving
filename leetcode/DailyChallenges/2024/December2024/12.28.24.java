class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] W = new int[nums.length-k+1];

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        W[0] = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i]-nums[i-k];
            W[i-k+1] = sum;
        }

        int[] leftBest = new int[nums.length-k+1];
        int best = 0;
        for (int i = 0; i < leftBest.length; i++) {
            if (W[i] > W[best]) {
                best = i;
            }
            leftBest[i] = best;
        }

        int[] rightBest = new int[nums.length-k+1];
        best = W.length-1;
        for (int i = rightBest.length-1; i >= 0; i--) {
            if (W[i] >= W[best]) {
                best = i;
            }
            rightBest[i] = best;
        }

        // System.out.println(Arrays.toString(leftBest));
        // System.out.println(Arrays.toString(rightBest));

        int[] ret = new int[]{0, k, k+k};
        for (int i = k; i < W.length-k; i++) {
            if (W[i] + W[leftBest[i-k]] + W[rightBest[i+k]] > W[ret[0]] + W[ret[1]] + W[ret[2]]) {
                ret[0] = leftBest[i-k];
                ret[1] = i;
                ret[2] = rightBest[i+k];
            }
        }

        // System.out.println(Arrays.toString(ret));


        return ret;
    }
}
