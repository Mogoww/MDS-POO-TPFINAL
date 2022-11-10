package Model;

public class Caesar2 extends Encrypt{

    //-------------------------------------------METHODS-------------------------------------------
    // encode all the letters, numbers and symbols in the plain text to cipher text
    public String encryptDecrypt(String plain, int key) {
        // encrypt all the letters, numbers and symbols in the plain text to cipher text with ascii code
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < plain.length(); i++) {
            char c = (char) (plain.charAt(i) + key);
            cipher.append(c);
        }
        return cipher.toString();
    }

    @Override
    public void encode(String plain) {
        this.v_cypher = encryptDecrypt(plain, 3);
    }

    @Override
    public void decode(String cypher) {
        this.v_plain = encryptDecrypt(cypher, -3);
    }
}
