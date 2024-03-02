public class Masina {
    private String producator;
    private String culoare;
    private int putere;

    public Masina(String producator, String culoare, int putere) {
        this.producator = producator;
        this.culoare = culoare;
        this.putere = putere;
    }

    public String getProducator() {
        return producator;
    }

    public String getCuloare() {
        return culoare;
    }

    public int getPutere() {
        return putere;
    }
}
