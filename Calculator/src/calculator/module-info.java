module calculator.application {
	requires javafx.fxml;
	requires javafx.controls;
	requires java.ws.rs;
	requires javafx.graphics;
	requires jdk.jshell;
	requires java.json.bind;
	opens calculator.application to javafx.fxml, javafx.graphics;
}
