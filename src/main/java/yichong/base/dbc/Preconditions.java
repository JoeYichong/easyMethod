/*******************************************************************************
 * Copyright 2018 Joe Yichong
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package yichong.base.dbc;

/**
 * Inspired by the concept of 'Design by Contract(DBC)',
 * these methods are designed primarily for checking preconditions of the calling methods or constructors before
 * executing the actual operations in them, e.g. as demonstrated below:
 * <pre>
 * {@code
 * public void foo(Bar bar, int size){
 * 	   Preconditions.argNotNull("Bar bar", bar);
 *     Preconditions.argument(size, "size > 0", size > 0);
 *
 *     // actual operations of this method
 *     ...
 * }
 * }
 * </pre>
 * <p>
 * Throw an {@code IllegalArgumentException} to indicate that
 * the calling method has been passed an illegal or inappropriate argument,
 * throw an {@code IllegalStateException} to signal that the calling method has been
 * invoked at an illegal or inappropriate time/state for the requested operation.
 * The reason why {@code NullPointerException} isn't used here, see {@link java.lang.NullPointerException}
 * </p>
 * <p>
 * The common traits of these assert methods' parameter signatures are like this:
 * {@code (actual/reality, expected/precondition, boolean expression)}
 * Customized variable information is inserted into the message templates offered by this class to
 * generate specific and precise exception message.
 * <p>Here we use a notation similar to javadoc tags to highlight these variable information.
 * <p>{@code {@sig ...}} means the signature of a method parameter or a state object etc.
 * <p>{@code {@val ...}} means the value of a method parameter or a state object etc.
 * <p>{@code {@actual ...}} means the actual situation of the argument or state object.
 * <p>{@code {@prec ...}} means the description of preconditions.
 * <p>The scenarios of variable information not being available are tolerated by using
 * string '[-]' to indicate this variable information isn't available
 *
 *
 * @author Joe Yichong
 * @version 1.2
 */

public final class Preconditions {
    private static final String Meta_Msg =
            "\r\n[Warning]: 0 Argument or 'null' passed into the `Preconditions` method";
    private static final String Msg_Arr_NotEmpty_Template =
            "\r\n[Problem]: Array {@sig: %s} is Empty(or Null)";
    private static final String Msg_Str_NotEmpty_Template =
            "\r\n[Problem]: String {@sig: %s} is Empty(or Null)";
    private static final String Msg_Arg_NotNull_Template =
            "\r\n[Problem]: Required Argument{@sig: %s} is NULL";
    private static final String Msg_State_NotNull_Template =
            "\r\n[Problem]: Required State{@sig: %s} is NULL";
    private static final String Msg_Arg_Template_v =
            "\r\n[Problem]: Argument {@val: %s} doesn't meet the {@prec: %s}";
    private static final String Msg_Arg_Template_d =
            "\r\n[Problem]: Argument {@actual: %s} doesn't meet the {@prec: %s}";
    private static final String Msg_State_Template_v =
            "\r\n[Problem]: State {@val: %s} doesn't meet the {@prec: %s}";
    private static final String Msg_State_Template_d =
            "\r\n[Problem]: State {@actual: %s} doesn't meet the {@prec: %s}";
    private static final String Msg_Arg_NotNull =
            "\r\n[Problem]: Required Argument is NULL";
    private static final String Msg_State_NotNull =
            "\r\n[Problem]: Required State is NULL";

    /**
     * If the object is a string instance or a character instance, wrap it in "" or ''.
     * Otherwise convert it to a string using {@code String.valueOf()}
     * @param o an object to be wrapped as a string
     * */
    private static String wrapString(Object o){
        String result;
        if (o instanceof String)
            result = "\"" + o + "\"";
        else if (o instanceof Character)
            result = "\'" + o + "\'";
        else
            result = String.valueOf(o);
        return result;
    }

    /**
     * a private method used by 'argument' methods to generate exception messages,
     * {@code null} value and empty string("") are tolerated which indicated by using string '[-]' instead.
     *
     * @param msg_templ a template of exception message into which {@code value} and {@code cond} are inserted
     * @param value a object value, string '[-]' is used to indicate this argument isn't available
     * @param cond a string that describes the preconditions,
     *             string '[-]' is used to indicate this argument isn't available
     * */
    private static String errorMsg(String msg_templ, Object value, String cond) {
        String val = (value == null) ? "[-]" : wrapString(value);
        String prec = (cond == null || "".equals(cond)) ? "[-]" : cond;

        return String.format(msg_templ, val, prec);
    }

    /**
     * a private method used by 'argument' methods to generate exception messages,
     * {@code null} value and empty string("") are tolerated which indicated by using string '[-]' instead or
     * other default values.
     *
     * @param msg_templ a template of exception message into which {@code desc_templ} and {@code cond} are inserted
     * @param desc_templ a template into which {@code value} is inserted, if not specified use {@code value} instead
     * @param value a object value, string '[-]' is used to indicate this argument isn't available
     * @param cond a string that describes the preconditions,
     *             string '[-]' is used to indicate this argument isn't available
     * */
    private static String errorMsg(String msg_templ, String desc_templ, Object value, String cond) {
        String val = (value == null) ? "[-]" : wrapString(value);
        String desc = (desc_templ == null || "".equals(desc_templ)) ? val : String.format(desc_templ, val);
        String prec = (cond == null || "".equals(cond)) ? "[-]" : cond;

        return String.format(msg_templ, desc, prec);
    }

    /**
     * a private method used by 'argNotNull' methods to generate exception messages,
     * {@code null} value and empty string("") are tolerated which indicated by using string '[-]' instead or
     * other default values.
     *
     * @param msg_templ a template of exception message into which {@code param} is inserted
     * @param param the parameter signature of the argument to be checked,
     *              string '[-]' is used to indicate this argument isn't available
     * */
    private static String nullMsg(String msg_templ, String param) {
        String para_n = (param == null || "".equals(param)) ? "[-]" : param;
        return String.format(msg_templ, para_n);
    }

    /**
     * a private method used by Varargs methods in this class to check that there is at least one argument passed in,
     * it also could be used by regular arrays.
     *
     * @param arr the Varargs argument array to be checked
     * */
    private static <T> void checkVarargs(T[] arr) {
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException(Meta_Msg); // warning: empty method calling
    }

    /**
     * A safe way to extract a value in an array without worrying about {@code IndexOutOfBoundsException} thrown.
     * A private method used by methods in this class to fetch a value in a specified array.
     * A {@code null} value is returned if index out of boundary or the array provided is a {@code null} value.
     * Note that it could also means that the value in the specified array is {@code null}.
     *
     * @param arr the specified array from which a value to be fetched
     * @param index the index of the value to be fetched
     * */
    private static <T> T valueInArray(T[] arr, int index) {
        if(arr != null && arr.length > index) {
            return arr[index];
        }
        return null;
    }


    /* ************************************************************************************************** */

    /**
     * Asserts that the specified array is not null and empty.
     * If it is it throws an {@link IllegalArgumentException} with the given
     * message.
     *
     * @param sig a string representation of the array signature
     * @param arr the array to be checked
     * @param <T> the type of the array
     * */
    public static <T> void notNullAndNotEmpty(String sig, T[] arr) {
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException(nullMsg(Msg_Arr_NotEmpty_Template, sig));
    }

    /**
     * Asserts that the specified string is not null and empty.
     * If it is it throws an {@link IllegalArgumentException} with the given
     * message.
     *
     * @param sig a string representation of the string argument signature
     * @param str the string to be checked
     * */
    public static void notNullAndNotEmpty(String sig, String str) {
        if(str == null || str.length() == 0)
            throw new IllegalArgumentException(nullMsg(Msg_Str_NotEmpty_Template, sig));
    }

    /**
     * Asserts that the specified object reference is not null. If it is it throws an
     * {@link IllegalArgumentException} with the given message.
     * (Similar to {@code Objects.requireNonNull(T obj)})
     *
     * @param ref the object reference(as argument) passed to the calling method
     * @throws IllegalArgumentException if the reference is null
     */
    public static void argNotNull(Object ref) {
        if (ref == null)
            throw new IllegalArgumentException(Msg_Arg_NotNull);
    }

    /**
     * Asserts that the specified object reference is not null. If it is it throws an
     * {@link IllegalArgumentException} with the given message.
     *
     * @param param a string that represents the reference's parameter signature
     * @param ref the object reference(as argument) passed to the calling method
     * @throws IllegalArgumentException if the reference is null
     * */
    public static void argNotNull(String param, Object ref) {
        if (ref == null)
            throw new IllegalArgumentException(nullMsg(Msg_Arg_NotNull_Template, param));
    }

    /**
     * Asserts that a batch of object references are not null. If null reference detected
     * it throws an {@link IllegalArgumentException} with the given message.
     *
     * @param refs the object references(as arguments) passed to the calling method
     * @throws IllegalArgumentException if null reference detected
     */
    public static void argsNotNull(Object... refs) {
        checkVarargs(refs);
        for (int i = 0; i < refs.length; i++) {
            if (refs[i] == null)
                throw new IllegalArgumentException(Msg_Arg_NotNull);
        }
    }

    /**
     * Asserts that a batch of object references are not null. If null reference detected
     * it throws an {@link IllegalArgumentException} with the given message.
     *
     * @param params strings that represent the arguments' parameter signatures
     * @param refs the object references(as arguments) passed to the calling method
     * @throws IllegalArgumentException if null reference detected
     */
    public static void argsNotNull(String[] params, Object... refs) {
        checkVarargs(refs);
        for (int i = 0; i < refs.length; i++) {
            if (refs[i] == null) {
                String param = valueInArray(params, i);
                throw new IllegalArgumentException(nullMsg(Msg_Arg_NotNull_Template, param));
            }
        }
    }

    /**
     * Asserts that the argument passed to the calling method meets the preconditions.
     * If it doesn't it throws an {@link IllegalArgumentException} with the given
     * message.
     *
     * @param val an argument to be checked
     * @param prec_str a string that represents the parameter restrictions
     * @param prec_expr a boolean expression that represents the parameter restrictions
     * @throws IllegalArgumentException if the argument is not valid
     */
    public static void argument(Object val, String prec_str, boolean prec_expr) {
        if (!prec_expr)
            throw new IllegalArgumentException(errorMsg(Msg_Arg_Template_v, val, prec_str));
    }

    /**
     * Asserts that the argument passed to the calling method meets the preconditions.
     * If it doesn't it throws an {@link IllegalArgumentException} with the given
     * message.
     * @param val a value or an attribute of the argument to be checked
     * @param desc_templ a template that describes the reality of the argument to be checked
     * @param prec_str a string that represents the parameter restrictions
     * @param prec_expr a boolean expression that represents the parameter restrictions
     * @throws IllegalArgumentException if the argument is not valid
     */
    public static void argument(Object val, String desc_templ, String prec_str, boolean prec_expr) {
        if (!prec_expr)
            throw new IllegalArgumentException(errorMsg(Msg_Arg_Template_d, desc_templ, val, prec_str));
    }

    /**
     * Asserts that a batch of arguments passed to the calling method meet the preconditions.
     * If they don't it throws an {@link IllegalArgumentException} with the given message.
     *
     * @param vals the arguments to be checked
     * @param prec_strs strings that represent the parameter restrictions
     * @param prec_exprs boolean expressions that represent the parameter restrictions
     * @throws IllegalArgumentException if invalid argument detected
     */
    public static void argumentsAll(Object[] vals, String[] prec_strs, Boolean... prec_exprs) {
        checkVarargs(prec_exprs);
        for (int i = 0; i < prec_exprs.length; i++) {
            if (!prec_exprs[i]) {
                Object val = valueInArray(vals, i);
                String prec_str = valueInArray(prec_strs, i);
                throw new IllegalArgumentException(errorMsg(Msg_Arg_Template_v, val, prec_str));
            }
        }
    }

    /**
     * Asserts that a batch of arguments passed to the calling method meet the preconditions.
     * If they don't it throws an {@link IllegalArgumentException} with the given message.
     *
     * @param vals values or attributes of the arguments to be checked
     * @param desc_templs templates that describe the reality of the arguments to be checked
     * @param prec_strs strings that represent the parameter restrictions
     * @param prec_exprs boolean expressions that represent the parameter restrictions
     * @throws IllegalArgumentException if invalid argument detected
     */
    public static void argumentsAll(Object[] vals, String[] desc_templs, String[] prec_strs, Boolean... prec_exprs) {
        checkVarargs(prec_exprs);
        for (int i = 0; i < prec_exprs.length; i++) {
            if (!prec_exprs[i]) {
                Object val = valueInArray(vals, i);
                String desc_templ = valueInArray(desc_templs, i);
                String prec_str = valueInArray(prec_strs, i);
                throw new IllegalArgumentException(errorMsg(Msg_Arg_Template_d, desc_templ, val, prec_str));
            }
        }
    }

    // Arguments: assert at least one condition is true
    public static void argumentsAny(boolean... args) {
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i])
                    return;
            }
            throw new IllegalArgumentException();
        }
    }

    // Arguments: assert at least one condition is true + a Exception message
    public static void argumentsAny(String msg, boolean... args) {
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i])
                    return;
            }
            throw new IllegalArgumentException(msg);
        }
    }

    /* **************************************************************************************************8 */

    /*
     * IllegalStateException
     *
     * Signals that a method has been invoked at an illegal or inappropriate time.
     * In other words, the Java environment or Java application is not in an
     * appropriate state for the requested operation.
     */

    /**
     * Asserts that the specified object reference is not null. If it is it throws an
     * {@link IllegalStateException} with the given message.
     *
     * @param ref the reference of a state object
     * @throws IllegalStateException if the reference is null
     */
    public static void stateNotNull(Object ref) {
        if (ref == null)
            throw new IllegalStateException(Msg_State_NotNull);
    }

    /**
     * Asserts that the specified object reference is not null. If it is it throws an
     * {@link IllegalStateException} with the given message.
     *
     * @param state_name a string that represents the state object's name
     * @param ref the reference of a state object
     * @throws IllegalStateException if the reference is null
     * */
    public static void stateNotNull(String state_name, Object ref) {
        if (ref == null)
            throw new IllegalStateException(nullMsg(Msg_State_NotNull_Template, state_name));
    }

    /**
     * Asserts that a batch of object references are not null. If null reference detected,
     * it throws an {@link IllegalStateException} with the given message.
     *
     * @param refs the references of state objects
     * @throws IllegalStateException if null reference detected
     */
    public static void statesNotNull(Object... refs) {
        checkVarargs(refs);
        for (int i = 0; i < refs.length; i++) {
            if (refs[i] == null)
                throw new IllegalStateException(Msg_State_NotNull);
        }
    }

    /**
     * Asserts that a batch of object references are not null. If null reference detected,
     * it throws an {@link IllegalStateException} with the given message.
     *
     * @param state_names strings that represent the state objects' names
     * @param refs the object references passed to the calling method
     * @throws IllegalStateException if null reference detected
     */
    public static void statesNotNull(String[] state_names, Object... refs) {
        checkVarargs(refs);
        for (int i = 0; i < refs.length; i++) {
            if (refs[i] == null) {
                String state_name = valueInArray(state_names, i);
                throw new IllegalStateException(nullMsg(Msg_State_NotNull_Template, state_name));
            }
        }
    }

    /**
     * Asserts that the state object meets the preconditions.
     * If it doesn't, it throws an {@link IllegalStateException} with the given message.
     *
     * @param val the state object to be checked
     * @param prec_str a string that represents the preconditions
     * @param prec_expr a boolean expression that represents the preconditions
     * @throws IllegalStateException if the state is not valid
     */
    public static void state(Object val, String prec_str, boolean prec_expr) {
        if (!prec_expr)
            throw new IllegalStateException(errorMsg(Msg_State_Template_v, val, prec_str));
    }

    /**
     * Asserts that the state object meets the preconditions.
     * If it doesn't, it throws an {@link IllegalStateException} with the given message.
     *
     * @param val a value or an attribute of the state object to be checked
     * @param desc_templ a template that describes the reality of the state object to be checked
     * @param prec_str a string that represents the preconditions
     * @param prec_expr a boolean expression that represents the preconditions
     * @throws IllegalStateException if the state is not valid
     */
    public static void state(Object val, String desc_templ, String prec_str, boolean prec_expr) {
        if (!prec_expr)
            throw new IllegalStateException(errorMsg(Msg_State_Template_d, desc_templ, val, prec_str));
    }


    /**
     * Asserts that a batch of state objects meet the preconditions.
     * If they don't, it throws an {@link IllegalStateException} with the given message.
     *
     * @param vals the state objects to be checked
     * @param prec_strs strings that represent the preconditions
     * @param prec_exprs boolean expressions that represent the preconditions
     * @throws IllegalStateException if invalid state detected
     */
    public static void statesAll(Object[] vals, String[] prec_strs, Boolean... prec_exprs) {
        checkVarargs(prec_exprs);
        for (int i = 0; i < prec_exprs.length; i++) {
            if (!prec_exprs[i]) {
                Object val = valueInArray(vals, i);
                String prec_str = valueInArray(prec_strs, i);
                throw new IllegalStateException(errorMsg(Msg_State_Template_v, val, prec_str));
            }
        }
    }

    /**
     * Asserts that a batch of state objects meet the preconditions.
     * If they don't, it throws an {@link IllegalStateException} with the given message.
     *
     * @param vals values or attributes of the state objects to be checked
     * @param desc_templs templates that describe the reality of the state objects to be checked
     * @param prec_strs strings that represent the preconditions
     * @param prec_exprs boolean expressions that represent the preconditions
     * @throws IllegalStateException if invalid state detected
     */
    public static void statesAll(Object[] vals, String[] desc_templs, String[] prec_strs, Boolean... prec_exprs) {
        checkVarargs(prec_exprs);
        for (int i = 0; i < prec_exprs.length; i++) {
            if (!prec_exprs[i]) {
                Object val = valueInArray(vals, i);
                String desc_templ = valueInArray(desc_templs, i);
                String prec_str = valueInArray(prec_strs, i);
                throw new IllegalStateException(errorMsg(Msg_State_Template_d, desc_templ, val, prec_str));
            }
        }
    }

    // State: assert at least one condition is true
    public static void statesAny(boolean... prec_strs) {
        if (prec_strs != null && prec_strs.length > 0) {
            for (int i = 0; i < prec_strs.length; i++) {
                if (prec_strs[i])
                    return;
            }
            throw new IllegalStateException();
        }
    }

    // State: assert at least one condition is true + a Exception message
    public static void statesAny(String msg, boolean... args) {
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i])
                    return;
            }
            throw new IllegalStateException(msg);
        }
    }

}
