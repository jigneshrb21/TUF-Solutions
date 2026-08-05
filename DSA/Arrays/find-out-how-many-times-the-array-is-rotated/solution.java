class Solution {
    public int findKRotation(ArrayList<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(low) <= arr.get(high)) {
                if (arr.get(low) < ans) {
                    index = low;
                    ans = arr.get(low);
                }
                break;
            }
            if (arr.get(low) <= arr.get(mid)) {
                /* Update ans with minimum 
                of ans and arr[low] */
                if(arr.get(low) < ans){
                    ans = arr.get(low);
                    index = low;
                }
                // Move to the right part
                low = mid + 1;
            } else {
                /* Update ans with minimum 
                   of ans and arr[mid] */
                if(arr.get(mid) < ans){
                    ans = arr.get(mid);
                    index = mid;
                }
               
                // Move to the left part
                high = mid - 1;
            }
        }
        // Return the minimum element found
        return index;
       
    }
}