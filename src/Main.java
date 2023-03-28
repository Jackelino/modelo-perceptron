import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Neuron> neurons = new ArrayList<Neuron>();
        int size = 3;
        int t = 0;
        int numeroDeErrores =0;
        ArrayList<Double> dendrites = new ArrayList<Double>();
        double [][] matrizEntrenamiento = {
                {-1.0, -1.0, 1.0},
                {-1.0, 1.0, 1.0},
                {1.0, -1.0, 1.0},
                {1.0, 1.0, 1,0}
        };
        /**
         * salidas esperadas
         */
        double[] salida = {-1.0, -1.0, -1.0, 1};

        Neuron neuron = new Neuron(size);
        System.out.println("la neurona recien instanciada es\n:"+neuron);
        // entrenar sobre la tabla de datos

        //se debe entrenar la neurona para cada renglon de la tabla

        do {
            numeroDeErrores = 0;
            for (int i=0; i<matrizEntrenamiento.length; i++) {
                dendrites = new ArrayList<>();
                for(int j = 0; j < matrizEntrenamiento[i].length; j++){
                    //System.out.println("tamaño" + matrizEntrenamiento[i].length + "index" + i);
                    dendrites.add(matrizEntrenamiento[i][j]);
                }
                numeroDeErrores += neuron.train(dendrites, salida[i]);

                System.out.println("\niterción no. "+i+": "+ neuron);

            }
            t += 1;
            System.out.println("No. Errores:" + numeroDeErrores);
           neuron.setAlpha( 1.0/(t+1.0) );
        }while ( numeroDeErrores > 0);
        neurons.add(neuron);
        Network net = new Network(neurons);

        System.out.println("Hello world!");
    }
}