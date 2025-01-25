import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFilterIterator {

    public static void main(String[] args) {
        // Create test BankAccount objects
        BankAccount account1 = new BankAccount("Alice", 1, 500);
        BankAccount account2 = new BankAccount("Bob", 2, 1500);
        BankAccount account3 = new BankAccount("Charlie", 3, 1000);
        BankAccount account4 = new BankAccount("Diana", 4, 2500);
        BankAccount account5 = new BankAccount("Eve", 5, 200);

        // Create a list of bank accounts
        List<BankAccount> accounts = Arrays.asList(account1, account2, account3, account4, account5);

        // Define filters
        Filter<BankAccount> balanceFilter = new FilterByBalance(1000);
        Filter<BankAccount> accountNumberFilter = new FilterByAccountNumber(2, 4);

        // Combine filters
        List<Filter<BankAccount>> filters = Arrays.asList(balanceFilter, accountNumberFilter);

        // Create the FilterIterator
        FilterIterator<BankAccount> filterIterator = new FilterIterator<>(accounts, filters);
        System.out.println(BankAccountFiltering.getAllValidAccounts(accounts,1000,2,4));

        // Test hasNext and next methods
//        System.out.println("Filtered accounts:");
//        while (filterIterator.hasNext()) {
//            System.out.println(filterIterator.next());
//        }

//        // Edge case: Test empty list
//        List<BankAccount> emptyList = new ArrayList<>();
//        FilterIterator<BankAccount> emptyIterator = new FilterIterator<>(emptyList, filters);
//        System.out.println("Empty list test:");
//        System.out.println("Has next: " + emptyIterator.hasNext());
//
//        // Edge case: Test null filters
//        try {
//            FilterIterator<BankAccount> nullFilterIterator = new FilterIterator<>(accounts, null);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Caught expected exception for null filters: " + e.getMessage());
//        }
//
//        // Edge case: Test null elements
//        try {
//            FilterIterator<BankAccount> nullElementsIterator = new FilterIterator<>(null, filters);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Caught expected exception for null elements: " + e.getMessage());
//        }
    }
}
