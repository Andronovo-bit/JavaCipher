package sample;

public class VigenereCipher implements Cipher{

    static String generateKey(String str, String key)
    {
        int x = str.length();

        for (int i = 0; ; i++)
        {
            if (x == i)
                i = 0;
            if (key.length() == str.length())
                break;
            key+=(key.charAt(i));
        }
        return key;
    }

    @Override
    public String encrypt(String plaintext, String key) {

        String cipher_text="";
        plaintext = plaintext.toUpperCase();
        for (int i = 0; i < plaintext.length(); i++)
        {
            // converting in range 0-25
            int x = (plaintext.charAt(i) + key.charAt(i)) %26;

            // convert into alphabets(ASCII)
            x += 'A';

            cipher_text+=(char)(x);
        }
        return cipher_text;
    }

    @Override
    public String decrypt(String ciphertext, String key) {
        String orig_text="";
        ciphertext = ciphertext.toUpperCase();
        for (int i = 0 ; i < ciphertext.length() &&
                i < key.length(); i++)
        {
            // converting in range 0-25
            int x = (ciphertext.charAt(i) -
                    key.charAt(i) + 26) %26;

            // convert into alphabets(ASCII)
            x += 'A';
            orig_text+=(char)(x);
        }
        return orig_text;
    }
}
