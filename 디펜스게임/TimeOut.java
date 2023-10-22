package 디펜스게임;

import java.util.*;
class TimeOut {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        Queue<int []> queue = new LinkedList<>();
        //queue[0] : 현재라운드 queue[1]:남은 아군 queue[2]: 남은 무적권
        queue.add(new int[] {-1,n,k});
        
        
        while(!queue.isEmpty()){
            int [] game = queue.poll();
            
            int round = game[0] + 1;
            if(answer < round){
                answer = round;
            }
            //적군 전멸했다면
            if(round >=enemy.length){
                answer = enemy.length;
                break;
            }
            int friendly = game[1];
            int guard = game[2];
            //무적권을 쓰는 경우
            if(guard >0){
                int [] nextGame = {round,friendly,guard-1};
                queue.add(nextGame);
            }
            //아군 - 적군이 0보다 크거나 같으면 진행가능
            if(friendly - enemy[round] >=0){
                int [] nextGame = {round,friendly-enemy[round],guard};
                queue.add(nextGame);
            }
            
        }
        return answer;
    }
}
