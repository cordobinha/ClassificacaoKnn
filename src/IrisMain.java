import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IrisMain {
    public static void main(String[] args) throws IOException {
        String matriz[][] = new String[149][1];

        List<String> list = new ArrayList<>();

        int setosa = 0;
        int virginica = 1;
        int versicolor = 2;

        BufferedReader br = new BufferedReader(new FileReader("c:/iris.arff"));
        while(br.ready()){
            String linha = br.readLine();
            if (linha.contains("Iris-setosa")){

                String[] linhaAux;

                linhaAux = linha.split("Iris-setosa");

                linha = linhaAux[0] + setosa;

                linhaAux = null;

            } else if (linha.contains("Iris-virginica")){

                String[] linhaAux;

                linhaAux = linha.split("Iris-virginica");

                linha = linhaAux[0] + virginica;

                linhaAux = null;

            } else{

                String[] linhaAux;

                linhaAux = linha.split("Iris-versicolor");

                linha = linhaAux[0] + versicolor;

                linhaAux = null;
            }
              //  PEGA O INDEX DE UM ARRAY  DE STRING , NO CASO A POSIÇÃO DO VALOR PRA FAZER O CALCULO






            list.add(linha);
        }
        br.close();

        int[][] matrizConfusao = new int[3][3];

        double distancia = 1.000;

        double distanciaAux = 0.0;

        int coluna = 0;

        int linha = 0;

        for (int i = 0; i < 30; i ++) {

            for (int j = 0; j < 130; j ++){




                distanciaAux = calculaKnn(list.get(i), list.get(j));
                if (distanciaAux <= distancia){
                    distancia = distanciaAux;
                    coluna = Integer.parseInt(list.get(j).substring(list.get(i).length() - 1));
                }
            }

            matrizConfusao[linha][coluna]++;
        }

        System.out.println(matrizConfusao[0][0] + " " + matrizConfusao[0][1] + " " + matrizConfusao[0][2]);
        System.out.println(matrizConfusao[1][0] + " " + matrizConfusao[1][1]  + " " + matrizConfusao[1][2] );
        System.out.println(matrizConfusao[2][0] + " " + matrizConfusao[2][1] + " " + matrizConfusao[2][2]);
    }

    public static double calculaKnn(String treino, String base){
        double calculo = 0.0;
        String[] baseAux;
        String[] treinoAux;
        if (base != null && treino != null){
            baseAux = base.split(",");
            treinoAux = treino.split(",");



              // PEGA O INDEX DE UM ARRAY  DE STRING , NO CASO A POSIÇÃO DO VALOR PRA FAZER O CALCULO

            calculo = Math.sqrt( Math.pow(Double.parseDouble(String.valueOf(Arrays.asList(baseAux).indexOf(0))) - Double.parseDouble(String.valueOf(Arrays.asList(treinoAux).indexOf(0))), 2 ) +

                    Math.pow(Double.parseDouble(String.valueOf(Arrays.asList(baseAux).indexOf(1))) - Double.parseDouble(String.valueOf(Arrays.asList(treinoAux).indexOf(1))), 2 ) +


                    Math.pow(Double.parseDouble(String.valueOf(Arrays.asList(baseAux).indexOf(2))) - Double.parseDouble(String.valueOf(Arrays.asList(treinoAux).indexOf(2))), 2 ) +


                    Math.pow(Double.parseDouble(String.valueOf(Arrays.asList(baseAux).indexOf(3))) - Double.parseDouble(String.valueOf(Arrays.asList(treinoAux).indexOf(3))), 2 ));
        }

        return calculo;
    }
}
