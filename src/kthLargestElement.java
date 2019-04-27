/**
 * @author Harry Tran on 11/3/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class kthLargestElement {
	private int partition(int[] nums, int lo, int hi, int k) {
		// select a random element, and store it to the end
		int mid = (lo + hi) / 2;
		swap(nums, mid, hi);
		int i = lo, j = hi - 1, pivot = nums[hi];

		// partition
		while (i <= j) {
			if (nums[i] > pivot) {
				swap(nums, i, j);
				j--;
			} else ++i;
		}

		// put it into the right position
		swap(nums, i, hi);

		// check as if it is the k-smallest element
		int count = i - lo + 1;
		if (count == k) return i;
		if (count > k) return partition(nums, lo, i - 1, k);
		return partition(nums, i + 1, hi, k - count);
	}


	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public int findKthLargest(int[] nums, int k) {
		int i = partition(nums, 0, nums.length - 1, nums.length - k + 1);
		return nums[i];
	}

	public static void main(String[] args) {
		kthLargestElement ke = new kthLargestElement();
//		int[] a = {3,2,3,1,2,4,5,5,6};
		int[] a = {3,2,1,3,3,3,3,5,6};
		System.out.println(ke.findKthLargest(a, 5));
	}
}
