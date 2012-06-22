package exception;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String resourceKey;
    private final Object[] resourceParam;

    public BusinessException(String resourceKey, Object... resourceParam) {
        this.resourceKey = resourceKey;
        this.resourceParam = resourceParam;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public Object[] getResourceParam() {
        return resourceParam;
    }
}
