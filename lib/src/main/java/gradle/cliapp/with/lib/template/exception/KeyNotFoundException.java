package gradle.cliapp.with.lib.template.exception;

public class KeyNotFoundException extends RuntimeException {
    /**
     * Create a new KeyNotFoundException
     */
    public KeyNotFoundException() {
        super("Key not found");
    }
}
