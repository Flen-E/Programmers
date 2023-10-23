package 숫자변환하기;

import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] def = {x,0};
        //중복은 하나로 없애버리기 위함
        HashSet<Integer> set = new HashSet<>();
        queue.add(def);
        
        
        //중복이 너무 많음 hash로 해결
        //먼저 y랑 값이 같으면 가장 작은 count니 반환
        while(!queue.isEmpty()){
            int []result = queue.poll();
            if(result[0] != y){
                int [] firstResult = {result[0] +n,result[1]+1};
                int [] secondResult = {result[0] *2,result[1]+1};
                int [] thirdResult = {result[0] *3,result[1]+1};
                if(result[0]+ n <=y && !set.contains(result[0]+ n)){
                    set.add(result[0]+n);
                    queue.add(firstResult);
                }
                if(result[0]*2 <=y && !set.contains(result[0] *2)){
                    set.add(result[0]+n);
                    queue.add(secondResult);
                }
                if(result[0]*3 <=y && !set.contains(result[0]*3)){
                    set.add(result[0]+n);
                    queue.add(thirdResult);
                }    
            }else if(result[0] == y){
                return result[1];
            } 
        }
        return -1;
    }
}
