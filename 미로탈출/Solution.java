package 미로탈출;

import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        //S :시작 지점, E : 출구, L : 레버, O : 통로, X : 벽
        //start 좌표
        int sx = 0;
        int sy = 0;
        //레버 좌표
        int lx = 0;
        int ly = 0;
        //종착지 좌표
        int ex = 0;
        int ey = 0;

        // x 가 j로 가로 y가 i로 세로, start,labber,end 좌표 구해줌
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    sx = j;
                    sy = i;
                }
                else if (maps[i].charAt(j) == 'L'){
                    lx = j;
                    ly = i;
                }
                else if ( maps[i].charAt(j) == 'E'){
                    ex = j;
                    ey = i;
                }
            }
        }   
        //start에서 레버까지 걸린시간
        int sToLTime = bfs(sx,sy,lx,ly,maps);
        //레버에서 종착지까지 걸린시간
        int lToETime = bfs(lx,ly,ex,ey,maps);
        
        
        answer = sToLTime + lToETime;
        if(sToLTime == -1 || lToETime == -1 ){
            answer = -1;
        }

        return answer;
    }
    //시작점과 도착점을 주어 최소를 구하고 count를 반환
    public static int bfs(int startX, int startY, int endX, int endY, String[] maps){
        //방문했는지 알아보기
        boolean [][] checked = new boolean[maps.length][maps[0].length()];
        for(boolean a[]: checked){
            Arrays.fill(a,false);
        }
        
        //현재X, 현재Y, 현재 카운트 초기화
        Queue<int[]> queue = new LinkedList<>();
        int [] dx = {1,0,-1,0};//동남서북
        int [] dy = {0,1,0,-1};//동남서북
        //시작점을 넣고 시작함
        queue.add(new int[] {startX,startY,0});
        checked[startY][startX] = true;
        
        while(!queue.isEmpty()){
            //현재 좌표와 count를 빼줌
            int [] now = queue.poll();
            int currentX = now[0];
            int currentY = now[1];
            int count = now[2];
            if(currentX == endX && currentY == endY){
                return count;
            }
            
            //상하좌우를 살펴봄
            for(int i = 0; i < 4; i++){
                int nowX = currentX + dx[i];
                int nowY = currentY + dy[i];
                //맵밖으로 안벗어나는 경우
                if(nowX >=0 && nowX < maps[0].length() && nowY >=0 && nowY <maps.length){
                    //통로이면서 한번도 안지나간 길이라면
                    if(maps[nowY].charAt(nowX) != 'X' && !checked[nowY][nowX]){
                        checked[nowY][nowX] = true;
                        queue.add(new int [] {nowX,nowY,count+1});

                    }
                }
            }
        }
        return -1;
        
    }
}
