public enum Command {
    AUTH_COMMAND("/auth"),
    AUTHOK_COMMAND("/authok"),
    DISCONNECTED("/disconnected"),
    PRIVATE_MESSAGE("/w"), ///w nick1 привет
    CHAT_MESSAGE("/clients");

    public String getText() {
        return text;
    }

    private String text;

    Command(String s) {
        text = s;
    }
}