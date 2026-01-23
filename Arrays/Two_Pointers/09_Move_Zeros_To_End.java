class Solution{
  public int [] Movezeros(int [] nums){
    int nz = 0;
    int z = 0;

    if (nums.length == 0 || nums.length ==1){
      return;
    }

    while(nz < nums.length){
      if(nums[nz] != 0){
        int temp = nums[nz];
        nums[nz] = nums[z];
        nums[z] = temp;
        nz++;
        z++;
      }else{
        nz++;
      }
    }

  }
}

public class Main{
  public static void main (String [] args]{
       int [] nums = {-4,-3,-2,0,2,4,5};
    Solution obj = new Solution ();
    Sop(obj.Movezeros(nums));
  }
}
    
