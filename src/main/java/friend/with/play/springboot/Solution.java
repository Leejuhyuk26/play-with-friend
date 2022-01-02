package friend.with.play.springboot;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {
    public String[] solution(String[] grid, boolean clockwise) {
        String[] answer = new String[grid.length];
        //반시계방향이면 문자열 뒤집기
        if(!clockwise){
            for (int i = 0; i < grid.length; i++){
                String buf = ""; // 뒤집은 문자열 담기
               for (int j=grid[i].length()-1; j>= 0; j--){
                   buf += grid[i].charAt(j);
               }
                   grid[i] = buf;
            }
        }
        //뒤집어서 값 담기
        for (int i =0; i < grid.length; i++){
            int num = grid.length; // 층수 3 -> 2-> 1
            int buf = i+1;
                for(int j=1; j<= i;j++){ // 2-> 1 -> 0

                    System.out.println("2개씩 붙이기");
                    System.out.println(grid[num-1]);
                    System.out.println((buf*2-1)+","+(buf*2+1));
                    System.out.println(grid[num-1].substring((buf*2-1),(buf*2+1)));

                    answer[i] += grid[num-1].substring((buf*2-1),(buf*2+1));
                    buf++;
                }

            answer[i] += grid[num-1].charAt(0);
            num--;
        }

       return answer;
    }

    @Test
    public void 정답() {
        String [] grid = {"1","234","56789"};
        String [] result = {"5","762","98431"};
        Assert.assertEquals(result, solution(grid,true));
    }
}
