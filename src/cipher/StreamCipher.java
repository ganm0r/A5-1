package cipher;

public abstract class StreamCipher {

    KeyStream keyStream;

    StreamCipher(KeyStream keyStream) {
        this.keyStream = keyStream;
    }

    public void initialize() {
        this.keyStream.initialize();
    }

    public KeyStream getKeyStream() {
        return keyStream;
    }

    public abstract String encrypt(String message);

    @Override
    public String toString() {
        return "StreamCipher{" +
                "\n\tkeyStream=" + keyStream +
                "\n}";
    }

}
