package cn.funnyhuang.exception;

/**

* @Description:    java类作用描述 自定义异常信息类

* @Author:         HJ

* @CreateDate:     2018/9/25 下午3:24

* @UpdateUser:     HJ

* @UpdateDate:     2018/9/25 下午3:24

* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class HJCustomException extends RuntimeException {

    private Integer code;

    /**
     * 自定义错误信息
     * @param message
     * @param code
     */
    public HJCustomException(String message,Integer code) {
        super(message);
        this.code = code;
    }

    public  HJCustomException(HJCustomExceptionEnum hjCustomExceptionEnum) {
        super(hjCustomExceptionEnum.getMessage());
        this.code = hjCustomExceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
