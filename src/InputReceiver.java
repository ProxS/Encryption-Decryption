package encryptdecrypt;

class InputReceiver {

    private InputMethod method;

    public void setMethod(InputMethod method) {
        this.method = method;
    }

    public void receive(Config config) {
        method.getData(config);
    }

}
