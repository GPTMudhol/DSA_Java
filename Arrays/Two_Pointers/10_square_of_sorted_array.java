class Solution {
  public int [] squaresort(int [] nums){

    int [] result  = new int[nums.length];
    int left = 0;
    int right = nums.length-1;

    for(int i = 0; i < nums.length;i++){
      nums[i] = nums[i] * nums[i];
    }

    for(int pos = nums.length-1; pos >= 0; pos--){
      
      if(nums[left] > nums[right]){
        result[pos] = nums[left];
        left++;
      }
      else{
        result[pos] = nums[right];
        right--;
      }
    }
   return result;
  }
}
public class Main{
  public static void main(String [] args){
    Solution obj = new Solution();

    int [] nums = {4, ,5,9,10,11};
    sop(obj.squaresort(nums));
  }
}
