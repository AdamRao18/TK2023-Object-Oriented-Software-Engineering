public class Feedback {
    private String busId;
    private String name;
    private String email;
    private int starScale;
    private String feedback;

    public Feedback(String busId, String name, String email, int starScale, String feedback) {
        this.busId = busId;
        this.name = name;
        this.email = email;
        this.starScale = starScale;
        this.feedback = feedback;
    }

    public String getBusId() {
        return busId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getStarScale() {
        return starScale;
    }

    public String getFeedback() {
        return feedback;
    }

    @Override
    public String toString() {
        return "Bus ID: " + busId + ", Name: " + name + ", Email: " + email +
                ", Star Scale: " + starScale + ", Feedback: " + feedback;
    }
}
