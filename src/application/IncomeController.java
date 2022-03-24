package application;

import java.time.LocalDate;

public class IncomeController {

	private Model model;
	
	
	public void setModel(Model m) {
		this.model = m;
	}
	
	public Model getModel() {
		return this.model;
	}
	public void addTransaction(String title, String price, LocalDate date, String category, String type, TransactionType typeTransaction) {
		// TODO Auto-generated method stub
		System.out.println("Transaction Added: "+typeTransaction);
		System.out.println("Title: "+title +" |Value:"+price +" |Date:"+date +" |Category: "+category+" |Option: "+type);
	}

}
