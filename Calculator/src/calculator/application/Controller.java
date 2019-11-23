package calculator.application;

import calculator.calculations.ModelClient;
import calculator.calculations.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * <p>
 * MVC Controller implements buttons actions from View.
 * </p>
 * <p>
 * Class sends output text to Model and sets calculated value on output.
 * </p>
 * <p>
 * Class handles exceptions thrown during calculations.
 * </p>
 * 
 * @author Jakub Ficek
 * @version 1.0
 */
public class Controller {
	/**
	 * to communicate with Model
	 */
	private ModelClient modelClient = new ModelClient();
	private Model model = new Model();
	private boolean client = false;
	/**
	 * Expression to calculate
	 *
	 */
	@FXML
	private TextField output;
	
	@FXML
	private Button buttonN;

	/**
	 * Method adds character to output.
	 * 
	 * @param event action on buttons which appends output
	 */
	@FXML
	private void handleButtonAction(ActionEvent event) {
		String value = ((Button) event.getSource()).getText();
		output.setText(output.getText() + value);
	}

	/**
	 * Method sends output to Model and sets proper output.
	 * 
	 * @param event action on buttons "=", "x!" and "sqrt()"
	 */
	@FXML
	private void handleResultButtonAction(ActionEvent event) {
		String value = ((Button) event.getSource()).getText();
		if(output.getText().isEmpty())
			return;
		try {
			if (client) {
				switch (value) {
				case "x!":
					output.setText(modelClient.factorial(output.getText()));
					break;
				case "sqrt()":
					output.setText(modelClient.squareRoot(output.getText()));
					break;
				default:
					output.setText(modelClient.calculate(output.getText()));
				}
			} else {
				switch (value) {
				case "x!":
					output.setText(model.factorial(output.getText()));
					break;
				case "sqrt()":
					output.setText(model.squareRoot(output.getText()));
					break;
				default:
					output.setText(model.calculate(output.getText()));
				}
			}
		} catch (RuntimeException e) {
			errorShow(e);
		}
	}

	/**
	 * Method clears output.
	 * 
	 * @param event action on button "C"
	 */
	@FXML
	private void handleDeleteButtonAction(ActionEvent event) {
		output.setText("");
	}

	@FXML
	private void clientButtonAction(ActionEvent event) {
		if(client)
		{
			client = false;
			buttonN.setText("S");
		}
		else
		{
			client = true;
			buttonN.setText("N");
		}
	}

	/**
	 * <p>
	 * Method handles exceptions that Model throws during calculations.
	 * </p>
	 * <p>
	 * Method creates alert informing user about exception.
	 * </p>
	 * 
	 * @param e thrown exception
	 */
	private void errorShow(RuntimeException e) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setHeaderText(e.getClass().getCanonicalName());
		alert.setContentText(e.getMessage());
		alert.showAndWait();
	}

}
