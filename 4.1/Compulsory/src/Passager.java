class Passenger extends Person {
    private boolean matched;

    public Passenger(String name, int age, String destination) {
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