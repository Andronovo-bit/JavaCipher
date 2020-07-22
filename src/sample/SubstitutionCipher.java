package sample;

import org.ietf.jgss.MessageProp;

public class SubstitutionCipher implements Cipher {

    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String encrypt(String plaintext, String key) {
        try {
            StringBuilder sb = new StringBuilder(plaintext.length());
            plaintext = plaintext.toLowerCase();
            for (char c : plaintext.toCharArray()) {
                if (c == ' ') {
                    sb.append(' ');
                } else {
                    int index = alphabet.indexOf(c);
                    sb.append(key.charAt(index));
                }
            }
            return sb.toString();

        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String decrypt(String ciphertext, String key) {
        StringBuilder sb = new StringBuilder(ciphertext.length());
        ciphertext = ciphertext.toLowerCase();
        for (char c : ciphertext.toCharArray()) {
            if (c == ' ') {
                sb.append(' ');
            } else {
                int index = key.indexOf(c);
                sb.append(alphabet.charAt(index));
            }
        }

        return sb.toString();
    }
}
