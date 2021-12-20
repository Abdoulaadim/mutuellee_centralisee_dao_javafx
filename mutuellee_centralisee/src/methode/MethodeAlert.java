package methode;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MethodeAlert {
	public void afficherAlert(String title, String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(contentText);

		alert.showAndWait();
	}
}
