import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Orange {
    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Sem parametro");
            return;
        }
        
        String fileName = args[0];

        String fileNamePerDot[] = fileName.split("\\.");

        String extension = fileNamePerDot[fileNamePerDot.length - 1];


        if(extension.equals("orange")){
        } else{
            System.out.println("extensao invalida");
            return;
        }
        String[] lines = new String[2000];
        int amount = 0;

        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                lines[amount++] =  line;
            }
            input.close();

        } catch (Exception e) {
            System.out.println("Nao foi possivel abrir o arquivo");
            System.out.println("Ele existe msm?");
            e.printStackTrace();
        }
        Processing orange = new Processing(lines, amount);
        orange.Process();
    }
}

