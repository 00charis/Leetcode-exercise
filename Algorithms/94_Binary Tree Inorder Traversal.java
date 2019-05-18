//recursive的方法
private void helper(TreeNode p, List<Integer> ret) {
		if(p == null) {
			return;
		}
		
		helper(p.left, ret);
		ret.add(p.val);
		helper(p.right, ret);
		
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        
        helper(root, ret);
        return ret;
    }


//用stack模拟递归的操作
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode p = root;
        while(p != null || !stack.isEmpty()) {//记住这里有2个while语句
        		while(p != null) {
        			stack.push(p);
        			p = p.left;
        		}
        		
        		p = stack.pop();
        		ret.add(p.val);
        		p = p.right;
        }
        
        return ret;
    }




