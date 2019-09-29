package encryptdecrypt;

import java.io.IOException;

class OutputSender {
    private OutputMethod method;

    public void setMethod(OutputMethod method) {
        this.method = method;
    }

    public void receive(String text, Config config) {
        try {
            method.sendData(text, config);
        } catch (IOException e) {
            System.out.println("File not found " + config.getOut());
        }
    }
}
