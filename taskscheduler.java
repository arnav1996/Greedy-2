#Time complexity:O(n)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No






class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];

        int maxFreq = 0;
        int occMaxFreq = 0;

        for (char task:tasks){
            frequency[task - 'A']++;
            if(frequency[task - 'A'] > maxFreq){
                maxFreq = frequency[task - 'A'];
                occMaxFreq = 1;
            }

            else if(frequency[task - 'A'] == maxFreq){
                occMaxFreq++;
            }


        }

        int partitionCount = maxFreq - 1;

        int emptySlots = partitionCount * (n - (occMaxFreq - 1));

        int pendingTasks = tasks.length - maxFreq * occMaxFreq;

        int idleSlots = Math.max(0, emptySlots - pendingTasks);
        return tasks.length + idleSlots;



    }
}