package 키패드누르기;

import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // *은 10 0 은 11 #은 12로 가정
        //좌표를 넣어줌
        int x = 0;int y = 0;
        HashMap<Integer, int []> keypad = new HashMap<>(); 
        //key에는 키패드를 넣어줌 1에는 {0,0} 2에는 {0,1} 4에는 {1,0}이런식 * 은 {3,0} 0 은 {3,1} #은 {3,2}
        for(int i = 1; i <=12; i ++){
            if(i % 3 == 1){
                y++;
                x = 0;
            }
            int [] arr = {y,x};
            keypad.put(i,arr);
            x++;
        }
        //* {3,0}
        int [] leftHand = keypad.get(10);
        //# {3,2}
        int [] rightHand = keypad.get(12);
        

        for(int num : numbers){
            //1 4 7은 무적권 왼쪽으로침
            if(num == 1 || num == 4 || num == 7){
                answer +="L";
                leftHand = keypad.get(num);
            }else if(num == 3 || num == 6 || num ==9){
                answer +="R";
                rightHand = keypad.get(num);
            }else {
                if(num == 0){
                    num = 11;
                }
                //2 5 8 11(0)을 누를때
                //y좌표차이 + x좌표차이
                int lHandDistance =
                    Math.abs(keypad.get(num)[0] - leftHand[0]) 
                    + Math.abs(keypad.get(num)[1] - leftHand[1]);
                int rHandDistance = Math.abs(keypad.get(num)[0] - rightHand[0]) 
                    + Math.abs(keypad.get(num)[1] - rightHand[1]);
                
                if(lHandDistance > rHandDistance){
                    rightHand = keypad.get(num);
                    answer += "R";
                }else if(lHandDistance == rHandDistance){
                    if(hand.equals("left")){
                        leftHand = keypad.get(num);
                        answer += "L";
                    }else{
                        rightHand = keypad.get(num);
                        answer += "R";
                    }
                }else{
                    leftHand = keypad.get(num);
                    answer += "L";
                }
            }
        } 
        return answer;
    }
}
