class Driver extends Person {

    private boolean matched;

    public Driver(String name, int age, String destination) {
        super(name, age, destination);
        this.matched = false;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }
}
