#Time complexity:O(n)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No


class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;

        int[] candies = new int[ratings.length];

        Arrays.fill(candies,1);
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                candies[i] = 1 + candies[i - 1];

            }

        }

        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], 1 + candies[i+1]);
            }
        }
        int sum = 0;
        for(int candy:candies){
            sum += candy;

        }


        return sum;

    }
}