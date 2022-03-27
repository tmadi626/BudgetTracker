package application;

import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class TransactionItem extends AnchorPane{
	@FXML
	CheckBox transactionCheck;
	@FXML
	Label transactionTitle, transactionType, transactionCategory, transactionSubcategory, transactionDate, transactionAmmount;
	
	
	public TransactionItem(String t, TransactionType ty, String c, String sc, LocalDate d, String amm) {
		//Making the Transaction Item as a component
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/transactionItem.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
        	
            loader.load();
        } catch (IOException exception) {
        	throw new RuntimeException(exception);
        }

        
        
		String tType ="";
		if(ty == TransactionType.EXPENSE) {
			tType = "Expense";
		}else {
			tType = "Income";
		}
        //Setting the components features:
        this.transactionTitle.setText(t);
        this.transactionType.setText(tType);
        this.transactionCategory.setText(c);
        this.transactionSubcategory.setText(sc);
        this.transactionDate.setText(d.toString());
        this.transactionAmmount.setText("$"+adjustAmmount(amm));
        
	}

	private String adjustAmmount(String amm) {
		int ammLen = amm.length();
		
		if(ammLen ==4) {
			return amm.substring(0, 1)+"K";
		}else if(ammLen ==5) {
			return amm.substring(0, 2)+"K";
		}else if(ammLen ==6) {
			return amm.substring(0, 3)+"K";
		}else if(ammLen ==7) {
			return amm.substring(0, 1)+"M";
		}else if(ammLen ==8) {
			return amm.substring(0, 2)+"M";
		}else if(ammLen ==9) {
			return amm.substring(0, 3)+"M";
		}else if(ammLen ==10) {
			return amm.substring(0, 1)+"B";
		}else if(ammLen ==11) {
			return amm.substring(0, 2)+"B";
		}else if(ammLen ==12) {
			return amm.substring(0, 3)+"B";
		}
		return amm;
	}
}
