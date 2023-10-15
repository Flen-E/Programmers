package 개인정보수집유효기간;

import java.util.*;
class Solution {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        HashMap<String,Integer> term = new HashMap<>();
        for(String z : terms){
            term.put(z.split(" ")[0],Integer.parseInt(z.split(" ")[1]));
        }
        int num = 0;
        
        for(String x : privacies){
            num++;
            String date = x.split(" ")[0];
            String type = x.split(" ")[1];
            System.out.println("연도" + date.split(".")[0]);

            int year = Integer.parseInt(date.split(".")[0]);
            int month = Integer.parseInt(date.split(".")[1]);
            int day = Integer.parseInt(date.split(".")[2]);
            int period = term.get(type);
            //유효기간을 더해주어 만료기간을 나타냄
            if(month + period >12){
                year++;
                month = month + period -12;
            }else
                month = month + period;
            // 날짜 비교
            int tyear = Integer.parseInt(today.split(".")[0]);
            int tmonth = Integer.parseInt(today.split(".")[1]);
            int tday = Integer.parseInt(today.split(".")[2]);
            // 년도를 넘으면 바로 아웃
            if(year >tyear){
                break;
            }
            //년도가 같다면
            if(year == tyear){
                if(month > tmonth)
                    break;
                if(month == tmonth){
                    if(day >= tday)
                        break;  
                }
            }
            answerList.add(num);
        }
        int [] answer = answerList.stream().mapToInt(i->i).toArray();
        return answer;
    }
    public static void main(String[] args){
        String today = "2022.05.19";
        String [] terms = {"A 6","B 12","C 3"};
        String [] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        int [] answer = solution(today, terms, privacies);
        for(int i=0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }

}
