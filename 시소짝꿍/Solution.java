package 시소짝꿍;

import java.util.*;
class Solution {
    public int count = 0;
    public long solution(int[] weights) {
        long answer = 0;
        //오름차순 정렬
        Arrays.sort(weights);
        HashMap<Double,Integer> map = new HashMap<>();
        //자기와 뒤에 비율이 1:1 ,3:4, 2:4, 2:3 일때만 경우에 해당함
        //key에 무게를 넣고 value에 해당 값과 짝꿍인 갯수를 넣음
        for(int weight : weights){
            //일단 해당 비율에 해당하는 값이 있으면 그 둘은 짝
            if(map.get((double)weight) != null){
                answer += map.get((double)weight);
            }     
            double w1 = (double)weight;
            double w2 = (weight*4.0)/3;
            double w3 = (weight*4.0)/2;
            double w4 = (weight*3.0)/2;
          
            //만약에 map에 없으면 0넣고 있다면 현재 value에 하나 더해줌
            //더해줌으로써 중복은 이제 한쌍이 되어 하나에게 바로 두짝이 만들어짐
            //3개중복이면 바로 3쌍이 되니 오히려좋아
            map.put((double)w1,map.getOrDefault((double)w1,0)+1); 
            map.put((double)w2,map.getOrDefault((double)w2,0)+1);
            map.put((double)w3,map.getOrDefault((double)w3,0)+1);
            map.put((double)w4,map.getOrDefault((double)w4,0)+1);
        }
        return answer;
    }
}