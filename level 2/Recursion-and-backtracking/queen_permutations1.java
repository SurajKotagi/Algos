import java.io.*;
import java.util.*;

//----------------------------------------------------------------
// Queens Combinations - 2d As 2d - Box Chooses
//----------------------------------------------------------------
public class queen_permutations1 {
    // qpsf - queens placed so far
    // tq - total number of queens need to be placed
    // row - row on which we are currently working
    // column - column on which we are currently working
    // asf - answer so far
    // n - number of rows / columns in chess board
    public static void solution(int qpsf, int n, int tq, int row, int col, String asf) {
        // this is a combination type of question as all the queens are same

        // base case
        // it was told in question that we shoould place n queens
        if (row == n) {
            if (qpsf == tq) {
                System.out.println(asf);
            }
            return;
        }

        // handling the path within the chess board and answer need to appended
        // nrow - next row ncol- next column
        int nrow = 0;
        int ncol = 0;

        String yes = "";
        String no = "";

        // at the end of column
        if (col == n - 1) {
            // handing path flow
            nrow = row + 1;
            ncol = 0;
            // handling answer need to be added to asf
            yes = "q\n";
            no = "-\n";

        } else {
            // handing path flow
            nrow = row;
            ncol = col + 1;
            // handling answer need to be added to asf
            yes = "q";
            no = "-";
        }

        // for every spot there are two options available

        // queen decides to be placed on current spot
        solution(qpsf + 1, n, tq, nrow, ncol, asf + yes);

        // queen decides not to be placed on current spot
        solution(qpsf, n, tq, nrow, ncol, asf + no);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        solution(0, n, n, 0, 0, "");
    }
}