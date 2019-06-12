package application;

import static application.Global.*;

public class Conversor {

    private static String num = "";
    private static int tamanho;
    private static String resposta = "";

    public static boolean isInt(String test){

        limpar();

        int numero;

        try{

            numero = Integer.parseInt(test);
            num = String.valueOf(numero);
        }
        catch (NumberFormatException e){return false;}

        tamanho = test.length();
        return true;
    }

    private static void limpar(){
        num = "";
        resposta = "";
    }

    public static String gerarTexto(){

        if (tamanho <= 3){

            concatMenor3();

        }else{

            concatMaior3();
            concatMenor3();
        }

        return resposta;
    }

    private static void concatMenor3(){

        if (tamanho >= 3){

            if (tamanho > 3 && Integer.parseInt(num.substring((num.length() - 3), (num.length() - 2))) == 0){

            }
            else{

                if (tamanho > 3){ resposta += " E "; }

                if (Integer.parseInt(num.substring((num.length() - 3), (num.length() - 2))) == 1){

                    resposta += "CENTO";

                }else {

                    resposta += alg3[Integer.parseInt(num.substring((num.length() - 3), (num.length() - 2)))];
                }
            }
        }

        if (tamanho >= 2){

            if (tamanho > 2 && Integer.parseInt(num.substring((num.length() - 2), (num.length() - 1))) == 0){

            }else {

                if (tamanho > 2) {
                    resposta += " E ";
                }

                if (Integer.parseInt(num.substring((num.length() - 2), (num.length() - 1))) == 1) {

                    resposta += dezena[Integer.parseInt(num.substring((num.length() - 1), (num.length() - 0)))];

                } else {

                    resposta += alg2[Integer.parseInt(num.substring((num.length() - 2), (num.length() - 1)))];
                }
            }
        }

        if (tamanho >= 1 && Integer.parseInt(num.substring((num.length() - 2), (num.length() - 1))) != 1){

            if (tamanho > 1 && Integer.parseInt(num.substring((num.length() - 1), (num.length() - 0))) == 0){

            }else{

                if (tamanho > 1){ resposta += " E "; }

                resposta += alg1[Integer.parseInt(num.substring((num.length() - 1), (num.length() - 0)))];

            }
        }

    }

    private static void concatMaior3(){

    }
}