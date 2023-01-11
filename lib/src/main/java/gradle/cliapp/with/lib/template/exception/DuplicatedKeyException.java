package gradle.cliapp.with.lib.template.exception;

public class DuplicatedKeyException extends Exception {
    /**
     * Create a new DuplicatedKeyException
     */
    public DuplicatedKeyException() {
        super("Duplicate key");
    }
}
