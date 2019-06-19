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

        else{  }

    }

    //TESTA OS VALORES INSERIDOS PARA QUE SEJAM APENAS NÚMEROS
    private Boolean isNum(){
        long numero;

        try{

            numero = Long.parseLong(inteiro.getText());

            if (numero < 0){
             throw new NumeroNegativoException("Apenas numeros positivos");
            }

            Conversor.inicialSetup(String.valueOf(numero));

            return true;
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Formato Invalido ou muito grande");
        }
        catch (NumeroNegativoException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return false;
    }
}
