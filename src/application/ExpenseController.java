package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.util.Callback;

public class ExpenseController implements Initializable{

	@FXML
	private TreeTableView<Category> expenseTreeTableView;
	@FXML
	private TreeTableColumn<Category, String> colCategory;
	@FXML
	private TreeTableColumn<Category, Number> colJan, colFeb, colMar, colApr, colMay, colJun,colJul, colAug, colSep, colOct, colNov, colDec, colTotal, colAvg;
	
	
	private Category rootCategory = new Category("Expenses",true, null);
	//The root node for all the categories
	private TreeItem<Category> root = new TreeItem<Category>(rootCategory );
	
//	private ArrayList<TreeItem<Category>> categoriesList = new ArrayList<TreeItem<Category>>();
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		root.setExpanded(true);
		root.expandedProperty().addListener(observable -> {
            if (!root.isExpanded()) {
            	root.setExpanded(true);
            }
        });
		
		// Defines how to fill data for each cell.
		// Get value from property of Category.
		colCategory.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, String>, ObservableValue<String>>(){
			@Override
			public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Category, String> arg0) {
				return new SimpleStringProperty(arg0.getValue().getValue().getName());
			}
		});
		
		colJan.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getJan());
			}
		});
		colFeb.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getFeb());
			}
		});
		colMar.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getMar());
			}
		});
		colApr.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getApr());
			}
		});
		colMay.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getMay());
			}
		});
		colJun.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getJun());
			}
		});
		colJul.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getJul());
			}
		});
		colAug.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getAug());
			}
		});
		colSep.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getSep());
			}
		});
		colOct.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getOct());
			}
		});
		colNov.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getNov());
			}
		});
		colDec.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getDec());
			}
		});
		colTotal.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getTotal());
			}
		});
		colAvg.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Category, Number>, ObservableValue<Number>>(){
			@Override
			public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Category, Number> arg0) {
				return new SimpleDoubleProperty(arg0.getValue().getValue().getAvg());
			}
		});
		
		
		expenseTreeTableView.setRoot(root);
		
		setUpTable();
	}

	
	public void addTransaction(String title, String price, LocalDate date, String catagory, String type, TransactionType typeTransaction) {
		// Create a new Transaction
		Transaction newTransaction = new Transaction(title, Double.parseDouble(price), date, typeTransaction);
		System.out.println("");
		System.out.println("Transaction created: ("+title+", "+price+", "+date+", "+typeTransaction+").");
		
		//If the category already exists
		if(categoryExist(catagory)) {
			System.out.println("Category already exists: "+catagory+".");
			
			// check if the option exists:
			if(optionExist(catagory, type)) {
				System.out.println("Option already exists: "+type+".");
				//get the option
				Category p = getOptionWithName(catagory, type);
				// Add the transaction to the option
				p.addTransaction(newTransaction);
			}
			//If the option doesnt exist
			else {
				System.out.println("New option created: "+type+".");
				//Get the Category
				Category c = this.getCategoryWithName(catagory);
				//Create new option
				Category newOption = new Category(type,false, c);
				// Add the Child(newOption) to the Parent(newCategory)
				c.addToChildren(newOption);
				// Add the transaction to the option
				newOption.addTransaction(newTransaction);
				// Add the option to the list of options of that category	
				Main.cOptions.get(catagory).add(newOption);
			}
			
			System.out.println("Transaction has been added to Category: "+catagory+", under Option:"+type+".");
		}
		//If the category does not exist
		else {
			//Create a new Category
			Category newCategory = new Category(catagory,true, rootCategory);
			System.out.println("New Category created: "+catagory+".");
			// Add the Child(newCategory) to the Parent(rootCategory)
			rootCategory.addToChildren(newCategory);
			//Create a new Option
			Category newOption = new Category(type,false, newCategory);
			System.out.println("New option created: "+type+".");
			// Add the Child(newOption) to the Parent(newCategory)
			newCategory.addToChildren(newOption);
			// Add the transaction to the option
			newOption.addTransaction(newTransaction);
			System.out.println("Transaction: "+title +" added to option: "+type+".");
			// Add the category to the list of catagories
			Main.categories.add(newCategory);
			// Add the option to the list of options of that category
			Main.cOptions.put(catagory, new ArrayList<Category>());
			Main.cOptions.get(catagory).add(newOption);
			System.out.println("Transaction has been added to Category: "+catagory+", under Option:"+type+".");
 
		}

	}

	public boolean categoryExist(String c) {
		for(Category el: Main.categories) {
			if(el.getName() == c) {
				return true;
			}
		}
		return false;
	}
	
	public Category getCategoryWithName(String c) {
		for(Category el: Main.categories) {
			if(el.getName() == c) {
				return el;
			}
		}
		return null;
	}
	
	public boolean optionExist(String c, String p) {
		ArrayList<Category> pList = Main.cOptions.get(c);
		for(Category el: pList) {
			if(el.getName() == p) {
				return true;
			}
		}
		return false;
	}
	
	public Category getOptionWithName(String c, String p) {
		ArrayList<Category> pList = Main.cOptions.get(c);
		for(Category el: pList) {
			if(el.getName() == p) {
				return el;
			}
		}
		return null;
	}

	//Creating the option under Category to display under Category
//	public void createOptionInTable(String name, TreeItem<Category> catagory) {
//		TreeItem<Category> option = new TreeItem<Category>(new Category(name) );
//		
//		catagory.getChildren().add(option);
//	}
	
	// this function is reposnible for updating all items inside table
	public void setUpTable() {
		//Get the children of the root
		ObservableList<TreeItem<Category>> rootChildren = root.getChildren();
		
		//Loop through the categories and add them to the table
		for( Category c: Main.categories) {
			//create a category item and make it "always" expanded
			TreeItem<Category> category = new TreeItem<Category>(c);
			category.setExpanded(true);
			category.expandedProperty().addListener(observable -> {
	            if (!category.isExpanded()) {
	            	category.setExpanded(true);
	            }
	        });
			
			//add the category to the table
			rootChildren.add(category);
			
			//get the options of that category 
			ArrayList<Category> cList = Main.cOptions.get(c.getName());
			// check if the options exist
			if (cList != null) {
				//Loop through the options if not empty
				if(!cList.isEmpty()) {
					for(Category p: cList) {
						//create an option item and add it under its category
						TreeItem<Category> option = new TreeItem<Category>(p);
						category.getChildren().add(option);
					}
				}
			}
		}
	}
}
