package 배열만들기2;

import java.util.*;

class Solution {
    public List solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        for(int i = l ; i <=r; i++){ // l부터 r까지
            String result = Integer.toString(i); //정수값을 문자열로바꿔줌
            int count = 0;
            for(int j =0; j < result.length(); j++){ //문자열들을 하나씩 살펴봄
                if(result.charAt(j) == '5' || result.charAt(j) == '0') //문자열중에 5나 0이 들어가면 진행되고 결국 문자열갯수랑 5 0 드간 갯수랑 같으면 맞으니 넣어줌
                    count++;
                if(count == result.length()) // 결국 끝에 도달했을때 같으면 answer에다가 현재값을 넣어줌
                    answer.add(Integer.parseInt(result));
            }  
        }
        if(answer.size() == 0) 
            answer.add(-1);
        
        return answer;
    }
}
