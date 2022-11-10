package Controller;

import Model.Caesar2;
import Vue.Caesar2Vue;

public class Cesar2Controller {
    //-------------------------------------------ATTRIBUTES-------------------------------------------
    private Caesar2 model;
    private Caesar2Vue vue = null;

    //-------------------------------------------CONSTRUCTOR-------------------------------------------
    public Cesar2Controller(Caesar2 model) {
        this.model = model;
    }

    //-------------------------------------------METHODS-------------------------------------------
    public void setVue(Caesar2Vue vue) {
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
}
