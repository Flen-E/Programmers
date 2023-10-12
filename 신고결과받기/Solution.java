package 신고결과받기;

import java.util.*;

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        String [] who_reporter = new String[id_list.length]; //나를 신고한 자들을 넣어줄 배열
        Arrays.fill(who_reporter,""); // 빈칸으로 채워줌
        for(String letter : report){
            String [] name =letter.split(" "); //report를 띄어쓰기로 나눠서 신고자와 신고당한자로 나눔
            String reporter = name[0]; //신고자
            String attacker = name[1]; //신고당한자
            for(int i = 0; i < id_list.length; i++){
                if(id_list[i].equals(attacker)){ //신고당한자랑 id_list사람과 같다면
                    if(who_reporter[i] == null){ //신고자가 없다면 그냥 바로 신고자 추가
                        who_reporter[i] += reporter;
                    }
                    else if(!who_reporter[i].contains(reporter)){ // 중복이 아닐시 이어서 추가 
                        who_reporter[i] += " " + reporter;
                    } 
                }   
            }
        }
        for(String declar : who_reporter){
            if(declar != null){ // 신고자들이 없는 것이 아니라면 
                String [] acc = declar.split(" ");//나를 신고한 사람들
                if(acc.length >= k){//나를 신고한 사람이 k이상 있으면 신고당함(이제 신고당한 사람이니 여기에 해당하는 신고자들에게 메일을 보내면 됨)
                    for(int i = 0; i <id_list.length; i++){
                        for(String accName : acc){ // 신고한 사람들 하나하나 둘러봄
                            if(id_list[i].equals(accName)) //id_list사람과 신고자들과 같으면 메일이 감
                                answer[i]++; //메일온 개수만큼 더해줌
                        }
                    }
                } 
            }
            
        }
        return answer;
    }
    public static void main(String[] args){
        String [] id_list = {"ab", "b", "c"};
        String [] report = {"b ab", "c ab", "c b"};
        int k = 2;

        int [] answer = solution(id_list,report,k);
        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i]);
        }
    }
}