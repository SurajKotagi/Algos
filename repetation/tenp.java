// import java.util.*;
// import java.io.*;

// public class tenp {
// public static void main(String[] args) {

// }
// }

// /* package codechef; // don't place package name! */

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// /* Name of the class has to be "Main" only if the class is public. */
// class Codechef {
// public static void main(String[] args) throws java.lang.Exception {
// Scanner scn = new Scanner(System.in);
// int t = scn.nextInt();
// while (t != 0) {

// t--;
// }
// }
// }

// //
// /* package codechef; // don't place package name! */

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// /* Name of the class has to be "Main" only if the class is public. */
// class Codechef {
// public static void main(String[] args) throws java.lang.Exception {
// // your code goes here
// Scanner scn = new Scanner(System.in);
// int t = scn.nextInt();
// while (t != 0) {
// int n = scn.nextInt();
// int[] c = new int[n];
// if (n == 1) {
// System.out.println("-1");
// t--;
// continue;
// }
// // ArrayList<Integer> a = new ArrayList<>();
// ArrayList<Integer> b = new ArrayList<>();

// for (int i = 0; i < n; i++) {
// c[i] = scn.nextInt();
// }
// b.add(c[0]);
// // String B = c[0] + " ";
// boolean flag = false;
// int i = 1;
// while (c[i] < c[0]) {
// // B += c[i] + " ";
// b.add(c[i]);
// i++;
// if (i == c.length) {
// flag = true;
// break;
// }
// }

// if (flag == true) {
// System.out.println("-1");
// t--;
// continue;
// }

// int imp = c.length - i;
// System.out.println(c.length - b.size());
// // String A = "";
// while (i < c.length) {
// // A += (c[i] + " ");
// System.out.print(c[i] + " ");
// i++;
// }
// // System.out.print(A);
// System.out.println();
// System.out.println(c.length - imp);
// for (int val : b) {
// System.out.print(val + " ");
// }
// // String mB = B.substring(0,B.length()-1);
// // System.out.println(B);
// System.out.println();
// t--;
// }
// }
// }

// import java.util.*;
// import java.io.*;

// public class tenp {
// public static void main(String[] args) {
// ArrayList<Integer> arrL = new ArrayList<>();
// arrL.add(1);
// arrL.add(2);
// arrL.add(3);
// arrL.add(4);

// for (int val : arrL) {
// System.out.print(val + " ");
// }
// System.out.println();

// arrL.remove(2);
// for (int val : arrL) {
// System.out.print(val + " ");
// }
// System.out.println();

// }
// }

// import java.util.*;
// import java.io.*;

// public class tenp {
// public static void main(String[] args) {
// Scanner scn = new Scanner(System.in);
// int n = scn.nextInt();

// int a = 0;
// int b = 1;

// for (int i = 0; i <= n; i++) {
// if (i == 0 || i == 1) {
// System.out.println(i);
// } else {
// System.out.println(a + b);
// b = a + b;
// a = b - a;
// }
// }
// }
// }

// import java.util.*;
// import java.io.*;

// public class tenp {
// public static void main(String[] args) {
// System.out.println('a' + 1);
// }
// }
import java.util.*;
import java.io.*;

public class tenp {
    static int[] notPrime = new int[500001];

    public static void best(int n) {
        notPrime[0] = 1;
        for (int i = 3; i * i <= n; i += 2) {
            if (notPrime[i / 2] == 0) {
                for (int j = i * 3; j <= n; j += 2 * i) {
                    notPrime[j / 2] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println((char) ('a' + 1));
    }
}