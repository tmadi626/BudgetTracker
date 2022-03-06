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
	
	public void btnHome(ActionEvent e) throws IOException{
		if ( currPage != Page.HOME) {
			Parent fxml = FXMLLoader.load(getClass().getResource("/homePage.fxml"));
			contentArea.getChildren().removeAll();
			contentArea.getChildren().setAll(fxml);
			currPage = Page.HOME;
			setButton(btnHome);
		}
	}
	
	public void btnExpenses(ActionEvent e) throws IOException {
		if ( currPage != Page.EXPENSES) {
			Parent fxml = FXMLLoader.load(getClass().getResource("/expensePage.fxml"));
			contentArea.getChildren().removeAll();
			contentArea.getChildren().setAll(fxml);
			currPage = Page.EXPENSES;
			setButton(btnExpenses);
		}
	}
	
	public void btnIncome(ActionEvent e) throws IOException{
		if ( currPage != Page.INCOME) {
			Parent fxml = FXMLLoader.load(getClass().getResource("/incomePage.fxml"));
			contentArea.getChildren().removeAll();
			contentArea.getChildren().setAll(fxml);
			currPage = Page.INCOME;		
			setButton(btnIncome);
		}
	}
	
	public void btnHistory(ActionEvent e) throws IOException{
		if ( currPage != Page.HISTORY) {
			contentArea.getChildren().removeAll();
			contentArea.getChildren().setAll();
			currPage = Page.HISTORY;
			setButton(btnHistory);
		}
	}

	public void btnGoals(ActionEvent e) throws IOException{
		if ( currPage != Page.GOAL) {
			contentArea.getChildren().removeAll();
			contentArea.getChildren().setAll();
			currPage = Page.GOAL;
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
		Parent fxml = FXMLLoader.load(getClass().getResource("/homePage.fxml"));
		contentArea.getChildren().removeAll();
		contentArea.getChildren().setAll(fxml);
		currPage = Page.HOME;
		setButton(btnHome);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}