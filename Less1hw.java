import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Less1hw {
    private static Scanner sc = new Scanner(System.in);
    private static int[] array1, array2;
    /*
     * 1) Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
     */
    public static void main(String[] args) {
        generate();
        print(array1, array2, Task2(),"разности");
        System.out.println();
        print(array1, array2, Task3(),"частного");    
    }


    private static String Task2() {
         return Arrays.toString(arrayDifference(array1,array2));
    }

    private static String Task3() {
        return Arrays.toString(arrayDiv(array1,array2));
    }
     /*
     * 2) Реализуйте метод, принимающий в качестве аргументов два целочисленных
     * массива, и возвращающий новый массив, каждый элемент которого равен разности
     * элементов двух входящих массивов в той же ячейке. Если длины массивов не
     * равны, необходимо как-то оповестить пользователя.
     */
    private static int[] arrayDifference(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];

        if (isGood(arr1, arr2)) {
            for (int i = 0; i < result.length; i++) {
                result[i] = arr1[i] - arr2[i];
            }
        }
        return result;
    }

    /*
     * 3) (Дополнительно) Реализуйте метод, принимающий в качестве аргументов два
     * целочисленных массива, и возвращающий новый массив, каждый элемент которого
     * равен частному элементов двух входящих массивов в той же ячейке. Если длины
     * массивов не равны, необходимо как-то оповестить пользователя.
     * Важно: При выполнении метода единственное исключение, которое пользователь
     * может увидеть - RuntimeException, т.е. ваше.
     */

    private static float[] arrayDiv(int[] arr1, int[] arr2) {
        float[] result = new float[arr1.length];

        if(isGood(arr1,arr2)){            
            for (int i = 0; i < result.length; i++) {
                if(arr2[i]==0){
                    throw new RuntimeException("деление на ноль невозможно, индекс "+i);
                }
                else{
                    result[i] =  ((float)arr1[i] / (float)arr2[i]);
                }
            }
        }
            return result;
    }

    private static void print(int[] arr1, int[] arr2, String result, String operation) {
        System.out.println(Arrays.toString(arr1) + " Массив 1");
        System.out.println(Arrays.toString(arr2) + " Массив 2");
        System.out.println(result + " Результат " + operation);
    }

    private static void generate() {

        System.out.println("Введите размер массива 1");
        String userIn = sc.nextLine();

        if (inputDigit(userIn)) {
            if (Integer.parseInt(userIn) > 0) {
                array1 = fillArray(userIn);
            } else {
                System.out.println("неверное значение %s" + userIn);
            }
        }

        System.out.println("Введите размер массива 2");
        userIn = sc.nextLine();
        if (Integer.parseInt(userIn) > 0) {
            array2 = fillArray(userIn);

        } else {
            System.out.println("неверное значение %s" + userIn);
        }
    } 
        

        private static boolean inputDigit(String s){
            for (int i = 0; i < s.length(); i++) {
                if(Character.isAlphabetic(s.charAt(i))){
                    throw new RuntimeException("Это точно число? " + "\"" + s + "\"");
                }
            }
            return true;
        }
        
    

    private static int[] fillArray(String s) {
        int[] temp = new int[Integer.parseInt(s)];
        Random rand = new Random();
        for (int i = 0; i < temp.length; i++) {
            temp[i] = rand.nextInt(5);
        }
        return temp;
    }

    private static boolean isGood(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Ошибка: Массивы с разным количеством элементов");
        } else {
            if (arr1.length == 0 || arr1.length == 0) {
                throw new RuntimeException("Ошибка : нет элементов в массиве");                
            }
        }
        return true;
    }
}
