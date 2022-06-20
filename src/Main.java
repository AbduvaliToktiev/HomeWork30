import com.sun.source.tree.PatternTree;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("file1.txt");
        FileWriter fileWriter = new FileWriter("file1.txt");
        fileWriter.write("Unchecked Exception - это ошибки возникающие в процессе выполнения программы, ошибки которые могут быть обработаны" +
                "\nChecked Exception - это ошибки которые возникают в ожиданных местах, ошибки которые обязательно должны быть обработаны");
        fileWriter.close();
        try {
            limitFile(file);
            System.out.println();
            BufferedReader fileReader = new BufferedReader(new FileReader("file1.txt"));
            String firstString = fileReader.readLine();
            System.out.println(firstString);
        } catch (MyException e) {
            System.out.println(e.getMessage() + " {Error!}");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage() + " {Файл не найден!}");
        }

        File file1 = new File("file2.txt");
        FileWriter fileWriter1 = new FileWriter("file2.txt");
        fileWriter1.write("Error - это ошибки(катастрофы) ломающие программу" +
                "\nRunTimeException - это исключения, относящиеся к необрабатываемым исключениям (Unchecked)" +
                "\nCheckedException - это исключения, которые обязательно должны быть отловлены и обработаны");
        fileWriter1.close();
        FileReader fileReader = new FileReader("file2.txt");
        Scanner sc = new Scanner(fileReader);
        while (sc.hasNextLine()) {
        String file0 = String.valueOf(sc.nextLine());
        String pattern = "[\\s]";
        String replace = "";

        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(file0);

        file0 = matcher.replaceAll(replace);
        System.out.println(file0);
        }
        fileReader.close();
    }

    private static void limitFile(File file) throws MyException {
        if (file.length() > 100) {
            throw new MyException("Код слишком большой!");
        }
    }
}
