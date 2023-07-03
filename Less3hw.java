import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Less3hw {
    static Scanner sc=new Scanner(System.in);    
/*Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
Фамилия Имя Отчество номертелефона

Форматы данных:
фамилия, имя, отчество - строки
номертелефона - целое беззнаковое число без форматирования

Ввод всех элементов через пробел
*/

public static String lastname; // фамилия

public static void main(String[] args) {
    
    try {
        userAdd();
    } catch (WrongDataInput | WrongPhoneNumber e) {
        e.printStackTrace();
    }
    
}

public static void userAdd() throws WrongDataInput, WrongPhoneNumber{
   
try {
    userInput();
} catch (WrongDataInput | WrongPhoneNumber e) {
    System.out.printf("%s \"%s\"",e.getMessage(),e.getErr());
    userInput();
}
/* }catch(WrongDataInput d){
     System.out.printf("%s \"%s\"",d.getMessage(),d.getErr());
}
catch(WrongPhoneNumber p){
    System.out.printf("%s \"%s\"",p.getMessage(),p.getErr());
    userInput();
} */

}

public static void userInput()  throws WrongDataInput, WrongPhoneNumber{
    System.out.println("\nВведите данные через пробел\nФамилия Имя Отчество номертелефона");
    String primary = sc.nextLine();
    String[] data = primary.split(" ");
    if (data.length == 4) {
        parsePhone(data[3]);
        lastname = data[0];
        saveUser(primary);

    } else if (data.length > 4) {
        char[] temp = primary.toCharArray();
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == ' ') {
                ++count;
                if (count == 4) {
                    throw new WrongDataInput("лишние элементы :", primary.substring(i));
                }
            }
        }
    } else {
        throw new WrongDataInput("Количество данных меньше требуемого", primary);
    }
}


/* Приложение должно проверить введенные данные по количеству. 
Если количество не совпадает с требуемым, вернуть код ошибки, 
обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется. */

/* Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, 
пользователю выведено сообщение с информацией, что именно неверно. */

public static void parsePhone(String s)throws WrongPhoneNumber{
    for (char element : s.toCharArray()) {
        if (Character.isAlphabetic(element)){
            throw new WrongPhoneNumber("Недопустимый символ в номере",Character.toString(element));
        }
    }
}

/*
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, 
в него в одну строку должны записаться полученные данные, 
вида    <Фамилия><Имя><Отчество><номер_телефона>
*/
public static void saveUser(String data) {
    String path = lastname + ".txt";

    try (FileWriter writer = new FileWriter(path, true)) {
        writer.write(data + '\n');
        writer.close();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
}
//Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

//Не забудьте закрыть соединение с файлом.

/*При возникновении проблемы с чтением-записью в файл, 
исключение должно быть корректно обработано, 
пользователь должен увидеть стектрейс ошибки.  */


}
class WrongDataInput extends MyException{
public WrongDataInput(String mes, String val){
super(mes, val);
}}
class WrongPhoneNumber extends MyException{
    public WrongPhoneNumber(String mes, String val){
    super(mes, val);
    }
}
abstract class MyException extends Exception{
    private final String x;


    public MyException(String message, String x){
        super(message);
        this.x = x;
    }

    public String getErr() {
        return x;
    }
}