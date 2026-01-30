class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(){
            {
                put(0,-1);
            }
        };

        int prefixsummodk = 0;

        for(int i = 0; i < nums.length; i++){
            prefixsummodk += nums[i];
            prefixsummodk %= k;

            if(!map.containsKey(prefixsummodk)){
                map.put(prefixsummodk,i);
            }else if(i - map.get(prefixsummodk) > 1){
                return true;
            }
        }
        return false; 
    }
}
