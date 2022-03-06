package application;

//import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;



public class HomeController implements Initializable{
	
	@FXML
	private TextField titleField, numField;
	@FXML
	private DatePicker dateField;
	@FXML
	private ChoiceBox<String> categoryField, subCategoryField;
	
	
	private HashMap<String, String[]> options = new HashMap<String, String[]>();
	
	private String[] categoryList = {"Children","Debt","Education","Entertainment","Everyday","Gifts","Health","Home","Insurance","Pets","Technology","Transportation","Travel","Utilities","Invests&eTransfer"};
	private String[] Children = {"Activities","Allowance","Medical","Childcare","Clothing","School","Toys","Other"};
	private String[] Debt = {"Credit cards","Student loans","Other loans","Taxes (federal)","Taxes (state)","Other"};
	private String[] Education = {"Tuition","Books","Lessons","Other"};
	private String[] Entertainment = {"Books","Concerts/shows","Games","Hobbies","Movies","Music","Outdoor activities","Photography","Sports","Theater/plays","TV","Other"};
	private String[] Everyday = {"Groceries","Restaurants","Personal supplies","Clothes","Laundry/dry cleaning","Hair/beauty","Subscriptions","Other"};
	private String[] Gifts = {"Gifts","Donations (charity)","Other"};
	private String[] Health= {"Doctors/dental/vision","Specialty care","Pharmacy","Emergency","Other"};
	private String[] Home = {"Rent/mortgage","Property taxes","Furnishings","Lawn/garden","Supplies","Maintenance","Improvements","Moving","Other"};
	private String[] Insurance = {"Car","Health","Home","Life","Other"};
	private String[] Pets = {"Food","Vet/medical","Toys","Supplies","Other"};
	private String[] Technology = {"Domains & hosting","Online services","Hardware","Software","Other"};
	private String[] Transportation = {"Fuel","Car payments","Repairs","Registration/license","Supplies","Public transit","Other"};
	private String[] Travel = {"Airfare","Hotels","Food","Transportation","Entertainment","Other"};
	private String[] Utilities = {"Phone","TV","Internet","Electricity","Heat/gas","Water","Trash","Other"};
	private String[] Invests = {"Investments","eTransfer"};
	

	@FXML
	private RadioButton typeIncome, typeExpense; 
	
	//Creating an instance of the Expense Controller
	ExpenseController expenseController = new ExpenseController();
	//Creating an instance of the Income Controller
	IncomeController incomeController = new IncomeController ();
	
	@FXML
	private void addTransaction() {
		//Get the data
		String title = titleField.getText();
		String price = numField.getText();
		LocalDate date = dateField.getValue();
		String category = categoryField.getValue();
		String type = subCategoryField.getValue();
		TransactionType typeTransaction = getTransactionType();

		
		//Add the transaction if the data valid - Not Done
		if(fieldsValid()) {
			//Adding the Transaction to Income Sheet:
			if(typeTransaction == TransactionType.INCOME) {
				incomeController.addTransaction(title, price, date, category, type, typeTransaction);		
			}//Adding the Transaction to Expesne Sheet:
			else {
				expenseController.addTransaction(title, price, date, category, type, typeTransaction);
			}

			//Clear the fields while keeping the date and the catagory
			titleField.clear();
			numField.clear();	
		}

	}

	@FXML
	private boolean fieldsValid() {
		String title = titleField.getText();
		String price = numField.getText();
		LocalDate date = dateField.getValue();
		String category = categoryField.getValue();
		String type = subCategoryField.getValue();
		
		//Check The Category Field
		if (category == null) {
			categoryField.setStyle("-fx-mark-color: red; -fx-border-width: 2px;");
			new animatefx.animation.Shake(categoryField).play();
			return false;
		}else {
			categoryField.setStyle(null);
		}
		//Check The Option Field
		if (type == null) {
			subCategoryField.setStyle("-fx-mark-color: red; -fx-border-width: 2px;");
			new animatefx.animation.Shake(subCategoryField).play();
			return false;
		}else {
			subCategoryField.setStyle(null);
		}
		//Check The Price Field
		if (price.length() == 0) {
			numField.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
			new animatefx.animation.Shake(numField).play();
			return false;
		}else {
			numField.setStyle(null);
		}
		//Check The Date Field
		if (date == null) {
			dateField.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
			new animatefx.animation.Shake(dateField).play();
			return false;
		}else {
			dateField.setStyle(null);
		}
		//Check The Title Field
		if (title.length() == 0) {
			titleField.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
			new animatefx.animation.Shake(titleField).play();
			return false;
		}else {
			titleField.setStyle(null);
		}
		
		return true;
	}
	
	private TransactionType getTransactionType() {
		if(typeIncome.isSelected()) {
			return TransactionType.INCOME;
		}else {
			return TransactionType.EXPENSE;
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
//		//Allowing only Numeric values in numField
		numField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		        	
		        	numField.setText(newValue.replaceAll("[^\\d]", "") );	//Integers not doubles
		        }
		    }
		});
		//Inilizing categories with their corresponding options
		options.put("Children", Children);
		options.put("Debt", Debt);
		options.put("Education", Education);
		options.put("Entertainment", Entertainment);
		options.put("Everyday", Everyday);
		options.put("Gifts", Gifts);
		options.put("Health", Health);
		options.put("Home", Home);
		options.put("Insurance", Insurance);
		options.put("Pets", Pets);
		options.put("Technology", Technology);
		options.put("Transportation", Transportation);
		options.put("Travel", Travel);
		options.put("Utilities", Utilities);
		options.put("Invests&eTransfer", Invests);
		
		//initializing predetermined List of Catagories to the dropdown
		categoryField.getItems().addAll(categoryList);
		
		//Setting the date field to the current date of the machine
		dateField.setValue(LocalDate.now());
	}
	
	@FXML
	private void updateOptions() {
		String[] subCategory = options.get( categoryField.getValue() );
		subCategoryField.getItems().clear();
		subCategoryField.getItems().addAll(subCategory);
	}


}
