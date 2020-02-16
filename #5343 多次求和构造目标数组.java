class Solution {
    private PriorityQueue<Long> q;
    private long sum = 0;

    public boolean isPossible(int[] target) {
        initialize(target);
        while (!q.isEmpty()) {
            long previousSum = q.poll();
            long previousVal = (previousSum << 1) - sum;
            if (previousVal < 1) return false;
            else if (previousVal > 1) q.offer(previousVal);
            sum = previousSum;
        }
        return true;
    }

    private void initialize(int[] target) {
        q = new PriorityQueue<>(target.length, Comparator.reverseOrder());
        for (long value : target) {
            sum += value;
            if (value > 1)
                q.offer(value);
        }
    }
}