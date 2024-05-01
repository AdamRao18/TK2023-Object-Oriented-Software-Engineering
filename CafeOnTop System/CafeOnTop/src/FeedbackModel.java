public class FeedbackModel {
    public void submitFeedback(String name, String email, int rating, String feedback) {
        System.out.println("Feedback Submitted:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Rating: " + rating);
        System.out.println("Feedback: " + feedback);
    }
}
