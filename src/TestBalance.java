import java.util.Comparator;

public class TestBalance {
    public static void main(String[] args) {
        Comparator<BankAccount> cmprtr = new AccountComparatorByNumber();
        BankAccountsBinarySearchTree bt = new BankAccountsBinarySearchTree(cmprtr);
        bt.insert(new BankAccount("a",5,0));
        bt.insert(new BankAccount("b",4,0));
        bt.insert(new BankAccount("b",3,0));
        bt.insert(new BankAccount("c",20,0));
        System.out.println("Tree before balancing:");
        System.out.println(bt);

        bt.balance();
        System.out.println("Tree after balancing:");
        System.out.println(bt);
    }



}
