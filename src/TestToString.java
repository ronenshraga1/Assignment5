import java.util.Comparator;

public class TestToString {
    public static void test1(){
        String expectedOutput="tree((Name: b, AccountNumber: 3,Name: b, AccountNumber: 4),Name: a, AccountNumber: 5,(Name: c, AccountNumber: 20))";
        Comparator<BankAccount> cmprtr = new AccountComparatorByNumber();
        BinarySearchTree<BankAccount> bt = new BinarySearchTree<>(cmprtr);
        bt.insert(new BankAccount("a",5,0));
        bt.insert(new BankAccount("b",4,0));
        bt.insert(new BankAccount("b",3,0));
        bt.insert(new BankAccount("c",20,0));
        System.out.println(bt.toString());
        System.out.println(expectedOutput.equals(bt.toString()));
    }
    public static void test2(){
        String expectedOutput="tree(Name: a, AccountNumber: 1,(Name: b, AccountNumber: 2))";
        Comparator<BankAccount> cmprtr = new AccountComparatorByNumber();
        BinarySearchTree<BankAccount> bt = new BinarySearchTree<>(cmprtr);
        bt.insert(new BankAccount("a",1,0));
        bt.insert(new BankAccount("b",2,0));
        System.out.println(bt.toString());
        System.out.println(expectedOutput.equals(bt.toString()));
    }
    public static void test3(){
        String expectedOutput="tree((Name: b, AccountNumber: 2),Name: a, AccountNumber: 3)";
        Comparator<BankAccount> cmprtr = new AccountComparatorByNumber();
        BinarySearchTree<BankAccount> bt = new BinarySearchTree<>(cmprtr);
        bt.insert(new BankAccount("a",3,0));
        bt.insert(new BankAccount("b",2,0));
        System.out.println(bt.toString());
        System.out.println(expectedOutput.equals(bt.toString()));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
