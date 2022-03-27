package app;

import cipher.A51Cipher;
import cipher.A51KeyStream;
import util.BinaryUtil;

public class App {

    private static final byte[] KEY = new byte[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1};

    private static final byte[] FRAME_COUNTER = new byte[]{0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0};

    private App() {
        A51Cipher cipher = new A51Cipher(new A51KeyStream(KEY, FRAME_COUNTER));
        cipher.initialize();

        System.out.print("\n[a51 stream cipher]\n\n[cipher information]\n\n");
        System.out.println(cipher);
        System.out.println();

        String message = "This is css advanced learning assignment string with some special characters é à ! ? ^";
        String encrypted = cipher.encrypt(BinaryUtil.stringToBinary(message));
        String decrypted = BinaryUtil.binaryToString(cipher.encrypt(encrypted));

        String encryptedString = BinaryUtil.binaryToString(encrypted);

        System.out.print("[encryption]\n\nplaintext='" +message+ "'");
        System.out.print("\nciphertext='" +encryptedString+ "'\n");

        System.out.print("\n\n[decryption]\n\nciphertext='" +encryptedString+ "'");
        System.out.print("\nplaintext='" + decrypted + "'\n\n");
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
}
