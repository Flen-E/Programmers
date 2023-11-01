package 인사고과;

import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        //근무 태도점수,동료평가 점수 어떤 사원이 다른 임의 사원보다 두점수 모드 낮은 경우 한번이라도 잇으면 인센티브 못받음
        //그렇지 않으면 두점수합으로 내림채순으로 인센티브 차등 지급
        //동석존재 2등3명이면 3등 4등 없음 
        int workPoint = scores[0][0];
        int cwPoint = scores[0][1];
        
        //근무 태도점수로 내림차순
        Arrays.sort(scores,(o1,o2)-> {
            if(o1[0]== o2[0]){
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        //여기서 일단 원호보다 낮은 애들은 신경 쓸 이유가 없음
        //그리고 높은 애들중에서도 자기보다 큰 동료평가가 있으면 인센티브 제외대상임(차피 근무 태도 내림차순이니 순서대로 본다면)
        //내림차순 정렬후 가장 큰 근무점수
        int startCWPoint = scores[0][1];
        for(int i = 1; i < scores.length; i++){
            //현재 근무점수가 최고 근무점수 보다 낮으면? 내림차순이기때문에 무조건 임의의 한명보다 둘다 낮다는 소리
            if(scores[i][1] < startCWPoint){ //인센티브 못받음
                //이때 원호가 해당하면 -1반환
                if(scores[i][0] == workPoint && scores[i][1] == cwPoint)
                    return -1;
                //나머지들은 다 인센티브 못받으니 나중에 정렬할때 제외해줘야함
                //그럼 완호의 점수합보다 낮아야하니 a,b는 최소 0이니 -1로 설정
                scores[i][0] = -1;
                scores[i][1] = -1;
                
            }else{
                //이게 아니면 얘는 통과했다는 소린데 통과했다는건 startPoint가 더 커졋다는 소린데 얘랑 비교해야함
                startCWPoint = scores[i][1];
            }
        }
        
        //이제 인센티브 못받는 놈들 다 제외했음 완호의 순위만 정하면됨
        //둘 합을 내림차순 해주고 몇등인지 비교하면됨
        Arrays.sort(scores,(o1,o2)->(o2[0] + o2[1]) - (o1[0] + o1[1]));
        
        for(int i = 0; i < scores.length; i++){            
            //나보다 큰놈만 거르고 그다음이면 나랑 동점이거나 그런애일테니
            //동점자는 같은 취급일테니 나보다 높은 놈만 보면됨 같은 순간 아웃
            if((scores[i][0] + scores[i][1]) == (workPoint + cwPoint)){
                break;
            }
            answer++;
        }

        return answer+1;
    }
}