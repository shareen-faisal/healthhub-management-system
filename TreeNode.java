class TreeNode {
    String value;
    TreeNode left;
    TreeNode right;

    TreeNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public String getValue() {
        return value;
    }

    // Setter for value
    public void setValue(String value) {
        this.value = value;
    }

    // Getter for left
    public TreeNode getLeft() {
        return left;
    }

    // Setter for left
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    // Getter for right
    public TreeNode getRight() {
        return right;
    }

    // Setter for right
    public void setRight(TreeNode right) {
        this.right = right;
    }
    
}//class
