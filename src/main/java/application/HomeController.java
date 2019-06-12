package application;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.*;

import static application.Conversor.gerarTexto;
import static application.Conversor.isInt;

public class HomeController {

    @FXML
    private JFXTextField inteiro;

    @FXML
    private Label txtResposta;

    @FXML
    private void converter(){

        if(isInt(inteiro.getText())){

           txtResposta.setText(gerarTexto());

        }else{

         JOptionPane.showMessageDialog(null, "Formato Invalido");

        }
    }
}
