import java.util.*;

class TheBiggestNumber {
    public String solution(int[] numbers) {
        String[][] nums = new String[numbers.length][2];
        for(int i = 0; i < numbers.length; i++) {
            String number =  String.valueOf(numbers[i]);
            nums[i][1] = String.valueOf(number.length());
            if(number.length() == 1) number += number + number + number;
            if(number.length() == 2) number += number + number;
            if(number.length() == 3) number += number;
            nums[i][0] = number;
        }
        
        Arrays.sort(nums, (a, b) -> b[0].compareTo(a[0]));
        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for(int i = 0; i < nums.length; i++) {
            String number = nums[i][0].substring(0, Integer.parseInt(nums[i][1]));
            if(!number.equals("0")) isZero = false;
            sb.append(number);
        }
        if(isZero) return "0";
        return sb.toString();
    }
}
