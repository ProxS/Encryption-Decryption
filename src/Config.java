package encryptdecrypt;

class Config {

    private String algorithm;
    private String input;
    private String mode;
    private int key;
    private String data;
    private String out;

    public void setData(String data) {
        this.data = data;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getData() {
        return data;
    }

    public int getKey() {
        return key;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getInput() {
        return input;
    }

    public String getMode() {
        return mode;
    }

    public String getOut() {
        return out;
    }

    public Config initializeFromConsole(String[] params) {
        String[] keywords = {"-mode", "-key", "-data", "-in", "-out", "-alg"};

        this.mode = "enc";
        this.algorithm = "shift";
        this.key = 5;

        for (int i = 0; i < params.length; i++) {

            if (i + 1 >= params.length || find(keywords, params[i + 1])) {
                continue;
            }

            String value = params[i + 1];

            switch (params[i]) {
                case "-mode":
                    this.mode = value;
                    break;
                case "-alg":
                    this.algorithm = value;
                    break;
                case "-key":
                    this.key = Integer.parseInt(value);
                    break;
                case "-data":
                    this.data = value;
                    break;
                case "-in":
                    this.input = value;
                    break;
                case "-out":
                    this.out = value;
                    break;
            }

        }

        return this;
    }

    public boolean find(String[] haystack, String needle) {
        boolean finded = false;

        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == needle) {
                finded = true;
                break;
            }
        }

        return finded;
    }

}
