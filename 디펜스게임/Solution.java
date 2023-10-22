package 디펜스게임;

import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        //적군 수만 넣어
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        //우선순위큐로 집어넣고 poll할때마다 카드를 썻다는 소리 모든 적군을 둘러볼동안
        //아군
        int friendly = n;
        //무적권
        int guard = k;
        for(int i =0; i< enemy.length; i++){
            
            //아군은 점점 줄어듬
            friendly -= enemy[i];
            //적군을 우선순위 큐에 넣어줌
            priorityQueue.add(enemy[i]);
            
            //아군이 0보다 작아지면 빼줘야함 빼서 가드를 쓴거처리하고 다시 아군수 회복시켜줘야함
            if(friendly < 0){
                //물론 가드가 있어야 처리 가능
                if(guard > 0){
                    friendly += priorityQueue.poll();
                    guard--;
                } else {
                    answer = i;
                    break;
                }
            }
            if(i == enemy.length-1){
                answer = enemy.length;
                break;
            }
        }
        return answer;
    }
}
