
public class FilterByBalance implements Filter<BankAccount>{
	private int balanceThreshold;
	public FilterByBalance(int balanceThreshold) {
		this.balanceThreshold = balanceThreshold;
	}
	
	@Override
	public boolean accept(BankAccount element) {
	    if(element.getBalance() >= this.balanceThreshold){
			return true;
		} else{
			return false;
		}

	}
}
