package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        try {
            Config config = new Config();

            config = config.initializeFromConsole(args);

            InputReceiver receiver = new InputReceiver();

            if (config.getInput() == null && config.getData() == null) {
                receiver.setMethod(new ConsoleInputMethod());
            } else {
                receiver.setMethod(new FileInputMethod());
            }

            receiver.receive(config);

            CodingFactory factory = new CodingFactory();

            Coding coding = factory.newInstance(config);

            String resultString = coding.runCoding();

            OutputSender out = new OutputSender();

            if(config.getOut() != null) {
                out.setMethod(new FileOutputMethod());
            } else {
                out.setMethod(new ConsoleOutputMethod());
            }

            out.receive(resultString, config);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}