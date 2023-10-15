package 공원산책;

import java.util.*;
class Solution {
    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int startX =0;
        int startY =0;
        char [][] maze = new char[park.length][park[0].length()];
        //maze에 S O X를 담음
        for(int i = 0 ; i <park.length; i++){
            maze[i] = park[i].toCharArray();
            if(park[i].contains("S")){
                startY = i;
                startX = park[i].indexOf("S");
            }
        }
        
        for(String route : routes){
            String dir = route.split(" ")[0];
            int distance = Integer.parseInt(route.split(" ")[1]);
            
            int plusX = startX;
            int plusY = startY;
            
            for(int i = 0; i < distance; i++){
                switch(dir){
                    case "E":
                        plusX++;
                        break;
                    case "S":
                        plusY++;
                        break;
                    case "W":
                        plusX--;
                        break;
                    case "N":
                        plusY--;
                        break;
                }
                // plusX,plusY값이 벽이나 장애물을 건너는지 확인
                if(plusX >=0 && plusY >=0 && plusY < park.length && plusX < park[0].length()){
                    if(maze[plusY][plusX] == 'X')
                        break;
                    //끝까지 다돌았는데 문제없으면 더해줌
                    if(i == distance-1){
                        startX = plusX;
                        startY = plusY;
                    }
                    
                }
            }
        }
        answer[0] = startY;
        answer[1] = startX;


        return answer;
    }
    public static void main(String[] args){
        String [] park = {"SOO","OOO","OOO"};
        String [] routes= {"E 2","S 2","W 1"};

        
        int [] answer = solution(park,routes);
        System.out.print(answer[0]+ "," + answer[1]);
    }
}
