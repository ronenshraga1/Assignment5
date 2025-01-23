import java.util.Comparator;

public class TestBalance {
    private static boolean isBalanced(BinaryNode<BankAccount> node) {
        if (node == null) {
            return true;
        }
        int left = treeHeight(node.left);
        int right = treeHeight(node.right);
        if (left - right > 1 || right - left > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }
    private static int treeHeight(BinaryNode<BankAccount> node) {
        if (node == null) {
            return -1;
        }
        int left = treeHeight(node.left);
        int right = treeHeight(node.right);
        if(left > right){
            return left + 1;
        } else{
            return right + 1;
        }
    }
    public static void test1(){
        Comparator<BankAccount> cmprtr = new AccountComparatorByNumber();
        BankAccountsBinarySearchTree bt = new BankAccountsBinarySearchTree(cmprtr);
        bt.insert(new BankAccount("a",5,0));
        bt.insert(new BankAccount("b",4,0));
        bt.insert(new BankAccount("b",3,0));
        bt.insert(new BankAccount("c",20,0));
        System.out.println("Tree before balancing:");
        System.out.println(bt);
        String expectedOutput =bt.toString();
        bt.balance();
        System.out.println("Tree after balancing:");
        System.out.println(bt);
        System.out.println("is expected output:" + isBalanced(bt.root));

    }
    public static void test2(){
        Comparator<BankAccount> cmprtr = new AccountComparatorByNumber();
        BankAccountsBinarySearchTree bt = new BankAccountsBinarySearchTree(cmprtr);
        bt.insert(new BankAccount("4", 4, 0));
        bt.insert(new BankAccount("1", 1, 0));
        bt.insert(new BankAccount("2", 2, 0));
        bt.insert(new BankAccount("3", 3, 0));
        bt.insert(new BankAccount("5", 5, 0));
        bt.insert(new BankAccount("6", 6, 0));
        bt.insert(new BankAccount("7", 7, 0));
        System.out.println("Tree before balancing:");
        System.out.println(bt);
        String expectedOutput =bt.toString();
        bt.balance();
        System.out.println("Tree after balancing:");
        System.out.println(bt);
        System.out.println("is expected output:" + isBalanced(bt.root));
    }
    public static void test3() {
        Comparator<BankAccount> cmprtr = new AccountComparatorByNumber();
        BankAccountsBinarySearchTree bt = new BankAccountsBinarySearchTree(cmprtr);
        bt.insert(new BankAccount("8", 8, 0));
        bt.insert(new BankAccount("3", 3, 0));
        bt.insert(new BankAccount("10", 10, 0));
        bt.insert(new BankAccount("1", 1, 0));
        bt.insert(new BankAccount("6", 6, 0));
        bt.insert(new BankAccount("4", 4, 0));
        bt.insert(new BankAccount("7", 7, 0));
        System.out.println("Tree before balancing:");
        System.out.println(bt);
        String expectedOutput = bt.toString();
        bt.balance();
        System.out.println("Tree after balancing:");
        System.out.println(bt);
        System.out.println("is expected output:" + isBalanced(bt.root));
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }



}
