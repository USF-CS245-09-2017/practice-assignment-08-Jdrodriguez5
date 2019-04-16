public class BST<S> {


    private class BSTNode extends BST<S> {
        public Comparable data;
        public BSTNode left;
        public BSTNode right;

        BSTNode(Comparable newdata){
            data = newdata;
        }
    }
    private BSTNode root;



    public boolean find(Comparable value)
    {
        return find(root, value);
    }
    private boolean find(BSTNode node, Comparable value)
    {
        if(node == null)
            return false;
        if(value.compareTo(value) == 0)
            return true;
        else if(value.compareTo(value) < 0)
            return find(node.left, value);
        else
            return find(node.right, value);
    }


    public void insert(S value)
    {
        root = insert(root, (Comparable) value);
    }

    public BSTNode insert(BSTNode node, Comparable value)
    {
        if(node == null)
        {
            return new BSTNode(value);
        } else if(node.data.compareTo(value) < 0) // right side
        {
            node.left = insert(node.left, value);
        } else { // left side, could also just be else if (node.data.compareTo(value) > 0)
            node.right = insert(node.right, value);
        }
        return node; //call from root
    }

    public void print()
    {
        print(root);
    }

    public void print(BSTNode node)
    {
        if(node != null)
        {
            print(node.left);
            System.out.print(node.data); // node.data += node.data * 0.15; // to increase all nodes by 15%.
            print(node.right);
        }
    }

    public void delete(Comparable insertable) {
        delete(this.root, insertable);
    }

    public BSTNode delete(BSTNode node, Comparable value) {
        if (node == null) {
            return null;
        }
        if (node.data.compareTo(value) == 0) {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                if (node.left == null) {
                    node.data = node.right.data;
                    node.right = node.right.right;
                    return node;
                } else {
                    node.data = (Comparable) removeSmallest(node.right);
                    return node;
                }
            }
        } else if(node.data.compareTo(value) < 0){
            node.left = delete(node.left, value);
        } else {
            node.right = delete(node.right, value);
            return node;
        }
        return node;
    }



    public BSTNode removeSmallest(BSTNode node)
    {
        if(node.left.left == null)
        {
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return (BSTNode) smallest;
        } else {
            return removeSmallest(node.left);
        }
    }
}
