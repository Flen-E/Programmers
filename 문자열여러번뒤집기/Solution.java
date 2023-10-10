package 문자열여러번뒤집기;
import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {

        for(int i = 0; i < queries.length; i++){
            StringBuffer sb = new StringBuffer(my_string);
            String  start = sb.substring(0,queries[i][0]);
            String rev = sb.substring(queries[i][0],queries[i][1]+1);
            StringBuffer rev1 = new StringBuffer(rev);
            String middle = rev1.reverse().toString();
            String end = sb.substring(queries[i][1]+1);
            String cont = start + middle + end;
            my_string = cont; 
        }
        return my_string;
    }
}
