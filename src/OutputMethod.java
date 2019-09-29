package encryptdecrypt;

import java.io.IOException;

public interface OutputMethod {

    public void sendData(String text, Config config) throws IOException;

}
