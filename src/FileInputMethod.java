package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInputMethod implements InputMethod {
    @Override
    public void getData(Config config) {
        String fileData = "";

        File file = new File(config.getInput());

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                fileData += scanner.nextLine();
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + config.getInput());

            fileData = "";
        }

        config.setData(fileData);
    }
}
