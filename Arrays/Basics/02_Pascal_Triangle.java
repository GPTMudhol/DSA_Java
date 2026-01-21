class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> Triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>(Collections.nCopies(i+1,1));

            for(int j = 1; j < i ; j++){
                row.set(j,Triangle.get(i-1).get(j-1) + Triangle.get(i-1).get(j));
            }
            Triangle.add(row);
        }
        return Triangle;
    }
}

public class Main{
  public static void main(String[] args){
    Solution obj = new Solution ();
    int numRows = 5;

    List<List<Integer>> result = obj.generate(numRows);
    for (List<Integer> row : result) {
      for(Integer val : row){
        System.out.print(val + " ");
      }
      System.out.println();
    }

  }
}
