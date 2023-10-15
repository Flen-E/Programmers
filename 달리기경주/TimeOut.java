package 달리기경주;

import java.util.*;
class TimeOut {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        for(String name : callings){
            // 불리는 사람의 순번
            int index = Arrays.asList(players).indexOf(name);
            // 불린 사람의 선두를 가져옴
            String temp = players[index-1];
            // 선두에 불린 사람을 넣음
            players[index-1] = players[index];
            // 불린사람자리에 선두를 넣어 교체함
            players[index] = temp;
        }
        
        return players;
    }
}