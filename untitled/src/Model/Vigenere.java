package Model;

import java.util.ArrayList;

public class Vigenere extends Encrypt {

    //-------------------------------------------ATTRIBUTES-------------------------------------------
    private ArrayList<Integer> key_liste;

    //-------------------------------------------CONSTRUCTOR-------------------------------------------
    public Vigenere(String key) {
        this.key_liste = convertKey(key);
    }

    public Vigenere() {
        this.key_liste = convertKey("a");
    }



    //-------------------------------------------METHODS-------------------------------------------
    // converte string to int array list
    public ArrayList<Integer> convertKey(String key) {
        ArrayList<Integer> key_tempo = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c >= 'a' && c <= 'z') {
                key_tempo.add(c - 'a');
            } else if (c >= 'A' && c <= 'Z') {
                key_tempo.add(c - 'A');
            }
        }
        return key_tempo;
    }

    // method to encrypt the plain text to cipher text with a Arraylist key and return the StringBuilder
    public String encryptDecrypt(String plain, ArrayList<Integer> key) {
        // encrypt the plain text to cipher text without spaces
        StringBuilder cipher = new StringBuilder();
        int key_index = 0;
        for (int i = 0; i < plain.length(); i++) {
            char c = (char) (plain.charAt(i) + key.get(key_index));
            cipher.append(c);
            if (key_index == key.size() - 1) {
                key_index = 0;
            } else {
                key_index++;
            }
        }
        return cipher.toString();
    }
    @Override
    public void encode(String plain) {
        this.v_cypher = encryptDecrypt(plain, this.key_liste);
    }

    @Override
    public void decode(String cypher) {
        // convert the key to negative
        ArrayList<Integer> key_tempo = new ArrayList<>();
        for (int i = 0; i < this.key_liste.size(); i++) {
            key_tempo.add(-this.key_liste.get(i));
        }
        this.v_plain = encryptDecrypt(cypher, key_tempo);
    }

    //-------------------------------------------GETTER AND SETTER-------------------------------------------
    public void setKey(String key) {
        this.key_liste = convertKey(key);
    }


}
