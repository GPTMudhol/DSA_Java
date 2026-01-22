#Remove_Duplicates_From_Sorted_Array

class Solution {
    public int removeDuplicates(int[] nums) {
        int rd = 0;
        for (int i = 1;i< nums.length;i++){
          if(nums[rd] != nums[i]){
                rd++;
                nums[rd] = nums[i];
            }
            
        }
        return rd+1;
    }
}
public class Main {
  public static void main(String [] args){
    int [] nums = {1,2,3,2,1,,5,6,4,3};
    removeDuplicates obj = new removeDuplicates();
    System.out.print(removeDuplicates(nums));
  }
}
