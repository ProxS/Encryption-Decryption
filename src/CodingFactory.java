package encryptdecrypt;

class CodingFactory {

    public Coding newInstance(Config config) {
        switch (config.getMode()) {
            case "enc":
                return new Encryption(config);
            case "dec":
                return new Decryption(config);
            default:
                return null;
//                    throw new NotFoundException("not found flag");
        }
    }
}
