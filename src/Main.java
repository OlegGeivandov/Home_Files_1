import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


//        1) Из исходного файла a1.txt прочитать два числа и вывести их сумму
//
//        2) Из исходного файла a2.txt прочитать массив целых чисел и вывести значение среднего арифметического.
//        структура файла: в первой строке записано количество элементов массива,
//        во второй строке через пробел записаны элементы.
//
//        3) Из файла b1.txt прочитать список строк и вывести их на экран в обратном порядке
//
//        4) Прочитать файл b2.txt и вывести из него такие строки, каких нет в файле b1.txt

// Тест Тест Тест
public class Main {
    public static void main(String[] args) {

        String fileInput =  "src/files/a1.txt";
        String fileOutput = "src/files/res.txt";

        readIntFromFile(fileInput, fileOutput);



    }

    static void readIntFromFile(String fileInput, String fileOutput){
        try{
            Scanner sc = new Scanner(new File(fileInput));
            int x = sc.nextInt();
            int y = sc.nextInt();
            FileWriter output = new FileWriter((new File(fileOutput)));
            System.out.println("значение равно " + (x+y));
            String s = "значение равно " + (x+y);
            output.write(s);
            sc.close();
            output.close();
        }
        catch(FileNotFoundException r){
            System.out.println("нет файла");
        }
        catch(IOException e){
            System.out.println("нет файла");
        }
    }


}