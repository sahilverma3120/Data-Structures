class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
		// the position we can achieve without any fuel
        int curr = startFuel;
		// total number of fueling 
        int res = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int index = 0;
		// The will not stop until we achieve the target
        while(curr < target) {
			// if we don't achieve the target, we need to get fuel. Which one station should we  fuel? That depenses on the maximun fuel we can get by one stop. (Greedy)
            while(index < stations.length && stations[index][0] <= curr) {
                queue.offer(stations[index]);
                index++;
            }
            if(!queue.isEmpty()) {
                int[] station = queue.poll();
                res++;
                curr += station[1];
                continue;
            }else {
                res = -1;
                break;
            }
        }
        return res;
    }
}
