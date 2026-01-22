#Container_with_most_water 


class Solution {
    public int maxArea(int[] height) {
        int water = 0;
        int left = 0;
        int right = height.length - 1;

        while (left <= right) {
            water = Math.max(water, Math.min(height[left], height[right]) * (right - left));

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return water;
    }

}
public class Main {
  public static void main(String [] args){
    int [] height = {1,4,5,7,20,10,9}; 
    maxArea obj = new maxArea();
    System.out.print(maxArea(height));

  }
}
