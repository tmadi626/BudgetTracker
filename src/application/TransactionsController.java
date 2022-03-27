package application;

//import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;




public class TransactionsController implements Initializable{
	
	@FXML
	TextField searchField;
	@FXML
	VBox transactionsList;
	
	private Model model;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

	public void setModel(Model m) {
		this.model = m;
	}
	
	public Model getModel() {
		return this.model;
	}
	
	public void addTransaction(String t, TransactionType ty, String c, String sc, LocalDate d, String amm) {
		transactionsList.getChildren().add( new TransactionItem(t, ty, c, sc, d, amm));
	}
	


}
