module HelloFX {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires AnimateFX;
	
	opens application to javafx.graphics, javafx.fxml;
}
