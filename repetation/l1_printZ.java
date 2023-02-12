import java.util.*;
import java.io.*;

public class l1_printZ {
    public static void main(String[] args) {
        // we have to print z , given that horizontal has 5 stars
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i == 1 || i == 5) {
                    System.out.print("*");
                } else if (i == 5 - j + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}