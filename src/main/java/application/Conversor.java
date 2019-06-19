package application;

import static application.Global.*;

public class Conversor {

    // VARIAVEIS

    // NÚMERO COMPLETO EM FORMATO DE ALGARISMO ESCRITO COMO STRING
    private static String num = "";

    // TAMANHO EM ALGARISMO DO NÚMERO
    private static int tamanho;

    // DIVISÃO DO NÚMERO EM GRUPOS DE TRÊS ALGARISMOS
    private static String[] divNum;

    // DIVIÃO DA RESPOSTA EM GRUPO DE TRÊS ALGARISMOS
    private static String[] divResposta;

    // RESPOSTA FINAL A SER RETORNADA
    private static String resposta = "";

    //NÚMERO DE GRUPOS
    private static int corte;

    //FUNÇÕES

    // CONFIGURA AS VARIAVEIS INICIAIS DO PROJETO
    public static void inicialSetup(String num){

        Conversor.num = num;
        Conversor.tamanho = num.length();
    }

    //RESETA O SOFTWARE PARA UMA NOVA CONVERSÃO
    public static void resetar(){
        num = "";
        resposta = "";
    }

    //MÉTODO QUE CORDENA A CONVERSÃO
    public static String gerarTexto(){

        corte = tratarCorte();

        divNum = new String[corte];
        divResposta = new String[corte];

        gerarDivInt();
        gerarDivResposta();

        if (divResposta.length >= 2){ tratarDivResposta(); }

        if (tamanho == 1) {
            resposta += divResposta[0];
        }else{
            for (int cont = 0; cont < corte; cont++) {
                if (!"0".equals(divNum[cont])) { resposta += divResposta[cont]; }
            }
        }

        return resposta;
    }

    //RETORNA A QUANTIDADE DE GRUPOS DO ALGARISMO, DE TRÊS EM TRÊS
    private static int tratarCorte(){

        int alg = tamanho;

        while (true) {
            if (alg % 3 == 0) {
                return alg / 3;
            }
            alg++;
        }
    }

    private static void gerarDivInt(){

        for (int cont = 0; cont < corte; cont++){ divNum[cont] = ""; }

        int difereca = corte * 3 - tamanho;
        int inicio = 0;
        int fim = 3;

        for (int cont = 0; cont < corte; cont++){

            if (cont == 0){
                divNum[cont] = num.substring(inicio, fim - difereca);
            }else{
                divNum[cont] = num.substring(inicio - difereca, fim - difereca);
            }
            inicio += 3;
            fim += 3;
        }
    }

    private static void gerarDivResposta(){

        for (int cont = 0; cont < corte; cont++){ divResposta[cont] = ""; }

        boolean isMaior = false;

        for (int cont = 0; cont < corte; cont++){
            incrementar(isMaior, cont);
            isMaior = true;
        }
    }

    private static void tratarDivResposta(){

        boolean isSingular;

        for (int cont = 0; cont < corte; cont++){
            if (!"0".equals(divNum[cont])){

                isSingular = ("1".equals(divNum[cont]));

                divResposta[cont] += " " + receberPosicao(corte - cont - 1, isSingular);

            }
        }
    }

    private static String receberPosicao(int posicao, boolean isSingular){
        String aaa = "";

        if (posicao != 0) {

            aaa += algarismos[posicao];

            if (posicao != 1) {
                aaa += (isSingular) ? quant[0] : quant[1];
            }

        }

        return aaa;
    }

    //GERA UM NÚMERO ESCRITO POR EXTENSO EM ATÉ GRUPOS DE 3
    private static void incrementar(boolean isMaior, int posicao){

        if (divNum[posicao].length() == 3){

            if (isMaior && Integer.parseInt(divNum[posicao].substring((divNum[posicao].length() - 3), (divNum[posicao].length() - 2))) == 0){

            }
            else{

                if (isMaior){ divResposta[posicao] += " E "; }

                if (Integer.parseInt(divNum[posicao].substring((divNum[posicao].length() - 3), (divNum[posicao].length() - 2))) == 1){

                    divResposta[posicao] += "CENTO";

                }else {

                    divResposta[posicao] += alg3[Integer.parseInt(divNum[posicao].substring((divNum[posicao].length() - 3), (divNum[posicao].length() - 2)))];
                }
            }
        }

        if (divNum[posicao].length() >= 2){

            if (divNum[posicao].length() > 2 && Integer.parseInt(divNum[posicao].substring((divNum[posicao].length() - 2), (divNum[posicao].length() - 1))) == 0){

            }else {

                if (divNum[posicao].length() > 2) {
                    divResposta[posicao] += " E ";
                }

                if (Integer.parseInt(divNum[posicao].substring((divNum[posicao].length() - 2), (divNum[posicao].length() - 1))) == 1) {

                    divResposta[posicao] += dezena[Integer.parseInt(divNum[posicao].substring((divNum[posicao].length() - 1)))];

                } else {

                    divResposta[posicao] += alg2[Integer.parseInt(divNum[posicao].substring((divNum[posicao].length() - 2), (divNum[posicao].length() - 1)))];
                }
            }
        }

        if (divNum[posicao].length() == 1){

            if ("0".equals(alg1[Integer.parseInt(divNum[posicao].substring((divNum[posicao].length() - 1)))])){

                if (tamanho == 1){ divResposta[posicao] += alg1[0]; }

            }else {
                divResposta[posicao] += alg1[Integer.parseInt(divNum[posicao].substring((divNum[posicao].length() - 1)))];
            }

        }else{

            if (divNum[posicao].length() >= 1 && Integer.parseInt(divNum[posicao].substring((divNum[posicao].length() - 2), (divNum[posicao].length() - 1))) != 1){

                if (divNum[posicao].length() > 1 && Integer.parseInt(divNum[posicao].substring((divNum[posicao].length() - 1))) == 0){

                }else{

                    if (divNum[posicao].length() > 1){ divResposta[posicao] += " E "; }

                    divResposta[posicao] += alg1[Integer.parseInt(divNum[posicao].substring((divNum[posicao].length() - 1)))];

                }
            }
        }
    }
}
