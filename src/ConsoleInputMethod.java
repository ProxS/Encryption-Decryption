package encryptdecrypt;

import java.util.Scanner;

public class ConsoleInputMethod implements InputMethod {
    @Override
    public void getData(Config config) {
        Scanner sc = new Scanner(System.in);

        String data = sc.nextLine();
        int key = sc.nextInt();

        config.setData(data);
        config.setKey(key);
    }
}