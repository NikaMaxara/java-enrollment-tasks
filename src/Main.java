import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Task 1
        System.out.println("Task 1 result : ");
        String s = "afga";
        System.out.println(validPalindrome(s) ? "YES" : "NO");

        //Task 2
        System.out.println("Task 2 result : ");
        int n = 2;
        generateBraces(n);

        //Task 3
        System.out.println();
        System.out.println("Task 3 result : ");
        List<Integer> list = Arrays.asList(1, 2, 4);
        List<Integer> list2 = Arrays.asList(1, 3, 4);
        List<Integer> merged = mergeLists(list, list2);
        System.out.println(merged);

        //Task 4
        System.out.println("Task 4 result : ");
        int[] number = {1,2,3};
        int[] result = addOne(number);
        System.out.println(Arrays.toString(result));

        //Task 5
        System.out.println("Task 5 result : ");
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxPossibleArea(heights);
        System.out.println(maxArea);
    }

    //Task 1 Methods
    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return check(s, left + 1, right) || check(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean check(String s, int i, int j ){
        while(i < j){
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }

        return true;
    }

    //Task 2 Methods
    public static void generateBraces(int n){
        char[] current = new char[2 * n];
        backtrack(current, 0, 0, 0, n);
    }

    private static void backtrack(char[] current, int pos, int open, int close, int max){
        if(pos == current.length){
            System.out.print(new String(current)+" ");
            return;
        }

        if(open < max){
            current[pos] = '{';
            backtrack(current, pos + 1, open + 1, close, max);
        }
        if(close < open){
            current[pos] = '}';
            backtrack(current, pos + 1, open, close + 1, max);
        }
    }

    //Task 3 method
    public static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2){
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                result.add(list1.get(i));
                i++;
            }else{
                result.add(list2.get(j));
                j++;
            }
        }

        while(i < list1.size()){
            result.add(list1.get(i++));
        }
        while(j < list2.size()){
            result.add(list2.get(j++));
        }

        return result;
    }

    //Task 4 method
    public static int[] addOne(int[] digits){
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    //Task 5 method
    public static int maxPossibleArea(int[] heights) {
        int maxArea = 0;
        int left = 0, right = heights.length - 1;

        while(left < right){
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, width * height);

            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}