package application;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {
	private ArrayList<Category> categories = new ArrayList<Category>();
	private HashMap<String,ArrayList<Category>> subCategory = new HashMap<String,ArrayList<Category>>();

	public ArrayList<Category> getCategories(){
		return this.categories;
	}
	
	public HashMap<String,ArrayList<Category>> getSubCategories(){
		return this.subCategory;
	}

	public boolean categoryExist(String c) {
		for(Category el: this.categories) {
			if(el.getName() == c) {
				return true;
			}
		}
		return false;
	}


	public Category getCategoryWithName(String c) {
		for(Category el: this.categories) {
			if(el.getName() == c) {
				return el;
			}
		}
		return null;
	}
	
	public boolean subCategoriesExist(String c, String p) {
		ArrayList<Category> pList = this.subCategory.get(c);
		for(Category el: pList) {
			if(el.getName() == p) {
				return true;
			}
		}
		return false;
	}
	
	public Category getSubCategoryWithName(String c, String p) {// This is added 
		ArrayList<Category> pList = this.subCategory.get(c);
		for(Category el: pList) {
			if(el.getName() == p) {
				return el;
			}
		}
		return null;
	}
	
}
