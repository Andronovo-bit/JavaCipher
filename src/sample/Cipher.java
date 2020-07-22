package sample;

public interface Cipher {
    String encrypt(String plaintext, String key);
    String decrypt(String ciphertext, String key);
}
