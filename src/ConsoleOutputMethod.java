package encryptdecrypt;

public class ConsoleOutputMethod implements OutputMethod {
    @Override
    public void sendData(String text, Config config) {
        System.out.println(text);
    }
}
