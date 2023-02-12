import java.io.*;
import java.util.*;

public class zerooneknapsack {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int total_items = scn.nextInt();

        int[] price = new int[total_items];
        for (int i = 0; i < total_items; i++) {
            price[i] = scn.nextInt();
        }

        int[] weight = new int[total_items];
        for (int i = 0; i < total_items; i++) {
            weight[i] = scn.nextInt();
        }

        int bag_capacity = scn.nextInt();

        // --------- 0 1 2 3 4 5 6 7 upto cap
        // wt1(ofPrice1)
        // wt2(ofPrice2)
        // continues

        // in every dp[][], maximum amount possible is stored
        int[][] maximum_amount = new int[total_items][bag_capacity + 1];

        for (int item = 0; item < total_items; item++) {
            for (int capacity = 0; capacity <= bag_capacity; capacity++) {
                if (capacity == 0)
                    maximum_amount[item][capacity] = 0;
                else if (item == 0) {
                    if (weight[item] <= capacity) {
                        maximum_amount[item][capacity] = price[item];
                    }
                } else {
                    if (weight[item] <= capacity) {
                        int no = maximum_amount[item - 1][capacity];
                        int yes = price[item] + maximum_amount[item - 1][capacity - weight[item]];

                        maximum_amount[item][capacity] = Math.max(no, yes);
                    } else {
                        maximum_amount[item][capacity] = maximum_amount[item - 1][capacity];
                    }

                }
            }
        }
        System.out.println(maximum_amount[total_items - 1][bag_capacity]);
    }
}