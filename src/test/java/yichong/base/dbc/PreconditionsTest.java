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
            assertEquals("[Warning]: 0 Argument or 'null' passed into the `Preconditions` method",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // no argument passed into the Varargs method
        try{
            PrecTestAssitant.checkVarargs(new Object[0]);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Warning]: 0 Argument or 'null' passed into the `Preconditions` method",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            PrecTestAssitant.checkVarargs(new Object[1]);
        }catch (IllegalArgumentException e){
            fail("An IllegalArgumentException isn't supposed to be thrown");
        }

    }

    /**
     * Test {@code public static <T> void argumentNotNullAndNotEmpty(String sig, T[] arr)}
     * @see Preconditions#argumentNotNullAndNotEmpty(String, Object[])
     * */
    @org.junit.Test
    public void argumentNotNullAndNotEmpty_1(){
        // a null value passed into the method as an array
        try{
            Preconditions.argumentNotNullAndNotEmpty("Array arr", (Object[]) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: Array arr} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // an empty array passed into the method
        try{
            Preconditions.argumentNotNullAndNotEmpty("Array arr", new Object[0]);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Array {@sig: Array arr} is Empty",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // null. null
        try{
            Preconditions.argumentNotNullAndNotEmpty(null, (Object[]) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // "", new Object[0]
        try{
            Preconditions.argumentNotNullAndNotEmpty("", new Object[0]);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Array {@sig: [-]} is Empty",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void argumentNotNullAndNotEmpty(String sig, String str)}
     * @see Preconditions#argumentNotNullAndNotEmpty(String, String)
     * */
    @org.junit.Test
    public void argumentNotNullAndNotEmpty_2(){
        // a null value passed into the method as an string
        try{
            Preconditions.argumentNotNullAndNotEmpty("String str", (String) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: String str} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // an empty string passed into the method
        try{
            Preconditions.argumentNotNullAndNotEmpty("String str", "");
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: String {@sig: String str} is Empty",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // null. null
        try{
            Preconditions.argumentNotNullAndNotEmpty(null, (String) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // "", ""
        try{
            Preconditions.argumentNotNullAndNotEmpty("", "");
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: String {@sig: [-]} is Empty",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void argumentNotNull(Object ref)}
     * @see Preconditions#argumentNotNull(Object)
     * */
    @org.junit.Test
    public void argNotNull_1() {
        // null argument
        try{
            Preconditions.argumentNotNull((Object) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // non-null argument
        try{
            Preconditions.argumentNotNull("");
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }

        PrecTestAssitant.getInstance().testAssertNotNull_1(10);
    }

    /**
     * Test {@code public static void argumentNotNull(String param, Object ref)}
     * @see Preconditions#argumentNotNull(String, Object)
     * */
    @org.junit.Test
    public void argNotNull_2() {
        // null argument
        try{
            Preconditions.argumentNotNull("Object obj", null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: Object obj} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // non-null argument
        try{
            Preconditions.argumentNotNull("Object obj", "");
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }

        // null argument, param not available ("" empty string)
        try{
            Preconditions.argumentNotNull("", null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // null argument, param not available (null value)
        try{
            Preconditions.argumentNotNull((String) null, null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void argumentNotNull(Object... refs)}
     * @see Preconditions#argumentsNotNull(Object...)
     * */
    @org.junit.Test
    public void argNotNull_3() {
        // a batch of objects with a null value in it
        try{
            Preconditions.argumentsNotNull("", "123", null, true);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects with 2 null values in it
        try{
            Preconditions.argumentsNotNull("", "123", null, null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects without null value in it
        try{
            Preconditions.argumentsNotNull("", "123", 100, true);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }

    }

    /**
     * Test {@code public static void argumentNotNull(String[] params, Object... refs)}
     * @see Preconditions#argumentsNotNull(String[], Object...)
     * */
    @org.junit.Test
    public void argNotNull_4() {
        // a batch of objects to be checked, the first one is null
        try{
            Preconditions.argumentsNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    null, "123", new Object(), false);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: String s1} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects to be checked, the last one is null
        try{
            Preconditions.argumentsNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", new Object(), null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: Boolean b} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects to be checked, the 3rd one is null
        try{
            Preconditions.argumentsNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", null, true);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: Object o} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects without null value
        try{
            Preconditions.argumentsNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", 100, true);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }
        // a batch of objects to be checked, the 3rd one is null and its corresponding sig is also null
        try{
            Preconditions.argumentsNotNull(new String[]{"String s1", "String s2", null, "Boolean b"},
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
     * Test {@code public static void argumentAll(Object val, String[] prec_strs, Boolean... prec_exprs)}
     * @see Preconditions#argumentAll(Object, String[], Boolean...)
     * */
    @org.junit.Test
    public void argumentAll_1() {
        try{
            int val = 10;
            String[] precs = new String[]{"val > 0", "val != 50", "val < 100"};
            Preconditions.argumentAll(val, precs, val > 0, val != 50, val < 100);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            int val = 10;
            String[] precs = new String[]{"val > 10", "val != 50", "val < 100"};
            Preconditions.argumentAll(val, precs, val > 10, val != 50, val < 100);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@val: 10} doesn't meet the {@prec: val > 10}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int val = 50;
            String[] precs = new String[]{"val > 0", "val != 50", "val < 100"};
            Preconditions.argumentAll(val, precs, val > 0, val != 50, val < 100);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@val: 50} doesn't meet the {@prec: val != 50}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int val = 100;
            String[] precs = new String[]{"val > 0", "val != 50", "val < 100"};
            Preconditions.argumentAll(val, precs, val > 0, val != 50, val < 100);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@val: 100} doesn't meet the {@prec: val < 100}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test
     * {@code public static void argumentAll(Object val, String desc_templ, String[] prec_strs, Boolean... prec_exprs)}
     * @see Preconditions#argumentAll(Object, String, String[], Boolean...)
     * */
    @org.junit.Test
    public void argumentAll_2() {
        try{
            int[] arr = new int[]{10, 20, 30, 40};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 10", "arr.length != 3"};
            Preconditions.argumentAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 10, arr.length != 3);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            int[] arr = new int[]{};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 10", "arr.length != 3"};
            Preconditions.argumentAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 10, arr.length != 3);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@actual: arr's length is 0} doesn't meet the {@prec: arr.length > 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int[] arr = new int[]{10, 20, 30, 40, 50};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 5", "arr.length != 3"};
            Preconditions.argumentAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 5, arr.length != 3);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@actual: arr's length is 5} doesn't meet the {@prec: arr.length < 5}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int[] arr = new int[]{10, 20, 30, 40};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 10", "arr.length != 4"};
            Preconditions.argumentAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 10, arr.length != 4);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@actual: arr's length is 4} doesn't meet the {@prec: arr.length != 4}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }


    /**
     * Test {@code public static void argumentAny(String conditions, Boolean... exprs)}
     * @see Preconditions#argumentAny(String, Boolean...)
     * */
    @org.junit.Test
    public void argumentAny() {
        try{
            int arg = 50;
            String conds = "arg < 30, arg > 90, arg == 60";
            Preconditions.argumentAny(conds, arg < 30, arg > 90, arg == 60);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: None of these specified argument conditions{@prec: arg < 30, arg > 90, arg == 60} is true",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int arg = 10;
            String conds = "arg < 30, arg > 90, arg == 60";
            Preconditions.argumentAny(conds, arg < 30, arg > 90, arg == 60);
        }catch (IllegalArgumentException e){
            fail("An IllegalStateException isn't supposed to be thrown");
        }
        try{
            int arg = 100;
            String conds = "arg < 30, arg > 90, arg == 60";
            Preconditions.argumentAny(conds, arg < 30, arg > 90, arg == 60);
        }catch (IllegalArgumentException e){
            fail("An IllegalStateException isn't supposed to be thrown");
        }
        try{
            int arg = 60;
            String conds = "arg < 30, arg > 90, arg == 60";
            Preconditions.argumentAny(conds, arg < 30, arg > 90, arg == 60);
        }catch (IllegalArgumentException e){
            fail("An IllegalStateException isn't supposed to be thrown");
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
     * Test {@code public static void stateAll(Object[] vals, String[] prec_strs, Boolean... prec_exprs)}
     * @see Preconditions#stateAll(Object, String[], Boolean...)
     * */
    @org.junit.Test
    public void statesAll_1() {
        try{
            int val = 10;
            String[] precs = new String[]{"val > 0", "val != 50", "val < 100"};
            Preconditions.stateAll(val, precs, val > 0, val != 50, val < 100);
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }
        try{
            int val = 10;
            String[] precs = new String[]{"val > 10", "val != 50", "val < 100"};
            Preconditions.stateAll(val, precs, val > 10, val != 50, val < 100);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@val: 10} doesn't meet the {@prec: val > 10}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int val = 50;
            String[] precs = new String[]{"val > 0", "val != 50", "val < 100"};
            Preconditions.stateAll(val, precs, val > 0, val != 50, val < 100);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@val: 50} doesn't meet the {@prec: val != 50}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int val = 100;
            String[] precs = new String[]{"val > 0", "val != 50", "val < 100"};
            Preconditions.stateAll(val, precs, val > 0, val != 50, val < 100);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@val: 100} doesn't meet the {@prec: val < 100}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        
    }

    /**
     * Test {@code public static void stateAll(Object[] vals, String[] desc_templs, String[] prec_strs, Boolean... prec_exprs)}
     * @see Preconditions#stateAll(Object, String, String[], Boolean...)
     * */
    @org.junit.Test
    public void statesAll_2() {
        try{
            int[] arr = new int[]{10, 20, 30, 40};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 10", "arr.length != 3"};
            Preconditions.stateAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 10, arr.length != 3);
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }
        try{
            int[] arr = new int[]{};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 10", "arr.length != 3"};
            Preconditions.stateAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 10, arr.length != 3);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@actual: arr's length is 0} doesn't meet the {@prec: arr.length > 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int[] arr = new int[]{10, 20, 30, 40, 50};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 5", "arr.length != 3"};
            Preconditions.stateAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 5, arr.length != 3);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@actual: arr's length is 5} doesn't meet the {@prec: arr.length < 5}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int[] arr = new int[]{10, 20, 30, 40};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 10", "arr.length != 4"};
            Preconditions.stateAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 10, arr.length != 4);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: State {@actual: arr's length is 4} doesn't meet the {@prec: arr.length != 4}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void stateAny(String conditions, Boolean... exprs)}
     * @see Preconditions#stateAny(String, Boolean...)
     * */
    @org.junit.Test
    public void stateAny() {
        try{
            int state = 50;
            String conds = "state < 30, state > 90, state == 60";
            Preconditions.stateAny(conds, state < 30, state > 90, state == 60);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: None of these specified state conditions{@prec: state < 30, state > 90, state == 60} is true",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int state = 10;
            String conds = "state < 30, state > 90, state == 60";
            Preconditions.stateAny(conds, state < 30, state > 90, state == 60);
        }catch (IllegalStateException e){
            fail("An IllegalStateException isn't supposed to be thrown");
        }
        try{
            int state = 100;
            String conds = "state < 30, state > 90, state == 60";
            Preconditions.stateAny(conds, state < 30, state > 90, state == 60);
        }catch (IllegalStateException e){
            fail("An IllegalStateException isn't supposed to be thrown");
        }
        try{
            int state = 60;
            String conds = "state < 30, state > 90, state == 60";
            Preconditions.stateAny(conds, state < 30, state > 90, state == 60);
        }catch (IllegalStateException e){
            fail("An IllegalStateException isn't supposed to be thrown");
        }
        
    }
}