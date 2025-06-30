public class BinaryTree {

    private TreeNode root;

    public BinaryTree(String[] values, String[] s){

        
        
        this.root = createPerfectBinaryTree(values);
        modifyLastLevelValues(root,s);

    }//cons


    public static TreeNode createPerfectBinaryTree(String[] values) {
    if (values == null || values.length == 0){
        return null;
    }//if

    TreeNode root = new TreeNode(values[0]);

    constructPerfectBinaryTree(root, values, 1);

    return root;
    }//createBT


    private static void constructPerfectBinaryTree(TreeNode node, String[] values, int level) {
  
         if (level >= values.length || node == null){
            return;
        }//if

    node.left = new TreeNode(values[level]);
    node.right = new TreeNode(values[level]);

    constructPerfectBinaryTree(node.left, values, level + 1);
    constructPerfectBinaryTree(node.right, values, level + 1);

    }//counstruct


public static void inOrderTraversal(TreeNode node) {
    if (node == null){
        return;
    }
    inOrderTraversal(node.left);
    System.out.print(node.value + " ");
    inOrderTraversal(node.right);
}//in order

public static void modifyLastLevelValues(TreeNode root,String[] s) {
    if (root == null){
        return;
    }//if

 
    int lastLevel = findLastLevel(root, 0);

   
     int[] count = new int[1];
    modifyLastLevel(root, lastLevel,s,count);
}//modify last level


private static int findLastLevel(TreeNode node, int level) {
     while (node != null) {
        node = node.left;
        level++;
    }
    return level - 1;
}//find last level


private static void modifyLastLevel(TreeNode node, int targetLevel, String[] s, int[] count) {
      
    if (node == null){
        return;
    }

    // If the current node is on the last level, assign a different value
    if (targetLevel == 0) {
        node.value = s[count[0]];
        ++count[0];
        
    } else {
        // Recursively modify values on the last level in the left and right subtrees
        modifyLastLevel(node.left, targetLevel - 1,s,count);
        modifyLastLevel(node.right, targetLevel - 1,s,count);
    }
}

public static String suggest(TreeNode root, String str, int index) {
    
    if (root.getRight() == null && root.getLeft() == null) {
        return root.getValue();
    }

   
    if (str.isEmpty() || index < 0 || index >= 4) { 
        return "No suggestion available";
    }

    char[] charactersToCheck = {'A', 'B', 'C', 'D'};

    char currentChar = charactersToCheck[index];

    boolean isCharPresent = str.contains(String.valueOf(currentChar));

    if (isCharPresent) {
      
        str = str.replace(currentChar, ' ');
        return suggest(root.getRight(), str, index + 1);
    } 
    // Otherwise, move to the left child
    else {
        return suggest(root.getLeft(), str, index+1);
    }
}//method

public TreeNode getRoot(){
    return this.root;
}

}






