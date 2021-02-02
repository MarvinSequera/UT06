/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut06;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author marvin
 */
public class ArrayDoble {
    private int[] array;
    
    public ArrayDoble() {
        array = new int[10];
    }
    
    public ArrayDoble(int size) {
        this.setArray(size);
    }
    
    //Contructor Copia
    public ArrayDoble(ArrayDoble another) {
        this.array = another.array;
    }
    
    public void setArray(int size) {
        this.array = new int[size];
    }
    
    public void leerArray() {
        Scanner scanner = new Scanner(System.in);
        int value;
        String exit = " Introduce 999 si quieres salir";
        String arrayInput = "Introduce el valor de la posición ";
        for(int i = 0; i < array.length; i++) {
            System.out.println(arrayInput + (i + 1) + exit);
            value = scanner.nextInt();
            if(value == 999) {
                break;
            }
            this.insertar(i,value);
        }
    }
    
    public void insertar(int position, int value) {
        array[position] = value;
    }
    
    public void eliminar(int position) {
        array[position] = 0;
    }
    
    public String escribirArray() {
       return Arrays.toString(array);
    }
    
    public int busquedaSecuencial1(int value) {
        int valueFound = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == value) {
                valueFound = value;
                break;
            }
        }
        return valueFound;
    }
    
    public int busquedaSecuencial2(int value) {
        int loop = 1;
        int valueFound = -1;
        while(loop < array.length) {
            loop++;
            if(array[loop -1] == value) {
                valueFound = value;
                break;
            }
        }
        return valueFound;
    }
    
    public int busquedaSecuencial3(int value) {
        int loop = 1;
        int valueFound = -1;
        do{
            if(array[loop - 1] == value){
                valueFound = value;
                break;
            }
            loop++;
        }
        while(loop <= array.length);
        return valueFound;
    }
    
    public boolean BusquedaBinaria(int value) {
        boolean found = false;
        Arrays.sort(array);
        do {
            double middle = Math.ceil((double)array.length / 2 -1);
            if(array[(int)middle] == value){
                found = true;
                break;
            }else if(array[(int)middle] > value) {
                array = Arrays.copyOfRange(array, 0 ,(int)middle);
                if(array.length == 0) {
                    break;
                }
            }else {
                array = Arrays.copyOfRange(array, (int)middle + 1, array.length);
            }
        }while(!found);
        return found;
    }
    public int[] maximo() {
        int[] positionAndValue = new int[2];
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        Arrays.sort(array);
        positionAndValue[1] = array[array.length-1];
        for(int i = 0; i < arrayCopy.length; i++){
            if(arrayCopy[i] == array[array.length-1]) {
                positionAndValue[0] = i;
            }
        }
        return positionAndValue;
    }
    
    public int[] minimo() {
        int[] positionAndValue = new int[2];
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        Arrays.sort(array);
        positionAndValue[1] = array[0];
        for(int i = 0; i < arrayCopy.length; i++){
            if(arrayCopy[i] == array[0]) {
                positionAndValue[0] = i;
            }
        }
        return positionAndValue;
    }
    
    public int[] ordenBurbuja() {
        int i, j, temp = 0;
        for(i = 0; i < array.length - 1; i++){
            for(j = 0; j <array.length -1 -i; j++) {
                if(array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        //System.out.println(Arrays.toString(array));
        return array;
    }
    
    public ArrayDoble fusion(int [] array1,int [] array2) {
        int lengthA = array1.length;
        int lengthB = array2.length;
        ArrayDoble result = new ArrayDoble(lengthA + lengthB);
        System.arraycopy(array1, 0, result, 0, lengthA);
        System.arraycopy(array2, 0, result, lengthA, lengthB);
        return result;
    }
    
    public void showEvenAndOdd() {
        int i, even = 0, odd = 0;
        for(i = 0; i < array.length; i ++){
            if(array[i] % 2 == 0){
                even++;
            }
        }
        System.out.println("Pares " + even);
        System.out.println("Impares " + (array.length - even));
    }
    public void media() {
        int i; 
        float avg = 0;
        for(i = 0; i < array.length; i ++) {
            avg += array[i];
        }
        System.out.println("La media es " + (avg/array.length));
    }
    public int arrayLength() {
        return array.length;
    }
    
}
