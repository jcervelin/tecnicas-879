package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Arquivos {
    private static String HOME = System.getProperty("user.home");
    private static String HOME_DIR = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {
        System.out.println("HOME " + HOME);
        System.out.println("HOME_DIR " + HOME_DIR);
        String mapas = HOME_DIR.concat("/mapas");
        String caminhoMapa = HOME_DIR.concat("/mapas/mapa.txt");
        final File file = new File(caminhoMapa);

        final Path path = Paths.get(caminhoMapa);

        final boolean exists = Files.exists(path);
        // System.out.println(exists);

        final Path pathNaoExistente = Paths.get("/caminho/invalido");

        // System.out.println(Files.exists(pathNaoExistente));

        final List<String> collect = Files
                .lines(path)
                .map(getStringStringFunction())
                .collect(Collectors.toList());

        System.out.println(collect);

        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }

        final Path caminhoASerCriado = Paths.get(mapas, System.currentTimeMillis() + ".txt");

        Files.createFile(caminhoASerCriado);
        final File file1 = new File(caminhoMapa);

        lerEmBufferReader(file1);

        for (int i = 0; i < 10; i++) {
            System.out.println("ABC " + i);
        }

    }

    private static Function<String, String> getStringStringFunction() {
        return linha -> {
            return linha + " Banana de Pijamas";
        };
    }

    public static void lerEmBufferReader(File file) {
        System.out.println("Lendo API antiga");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
