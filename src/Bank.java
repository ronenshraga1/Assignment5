public class Bank {

	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;
	
	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}

	
	// END OF Given code -----------------------------------
	

	public boolean add(BankAccount newAccount) {
		if(newAccount == null){
			throw new IllegalArgumentException("value is null");
		}
		if(!namesTree.contains(newAccount) && !accountNumbersTree.contains(newAccount)){
			namesTree.insert(newAccount);
			accountNumbersTree.insert(newAccount);
			return true;
		} else{
			return false;
		}
	}


	public boolean delete(String name){
		BankAccount findBank = new BankAccount(name,1,0);
		if(namesTree.contains(findBank)){
			findBank = namesTree.findData(findBank);
			namesTree.remove(findBank);
			accountNumbersTree.remove(findBank);
			return true;
		} else{
			return false;
		}
	}
	

	public boolean delete(int accountNumber){
		BankAccount findBank = new BankAccount("a",accountNumber,0);
		if(accountNumbersTree.contains(findBank)){
			findBank = accountNumbersTree.findData(findBank);
			namesTree.remove(findBank);
			accountNumbersTree.remove(findBank);
			return true;
		} else{
			return false;
		}


	}
	

	public boolean depositMoney(int amount, int accountNumber){
		BankAccount findBank = new BankAccount("a",accountNumber,1);
		if(accountNumbersTree.contains(findBank)){
			findBank = accountNumbersTree.findData(findBank);
			boolean canDeposit = findBank.depositMoney(amount);
			if(!canDeposit){
				return false;
			}
			delete(accountNumber);
			accountNumbersTree.insert(findBank);
			namesTree.insert(findBank);
			namesTree.balance();
			accountNumbersTree.balance();
			return true;
		} else{
			return false;
		}
	}


	public boolean withdrawMoney(int amount, int accountNumber){
		BankAccount findBank = new BankAccount("a",accountNumber,1);
		if(accountNumbersTree.contains(findBank)){
			findBank = accountNumbersTree.findData(findBank);
			boolean canwithdraw = findBank.withdrawMoney(amount);
			if(!canwithdraw){
				return false;
			}
			delete(accountNumber);
			accountNumbersTree.insert(findBank);
			namesTree.insert(findBank);
			namesTree.balance();
			accountNumbersTree.balance();
			return true;
		} else{
			return false;
		}
	}

	public boolean transferMoney(int amount, int accountNumber1, int accountNumber2) {
		BankAccount findBank = new BankAccount("a",accountNumber1,1);
		BankAccount findBank2 = new BankAccount("b",accountNumber2,1);
	    if(accountNumbersTree.contains(findBank) && accountNumbersTree.contains(findBank2)){
			findBank = accountNumbersTree.findData(findBank);
			if(findBank.getBalance() >= amount){
				findBank.withdrawMoney(amount);
				findBank2 = accountNumbersTree.findData(findBank2);
				boolean canDeposit = findBank2.depositMoney(amount);
				if(!canDeposit){
					return false;
				}
				delete(accountNumber1);
				delete(accountNumber2);
				add(findBank);
				add(findBank2);
				accountNumbersTree.balance();
				namesTree.balance();
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
   
    public boolean transferMoney(int amount, int accountNumber, String name) {
		BankAccount findBank = new BankAccount("a",accountNumber,1);
		BankAccount findBank2 = new BankAccount(name,1,1);
		if(accountNumbersTree.contains(findBank) && namesTree.contains(findBank2)){
			findBank = accountNumbersTree.findData(findBank);
			if(findBank.getBalance() >= amount){
				findBank.withdrawMoney(amount);
				findBank2 = namesTree.findData(findBank2);
				boolean canDeposit =findBank2.depositMoney(amount);
				if(!canDeposit){
					return false;
				}
				delete(accountNumber);
				delete(name);
				add(findBank);
				add(findBank2);
				accountNumbersTree.balance();
				namesTree.balance();
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}
}
