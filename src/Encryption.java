package encryptdecrypt;

class Encryption extends Coding {

    public Encryption(Config config) {
        super(config);
    }

    @Override
    public String runCoding() {
        String encoded = "";

        for (char ch : text.toCharArray()) {

            if (algorithm == "shift") {

                if(!checkUnicodeSymbol(ch)) {
                    encoded += ch;
                    continue;
                }

                int number = ch;
                int newNumber = 0;

                if(number >= 97 && number <= 122) {
                    int position = number - 96;
                    int newPosition = position + key;

                    newPosition = newPosition>26?newPosition%26:newPosition;

                    newNumber = 96 + newPosition;
                } else {
                    int position = number - 64;
                    int newPosition = position + key;

                    newPosition = newPosition>26?newPosition%26:newPosition;

                    newNumber = 64 + newPosition;
                }

                encoded += (char) newNumber;
            } else if (algorithm == "unicode") {

                int number = ch;
                int newNumber = number + key;

                if (newNumber > 65536) {
                    newNumber = newNumber % 65536;
                }

                encoded += (char) newNumber;
            }
        }

        return encoded;
    }

}
