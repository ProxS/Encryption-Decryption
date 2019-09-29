package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputMethod implements OutputMethod {

    @Override
    public void sendData(String text, Config config) throws IOException {
        File file = new File(config.getOut());

        file.createNewFile();

        FileWriter writer = new FileWriter(file);
        writer.write(text);

        writer.close();
    }
}
