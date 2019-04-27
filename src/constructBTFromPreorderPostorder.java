/**
 * @author Harry Tran on 11/7/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class constructBTFromPreorderPostorder {
	public TreeNode construct(int[] pre, int preL, int preR, int[] post, int postL, int postR) {
		if (preL > preR) return null;
		if (pre[preL] != post[postR]) return null;
		TreeNode root = new TreeNode(pre[preL]);
		if (preL == preR) {
			return root ;
		}
		// Left children number: [ 1 , (preR - preL)]
		for (int i = 1; i <= preR - preL; ++i) {
			TreeNode tmpL = construct(pre, preL + 1, preL + i, post, postL, postL + i - 1);
			if (tmpL == null) continue;
			TreeNode tmpR = construct(pre, preL + i + 1, preR, post, postL + i, postR - 1);
			if (i != preR - preL && tmpR == null) continue;
			root.left = tmpL;
			root.right = tmpR;
			return root;
		}
		return null;
	}

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		return construct(pre, 0, pre.length - 1, post, 0, post.length - 1);
	}

	public static void main(String[] args) {
		constructBTFromPreorderPostorder tmp = new constructBTFromPreorderPostorder();
		int[] pre = {1,2,4,5,3,6,7};
		int[] post = {4,5,2,6,7,3,1};
		TreeNode n = tmp.constructFromPrePost(pre, post);
		System.out.println(n.val);
	}
}
