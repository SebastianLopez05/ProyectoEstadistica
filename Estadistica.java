import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Estadistica {

    public static void main(String[] args) {

        int poblacionN = 300; // Población total de alumnos
        int tamanoMuestra = 150; // La mitad de la población
        double minimo = 5.0;
        double maximo = 10.0;
        Random random = new Random();

        // 1. GENERAR LA POBLACIÓN DE 300 ALUMNOS
        List<Double> poblacion = new ArrayList<>();
        double sumaPoblacion = 0;

        for (int i = 0; i < poblacionN; i++) {
            double promedio = minimo + (random.nextDouble() * (maximo - minimo));
            promedio = Math.round(promedio * 100.0) / 100.0;
            poblacion.add(promedio);
            sumaPoblacion += promedio;
        }

        double mediaPoblacional = sumaPoblacion / poblacionN;
        mediaPoblacional = Math.round(mediaPoblacional * 100.0) / 100.0;
        
        System.out.println("=== DATOS DE LA POBLACIÓN ===");
        System.out.println("Promedio general de los " + poblacionN + " alumnos (Parámetro): " + mediaPoblacional);

        // 2. MÉTODOS DE SELECCIÓN DE LA MUESTRA (Muestreo Aleatorio Simple sin reemplazo)
        // Se crea una lista con los índices del 0 al 299
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < poblacionN; i++) {
            indices.add(i);
        }

        // Se mezcla la lista aleatoriamente para evitar sesgos
        Collections.shuffle(indices);

        // 3. EXTRAER LA MUESTRA DE 150 ALUMNOS
        List<Double> muestra = new ArrayList<>();
        double sumaMuestra = 0;

        System.out.println("\n=== DATOS DE LA MUESTRA ===");
        System.out.println("Extrayendo una muestra aleatoria de " + tamanoMuestra + " alumnos...");

        for (int i = 0; i < tamanoMuestra; i++) {
            // Se toman los primeros 150 elementos de la lista desordenada
            int indiceSeleccionado = indices.get(i);
            double calificacionAlumno = poblacion.get(indiceSeleccionado);
            
            muestra.add(calificacionAlumno);
            sumaMuestra += calificacionAlumno;
        }

        double mediaMuestral = sumaMuestra / tamanoMuestra;
        mediaMuestral = Math.round(mediaMuestral * 100.0) / 100.0;

        System.out.println("Promedio de la muestra de " + tamanoMuestra + " alumnos (Estadístico): " + mediaMuestral);
        
        // Comprobar qué tan cerca estuvo la muestra del valor real
        double diferencia = Math.abs(mediaPoblacional - mediaMuestral);
        diferencia = Math.round(diferencia * 100.0) / 100.0;
        System.out.println("\nDiferencia absoluta entre la población y la muestra: " + diferencia);
    }
}