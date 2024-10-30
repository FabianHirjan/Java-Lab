public abstract class Attraction implements Comparable<Attraction> {
    private String name;

    public Attraction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    @Override
    public int compareTo(Attraction other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
