package Model;

public abstract class Encrypt {
    //-------------------------------------------ATTRIBUTES-------------------------------------------
    protected String v_plain;
    protected String v_cypher;

    //-------------------------------------------GETTERS-------------------------------------------
    public String getPlain() {
        return v_plain;
    }
    public String getCypher() {
        return v_cypher;
    }

    //-------------------------------------------METHODS-------------------------------------------
    public abstract void encode(String plain);
    public abstract void decode(String cypher);
}
