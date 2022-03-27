package cipher;

public class A51Cipher extends StreamCipher {

    public A51Cipher(A51KeyStream keyStream) {
        super(keyStream);
    }

    @Override
    public String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();
        char[] fluxBitChar = message.toCharArray();

        for (int i = 0; i < fluxBitChar.length; i++) {
            encrypted.append(Integer.parseInt(String.valueOf(fluxBitChar[i]))
                    ^ (this.keyStream.getKeyAt(i % 228).get(0) ? 1 : 0));
        }

        return encrypted.toString();
    }
}
