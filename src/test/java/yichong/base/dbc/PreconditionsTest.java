package yichong.base.dbc;

import static org.junit.Assert.*;

public class PreconditionsTest {
    /**
     * Test {@code private static <T> T valueInArray(T[] arr, int index)} in class {@code Preconditions}.
     * Its codes has been copied into {@code PrecTestAssitant} class as a public method for this test.
     * Random values used for testing are automatically generated.
     * @see Preconditions#valueInArray(Object[], int)
     * */
    @org.junit.Test
    public void valueInArray(){
        PrecTestAssitant.getInstance().testValueInArray(10);
    }

    /**
     * Test {@code private static <T> boolean checkVarargs(T[] arr)} in class {@code Preconditions}.
     * Its codes has been copied into {@code PrecTestAssitant} class as a public method for this test.
     * Random values used for testing are automatically generated.
     * @see Preconditions#checkVarargs(Object[])
     * */
    @org.junit.Test
    public void checkVarargs(){
        PrecTestAssitant.getInstance().testCheckVarargs(10);

        // Varargs method test
        // null value passed into the method
        try{
            PrecTestAssitant.checkVarargs((Object[]) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Warning]: No Arguments or 'null' passed into the `assertXXX` method",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // no argument passed into the Varargs method
        try{
            PrecTestAssitant.checkVarargs(new Object[0]);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Warning]: No Arguments or 'null' passed into the `assertXXX` method",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            boolean result = PrecTestAssitant.checkVarargs(new Object[1]);
            assertEquals(result, true);
        }catch (IllegalArgumentException e){
            fail("An IllegalArgumentException isn't supposed to be thrown");
        }

    }

    /**
     * Test {@code public static <T> void notNullAndNotEmpty(String sig, T[] arr)}
     * @see Preconditions#notNullAndNotEmpty(String, Object[])
     * */
    @org.junit.Test
    public void notNullAndNotEmpty_1(){
        // a null value passed into the method as an array
        try{
            Preconditions.notNullAndNotEmpty("Array arr", (Object[]) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Array {@sig: Array arr} is Empty(or Null)",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // an empty array passed into the method
        try{
            Preconditions.notNullAndNotEmpty("Array arr", new Object[0]);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Array {@sig: Array arr} is Empty(or Null)",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // null. null
        try{
            Preconditions.notNullAndNotEmpty(null, (Object[]) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Array {@sig: [-]} is Empty(or Null)",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // "", new Object[0]
        try{
            Preconditions.notNullAndNotEmpty("", new Object[0]);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Array {@sig: [-]} is Empty(or Null)",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void notNullAndNotEmpty(String sig, String str)}
     * @see Preconditions#notNullAndNotEmpty(String, String)
     * */
    @org.junit.Test
    public void notNullAndNotEmpty_2(){
        // a null value passed into the method as an string
        try{
            Preconditions.notNullAndNotEmpty("String str", (String) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: String {@sig: String str} is Empty(or Null)",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // an empty string passed into the method
        try{
            Preconditions.notNullAndNotEmpty("String str", "");
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: String {@sig: String str} is Empty(or Null)",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // null. null
        try{
            Preconditions.notNullAndNotEmpty(null, (String) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: String {@sig: [-]} is Empty(or Null)",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // "", ""
        try{
            Preconditions.notNullAndNotEmpty("", "");
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: String {@sig: [-]} is Empty(or Null)",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void argNotNull(Object ref)}
     * @see Preconditions#argNotNull(Object)
     * */
    @org.junit.Test
    public void argNotNull_1() {
        // null argument
        try{
            Preconditions.argNotNull((Object) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // non-null argument
        try{
            Preconditions.argNotNull("");
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }

        PrecTestAssitant.getInstance().testAssertNotNull_1(10);
    }

    /**
     * Test {@code public static void argNotNull(String param, Object ref)}
     * @see Preconditions#argNotNull(String, Object)
     * */
    @org.junit.Test
    public void argNotNull_2() {
        // null argument
        try{
            Preconditions.argNotNull("Object obj", null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: Object obj} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // non-null argument
        try{
            Preconditions.argNotNull("Object obj", "");
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }

        // null argument, param not available ("" empty string)
        try{
            Preconditions.argNotNull("", null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // null argument, param not available (null value)
        try{
            Preconditions.argNotNull((String) null, null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void argNotNull(Object... refs)}
     * @see Preconditions#argsNotNull(Object...)
     * */
    @org.junit.Test
    public void argNotNull_3() {
        // a batch of objects with a null value in it
        try{
            Preconditions.argsNotNull("", "123", null, true);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects with 2 null values in it
        try{
            Preconditions.argsNotNull("", "123", null, null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects without null value in it
        try{
            Preconditions.argsNotNull("", "123", 100, true);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }

    }

    /**
     * Test {@code public static void argNotNull(String[] params, Object... refs)}
     * @see Preconditions#argsNotNull(String[], Object...)
     * */
    @org.junit.Test
    public void argNotNull_4() {
        // a batch of objects to be checked, the first one is null
        try{
            Preconditions.argsNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    null, "123", new Object(), false);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: String s1} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects to be checked, the last one is null
        try{
            Preconditions.argsNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", new Object(), null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: Boolean b} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects to be checked, the 3rd one is null
        try{
            Preconditions.argsNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", null, true);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: Object o} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects without null value
        try{
            Preconditions.argsNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", 100, true);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }
        // a batch of objects to be checked, the 3rd one is null and its corresponding sig is also null
        try{
            Preconditions.argsNotNull(new String[]{"String s1", "String s2", null, "Boolean b"},
                    "", "123", null, true);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void argument(Object val, String prec_str, boolean prec_expr)}
     * @see Preconditions#argument(Object, String, boolean)
     * */
    @org.junit.Test
    public void argument_1() {
        try{
            int arg = 0;
            Preconditions.argument(arg, "arg > 0", arg > 0);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@val: 0} doesn't meet the {@prec: arg > 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int arg = 1;
            Preconditions.argument(arg, "arg > 0", arg > 0);
        }catch (IllegalArgumentException e){
            fail("An IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            int arg = 0;
            Preconditions.argument(null, null, arg > 0);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e) {
            assertEquals("[Problem]: Argument {@val: [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void argument(Object val, String desc_templ, String prec_str, boolean prec_expr)}
     * @see Preconditions#argument(Object, String, String, boolean)
     * */
    @org.junit.Test
    public void argument_2() {
        try{
            Object[] objs = new Object[10];
            Preconditions.argument(objs.length, "The length of object array argument is %s","objs.length > 10", objs.length > 10);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@actual: The length of object array argument is 10} doesn't meet the {@prec: objs.length > 10}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[11];
            Preconditions.argument(objs.length, "The length of object array argument is %s","objs.length > 10", objs.length > 10);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            Object[] objs = new Object[10];
            Preconditions.argument(null, "The length of object array argument is %s",null, objs.length > 10);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e) {
            assertEquals("[Problem]: Argument {@actual: The length of object array argument is [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[10];
            Preconditions.argument(null, null,null, objs.length > 10);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e) {
            assertEquals("[Problem]: Argument {@actual: [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[10];
            Preconditions.argument(10, null,null, objs.length > 10);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e) {
            assertEquals("[Problem]: Argument {@actual: 10} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void argumentsAll(Object[] vals, String[] prec_strs, Boolean... prec_exprs)}
     * @see Preconditions#argumentsAll(Object[], String[], Boolean...)
     * */
    @org.junit.Test
    public void argumentsAll_1() {
        try{
            int arg1 = 10;
            String arg2 = "a String";
            Object arg3 = new Object();
            Object[] vals = new Object[]{arg1, arg2, arg3};
            String[] precs = new String[]{"arg1 > 0", "arg2 != \"\"", "arg3 != null"};
            Preconditions.argumentsAll(vals, precs, arg1 > 0, arg2 != "", arg3 != null);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            int arg1 = 0;
            String arg2 = "";
            Object arg3 = null;
            Object[] vals = new Object[]{arg1, arg2, arg3};
            String[] precs = new String[]{"arg1 > 0", "arg2 != \"\"", "arg3 != null"};
            Preconditions.argumentsAll(vals, precs, arg1 > 0, arg2 != "", arg3 != null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@val: 0} doesn't meet the {@prec: arg1 > 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int arg1 = 10;
            String arg2 = "";
            Character arg3 = 'a';
            Object[] vals = new Object[]{arg1, arg2, arg3};
            String[] precs = new String[]{"arg1 > 0", "arg2 != \"\"", "arg3 != 'a'"};
            Preconditions.argumentsAll(vals, precs, arg1 > 0, arg2 != "", arg3 != 'a');
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@val: \"\"} doesn't meet the {@prec: arg2 != \"\"}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int arg1 = 10;
            String arg2 = "a string";
            Character arg3 = 'a';
            Object[] vals = new Object[]{arg1, arg2, arg3};
            String[] precs = new String[]{"arg1 > 0", "arg2 != \"\"", "arg3 != 'a'"};
            Preconditions.argumentsAll(vals, precs, arg1 > 0, arg2 != "", arg3 != 'a');
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@val: 'a'} doesn't meet the {@prec: arg3 != 'a'}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test
     * {@code public static void argumentsAll(Object[] vals, String[] desc_templs, String[] prec_strs, Boolean... prec_exprs)}
     * @see Preconditions#argumentsAll(Object[], String[], String[], Boolean...)
     * */
    @org.junit.Test
    public void argumentsAll_2() {
        try{
            String arg1 = "Hello";
            int[] arg2 = new int[]{1, 2, 3, 4};
            Object[] arg3 = new Object[]{};
            Object[] vals = new Object[]{arg1, arg2, arg3};
            String[] desc_templs = new String[]{"String arg1's length is %s", "arg2[0] is %s", "arg3's length is %s"};
            String[] prec_strs = new String[]{"arg1.length() >= 5", "arg2[0] == 1", "arg3.length == 0"};
            Preconditions.argumentsAll(vals, desc_templs, prec_strs, arg1.length() >= 5, arg2[0] == 1, arg3.length == 0);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            String arg1 = "Hello";
            int[] arg2 = new int[]{1, 2, 3, 4};
            Object[] arg3 = new Object[]{};
            Object[] vals = new Object[]{arg1.length(), arg2[0], arg3.length};
            String[] desc_templs = new String[]{"String arg1's length is %s", "arg2[0] is %s", "arg3's length is %s"};
            String[] prec_strs = new String[]{"arg1.length() > 5", "arg2[0] == 0", "arg3.length > 0"};
            Preconditions.argumentsAll(vals, desc_templs, prec_strs, arg1.length() > 5, arg2[0] == 0, arg3.length > 0);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@actual: String arg1's length is 5} doesn't meet the {@prec: arg1.length() > 5}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            String arg1 = "Hello";
            int[] arg2 = new int[]{1, 2, 3, 4};
            Object[] arg3 = new Object[]{};
            Object[] vals = new Object[]{arg1.length(), arg2[0], arg3.length};
            String[] desc_templs = new String[]{"String arg1's length is %s", "arg2[0] is %s", "arg3's length is %s"};
            String[] prec_strs = new String[]{"arg1.length() >= 5", "arg2[0] == 0", "arg3.length > 0"};
            Preconditions.argumentsAll(vals, desc_templs, prec_strs, arg1.length() >= 5, arg2[0] == 0, arg3.length > 0);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@actual: arg2[0] is 1} doesn't meet the {@prec: arg2[0] == 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            String arg1 = "Hello";
            int[] arg2 = new int[]{1, 2, 3, 4};
            Object[] arg3 = new Object[]{};
            Object[] vals = new Object[]{arg1.length(), arg2[0], arg3.length};
            String[] desc_templs = new String[]{"String arg1's length is %s", "arg2[0] is %s", "arg3's length is %s"};
            String[] prec_strs = new String[]{"arg1.length() >= 5", "arg2[0] == 1", "arg3.length > 0"};
            Preconditions.argumentsAll(vals, desc_templs, prec_strs, arg1.length() >= 5, arg2[0] == 1, arg3.length > 0);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@actual: arg3's length is 0} doesn't meet the {@prec: arg3.length > 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void stateNotNull(Object ref)}
     * @see Preconditions#stateNotNull(Object)
     * */
    @org.junit.Test
    public void stateNotNull_1() {
        // null argument
        try{
            Preconditions.stateNotNull((Object) null);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required State is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // non-null argument
        try{
            Preconditions.stateNotNull("");
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }

    }

    /**
     * Test {@code public static void stateNotNull(Object ref, String state_name)}
     * @see Preconditions#stateNotNull(String, Object)
     * */
    @org.junit.Test
    public void stateNotNull_2() {
        // null argument
        try{
            Preconditions.stateNotNull("Object obj", null);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required State{@sig: Object obj} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // non-null argument
        try{
            Preconditions.stateNotNull("Object obj", "");
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }

        // null argument, param not available ("" empty string)
        try{
            Preconditions.stateNotNull("", null);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required State{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // null argument, param not available (null value)
        try{
            Preconditions.stateNotNull((String) null, null);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required State{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void stateNotNull(Object... refs)}
     * @see Preconditions#statesNotNull(Object...)
     * */
    @org.junit.Test
    public void statesNotNull_1() {
        // a batch of objects with a null value in it
        try{
            Preconditions.statesNotNull("", "123", null, true);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required State is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects with 2 null values in it
        try{
            Preconditions.statesNotNull("", "123", null, null);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required State is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects without null value in it
        try{
            Preconditions.statesNotNull("", "123", 100, true);
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }

    }

    /**
     * Test {@code public static void stateNotNull(String[] state_names, Object... refs)}
     * @see Preconditions#statesNotNull(String[], Object...)
     * */
    @org.junit.Test
    public void statesNotNull_2() {
        // a batch of objects to be checked, the first one is null
        try{
            Preconditions.statesNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    null, "123", new Object(), false);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required State{@sig: String s1} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects to be checked, the last one is null
        try{
            Preconditions.statesNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", new Object(), null);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required State{@sig: Boolean b} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects to be checked, the 3rd one is null
        try{
            Preconditions.statesNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", null, true);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required State{@sig: Object o} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects without null value
        try{
            Preconditions.statesNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", 100, true);
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }
        // a batch of objects to be checked, the 3rd one is null and its corresponding sig is also null
        try{
            Preconditions.statesNotNull(new String[]{"String s1", "String s2", null, "Boolean b"},
                    "", "123", null, true);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required State{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void state(Object val, String prec_str, boolean prec_expr)}
     * @see Preconditions#state(Object, String, boolean)
     * */
    @org.junit.Test
    public void state_1() {
        try{
            int arg = 0;
            Preconditions.state(arg, "arg > 0", arg > 0);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@val: 0} doesn't meet the {@prec: arg > 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int arg = 1;
            Preconditions.state(arg, "arg > 0", arg > 0);
        }catch (IllegalStateException e){
            fail("An IllegalStateException isn't supposed to be thrown");
        }
        try{
            int arg = 0;
            Preconditions.state(null, null, arg > 0);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e) {
            assertEquals("[Problem]: State {@val: [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void state(Object val, String desc_templ, String prec_str, boolean prec_expr)}
     * @see Preconditions#state(Object, String, String, boolean)
     * */
    @org.junit.Test
    public void state_2() {
        try{
            Object[] objs = new Object[10];
            Preconditions.state(objs.length, "The length of object array State is %s","objs.length > 10", objs.length > 10);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@actual: The length of object array State is 10} doesn't meet the {@prec: objs.length > 10}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[11];
            Preconditions.state(objs.length, "The length of object array State is %s","objs.length > 10", objs.length > 10);
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }
        try{
            Object[] objs = new Object[10];
            Preconditions.state(null, "The length of object array State is %s",null, objs.length > 10);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e) {
            assertEquals("[Problem]: State {@actual: The length of object array State is [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[10];
            Preconditions.state(null, null,null, objs.length > 10);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e) {
            assertEquals("[Problem]: State {@actual: [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[10];
            Preconditions.state(10, null,null, objs.length > 10);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e) {
            assertEquals("[Problem]: State {@actual: 10} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void statesAll(Object[] vals, String[] prec_strs, Boolean... prec_exprs)}
     * @see Preconditions#statesAll(Object[], String[], Boolean...)
     * */
    @org.junit.Test
    public void statesAll_1() {
        try{
            int state1 = 10;
            String state2 = "a String";
            Object state3 = new Object();
            Object[] vals = new Object[]{state1, state2, state3};
            String[] precs = new String[]{"state1 > 0", "state2 != \"\"", "state3 != null"};
            Preconditions.statesAll(vals, precs, state1 > 0, state2 != "", state3 != null);
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }
        try{
            int state1 = 0;
            String state2 = "";
            Object state3 = null;
            Object[] vals = new Object[]{state1, state2, state3};
            String[] precs = new String[]{"state1 > 0", "state2 != \"\"", "state3 != null"};
            Preconditions.statesAll(vals, precs, state1 > 0, state2 != "", state3 != null);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@val: 0} doesn't meet the {@prec: state1 > 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int state1 = 10;
            String state2 = "";
            Character state3 = 'a';
            Object[] vals = new Object[]{state1, state2, state3};
            String[] precs = new String[]{"state1 > 0", "state2 != \"\"", "state3 != 'a'"};
            Preconditions.statesAll(vals, precs, state1 > 0, state2 != "", state3 != 'a');
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@val: \"\"} doesn't meet the {@prec: state2 != \"\"}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int state1 = 10;
            String state2 = "a string";
            Character state3 = 'a';
            Object[] vals = new Object[]{state1, state2, state3};
            String[] precs = new String[]{"state1 > 0", "state2 != \"\"", "state3 != 'a'"};
            Preconditions.statesAll(vals, precs, state1 > 0, state2 != "", state3 != 'a');
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@val: 'a'} doesn't meet the {@prec: state3 != 'a'}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void statesAll(Object[] vals, String[] desc_templs, String[] prec_strs, Boolean... prec_exprs)}
     * @see Preconditions#statesAll(Object[], String[], String[], Boolean...)
     * */
    @org.junit.Test
    public void statesAll_2() {
        try{
            String state1 = "Hello";
            int[] state2 = new int[]{1, 2, 3, 4};
            Object[] state3 = new Object[]{};
            Object[] vals = new Object[]{state1, state2, state3};
            String[] desc_templs = new String[]{"String state1's length is %s", "state2[0] is %s", "state3's length is %s"};
            String[] prec_strs = new String[]{"state1.length() >= 5", "state2[0] == 1", "state3.length == 0"};
            Preconditions.statesAll(vals, desc_templs, prec_strs, state1.length() >= 5, state2[0] == 1, state3.length == 0);
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }
        try{
            String state1 = "Hello";
            int[] state2 = new int[]{1, 2, 3, 4};
            Object[] state3 = new Object[]{};
            Object[] vals = new Object[]{state1.length(), state2[0], state3.length};
            String[] desc_templs = new String[]{"String state1's length is %s", "state2[0] is %s", "state3's length is %s"};
            String[] prec_strs = new String[]{"state1.length() > 5", "state2[0] == 0", "state3.length > 0"};
            Preconditions.statesAll(vals, desc_templs, prec_strs, state1.length() > 5, state2[0] == 0, state3.length > 0);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@actual: String state1's length is 5} doesn't meet the {@prec: state1.length() > 5}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            String state1 = "Hello";
            int[] state2 = new int[]{1, 2, 3, 4};
            Object[] state3 = new Object[]{};
            Object[] vals = new Object[]{state1.length(), state2[0], state3.length};
            String[] desc_templs = new String[]{"String state1's length is %s", "state2[0] is %s", "state3's length is %s"};
            String[] prec_strs = new String[]{"state1.length() >= 5", "state2[0] == 0", "state3.length > 0"};
            Preconditions.statesAll(vals, desc_templs, prec_strs, state1.length() >= 5, state2[0] == 0, state3.length > 0);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@actual: state2[0] is 1} doesn't meet the {@prec: state2[0] == 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            String state1 = "Hello";
            int[] state2 = new int[]{1, 2, 3, 4};
            Object[] state3 = new Object[]{};
            Object[] vals = new Object[]{state1.length(), state2[0], state3.length};
            String[] desc_templs = new String[]{"String state1's length is %s", "state2[0] is %s", "state3's length is %s"};
            String[] prec_strs = new String[]{"state1.length() >= 5", "state2[0] == 1", "state3.length > 0"};
            Preconditions.statesAll(vals, desc_templs, prec_strs, state1.length() >= 5, state2[0] == 1, state3.length > 0);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@actual: state3's length is 0} doesn't meet the {@prec: state3.length > 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }
}