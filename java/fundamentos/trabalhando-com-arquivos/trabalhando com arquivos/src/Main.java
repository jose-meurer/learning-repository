import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        String path = "in.txt";

//        lendoArquivosComScanner(path);
//        lendoArquivosFileReader(path);

//        escrevendoEmArquivos(path);
//        lendoArquivosTryWithResources(path);

//        manipulandoPastas();

        informacoesSobreAquivos();
    }

    public static void informacoesSobreAquivos() {
        File file = new File("c:\\temp\\in.txt");

        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.getFreeSpace());
        System.out.println(file.getUsableSpace());
        System.out.println(file.isFile());

        //retornando uma pasta
        File parentFolder = new File(file.getParent());
        System.out.println(parentFolder.getParent());
    }

    public static void manipulandoPastas() {
        File path = new File("c:");

        File[] folders = path.listFiles((x) -> {
            return x.isDirectory();
        });
        System.out.println("FOLDERS: ");
        for (File folder : folders) {
            System.out.println(folder);
        }

        File[] files = path.listFiles(x -> x.isFile());
        System.out.println("FILES: ");
        for (File file : files) {
            System.out.println(file);
        }

        //Criacao de pastas
        boolean sucess = new File("c:" + "\\test").mkdir();
        System.out.println("Directory created successfully: " + sucess);
    }

    public static void escrevendoEmArquivos(String path) {
        String[] lines = {"\n", "Segunda-feira", "Terça-feira", "Bom domingo"};

        try (
                FileWriter fw = new FileWriter(path, true);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lendoArquivosTryWithResources(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lendoArquivosFileReader(String path) {

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void lendoArquivosComScanner(String path) {
        Scanner sc = null;
        File file = new File(path);

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) sc.close();
        }
    }

}
