import java.util.*;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}

class MyTree{
    private final TreeNode root;

    private TreeNode buildTree(int[]buff,int pos){
        if(pos>=buff.length){
            return null;
        }
        TreeNode node=new TreeNode(buff[pos]);
        node.left=buildTree(buff,2*pos+1);
        node.right=buildTree(buff,2*pos+2);
        return node;
    }

    MyTree(int[]buff){//前序遍历创建树
        if(buff.length==0){
            throw new RuntimeException("初始化二叉树失败");
        }
        this.root=buildTree(buff,0);
    }

    //层序遍历
    private void _SequenceDisplay(TreeNode node){
        if(node==null){
            return;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            TreeNode nodeTmp=queue.poll();
            System.out.print(nodeTmp.val+" ");
            if(nodeTmp.left!=null){
                queue.offer(nodeTmp.left);
            }
            if(nodeTmp.right!=null){
                queue.offer(nodeTmp.right);
            }
        }
    }
    public void SequenceDisplay(){
        _SequenceDisplay(root);
    }

    //后序遍历
    private void _postorderDisPlay(TreeNode node){
        if(node==null){
            return;
        }
        _postorderDisPlay(node.left);
        _postorderDisPlay(node.right);
        System.out.print(node.val+" ");
    }
    private void _postorderDisPlayNotRecurve(TreeNode node){
        if(node==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        TreeNode prev=null;
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            if(node.right==null||node.right==prev){
                System.out.print(node.val+" ");
                prev=node;
                node=null;
            }
            else{
                stack.push(node);
                node=node.right;
            }
        }
    }
    private void _postorderMorrisDisPlay(TreeNode node,ArrayList<Integer>array){
        if(node==null){
            return;
        }
        //array存放后序遍历结果
        TreeNode leftNode=null;
        while(node!=null){
            leftNode=node.right;
            if(leftNode!=null){
                while(leftNode.left!=null&&leftNode.left!=node){
                    leftNode=leftNode.left;
                }
                if(leftNode.left==null){
                    array.add(node.val);
                    leftNode.left=node;
                    node=node.right;
                    continue;
                }
                else{
                    leftNode.left=null;
                }
            }
            else{
                array.add(node.val);
            }
            node=node.left;
        }
        Collections.reverse(array);
    }
    public void postorderDisPlay(){
        if (root == null){
            throw new RuntimeException("树节点为空");
        }
        _postorderDisPlay(root);
        System.out.println();
        _postorderDisPlayNotRecurve(root);
        System.out.println();
        ArrayList<Integer> array=new ArrayList<>();
        _postorderMorrisDisPlay(root,array);
        System.out.println(array);
    }

    //中序遍历
    private void _InorDisplay(TreeNode node){
        if(node==null){
            return;
        }
        _InorDisplay(node.left);
        System.out.print(node.val+" ");
        _InorDisplay(node.right);
    }
    private void _InorDisplayNotRecurve(TreeNode node){
        if(node==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            System.out.print(node.val+" ");
            node=node.right;
        }
    }
    private void _InorMorrisDisplay(TreeNode node){
        if(node==null){
            return;
        }
        TreeNode nodeRight=null;
        while(node!=null){
            nodeRight=node.left;
            if(nodeRight!=null){
                while(nodeRight.right!=null&&nodeRight.right!=node){
                    nodeRight=nodeRight.right;
                }
                if(nodeRight.right==null){
                    nodeRight.right=node;
                    node=node.left;
                    continue;
                }
                else {
                    System.out.print(node.val+" ");
                    nodeRight.right=null;
                }
            }
            else{
                System.out.print(node.val+" ");
            }
            node=node.right;
        }
    }
    public void InorDisplay(){
        if (root == null){
            throw new RuntimeException("树节点为空");
        }
        _InorDisplay(root);
        System.out.println();
        _InorDisplayNotRecurve(root);
        System.out.println();
        _InorMorrisDisplay(root);
        System.out.println();
    }

    //前序遍历
    private void _preDisplay(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.val+" ");
        _preDisplay(node.left);
        _preDisplay(node.right);
    }
    private void _preDisplayNotRecursion(TreeNode node){
        if(node==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                System.out.print(node.val+" ");
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            node=node.right;
        }
    }
    private void _preMorrisDisplay(TreeNode node){
        if(node==null){
            return;
        }
        TreeNode nodeRight=null;
        while(node!=null){
            nodeRight=node.left;
            if(nodeRight!=null){
                while(nodeRight.right!=null&&nodeRight.right!=node){
                    nodeRight=nodeRight.right;
                }
                if(nodeRight.right==null){
                    System.out.print(node.val+" ");
                    nodeRight.right=node;
                    node=node.left;
                    continue;
                }
                else {
                    nodeRight.right=null;
                }
            }
            else{
                System.out.print(node.val+" ");
            }
            node=node.right;
        }
    }
    public void preDisplay(){
        if(root==null){
            throw new RuntimeException("根节点为空");
        }
        _preDisplay(this.root);
        System.out.println();
        _preDisplayNotRecursion(this.root);//非递归
        System.out.println();
        _preMorrisDisplay(this.root);
        System.out.println();
    }

    //获取树中的节点个数
    private int _getNodeSize(TreeNode node){
        if(node==null){
            return 0;
        }
        return _getNodeSize(node.left)+_getNodeSize(node.right)+1;
    }
    public int getNodeSize(){
        if(root==null){
            throw new RuntimeException("根节点为空");
        }
        return _getNodeSize(this.root);
    }

    //获取树的叶子节点个数
    private int _getLeafSize(TreeNode node){
        if(node==null){
            return 0;
        }
        if(node.left==null&&node.right==null){
            return 1;
        }
        return _getLeafSize(node.left)+_getLeafSize(node.right);
    }
    public int getLeafSize(){
        if(root==null){
            throw new RuntimeException("根节点位空");
        }
        return _getLeafSize(this.root);
    }

    //获取二叉树第k层节点个数
    private  int _getKSize(TreeNode node,int K){
        if(node==null||K<=0){
            return 0;
        }
        if(K==1){
            return 1;
        }
        return _getKSize(node.left,K-1)+_getKSize(node.right,K-1);
    }
    public int getKSize(int K){
        if(root==null){
            throw new RuntimeException("根节点位空");
        }
        return _getKSize(this.root,K);
    }

    //获取二叉树高度
    public int _getTreeHigh(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftHigh=_getTreeHigh(node.left);
        int rightHigh=_getTreeHigh(node.right);
        return Math.max(leftHigh,rightHigh)+1;
    }
    public int getTreeHigh(){
        if(root==null){
            throw new RuntimeException("根节点位空");
        }
        return _getTreeHigh(this.root);
    }

    //检测值位val的节点是否存在
    private TreeNode _find(TreeNode node,int val){
        if(node==null){
            return null;
        }
        if(node.val==val){
            return node;
        }
        TreeNode find=_find(node.left,val);
        if(find!=null){
            return find;
        }
        find=_find(node.right,val);
        return find;
    }
    public TreeNode find(int val){
        if(root==null){
            throw new RuntimeException("根节点位空");
        }
        return _find(this.root,val);
    }

    //判断这棵树是否是完全二叉树
    /*
      完全二叉树使用队列，当弹出的队列元素为空时，整个队列都为空。
     */
    private boolean _checkQueue(Queue<TreeNode>queue){//检查队列的元素是否全部为null
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node!=null){
                return false;
            }
        }
        return true;
    }
    private boolean _isCompTree(TreeNode node){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(node);
        boolean ret=true;
        while(true){
            TreeNode nodeTmp=queue.poll();
            if(nodeTmp==null){
                ret=_checkQueue(queue);
                break;
            }
            queue.offer(nodeTmp.left);
            queue.offer(nodeTmp.right);
        }
        return ret;
    }
    public boolean isCompTree(){
        if(root==null){
            throw new RuntimeException("根节点位空");
        }
        return _isCompTree(this.root);
    }
}

public class TestTree {
    public static void main(String[] args) {
        MyTree tree=new MyTree(new int[]{1,2,3,4,5,6,7,8,9,10});
        tree.preDisplay();
        tree.InorDisplay();
        tree.postorderDisPlay();
        tree.SequenceDisplay();
//        System.out.println(tree.getNodeSize());
//        System.out.println(tree.getLeafSize());
//        System.out.println(tree.getKSize(4));
//        System.out.println(tree.getTreeHigh());
//        System.out.println(tree.find(1111));
//        System.out.println(tree.find(3));
//        System.out.println(tree.isCompTree());
    }
}
