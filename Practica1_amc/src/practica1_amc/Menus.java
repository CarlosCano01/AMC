package practica1_amc;

import java.util.ArrayList;
import java.util.Scanner;


public class Menus {

    private Scanner scanner = new Scanner(System.in);
    private int opcion;

    public int menuPrincipal(boolean peorCaso,String FicheroActual) {
        System.out.println(" *** AMC. Practica 1. Curso 23/24 ****");
        System.out.println(" Alumnos: Carlos Cano Espinosa y Ignacio VelÃ¡zquez MuÃ±oz");
        System.out.println(" ***     MENU PRINCIPAL ***");
        System.out.println(" PEOR CASO: " + (peorCaso ? "ON" : "OFF")+(FicheroActual.isBlank() ? " " : "\t\tFichero actual: "+FicheroActual));
        System.out.println(" 1.- COMPROBAR TODOS LOS FICHEROS");
        System.out.println(" 2.- COMPROBAR TODAS LAS ESTRATEGIAS");
        System.out.println(" 3.- ESTUDIAR 1 ESTRATEGIA");
        System.out.println(" 4.- COMPARAR 2 ESTRATEGIAS");
        System.out.println(" 5.- COMPARAR TODAS LAS ESTRATEGIAS");
        System.out.println(" 6.- ACTIVAR/DESACTIVAR PEOR CASO (TODOS LOS PUNTOS EN LA MISMA VERTICAL)");
        System.out.println(" 7.- CREAR FICHERO TSP ALEATORIO");
        System.out.println(" 8.- COMPROBAR TODAS LAS ESTRATEGIAS DE UN FICHERO TSP CONCRETO");
        System.out.println(" 0.- Salir");
        System.out.println(" ---------");
        System.out.print("Elige opcion: ");

        opcion = scanner.nextInt();
        return opcion;
    }

    public int menuEstrategias(boolean peorCaso) {
        
        System.out.println("*** Estrategia a estudiar para el "+(peorCaso ? "caso peor ***" :"caso medio ***"));
        System.out.println("1.- Exhaustivo");
        System.out.println("2.- ExhaustivoPoda");
        System.out.println("3.- DivideVenceras");
        System.out.println("4.- DyV Mejorado");
        System.out.println("0.- Volver al menu anterior");
        System.out.println("---------");
        System.out.print("Elige opcion: ");

        opcion = scanner.nextInt();
        return opcion;
    }
    
    public int menuFicheros(ArrayList<String> ListaFicheros) {
        
        System.out.println("*** LISTA DE FICHEROS QUE TENEMOS ***\n");
        for (int i = 0; i < ListaFicheros.size(); i++) {
            System.out.println((i+1)+".- "+ListaFicheros.get(i));
        }
        System.out.println("0.- Volver al menu anterior");
        System.out.println("---------");
        System.out.print("Elige el fichero que deseas cargar: ");

        opcion = scanner.nextInt();
        if (opcion>ListaFicheros.size()) {
            opcion=-1;
        }
        return opcion;
    }
}
