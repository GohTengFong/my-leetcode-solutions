class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Collections.sort(access_times, (a, b) -> {
            if (a.get(0).equals(b.get(0))) return a.get(1).compareTo(b.get(1));
            else return a.get(0).compareTo(b.get(0));
        });
            
        ArrayList<String> answer = new ArrayList<String>();
                    
        for (int i = 0; i < access_times.size(); i++) {
            String currEmployee = access_times.get(i).get(0);
            String firstAccess = access_times.get(i).get(1);
            int accessCount = 1;
            
            for (int j = i + 1; j < access_times.size(); j++) {
                List<String> entry = access_times.get(j);
                String employee = entry.get(0);
                String accessTime = entry.get(1);
                
                if (employee.equals(currEmployee)) { // same employee accessed
                    int firstAccessInt = Integer.parseInt(firstAccess);
                    int accessTimeInt = Integer.parseInt(accessTime);
                    
                    if (accessTimeInt - firstAccessInt < 100) {
                        accessCount++;
                    } else {
                        if (accessCount >= 3) { // currEmployee is high-access
                            if (!answer.contains(currEmployee)) {
                                answer.add(currEmployee);

                                i = j - 1;
                                break;
                            }
                        } else { // currEmployee is not high-access when the current access time is used as firstAccess, need to consider his next access time as firstAccess
                            break;
                        }
                    }
                } else { // different employee accessed, check if previous employee is high-access
                    if (accessCount >= 3 && !answer.contains(currEmployee)) answer.add(currEmployee);
                
                    i = j - 1; // to shift i past all previous employee's accesses
                    break;
                }
                
                if (j == access_times.size() - 1 && accessCount >= 3 && !answer.contains(currEmployee)) answer.add(currEmployee); // accounting for last employee
            }
        }
        
        return answer;
    }
}

/*

Idea :
- sort by name and access times

*/