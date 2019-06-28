package application;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Nomes {

    public static void config(){

        String line;
        List<String> text = new ArrayList<>();

        text.add("");

        try (BufferedReader br = new BufferedReader(new FileReader("./text/alga.txt"))) {
            while ((line = br.readLine()) != null) {
                text.add(line);
            }
            algarismos = text.toArray(new String[0]);
        } catch (FileNotFoundException e) {
            novoText();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void novoText(){
        new File("./text").mkdir();
        new File("./text/alga.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./text/alga.txt", false))){
            bw.write(getText());
        }catch (Exception e){
            e.printStackTrace();
        }

        config();
    }

    private static String getText(){
        String retorno;

        retorno = "MIL\n" +
                "MILH\n" +
                "BILH\n" +
                "TRILH\n" +
                "QUADRILH\n" +
                "QUINTILH\n" +
                "SEXTILH\n" +
                "SEPTILH\n" +
                "OCTILH\n" +
                "NONILH\n" +
                "DECILH\n" +
                "UNDECILH\n" +
                "DUODECILH\n" +
                "TREDECILH\n" +
                "QUATTUORDECILH\n" +
                "QUINDECILH\n" +
                "SEXDECILH\n" +
                "SEPTENDECILH\n" +
                "OCTODECILH\n" +
                "NOVENDECILH\n" +
                "VIGINTILH\n" +
                "...";

        return retorno;
    }

    public static String[] quant = {
            "AO",
            "OES"
    };

    public static String[] dezena = {
            "DEZ",
            "ONZE",
            "DOZE",
            "TREZE",
            "QUATORZE",
            "QUINZE",
            "DEZESSEIS",
            "DEZESSETE",
            "DEZOITO",
            "DEZENOVE"
    };

    public static String[] alg1 = {
            "ZERO",
            "UM",
            "DOIS",
            "TRES",
            "QUATRO",
            "CINCO",
            "SEIS",
            "SETE",
            "OITO",
            "NOVE"
    };

    public static String[] alg2 = {
            "",
            "",
            "VINTE",
            "TRINTA",
            "QUARENTA",
            "CINQUENTA",
            "SESSENTA",
            "SETENTA",
            "OITENTA",
            "NOVENTA"
    };

    public static String[] alg3 = {
            "",
            "CEM",
            "DUZENTOS",
            "TREZENTOS",
            "QUATROCENTOS",
            "QUINHENTOS",
            "SEISCENTOS",
            "SETECENTOS",
            "OITOSENTOS",
            "NOVECENTOS"
    };

    public static String[] algarismos;
}
