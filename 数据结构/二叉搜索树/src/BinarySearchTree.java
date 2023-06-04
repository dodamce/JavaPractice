class Node{
    public Node left;
    public Node right;
    public int val;
    public Node(int _val){
        this.val=_val;
    }
}

class BinarySearchTree {
    public Node root;

    private  void _inorder(Node node){
        if(node==null){
            return;
        }
        _inorder(node.left);
        System.out.print(node.val+" ");
        _inorder(node.right);
    }
    public void inorder(){
        _inorder(root);
    }
    public Node searchNode(int val){
        //二叉搜索树查找
        Node node=root;
        while(node!=null){
            if(node.val<val){
                node=node.right;
            }
            else if(node.val>val){
                node=node.left;
            }
            else{
                return node;
            }
        }
        return null;
    }

    public boolean insertNode(int val){
        Node prev=null; Node node=root;
        while(node!=null){
            prev=node;
            if(node.val>val){
                node=node.left;
            }
            else if(node.val<val){
                node=node.right;
            }
            else{
                //重复元素
                return false;
            }
        }
        node=new Node(val);
        if(prev==null){
            //开始树为空
            root=node;
        }
        else{
            //树不为空
            if(prev.val>val){
                prev.left=node;
            }
            else{
                prev.right=node;
            }
        }
        return true;
    }

    //二叉搜索树的删除
    private void removeNode(Node node,Node parent){
        if(node.left==null){
            if(node==root){
                root=node.right;
            }
            else if(node==parent.left){
                parent.left=node.right;
            }
            else{
                parent.right=node.right;
            }
        }
        else if(node.right==null){
            if(node==root){
                root=node.left;
            }
            else if(node==parent.left){
                parent.left=node.left;
            }
            else{
                parent.right=node.left;
            }
        }
        else{
            //左右都有节点，找左树最大值或找右树最小值
            //这里选择找左树的最大
            Node targetParent=node;
            Node target=node.right;
            while(target.left!=null){
                targetParent=target;
                target=target.left;
            }
            node.val=target.val;
            removeNode(target,targetParent);
            /*
              if(targetParent.left==target){
                  targetParent.left=target.right;
              }
              else if(targetParent==target){
                  targetParent.right=target.right;
              }
             */
        }
    }

    public boolean remove(int val){
        Node node=root;
        Node parent=null;
        while(node!=null){
            parent=node;
            if(node.val<val){
                node=node.right;
            }
            else if(node.val>val){
                node=node.left;
            }
            else{
                removeNode(node,parent);
                return true;
            }
        }
        return false;
    }
}
