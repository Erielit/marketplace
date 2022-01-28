package mx.edu.utez.marketplace.utils;

public class Message {
    private String message;
    private boolean error;
    private Object data;

    public Message() {
    }

    public Message(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public Message(String message, boolean error, Object data) {
        this.message = message;
        this.error = error;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
