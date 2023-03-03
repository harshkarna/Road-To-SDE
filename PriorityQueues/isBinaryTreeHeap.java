//class Solution {

/*    int countNodes(Node tree){
        //base case
        if (tree ==null){
            return 0;
        }
        int ans= 1+countNodes(tree.left) + countNodes(tree.right);
        return ans;
    }

    boolean isCBT(Node tree, int index, int nodeCount){
        if(tree==null){
            return true;
        }
        //now if the count of index goes equal or beyond count of tatal ndoes , then its not a cbt
        if(index >=nodeCount){
            return false;
        }
        else{
            boolean left=isCBT(tree.left, 2*index+1, nodeCount);
            boolean right=isCBT(tree.right,2*index+2,nodeCount);
            return left && right;
        }

    }

    boolean isMaxOrder(Node tree){
        //leaf node
        if(tree.left == null && tree.right ==null){
            return true;
        }

        //single child , checking right only as we know its a cbt
        if(tree.right ==null){
            return (tree.data > tree.left.data);
        }
        else{
            //both child
            boolean left=isMaxOrder(tree.left);
            boolean right=isMaxOrder(tree.right);

            return (left && right && (tree.data > tree.left.data && tree.data > tree.right.data));
        }
    }

    boolean isHeap(Node tree) {
        int index =0;
        int totalCount=countNodes(tree);

        if(isCBT(tree,index, totalCount) && isMaxOrder(tree)){
            return true;
        }
        else{
            return false;
        }

    }*/
//}