package Baekjoon;

import java.util.*;
import java.io.*;

public class WhoAssignmentNotFinish {
    public static void solution(List<Integer> number){
        for(int i=0; i<30; i++){
            if(!number.contains(i+1)){
                System.out.println(i+1);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        List<Integer> number = new ArrayList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i =0; i<28; i++){
            number.add(Integer.parseInt(br.readLine()));
        }
        solution(number);
    }
}
