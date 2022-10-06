package files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CriacaoArquivos {
    private static String HOME_DIR = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {
        System.out.println("HOME_DIR " + HOME_DIR);

        // ler arquivo teste.txt
        // imprimir no console

        Path path = Paths.get(HOME_DIR, "teste.txt");
        Path novo = Paths.get(HOME_DIR, "novo.txt");

        // byte[] bytes = Files.readAllBytes(path);

        Files.lines(path)
                .forEach(System.out::println);

        //   Files.write(novo,bytes);
        //  System.out.println(new String(bytes));

    }

    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    static BufferedReader read;

    public static void CleanCode(String[] args) {
        String Start = "cmd /c start cmd.exe";
        String c = "shutdown -s";

        try {
            pro = run.exec(Start + c);
            read = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            read.readLine();
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}
