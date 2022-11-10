package Controller;

import Model.Caesar;
import Vue.CaesarVue;

public class CesarController {
    //-------------------------------------------ATTRIBUTES-------------------------------------------
    private Caesar model;
    private CaesarVue vue = null;

    //-------------------------------------------CONSTRUCTOR-------------------------------------------
    public CesarController(Caesar model) {
        this.model = model;
    }

    //-------------------------------------------METHODS-------------------------------------------
    public void setVue(CaesarVue vue) {
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
