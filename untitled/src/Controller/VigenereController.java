package Controller;

import Model.Vigenere;
import Vue.VigenereVue;

public class VigenereController {
    //-------------------------------------------ATTRIBUTES-------------------------------------------
    private Vigenere model;
    private VigenereVue vue = null;

    //-------------------------------------------CONSTRUCTOR-------------------------------------------
    public VigenereController(Vigenere model) {
        this.model = model;
    }

    //-------------------------------------------METHODS-------------------------------------------
    public void setVue(VigenereVue vue) {
        this.vue = vue;
    }

    //-------------------------------------------GETTERS/SETTERS-------------------------------------------
    public void encode(String plain) {
        model.encode(plain);
    }
    public void decode(String cypher) {
        model.decode(cypher);
    }

    public String getPlain() {
        return model.getPlain();
    }

    public String getCypher() {
        return model.getCypher();
    }

    public void setKey(String key) {
        model.setKey(key);
    }

}
