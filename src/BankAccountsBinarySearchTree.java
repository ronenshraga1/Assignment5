
import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}
	
	public void balance(){
		Iterator<BankAccount> it = iterator();
		List<BankAccount> list = new LinkedList<BankAccount>();
		while (it.hasNext()){
			list.add(it.next());
		}
		this.root = null;
	    buildBalancedTree(list,0, list.size()-1);
	}
	    
	private void buildBalancedTree(List<BankAccount> list, int low, int high) {
		if (low > high) {
			return;
		}
		int middle = (low + high) / 2;
		insert(list.get(middle));
		buildBalancedTree(list, low, middle - 1);
		buildBalancedTree(list, middle + 1, high);
	}
}
