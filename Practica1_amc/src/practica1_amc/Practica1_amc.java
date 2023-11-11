package practica1_amc;

import Algoritmos.AlgoritmoExhaustivo;
import Algoritmos.AlgoritmosDyV;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Practica1_amc {

    public static void main(String[] args) {

        AlgoritmoExhaustivo AExhauxtivo = new AlgoritmoExhaustivo();
        LecturaEscritura l = new LecturaEscritura();
        String sDirectorio = "\\archivos";
        File darchivos = new File(sDirectorio);
        String NombreFicheroActual;
        System.out.println("PEOR CASO");
        ArrayList<Punto> PuntoCoordenadas = l.lectura("archivos/segundo8.tsp");
        System.out.println("MEDIO CASO");   
        ArrayList<Punto> PuntoCoordenadas2 = l.lectura("archivos/tercero8.tsp");
        
        System.out.println("----------------------------------------------------------");

        Scanner scanner = new Scanner(System.in);

        Menus m = new Menus();

        boolean peorCaso = false;
        int opcion, opcion2;
        do {
            opcion = m.menuPrincipal(peorCaso);
            switch (opcion) {
                case 1:
                    // Lógica para la opción 1
                    System.out.println("Has seleccionado la opción 1.");
                    break;
                case 2:
                    // Lógica para la opción 2
                    System.out.println("Has seleccionado la opción 2.");
                    break;
                case 3:
                    do {
                        opcion2 = m.menuEstrategias(peorCaso);
                        switch (opcion2) {
                            case 1:
                                // Lógica para la opción 1 (Exhaustivo)
                                System.out.println("Has seleccionado la opción 1 (Exhaustivo).");
                                AlgoritmoExhaustivo.BusquedaExhauxtiva(PuntoCoordenadas);
                                break;
                            case 2:
                                // Lógica para la opción 2 (ExhaustivoPoda)
                                System.out.println("Has seleccionado la opción 2 (ExhaustivoPoda).");
                                AlgoritmoExhaustivo.BusquedaExhauxtivaPoda(PuntoCoordenadas);
                                for (int i = 0; i < PuntoCoordenadas.size(); i++) {
                                    System.out.println("Nodo " + (i + 1) + ": x = " + PuntoCoordenadas.get(i).getX()
                                            + ", y = " + PuntoCoordenadas.get(i).getY());
                                }
                                break;
                            case 3:
                                // Lógica para la opción 3 (DivideVenceras)
                                System.out.println("Has seleccionado la opción 3 (DivideVenceras).");
                                AlgoritmosDyV.DyV(PuntoCoordenadas);
                                break;
                            case 4:
                                // Lógica para la opción 4 (DyV Mejorado)
                                System.out.println("Has seleccionado la opción 4 (DyV Mejorado).");
                                break;
                            case 0:
                                System.out.println("Volviendo al menu anterior.");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, elige una opción válida.");
                                break;
                        }
                    } while (opcion2 != 0);
                    break;
                case 4:
                    // Lógica para la opción 4
                    System.out.println("Has seleccionado la opción 4.");
                    break;
                case 5:
                    // Lógica para la opción 5
                    System.out.println("Has seleccionado la opción 5.");
                    break;
                case 6:
                    if (peorCaso == true) {
                        peorCaso = false;
                    } else {
                        peorCaso = true;
                    }
                    break;
                case 7:
                    System.out.println("Escriba el nombre del fichero: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Escriba el numero de puntos: ");
                    int numero = scanner.nextInt();
                    //System.out.println("Escriba el caso que quiera PEOR: 0 /MEDIO: 1: ");
                    //int caso = scanner.nextInt();
                    LecturaEscritura.crearArchivoTSP(nombre, numero,peorCaso);
                    break;
                case 8:
                    // Lógica para la opción 8
                    System.out.println("Has seleccionado la opción 8.");
                    File[] ficheros = darchivos.listFiles();
                    for (File fich : ficheros) {
                        System.out.println(fich.getName());
        }
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
                    break;
            }

        } while (opcion
                != 0);

    }

}
