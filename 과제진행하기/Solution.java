package 과제진행하기;

import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        List<String> result = new ArrayList<String>();
        // plans 원소에는 이름, 시작시각, 걸리는 시간 구조로 되어있음
        // 끝내는 시각과 새로운 과제 시작이 같으면 끝난걸로 판단
        //과목과 남은 시간을 넣어주면 좋을 거같음
        Stack<String[]> stack = new Stack<>();
        
        // 시간별로 정렬
        Arrays.sort(plans, Comparator.comparing((String[] x) -> x[1]));
        int nextTime = 0;
        int endTime = 0;
        
        for(int i = 0; i < plans.length; i++){
            //과목
            String subject = plans[i][0];
            //시작시각
            int time = (Integer.parseInt(plans[i][1].substring(0,2)) * 60 
                        + Integer.parseInt(plans[i][1].substring(3,5)));
            //걸리는 시간
            int playTime = Integer.parseInt(plans[i][2]);
            
            // 끝나는 시각 : 시작시각 + 걸리는시간
            endTime = time + playTime;
            //다음에 오는 거 시각
            //마지막일 때는 그다음이 없기때문에 nextTime이 없음
            if(i != plans.length-1){
                nextTime = (Integer.parseInt(plans[i+1][1].substring(0,2)) * 60 
                        + Integer.parseInt(plans[i+1][1].substring(3,5)));
            }
            // 끝나는 시각 > 다음오는 시각 이면 끝내지못한채 다음거받아옴
            if(endTime > nextTime){
                //끝내지 못한것을 스택에 넣어줌
                stack.push(new String[]{subject,endTime - nextTime +""});
                //스택에 넣었으면 다음으로 넘어가줌
                continue;
            }
            result.add(subject);
            //오기전이면 스택에 있는 것을 꺼내서 돌려야함
            while(!stack.empty()){
                //남은시간
                int restTime = nextTime - endTime;
                //스택에서 꺼냄
                String [] prev = stack.pop();
                //꺼낸거의 남은시간
                int prevRestTime = Integer.parseInt(prev[1]);
                //남은시간과 스택에서 꺼낸 남은 시간과 비교해서 남으면 한번더 돌리고 아니면 탈출
                if(restTime >= prevRestTime){
                    //완료후 다음꺼 꺼냄
                    result.add(prev[0]);
                    //완료한 만큼 endTime을 늘려줌
                    endTime += prevRestTime;
                }else{
                    //중간에 새로운게 왔으니 다시 넣어줌
                    stack.push(new String[] {prev[0],prevRestTime-restTime+""});
                    break;
                }
            }
        }

        //이제 남은 것들 다 출력
        while(!stack.empty()){
            result.add(stack.pop()[0]);
        }
        
        String [] answer = result.toArray(new String[result.size()]);

        
        return answer;
    }
}
