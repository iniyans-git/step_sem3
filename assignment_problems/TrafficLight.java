// Week 7 Assignment - Problem 4: The Traffic Light
// Demonstrates controlled state: color changes only via next(), no direct setter

public class TrafficLight {
    private final String id;
    private String color;

    private static final String[] CYCLE = {"RED", "GREEN", "YELLOW"};

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // starts on RED
    }

    public String getColor() {
        return color;
    }

    public String next() {
        for (int i = 0; i < CYCLE.length; i++) {
            if (CYCLE[i].equals(color)) {
                color = CYCLE[(i + 1) % CYCLE.length];
                return color;
            }
        }
        return color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor()); // RED
        System.out.println(t.next());     // GREEN
        System.out.println(t.next());     // YELLOW
        System.out.println(t.next());     // RED
        System.out.println(t.next());     // GREEN (cycles again)
    }
}
