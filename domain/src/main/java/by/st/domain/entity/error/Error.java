package by.st.domain.entity.error;

public class Error extends Exception {

    private ErrorType type;

    public Error(String message, ErrorType type) {
        super(message);
        this.type = type;
    }

    public ErrorType getType() {
        return type;
    }
}
