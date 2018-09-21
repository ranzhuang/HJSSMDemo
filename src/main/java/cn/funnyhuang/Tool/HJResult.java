package cn.funnyhuang.Tool;

/**

* @Description:    请求返回最外层的对象

* @Author:         HJ

* @CreateDate:     2018/9/21 下午3:43

* @UpdateUser:     HJ

* @UpdateDate:     2018/9/21 下午3:43

* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class HJResult<T> {
    /*错误码*/
    private Integer code;
    /*错误信息*/
    private String msg;
    /*返回类型  T 代表任意类型*/
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
