import java.util.Iterator;

public class BankAccountFiltering {
    public static List<BankAccount> getAllValidAccounts(Iterable<BankAccount> accounts, 
                                                        int requiredBalance, 
                                                        int minAccountNumber, 
                                                        int maxAccountNumber) {
        FilterByAccountNumber filterByAccountNumber = new FilterByAccountNumber(minAccountNumber,maxAccountNumber);
        FilterByBalance filterByBalance = new FilterByBalance(requiredBalance);
        List<Filter> filterList = new LinkedList<>();
        filterList.add(filterByBalance);
        filterList.add(filterByAccountNumber);
        FilterIterator<BankAccount> filterIterator = new FilterIterator<>(accounts,(Iterable)filterList);
        List<BankAccount> returnedlist = new LinkedList<>();
        while (filterIterator.hasNext()){
            returnedlist.add(filterIterator.next());
        }
        return returnedlist;
    }
}
