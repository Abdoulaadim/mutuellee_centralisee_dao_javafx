module mutuellee_centralisee {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;
	requires jbcrypt;
	requires junit;
	requires json.parser;
	
	opens application to javafx.graphics, javafx.fxml;
	opens controller to javafx.graphics , javafx.fxml;
	opens model to javafx.graphics , javafx.fxml , javafx.base;

}
