class Solution {
    public String rankTeams(String[] votes) {
        int numOfTeams = votes[0].length();

        // each row in map denotes a team (value corresponds to a letter)
        // each col in map denotes the position (value indicates how many votes at that specific position the team has)
        // last col stores the team letter associated with the team's accumulated votes (cannot rely on index of each row to indicate due to sorting changing the ordering)
        // this makes it possible to add the team letters to answer
        int[][] map = new int[26][numOfTeams + 1];

        for (int i = 0; i < 26; i++) map[i][numOfTeams] = i; // allocating all 26 possible teams in col == numOfTeams

        // for each vote, iterate through the rankings
        // access the team's accumulated votes and increment the number of votes at position i
        for (String vote : votes) {
            for (int i = 0; i < numOfTeams; i++) {
                map[vote.charAt(i) - 'A'][i]++;
            }
        }

        Arrays.sort(map, (a, b) -> {
            for (int i = 0; i < numOfTeams; i++) {
                if (a[i] < b[i]) return 1;
                if (a[i] > b[i]) return -1;
            }

            return 0;
        });

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numOfTeams; i++) {
            char c = (char) ('A' + map[i][numOfTeams]);

            answer.append(c);
        }

        return answer.toString();
    }
}