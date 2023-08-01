import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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


public class Main {
    public static void main(String[] args) {

        String fileInput1 =  "src/files/a1.txt";
        String fileInput2 =  "src/files/a2.txt";
        String fileInput3 =  "src/files/b1.txt";
        String fileInput4 =  "src/files/b2.txt";

        String fileOutput = "src/files/res.txt";

        readIntFromFileAndWriteSumToFile(fileInput1, fileOutput);

        readArrayFromFileAndWriteAverageToFile(fileInput2, fileOutput);

        readStringFromFileAndWriteToFile(fileInput3, fileOutput);

        readStringFromFileAndWriteToFile1(fileInput3, fileInput4, fileOutput);

    }

    static void readIntFromFileAndWriteSumToFile(String fileInput, String fileOutput){
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

    static void readArrayFromFileAndWriteAverageToFile(String fileInput, String fileOutput){
        try{
            Scanner sc = new Scanner(new File(fileInput));
            int n = sc.nextInt();
            int[] arr = new int[n];
            double avg = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                avg+=arr[i];
            }
            avg/=n;
            FileWriter output = new FileWriter((new File(fileOutput)));
            System.out.println("среднее арифметическое " + avg);
            String s = "среднее арифметическое " + avg;
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

    static void readStringFromFileAndWriteToFile(String fileInput, String fileOutput){
        try{
            Scanner sc = new Scanner(new File(fileInput));
            String s;
            ArrayList<String> list = new ArrayList<String>();
            while (sc.hasNextLine()) {
                s = sc.nextLine();
                list.add(s);
            }

            FileWriter output = new FileWriter((new File(fileOutput)));
                for (int i = list.size()-1; i >= 0; i--) {
//                    System.out.println(Arrays.toString(list.toArray()));
                    String s1 = list.get(i);
                    System.out.println(s1);
                    output.write(s1 + "\n");
                }
//            for (String s2 : list) {System.out.println(s2);}
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


    static void readStringFromFileAndWriteToFile1(String fileInput1, String fileInput2,  String fileOutput){
        try{
            Scanner sc = new Scanner(new File(fileInput1));
            String s;
            ArrayList<String> list1 = new ArrayList<String>();
            while (sc.hasNextLine()) {
                s = sc.nextLine();
                list1.add(s);
            }

            sc = new Scanner(new File(fileInput2));
            ArrayList<String> list2 = new ArrayList<String>();
            while (sc.hasNextLine()) {
                s = sc.nextLine();
                list2.add(s);
            }

            ArrayList<String> listResult = new ArrayList<String>();

            FileWriter output = new FileWriter((new File(fileOutput)));
            for (int i = 0; i < list2.size(); i++) {
                if(!list1.contains(list2.get(i))) {
                    String s1 = list2.get(i);
                    System.out.println(s1);
                    output.write(s1 + "\n");
                }
            }
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