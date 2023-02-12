import java.io.*;
import java.util.*;

public class largestareahistogram {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // solution
        Stack<Integer> stack = new Stack<>();

        // iterating in main array from right towards left

        // Algorithm
        // if the current element is smaller than that of stacks peek go on popping the
        // stack
        // if stack becomes zero then it means that there is no smaller number at right
        // if there is some smaller number then put that element index in ra array at
        // current element's index

        // ra - array containing smaller element index at right side
        int[] ra = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            // stack size not zero and current number is smaller than its peek
            while (stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            // is stack is 0 then its indicating that there is no smaller element at right
            if (stack.size() == 0) {
                // as there is no smaller element in right array length is taken as default
                // right small's index
                ra[i] = arr.length;
            } else {
                // if stack is not zero then its indication thatstacks peek is the smaller elent
                // than current
                ra[i] = stack.peek();
            }
            // its necessary to push every element to stack as it can be smaller to other
            // upcoming elements
            stack.push(i);
        }

        // la - array containing smaller element index at left side
        int[] la = new int[arr.length];

        // making fresh stack
        stack = new Stack<>();

        // iterating in main array from left towards right

        // Algorithm
        // if the current element is smaller than that of stacks peek go on popping the
        // stack
        // if stack becomes zero then it means that there is no smaller number on left
        // side
        // if there is some smaller number then put that element index in ra array at
        // current element's index
        for (int i = 0; i < arr.length; i++) {

            while (stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            if (stack.size() == 0) {
                // -1 is taken as default if no smaller element is present on left side
                la[i] = -1;
            } else {
                la[i] = stack.peek();
            }

            stack.push(i);
        }

        // Now we have array ra containing index of right small number for each number
        // and la containing index of left small number for each number

        // to find largest area histogram
        // initially take area minimum value of integer
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            // aai - area at index
            // Area - height * (right small's index - left small's index - 1)
            int aai = arr[i] * (ra[i] - la[i] - 1);

            if (max < aai) {
                max = aai;
            }
        }

        // after loop we get maximum area of histogram
        System.out.println(max);
    }
}