package org.autodatacorp.orchestration.models.exception;

/**
 * Created by nurico on 2016-04-05.
 */
public class GeneralException extends RuntimeException {

    private static final long serialVersionUID = 5170272671936703875L;
    private final String reason;

    public GeneralException(Throwable cause) {
        super(cause);
        this.reason = null;
    }

    public GeneralException(Throwable cause, final String reason) {
        super(cause);
        this.reason = reason;
    }

    public GeneralException(String message) {
        super(message);
        this.reason = null;
    }

    public GeneralException(String message, final String reason) {
        super(message);
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }
}
