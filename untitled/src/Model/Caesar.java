package Model;

public class Caesar extends Encrypt{



    //-------------------------------------------METHODS-------------------------------------------

    // method to encrypt the plain text to cipher text with a key and return the StringBuilder
    public String encryptDecrypt(String plain, int key) {
        // encrypt the plain text to cipher text without spaces
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < plain.length(); i++) {
            if (Character.isLetter(plain.charAt(i))) {
                if (Character.isLowerCase(plain.charAt(i))) {
                    char c = (char) (plain.charAt(i) + key);
                    if (c > 'z') {
                        cipher.append((char) (plain.charAt(i) - (26 - key)));
                    } else {
                        cipher.append((char) (plain.charAt(i) + key));
                    }
                } else if (Character.isUpperCase(plain.charAt(i))) {
                    char c = (char) (plain.charAt(i) + key);
                    if (c > 'Z') {
                        cipher.append((char) (plain.charAt(i) - (26 - key)));
                    } else {
                        cipher.append((char) (plain.charAt(i) + key));
                    }
                }
            } else {
                cipher.append(plain.charAt(i));
            }
        }
        return cipher.toString();
    }


    // this method encrypts the plain text to cipher text with 3 shift
    @Override
    public void encode(String plain) {
        this.v_cypher = encryptDecrypt(plain, 3);
    }

    @Override
    public void decode(String cypher) {
        this.v_plain = encryptDecrypt(cypher, -3);
    }


}
