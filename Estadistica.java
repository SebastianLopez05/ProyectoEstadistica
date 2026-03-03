import java.util.Random;

public class Estadistica {

    public static void main(String[] args) {

        int numeroAlumnos = 300;
        double minimo = 5.0;
        double maximo = 10.0;

        Random random = new Random();
        double sumaPromedios = 0;

        for (int i = 1; i <= numeroAlumnos; i++) {

            //  promedio entre 5 y 10
            double promedio = minimo + (random.nextDouble() * (maximo - minimo));

            //  2 decimales
            promedio = Math.round(promedio * 100.0) / 100.0;

            sumaPromedios += promedio;

            System.out.println("Alumno " + i + " promedio: " + promedio);
        }

        double promedioGeneral = sumaPromedios / numeroAlumnos;
        promedioGeneral = Math.round(promedioGeneral * 100.0) / 100.0;

        System.out.println("\nPromedio general de los 300 alumnos: " + promedioGeneral);
    }
}