import java.util.Arrays;
import java.util.Random;

public class Estadistica {

    public static void main(String[] args) {

        int poblacion = 300;

        int muestra50 = (int)(poblacion * 0.50); // 150
        int muestra3 = (int)(poblacion * 0.03);  // 9

        double minimo = 5.0;
        double maximo = 10.0;

        Random random = new Random();

        double[] promedios = new double[poblacion];

        // GENERAR POBLACION
        for (int i = 0; i < poblacion; i++) {
            double promedio = minimo + (random.nextDouble() * (maximo - minimo));
            promedio = Math.round(promedio * 100.0) / 100.0;
            promedios[i] = promedio;
        }

        // MUESTRA 50%
        double[] muestraA = new double[muestra50];
        for (int i = 0; i < muestra50; i++) {
            int indice = random.nextInt(poblacion);
            muestraA[i] = promedios[indice];
        }

        System.out.println("MUESTRA 50% (150 alumnos)");

        mostrarEstadisticas(muestraA);

        // MUESTRA 3%
        double[] muestraB = new double[muestra3];
        for (int i = 0; i < muestra3; i++) {
            int indice = random.nextInt(poblacion);
            muestraB[i] = promedios[indice];
        }

        System.out.println("\n");
        System.out.println("MUESTRA 3% (9 alumnos)");


        mostrarEstadisticas(muestraB);
    }

    public static void mostrarEstadisticas(double[] muestra) {

        Arrays.sort(muestra);
        int n = muestra.length;

        // MOSTRAR DATOS
        System.out.println("\nDatos de la muestra (ordenados):");
        for (int i = 0; i < n; i++) {
            System.out.println("Dato " + (i + 1) + ": " + muestra[i]);
        }

        // MEDIA
        double suma = 0;
        for (double val : muestra) suma += val;
        double media = suma / n;

        // MEDIANA
        double mediana;
        if (n % 2 == 0) {
            mediana = (muestra[n / 2 - 1] + muestra[n / 2]) / 2;
        } else {
            mediana = muestra[n / 2];
        }

        // MODA
        double moda = muestra[0];
        int maxFrecuencia = 1;
        int frecuenciaActual = 1;

        for (int i = 1; i < n; i++) {
            if (muestra[i] == muestra[i - 1]) {
                frecuenciaActual++;
            } else {
                if (frecuenciaActual > maxFrecuencia) {
                    maxFrecuencia = frecuenciaActual;
                    moda = muestra[i - 1];
                }
                frecuenciaActual = 1;
            }
        }

        // RANGO
        double rango = muestra[n - 1] - muestra[0];

        // VARIANZA
        double sumaVar = 0;
        for (double val : muestra) {
            sumaVar += Math.pow(val - media, 2);
        }
        double varianza = sumaVar / n;

        // DESVIACIÓN
        double desviacion = Math.sqrt(varianza);

        // REDONDEO
        media = Math.round(media * 100.0) / 100.0;
        mediana = Math.round(mediana * 100.0) / 100.0;
        moda = Math.round(moda * 100.0) / 100.0;
        rango = Math.round(rango * 100.0) / 100.0;
        varianza = Math.round(varianza * 100.0) / 100.0;
        desviacion = Math.round(desviacion * 100.0) / 100.0;

        // RESULTADOS
        System.out.println("\nResultados:");
        System.out.println("Media: " + media);
        System.out.println("Mediana: " + mediana);

        if (maxFrecuencia > 1) {
            System.out.println("Moda: " + moda);
        } else {
            System.out.println("Moda: No hay");
        }

        System.out.println("Rango: " + rango);
        System.out.println("Varianza: " + varianza);
        System.out.println("Desviación estándar: " + desviacion);
    }
}