package insat.tps.tpframework.tp_framework_service.util;

public class Response {
    private ResultState status;
    private String errorMessage;
    private Object result;

    public Response(ResultState status, String errorMessage, Object result) {
        this.status = status;
        this.errorMessage = errorMessage;
        this.result = result;
    }

    public Response() {
    }

    public ResultState getStatus() {
        return status;
    }

    public void setStatus(ResultState status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
