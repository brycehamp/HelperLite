public class BasicConversation {

    // presents the initial introduction
    public String initialStatement() {
        return "Hello! I'm HelperLite. It's very nice to meet you, you look wonderful today.\n  How has your day been?";
    }

    // evaluates the user's response for "good day" or "bad day"
    public String evaluateResponseAndReply(String response) {
        if (response.toLowerCase().contains("good") || response.toLowerCase().contains("well") || response.toLowerCase().contains("great")) {
            return "I'm glad! Maybe I can make it even better.\n  You are loved and valued, and I appreciate you.";
        }

        if (response.toLowerCase().contains("bad") || response.toLowerCase().contains("terrible") || response.toLowerCase().contains("awful")) {
            return "I'm so sorry to hear that.\n  Even if you didn't have the best day, you'll do better in the future, I know it.\n  Sometimes, patience is all you need. You've got this.";
        }

        // In case an unexpected response comes up. (Try simplifying the response.)
        return "I'm sorry, I think I misheard. Can you repeat that?";
    }



}
