package application;

//import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;




public class TransactionsController implements View, Initializable{
	
	@FXML
	TextField searchField;
	@FXML
	VBox transactionsList;
	
	private ArrayList<TransactionItem> TransactionItemList = new ArrayList<TransactionItem>();
	
	private Model model;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		EventHandler<ActionEvent> searchEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {	//Check if the field isn't empty
            	if ( searchField.getText() != "" && searchField.getText() != null) {
                	//create a temporary array for the matching transactions
            		ArrayList<TransactionItem> wantedTransactions = new ArrayList<TransactionItem>();
                	//Get the text of what we are looking for
            		String lookUp = searchField.getText();
            		for (TransactionItem tr : TransactionItemList) {
                		if(lookUp.equals(tr.getTransaction().getName()) || lookUp.equals(Double.toString(tr.getTransaction().getValue())) || lookUp.equals(tr.category) || lookUp.equals(tr.subCategory)) {
                			// if the name of thetransaction, category,subcategory, or ammount, or date is found then add it
                			wantedTransactions.add(tr);
                		}
                	}
                	//Display the found
                	transactionsList.getChildren().setAll(wantedTransactions);
            	}else {
            		//If the search is empty, then display all of the transactions
            		transactionsList.getChildren().setAll(TransactionItemList);
            	}
            }
        };
		searchField.setOnAction(searchEvent);
	}

	public void setModel(Model m) {
		this.model = m;
	}
	
	public Model getModel() {
		return this.model;
	}
	
	public void addTransaction(String category, String subcategory, Transaction newTransaction) {
		TransactionItem newTransactionItem = new TransactionItem(category, subcategory, newTransaction, this);
		TransactionItemList.add(newTransactionItem);
	}

	public void deleteTransaction(TransactionItem transactionItem) {
		//Called only from transactionItem class (controller)
		TransactionItemList.remove(transactionItem);
		this.model.removeTransaction(transactionItem.category, transactionItem.subCategory, transactionItem.getTransaction());
	}

	@Override
	public void update() {
		transactionsList.getChildren().setAll(TransactionItemList);
	}
	


}
