package 신고결과받기;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int [] answer = new int[id_list.length];
        //report를 유니크하게 만들어줌 같은 신고를 삭제해준다
        HashSet<String> uniqueReport = new HashSet<String>(Arrays.asList(report));

        //신고자와 신고 당한자 가질 map을 만들어준다
        HashMap<String, HashSet<String>> reporterInfoMap = new HashMap<>();
        //신고당한자와 신고된 수 가질 map을 만들어줍니다
        HashMap<String, Integer> reportedCountInfoMap = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++){
            String reporter = id_list[i];
            reporterInfoMap.put(reporter,new HashSet<>());
        }
        
        for(String reporterList : uniqueReport){
            // 신고자
            String reporter = reporterList.split(" ")[0];
            // 신고당한자
            String attacker = reporterList.split(" ")[1];
            //신고자들을 찾아 신고당한사람들을 추가해줌
            reporterInfoMap.get(reporter).add(attacker);
            //신고당한 사람의 신고횟수를 만들어줌
            reportedCountInfoMap.put(attacker, reportedCountInfoMap.getOrDefault(attacker, 0) + 1);

        }
        //reportedList : reportedCountInfoMap에 들어가는 attacker
        for(String reportedList : reportedCountInfoMap.keySet()){
            
            int count = reportedCountInfoMap.get(reportedList); //신고자수를 받아옴 value
            
            //k명 이상이면 신고가 되기때문에 메일을 발송 해줘야함
            if(count >= k){
                //모든 유저를 둘러봄
                for(int i = 0; i < id_list.length; i++){
                  if(reporterInfoMap.containsKey(id_list[i]) && 
                     reporterInfoMap.get(id_list[i]).contains(reportedList)){
                      answer[i]++;

                  }
                        
                    
                }
                
                
            }
            
        }
        return answer;
        
        
    }

}
