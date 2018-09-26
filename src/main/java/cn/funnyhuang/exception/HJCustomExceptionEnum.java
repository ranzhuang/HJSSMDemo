package cn.funnyhuang.exception;


public enum HJCustomExceptionEnum {
    UNKNOWN_ERROR(499,"未知错误"),
    PARAMETER_ERROR(401,"参数错误");

    private Integer code;
    private String message;

    HJCustomExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
