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
	private Button btnHome, btnExpenses, btnIncome, btnHistory, btnGoals, btnSummary;
	
	private Button currBtn = null;
	
	private String btnSet = "-fx-background-color: #C3E5ED; -fx-border-color:#1199B7; -fx-border-width: 0px 0px 0px 3px; -fx-text-fill: #1199B7; -fx-font-weight: bold;";
	
	private Page currPage;
	
	private Model model;
	
	private Parent homeRoot;
	private Parent incomeRoot;
	private Parent expenseRoot;
//	private Parent histroyRoot;
//	private Parent goalsRoot;
//	private Parent summaryRoot;
	
	private FXMLLoader homeFXML;
	private FXMLLoader incomeFXML;
	private FXMLLoader expenseFXML;
//	private FXMLLoader historyFXML;
//	private FXMLLoader goalsFXML;
//	private FXMLLoader summaryFXML;
	
	private HomeController homeController;
	private ExpenseController expenseController;
	private IncomeController incomeController;
//	private HistoryController historyController;
//	private GoalsController goalsController;
//	private SummaryController summaryController;
	
	public void btnHome(ActionEvent e) throws IOException{
		if ( currPage != Page.HOME) {
			//Getting the FXML file
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/homePage.fxml"));
			//loading the FXML
//			this.homeRoot = this.homeFXML.load();
			//Getting the controller class
//			this.homeController = this.homeFXML.getController();
			//passing the model to it
//			this.homeController.setModel(this.model);
//			Parent fxml = FXMLLoader.load(getClass().getResource("/homePage.fxml"));
			contentArea.getChildren().removeAll();
			contentArea.getChildren().setAll(this.homeRoot);
			currPage = Page.HOME;
			setButton(btnHome);
		}
	}
	
	public void btnExpenses(ActionEvent e) throws IOException {
		if ( currPage != Page.EXPENSES) {
//			this.expenseFXML =null;
//			this.expenseRoot =null;
//			this.expenseFXML = new FXMLLoader(getClass().getResource("/expensePage.fxml"));
//			this.expenseRoot = expenseFXML.load();
//			this.expenseController = this.expenseFXML.getController();
//			this.expenseController.setModel(this.model);
//			this.homeController.setExpenseController(expenseController);
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
//			//Getting the FXML file
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/HistoryPage.fxml"));
//			//loading the FXML
//			Parent root = loader.load();
//			//Getting the controller class
//			HomeController controller = loader.getController();
//			//passing the model to it
//			controller.setModel(model);
			
			
			contentArea.getChildren().removeAll();
//			contentArea.getChildren().setAll(root);
			contentArea.getChildren().setAll();
			currPage = Page.HISTORY;
			setButton(btnHistory);
		}
	}

	public void btnGoals(ActionEvent e) throws IOException{
		if ( currPage != Page.GOALS) {
			contentArea.getChildren().removeAll();
			contentArea.getChildren().setAll();
			currPage = Page.GOALS;
			setButton(btnGoals);
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
//		System.out.println("MainController| Model has been set. 1");
		if(this.homeController != null) {
			this.homeController.setModel(m);
		}if(this.expenseController != null) {
			this.expenseController.setModel(m);
		}if(this.incomeController != null) {
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
//			this.homeController.setModel(this.model);//passing the model to it
		} catch(Exception e) {System.out.println(e);}

		try {
			//Loading Expense Page
			
			this.expenseFXML = new FXMLLoader(getClass().getResource("/expensePage.fxml"));//Getting the FXML file
			this.expenseRoot = expenseFXML.load();
			this.expenseController = this.expenseFXML.getController();
//			this.expenseController.setModel(this.model);
		} catch(Exception e) {System.out.println(e);}
		
		try {
			//Loading Income Page
			this.incomeFXML = new FXMLLoader(getClass().getResource("/incomePage.fxml"));
			this.incomeRoot = this.incomeFXML.load();
				//**HAVE TO CREATE CONTROLLER FIRST
				//Getting the controller class
//				IncomeController controller = loader.getController();
				//passing the model to it
//				controller.setModel(this.model);
//			System.out.println("MainController| Income loaded and model set.");
		} catch(Exception e) {System.out.println(e);}
		
		try {
			//Loading History Page
//			this.historyFXML = new FXMLLoader(getClass().getResource("/HistoryPage.fxml"));

		} catch(Exception e) {System.out.println(e);}
		try {
			//Loading Goals Page
//			this.goalsFXML = new FXMLLoader(getClass().getResource("/goalsPage.fxml"));
		} catch(Exception e) {System.out.println(e);}
		try {
			//Loading Summary Page
//			this.summaryFXML = new FXMLLoader(getClass().getResource("/summaryPage.fxml"));
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