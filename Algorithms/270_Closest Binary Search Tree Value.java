//返回的是最close的节点value
//recursive
//每次把问题的规模缩小一半
public int closestValue(TreeNode root, double target) {
    int a = root.val;
    TreeNode kid = target < a ? root.left : root.right;
    if (kid == null) return a;
    int b = closestValue(kid, target);
    return Math.abs(a - target) < Math.abs(b - target) ? a : b;
}

//iterative
int closestValue(TreeNode* root, double target) {
    int closest = root->val;
    //记住，操作是先对当前的root做判断
    while (root) {
        if (abs(closest - target) >= abs(root->val - target))
            closest = root->val;
        root = target < root->val ? root->left : root->right;
    }
    return closest;
}