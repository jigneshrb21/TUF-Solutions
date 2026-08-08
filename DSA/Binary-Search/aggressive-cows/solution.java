class Solution {
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int limit  = nums[n - 1] - nums[0];
        int low = 0;
        int high = limit;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canweplace(nums,mid,k) == true)
            {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }

        }
        return high;
    }
    private boolean canweplace(int[] nums, int dist, int k){
        int n = nums.length;
        int cntcows = 1;
        int last = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] - last >= dist){
                cntcows++;
                last = nums[i];
            }
            if(cntcows >= k)  return true;
        }
        return false;
    }
}
