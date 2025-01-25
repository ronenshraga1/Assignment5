public class TestBank {
    public static void test1(){
        Bank bank = new Bank();
        bank.add(new BankAccount("a",1,100));
        bank.add(new BankAccount("b",2,100));
        bank.add(new BankAccount("c",3,100));
        bank.add(new BankAccount("d",4,100));
        bank.add(new BankAccount("e",5,100));
        System.out.println(bank.transferMoney(50,1,"g"));
    }
    public static void main(String[] args){
        test1();
    }
}
