package wiki.chenxun.ace.core.base.exception;

/**
 * @Description: Created by chenxun on 2017/5/7.
 */
public class ApplicationException extends RuntimeException{

    public ApplicationException(String msg) {
        super(msg);
    }

    public ApplicationException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
