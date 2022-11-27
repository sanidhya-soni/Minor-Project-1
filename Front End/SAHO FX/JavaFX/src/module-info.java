module demo {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	opens home to javafx.graphics, javafx.fxml;

}
