package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller {

    @FXML
    // The reference of inputText will be injected by the FXML loader
    public javafx.scene.control.TextField key;
    public javafx.scene.control.TextField keydecrypt;
    public javafx.scene.control.TextField plaintext;
    public javafx.scene.control.TextField plaintextdecrypt;
    public javafx.scene.control.TextField ciphertext;
    public javafx.scene.control.TextField ciphertextdecrypt;
    public javafx.scene.control.ComboBox cmbox1;
    public javafx.scene.control.ComboBox cmbox2;
    private String globalKey;
    // The reference of outputText will be injected by the FXML loader
    @FXML
    private TextArea outputText;

    // location and resources will be automatically injected by the FXML loader
    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    // Add a public no-args constructor
    public void FxFXMLController() {
    }

    @FXML
    private void initialize() {

        cmbox1.getItems().setAll("Substitution", "Vigenere");
        cmbox2.getItems().setAll("Substitution", "Vigenere");

    }

    @FXML
    private void encryptText() {

        try {
            if (cmbox1.getValue().toString() == "Substitution") {
                SubstitutionCipher substitutionCipher = new SubstitutionCipher();

                var returncipherText = substitutionCipher.encrypt(plaintext.getText(), key.getText());
                ciphertext.setText(returncipherText);


            } else {

                VigenereCipher vigenereCipher = new VigenereCipher();

                globalKey = vigenereCipher.generateKey(plaintext.getText(), key.getText());

                keydecrypt.setText(globalKey);

                var returncipherText = vigenereCipher.encrypt(plaintext.getText(), globalKey);

                ciphertext.setText(returncipherText);
            }

        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("You have entered incomplete or incorrect information.\nPlease check the information you entered.");
            a.show();
        }
    }

    @FXML
    private void decryptText() {
        try {

            if (cmbox2.getValue().toString() == "Substitution") {
                SubstitutionCipher substitutionCipher = new SubstitutionCipher();

                var returnplainText = substitutionCipher.decrypt(ciphertextdecrypt.getText(), keydecrypt.getText());

                plaintextdecrypt.setText(returnplainText);
            } else {
                VigenereCipher vigenereCipher = new VigenereCipher();

                var returnplainText = vigenereCipher.decrypt(ciphertextdecrypt.getText(), globalKey);

                plaintextdecrypt.setText(returnplainText);
            }

        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("You have entered incomplete or incorrect information.\nPlease check the information you entered.");
            a.show();
        }
    }
}
