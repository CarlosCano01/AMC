package practica1_amc;

import Algoritmos.AlgoritmoExhaustivo;
import Algoritmos.AlgoritmosDyV;
import java.util.ArrayList;

public class Practica1_amc {

    public static void main(String[] args) {
        
        AlgoritmoExhaustivo AExhauxtivo=new AlgoritmoExhaustivo();
        LecturaEscritura l=new LecturaEscritura();
        ArrayList<Punto> PuntoCoordenadas = l.lectura("ch130.tsp");
        
        System.out.println("----------------------------------------------------------");
        
        
        Menus m = new Menus();
        
        boolean peorCaso = false;
        int opcion, opcion2;
        do {
            opcion = m.menuPrincipal(peorCaso);
            switch (opcion) {
                case 1:
                    // L�gica para la opci�n 1
                    System.out.println("Has seleccionado la opci�n 1.");
                    break;
                case 2:
                    // L�gica para la opci�n 2
                    System.out.println("Has seleccionado la opci�n 2.");
                    break;
                case 3:
                    do {
                        opcion2 = m.menuEstrategias(peorCaso);
                        switch (opcion2) {
                            case 1:
                                // L�gica para la opci�n 1 (Exhaustivo)
                                System.out.println("Has seleccionado la opci�n 1 (Exhaustivo).");
                                AlgoritmoExhaustivo.BusquedaExhauxtiva(PuntoCoordenadas);
                                break;
                            case 2:
                                // L�gica para la opci�n 2 (ExhaustivoPoda)
                                System.out.println("Has seleccionado la opci�n 2 (ExhaustivoPoda).");
                                AlgoritmoExhaustivo.BusquedaExhauxtivaPoda(PuntoCoordenadas);
                                break;
                            case 3:
                                // L�gica para la opci�n 3 (DivideVenceras)
                                System.out.println("Has seleccionado la opci�n 3 (DivideVenceras).");
                                AlgoritmosDyV.DyV(PuntoCoordenadas);
                                break;
                            case 4:
                                // L�gica para la opci�n 4 (DyV Mejorado)
                                System.out.println("Has seleccionado la opci�n 4 (DyV Mejorado).");
                                break;
                            case 0:
                                System.out.println("Volviendo al menu anterior.");
                                break;
                            default:
                                System.out.println("Opci�n no v�lida. Por favor, elige una opci�n v�lida.");
                                break;
                        }
                    } while (opcion2 != 0);
                    break;
                case 4:
                    // L�gica para la opci�n 4
                    System.out.println("Has seleccionado la opci�n 4.");
                    break;
                case 5:
                    // L�gica para la opci�n 5
                    System.out.println("Has seleccionado la opci�n 5.");
                    break;
                case 6:
                    if(peorCaso==true){
                        peorCaso=false;
                    }else{
                        peorCaso=true;
                    }
                    break;
                case 7:
                    // L�gica para la opci�n 7
                    System.out.println("Has seleccionado la opci�n 7.");
                    break;
                case 8:
                    // L�gica para la opci�n 8
                    System.out.println("Has seleccionado la opci�n 8.");
                    break;
                case 0:
                    System.out.println("Saliendo del programa. �Hasta luego!");
                    break;
                default:
                    System.out.println("Opci�n no v�lida. Por favor, elige una opci�n v�lida.");
                    break;
            }

        } while (opcion
                != 0);

    }

}