/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.domain;

/**
 *
 * @author Administrator
 */
public class MeiException extends Exception {

    /**
     * Creates a new instance of <code>MeiException</code> without detail
     * message.
     */
    public MeiException() {
    }

    /**
     * Constructs an instance of <code>MeiException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MeiException(String msg) {
        super(msg);
    }

    public MeiException(String message, Throwable cause) {
        super(message, cause);
    }
}
