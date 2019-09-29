package encryptdecrypt;

class Decryption extends Coding {

    public Decryption(Config config) {
        super(config);
    }

    @Override
    public String runCoding() {
        String decoded = "";

        for (char ch : text.toCharArray()) {

            if (algorithm == "shift") {

                if (!checkUnicodeSymbol(ch)) {
                    decoded += ch;
                    continue;
                }

                int number = ch;
                int newNumber = 0;

                if (number >= 97 && number <= 122) {
                    int position = number - 96;
                    int newPosition = position - key;

                    newPosition = newPosition < 0 ? 26 + newPosition : newPosition;

                    newNumber = 96 + newPosition;
                } else {
                    int position = number - 64;
                    int newPosition = position - key;

                    newPosition = newPosition < 0 ? 26 + newPosition : newPosition;

                    newNumber = 64 + newPosition;
                }

                decoded += (char) newNumber;
            } else if (algorithm == "unicode") {


                int number = ch;
                int newNumber = number - key;

                if (newNumber < 0) {
                    newNumber = 65536 + newNumber;
                }

                decoded += (char) newNumber;
            }
        }

        return decoded;
    }

}
