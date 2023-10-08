class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(tasks);
        Collections.sort(processorTime);
        
        ArrayList<Integer> completionTimes = new ArrayList<Integer>();
        
        int processorTimeIndex = 0;
        
        for (int i = tasks.size() - 1; i >= 0; i -= 4) {
            int maxTime1 = Math.max(tasks.get(i), tasks.get(i - 1));
            int maxTime2 = Math.max(tasks.get(i - 2), tasks.get(i - 3));
            
            int maxTimeOverall = Math.max(maxTime1, maxTime2);
            
            int completionTime = maxTimeOverall + processorTime.get(processorTimeIndex);
            
            completionTimes.add(completionTime);
            
            processorTimeIndex++;
        }
        
        int answer = Integer.MIN_VALUE;
        for (int time : completionTimes) answer = Math.max(answer, time);
        
        return answer;
    }
}