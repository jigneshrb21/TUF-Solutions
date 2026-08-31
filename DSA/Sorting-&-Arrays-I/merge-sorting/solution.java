class Solution {
    public int[] mergeSort(int[] nums) {
        mergeS(nums,0,nums.length - 1);
        return nums;
    }
    public void mergeS(int[] nums, int low, int high){
        if(low >= high) return;
        int mid = low + (high - low) / 2;
        mergeS(nums,low,mid);
        mergeS(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
     public void merge(int[] arr, int low, int mid, int high) {
  
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
          
            if (arr[left] <= arr[right]) {
           
                temp.add(arr[left]);
             
                left++;
            } else {
            
                temp.add(arr[right]);
           
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}