import java.util.Scanner;

public class Less2hw {

    public static void main(String[] args) {
        inputFloat();
        //Code2();
        //Code3();
        //Task4();
    }

/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float)
 * и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
private static void inputFloat() {
    Scanner sc = new Scanner(System.in);
    try {
        System.out.println("введите дробное число");
        float out = Float.parseFloat(sc.nextLine());
        System.out.println("вывод "+out);
    } catch (Exception e) {
        System.out.println("неверный ввод "+e.getMessage());
    }finally{
        sc.close();
        System.out.println("конец обработки");
    }
}

/** Если необходимо, исправьте данный код 
  задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit */
 public static void Code2() {
    int[] intArray={1,2,3,4,5,6,7,8,9};
    try {
        int d = 0;
        double catchedRes1 = intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
     } catch (ArithmeticException e) {
        System.out.println("Catching exception: " + e);
     }     
}    

/**  Задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit
 Если необходимо, исправьте данный код */
public static void Code3() {
    try {
        int a = 90;
        int b = 3;
        System.out.println(a / b);
        printSum(23, 234);
        int[] abc = { 1, 2 };
        abc[3] = 9;
    } catch (IndexOutOfBoundsException ex) {
        System.out.println("Массив выходит за пределы своего размера!");
    } catch (NullPointerException ex) {
        System.out.println("Указатель не может указывать на null!");
    } catch (Throwable ex) {
        System.out.println("Что-то пошло не так...");
    }

}

public static void printSum(Integer a, Integer b) throws Throwable{
    System.out.println(a + b);
}


public static Scanner sc = new Scanner(System.in);
/** Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.  */
public static void Task4(){
    try {
        System.out.println("Введите строку");       
        checkInput(sc.nextLine());

    } catch (EmptyLineException e) {
        System.out.println(e.getMessage());
        Task4();
    } finally {
        sc.close();
    }
}

public static void checkInput(String s) throws EmptyLineException { // throws EmptyLineException
    
        char[] arr = s.toCharArray();
        int count = 0;

        for (int i = 0; i < arr.length; i++) { 
            if (Character.isWhitespace(arr[i])) 
                count++;            
        }
        if (count == s.length() || s.isEmpty()) {
            throw new EmptyLineException("Пустая строка, попробуйте снова");
        }

        showLine(s);
    
}

public static void showLine(String a) {
    System.out.printf("Введенная строка \"%s\"" , a);
}


}

class EmptyLineException extends Exception{
    public EmptyLineException(String message){
        super(message);
    }
}