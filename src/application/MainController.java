package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class MainController implements Initializable{
	
	@FXML
	private StackPane contentArea;
	@FXML
	private Button btnHome, btnExpenses, btnIncome, btnHistory, btnSummary;
	
	private Button currBtn = null;
	
	private String btnSet = "-fx-background-color: #C3E5ED; -fx-border-color:#1199B7; -fx-border-width: 0px 0px 0px 3px; -fx-text-fill: #1199B7; -fx-font-weight: bold;";
	
	private Page currPage;
	
	private Model model;
	
	private Parent homeRoot;
	private Parent incomeRoot;
	private Parent expenseRoot;
//	private Parent histroyRoot;
//	private Parent summaryRoot;
	
	private FXMLLoader homeFXML;
	private FXMLLoader incomeFXML;
	private FXMLLoader expenseFXML;
//	private FXMLLoader historyFXML;
//	private FXMLLoader summaryFXML;
	
	private HomeController homeController;
	private ExpenseController expenseController;
	private IncomeController incomeController;
//	private HistoryController historyController;
//	private SummaryController summaryController;
	
	public void btnHome(ActionEvent e) throws IOException{
		if ( currPage != Page.HOME) {
			contentArea.getChildren().removeAll();
			contentArea.getChildren().setAll(this.homeRoot);
			currPage = Page.HOME;
			setButton(btnHome);
		}
	}
	
	public void btnExpenses(ActionEvent e) throws IOException {
		if ( currPage != Page.EXPENSES) {
			contentArea.getChildren().removeAll();
			contentArea.getChildren().setAll(this.expenseRoot);
			currPage = Page.EXPENSES;
			setButton(btnExpenses);
		}
	}
	
	public void btnIncome(ActionEvent e) throws IOException{
		if ( currPage != Page.INCOME) {
			contentArea.getChildren().removeAll();
			contentArea.getChildren().setAll(this.incomeRoot);
			currPage = Page.INCOME;		
			setButton(btnIncome);
		}
	}
	
	public void btnHistory(ActionEvent e) throws IOException{
		if ( currPage != Page.HISTORY) {	
			contentArea.getChildren().removeAll();
//			contentArea.getChildren().setAll(root);
			contentArea.getChildren().setAll();
			currPage = Page.HISTORY;
			setButton(btnHistory);
		}
	}

	public void btnSummary(ActionEvent e) throws IOException{
		if ( currPage != Page.SUMMARY) {
			contentArea.getChildren().removeAll();
			contentArea.getChildren().setAll();
			currPage = Page.SUMMARY;
			setButton(btnSummary);
		}
	}

	private void setButton(Button b) {
		if(currBtn != null) {
			currBtn.setStyle(null);
		}
		b.setStyle(btnSet);
		currBtn = b;
	}
	
	public void setModel(Model m) {
		this.model = m;
		if(this.homeController != null) {//Set the home controller's Database model
			this.homeController.setModel(m);
		}if(this.expenseController != null) {//Set the expense controller's Database model
			this.expenseController.setModel(m);
		}if(this.incomeController != null) {//Set the income controller's Database model
			this.incomeController.setModel(m);
		}
	}
	
	public Model getModel() {
		return this.model;
	}
	
	private void loadFiles() {
	//loading all the other files
		try {
			//Loading Home Page
			this.homeFXML = new FXMLLoader(getClass().getResource("/homePage.fxml"));//Getting the FXML file
			this.homeRoot = this.homeFXML.load();//loading the FXML
			this.homeController = this.homeFXML.getController();//Getting the controller class
		} catch(Exception e) {System.out.println(e);}

		try {
			//Loading Expense Page
			this.expenseFXML = new FXMLLoader(getClass().getResource("/expensePage.fxml"));//Getting the FXML file
			this.expenseRoot = expenseFXML.load();
			this.expenseController = this.expenseFXML.getController();
		} catch(Exception e) {System.out.println(e);}
		
		try {
			//Loading Income Page
			this.incomeFXML = new FXMLLoader(getClass().getResource("/incomePage.fxml"));
			this.incomeRoot = this.incomeFXML.load();
			this.incomeController = this.incomeFXML.getController();
		} catch(Exception e) {System.out.println(e);}
	
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			this.loadFiles();// MUST LOAD FILES FIRST
			this.homeController.setExpenseController(expenseController);
			this.homeController.setIncomeController(incomeController);
			//setting the home page as the first page
			contentArea.getChildren().removeAll();
			contentArea.getChildren().setAll(this.homeRoot);
			currPage = Page.HOME;
			setButton(btnHome);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}