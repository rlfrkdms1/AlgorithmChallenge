import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] stack = new int[10000];
    static int size;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        size = 0;
        for(int i = 0; i < length; i++){
            stackOperation(reader.readLine());
        }
    }

    public static void stackOperation(String line){
        String[] lines=line.split(" ");
        String operation = lines[0];
        if(operation.equals("push")){
            stack[size] = Integer.parseInt(lines[1]);
            size++;
        } else if(operation.equals("top")){
            if(size == 0){
                System.out.println("-1");
            } else {
                System.out.println(stack[size-1]);
            }
        } else if(operation.equals("pop")) {
            if(size == 0){
                System.out.println("-1");
            } else {
                System.out.println(stack[size-1]);
                size--;
            }
        } else if(operation.equals("size")) System.out.println(size);
        else {
            if(size==0) System.out.println("1");
            else  System.out.println("0");
        }
    }
}
