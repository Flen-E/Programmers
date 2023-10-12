package 옹알이1;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String [] sentence = {"aya","ye","woo","ma"};
        
        for(String said : babbling){
            for(String say : sentence )
                said = said.replace(say, " ");
            if(said.replaceAll(" ","").equals(""))
                answer++;
        }
        return answer;
    }
}