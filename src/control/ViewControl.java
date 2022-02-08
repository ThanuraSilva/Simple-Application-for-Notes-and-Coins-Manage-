package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class ViewControl {
    public TextField txtValue;
    public TextField txt5000;
    public TextField txt1000;
    public TextField txt500;
    public TextField txt100;
    public TextField txt20;
    public TextField txt50;
    public TextField txt10;
    public TextField txt5;
    public TextField txt2;
    public TextField txt1;
    public Button btnCalc;
    public Button btnAbout;
    public Button btnClear;
    public AnchorPane consoleView;


    public void initialize(){

        btnCalc.setDisable(true);
        btnClear.setDisable(true);


        txtValue.textProperty().addListener((observable, oldValue, newValue) -> {
            btnCalc.setDisable(false);
            btnClear.setDisable(false);
            txtValue.requestFocus();

        });

    }

    public void inputValue(ActionEvent actionEvent) {
        Scanner d = new Scanner(System.in);
        int input =d.nextInt();
        txtValue.setText(String.valueOf(input));

        }

    public void calcTask(ActionEvent actionEvent) {
         calculation();

    }

    private void calculation() {
        int initValue=Integer.parseInt(txtValue.getText());

        int v5000=initValue/5000;
        initValue=initValue%5000;

        int v1000=initValue/1000;
        initValue%=1000;

        int v500=initValue/500;
        initValue%=500;

        int v100=initValue/100;
        initValue%=100;

        int v50=initValue/50;
        initValue%=50;

        int v20=initValue/20;
        initValue%=20;

        int v10=initValue/10;
        initValue%=10;

        int v5=initValue/5;
        initValue%=5;

        int v2=initValue/2;
        initValue%=2;

        int v1=initValue;

        txt5000.setText(String.valueOf(v5000));
        txt1000.setText(String.valueOf(v1000));
        txt500.setText(String.valueOf(v500));
        txt100.setText(String.valueOf(v100));
        txt50.setText(String.valueOf(v50));
        txt20.setText(String.valueOf(v20));
        txt10.setText(String.valueOf(v10));
        txt5.setText(String.valueOf(v5));
        txt2.setText(String.valueOf(v2));
        txt1.setText(String.valueOf(v1));

    }

    public void resetTask(ActionEvent actionEvent) {
        clearData();

    }
    public void clearData(){
        txtValue.clear();
        txt5000.clear();
        txt1000.clear();
        txt500.clear();
        txt100.clear();
        txt50.clear();
        txt20.clear();
        txt10.clear();
        txt5.clear();
        txt2.clear();
        txt1.clear();
    }

    public void aboutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/about.fxml");
        AnchorPane root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("About");
        stage.show();


    }

    public void txtInputOnAction(ActionEvent actionEvent) {
        btnCalc.fire();
    }
}
