import java.util.*;
import java.io.*;

public class reverseanarray {
	public static void main(String[] args) throws Exception {
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bs.readLine());

		while (t != 0) {
			int n = Integer.parseInt(bs.readLine());
			String line = bs.readLine();

			String[] arr = line.split(" ");

			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(arr[i]);
			}

			int i = 0;
			int j = nums.length - 1;

			while (i < j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;

				i++;
				j--;
			}

			for (int x : nums) {
				System.out.print(x + " ");
			}
			System.out.println();
			t--;
		}

	}
}