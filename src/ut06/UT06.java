/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut06;
import java.util.Scanner;
/**
 *
 * @author marvin
 */
public class UT06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int size;
        String input = "Introduce el tamaño del Array";
        String exit = " Introduce 999 si quieres salir";
        String arrayInput = "Introduce el valor de la posición ";
        System.out.println(input);
        size = scanner.nextInt();
        ArrayDoble array = new ArrayDoble(size);
        array.leerArray();
        //System.out.println(array.escribirArray());
        ArrayDoble copy = new ArrayDoble(array);
        array.media();
        //System.out.println(array.escribirArray());
    }
    
}
