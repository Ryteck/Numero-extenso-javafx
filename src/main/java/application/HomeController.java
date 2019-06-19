package application;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import javax.swing.*;

import static application.Conversor.gerarTexto;

public class HomeController {

    @FXML
    private JFXTextField inteiro;

    @FXML
    private JFXTextArea txtResposta;

    @FXML
    private void converter(){

        Conversor.resetar();

        if(isNum()){ txtResposta.setText(gerarTexto()); }

        else{ JOptionPane.showMessageDialog(null, "Formato Invalido"); }

    }

    //TESTA OS VALORES INSERIDOS PARA QUE SEJAM APENAS NÚMEROS
    private Boolean isNum(){
        long numero;

        try{

            numero = Long.parseLong(inteiro.getText());
            Conversor.inicialSetup(String.valueOf(numero));
        }
        catch (NumberFormatException e){return false;}
        return true;
    }
}
