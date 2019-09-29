package encryptdecrypt;

abstract class Coding {
    protected String text;
    protected int key;
    protected String algorithm;

    public Coding(Config config) {
        this.text = config.getData();
        this.key = config.getKey();
        this.algorithm = config.getAlgorithm();
    }

    /*
        a - 97
        z - 122
        A - 65
        Z - 90
     */

    protected boolean checkUnicodeSymbol(char symbol) {
        boolean inRange = false;
        int unicodeNumber = (int)symbol;

        if((unicodeNumber >= 97 && unicodeNumber <= 122 )
                || (unicodeNumber >= 65 && unicodeNumber <= 90)) {
            inRange = true;
        }

        return inRange;
    }

    public abstract String runCoding();
}
