package yichong.base.dbc;

import static org.junit.Assert.*;

public class RequireTest {
    /**
     * Test {@code private static <T> T valueInArray(T[] arr, int index)} in class {@code Require}.
     * Random values used for testing are automatically generated.
     * @see Require#valueInArray(Object[], int)
     * */
    @org.junit.Test
    public void valueInArray(){
        RequireTestAssitant.getInstance().testValueInArray_random(10);
    }

    /**
     * Test {@code public static <T> void argumentNotNullAndNotEmpty(String sig, T[] arr)}
     * @see Require#argumentNotNullAndNotEmpty(String, Object[])
     * */
    @org.junit.Test
    public void argumentNotNullAndNotEmpty_1(){
        // a null value passed into the method as an array
        try{
            Require.argumentNotNullAndNotEmpty("Array arr", (Object[]) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object{@sig: Array arr} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // an empty array passed into the method
        try{
            Require.argumentNotNullAndNotEmpty("Array arr", new Object[0]);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Array{@sig: Array arr} is Empty",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // null. null
        try{
            Require.argumentNotNullAndNotEmpty(null, (Object[]) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // "", new Object[0]
        try{
            Require.argumentNotNullAndNotEmpty("", new Object[0]);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Array{@sig: [-]} is Empty",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void argumentNotNullAndNotEmpty(String sig, String str)}
     * @see Require#argumentNotNullAndNotEmpty(String, String)
     * */
    @org.junit.Test
    public void argumentNotNullAndNotEmpty_2(){
        // a null value passed into the method as an string
        try{
            Require.argumentNotNullAndNotEmpty("String str", (String) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object{@sig: String str} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // an empty string passed into the method
        try{
            Require.argumentNotNullAndNotEmpty("String str", "");
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: String{@sig: String str} is Empty",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // null. null
        try{
            Require.argumentNotNullAndNotEmpty(null, (String) null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // "", ""
        try{
            Require.argumentNotNullAndNotEmpty("", "");
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: String{@sig: [-]} is Empty",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void argumentNotNull(Object ref)}
     * @see Require#argumentNotNull(Object)
     * */
    @org.junit.Test
    public void argNotNull_1() {
        // null argument
        try{
            Require.argumentNotNull(null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // non-null argument
        try{
            Require.argumentNotNull("");
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }

        RequireTestAssitant.getInstance().testAssertNotNull_1_random(10);
    }

    /**
     * Test {@code public static void argumentNotNull(String param, Object ref)}
     * @see Require#argumentNotNull(String, Object)
     * */
    @org.junit.Test
    public void argNotNull_2() {
        // null argument
        try{
            Require.argumentNotNull("Object obj", null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object{@sig: Object obj} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // non-null argument
        try{
            Require.argumentNotNull("Object obj", "");
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }

        // null argument, param not available ("" empty string)
        try{
            Require.argumentNotNull("", null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // null argument, param not available (null value)
        try{
            Require.argumentNotNull(null, null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void argumentNotNull(Object... refs)}
     * @see Require#argumentsNotNull(Object...)
     * */
    @org.junit.Test
    public void argNotNull_3() {
        // a batch of objects with a null value in it
        try{
            Require.argumentsNotNull("", "123", null, true);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects with 2 null values in it
        try{
            Require.argumentsNotNull("", "123", null, null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects without null value in it
        try{
            Require.argumentsNotNull("", "123", 100, true);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }

    }

    /**
     * Test {@code public static void argumentNotNull(String[] params, Object... refs)}
     * @see Require#argumentsNotNull(String[], Object...)
     * */
    @org.junit.Test
    public void argNotNull_4() {
        // a batch of objects to be checked, the first one is null
        try{
            Require.argumentsNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    null, "123", new Object(), false);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object{@sig: String s1} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects to be checked, the last one is null
        try{
            Require.argumentsNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", new Object(), null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object{@sig: Boolean b} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects to be checked, the 3rd one is null
        try{
            Require.argumentsNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", null, true);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object{@sig: Object o} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects without null value
        try{
            Require.argumentsNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", 100, true);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }
        // a batch of objects to be checked, the 3rd one is null and its corresponding sig is also null
        try{
            Require.argumentsNotNull(new String[]{"String s1", "String s2", null, "Boolean b"},
                    "", "123", null, true);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Object{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void argument(Object val, String prec_str, boolean prec_expr)}
     * @see Require#argument(Object, String, boolean)
     * */
    @org.junit.Test
    public void argument_1() {
        try{
            int arg = 0;
            Require.argument(arg, "arg > 0", arg > 0);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: {@val: 0} doesn't meet the {@prec: arg > 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int arg = 1;
            Require.argument(arg, "arg > 0", arg > 0);
        }catch (IllegalArgumentException e){
            fail("An IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            int arg = 0;
            Require.argument(null, null, arg > 0);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e) {
            assertEquals("[Problem]: {@val: [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void argument(Object val, String desc_templ, String prec_str, boolean prec_expr)}
     * @see Require#argument(Object, String, String, boolean)
     * */
    @org.junit.Test
    public void argument_2() {
        try{
            Object[] objs = new Object[10];
            Require.argument(objs.length, "The length of object array argument is %s","objs.length > 10", objs.length > 10);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: {@actual: The length of object array argument is 10} doesn't meet the {@prec: objs.length > 10}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[11];
            Require.argument(objs.length, "The length of object array argument is %s","objs.length > 10", objs.length > 10);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            Object[] objs = new Object[10];
            Require.argument(null, "The length of object array argument is %s",null, objs.length > 10);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e) {
            assertEquals("[Problem]: {@actual: The length of object array argument is [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[10];
            Require.argument(null, null,null, objs.length > 10);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e) {
            assertEquals("[Problem]: {@actual: [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[10];
            Require.argument(10, null,null, objs.length > 10);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e) {
            assertEquals("[Problem]: {@actual: 10} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void argumentAll(Object val, String[] prec_strs, Boolean... prec_exprs)}
     * @see Require#argumentAll(Object, String[], Boolean...)
     * */
    @org.junit.Test
    public void argumentAll_1() {
        try{
            int val = 10;
            String[] precs = new String[]{"val > 0", "val != 50", "val < 100"};
            Require.argumentAll(val, precs, val > 0, val != 50, val < 100);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            int val = 10;
            String[] precs = new String[]{"val > 10", "val != 50", "val < 100"};
            Require.argumentAll(val, precs, val > 10, val != 50, val < 100);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: {@val: 10} doesn't meet the {@prec: val > 10}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int val = 50;
            String[] precs = new String[]{"val > 0", "val != 50", "val < 100"};
            Require.argumentAll(val, precs, val > 0, val != 50, val < 100);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: {@val: 50} doesn't meet the {@prec: val != 50}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int val = 100;
            String[] precs = new String[]{"val > 0", "val != 50", "val < 100"};
            Require.argumentAll(val, precs, val > 0, val != 50, val < 100);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: {@val: 100} doesn't meet the {@prec: val < 100}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test
     * {@code public static void argumentAll(Object val, String desc_templ, String[] prec_strs, Boolean... prec_exprs)}
     * @see Require#argumentAll(Object, String, String[], Boolean...)
     * */
    @org.junit.Test
    public void argumentAll_2() {
        try{
            int[] arr = new int[]{10, 20, 30, 40};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 10", "arr.length != 3"};
            Require.argumentAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 10, arr.length != 3);
        }catch (IllegalArgumentException e){
            fail("IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            int[] arr = new int[]{};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 10", "arr.length != 3"};
            Require.argumentAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 10, arr.length != 3);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: {@actual: arr's length is 0} doesn't meet the {@prec: arr.length > 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int[] arr = new int[]{10, 20, 30, 40, 50};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 5", "arr.length != 3"};
            Require.argumentAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 5, arr.length != 3);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: {@actual: arr's length is 5} doesn't meet the {@prec: arr.length < 5}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int[] arr = new int[]{10, 20, 30, 40};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 10", "arr.length != 4"};
            Require.argumentAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 10, arr.length != 4);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: {@actual: arr's length is 4} doesn't meet the {@prec: arr.length != 4}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }


    /**
     * Test {@code public static void argumentAny(Object val, String conditions, Boolean... exprs)}
     * @see Require#argumentAny(Object, String, Boolean...)
     * */
    @org.junit.Test
    public void argumentAny_1() {
        try{
            int arg = 50;
            String conds = "arg < 30, arg > 90, arg == 60";
            Require.argumentAny(arg, conds, arg < 30, arg > 90, arg == 60);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: {@val: 50} doesn't meet any of these specified conditions{@prec: arg < 30, arg > 90, arg == 60}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int arg = 10;
            String conds = "arg < 30, arg > 90, arg == 60";
            Require.argumentAny(arg, conds, arg < 30, arg > 90, arg == 60);
        }catch (IllegalArgumentException e){
            fail("An IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            int arg = 100;
            String conds = "arg < 30, arg > 90, arg == 60";
            Require.argumentAny(arg, conds, arg < 30, arg > 90, arg == 60);
        }catch (IllegalArgumentException e){
            fail("An IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            int arg = 60;
            String conds = "arg < 30, arg > 90, arg == 60";
            Require.argumentAny(arg, conds, arg < 30, arg > 90, arg == 60);
        }catch (IllegalArgumentException e){
            fail("An IllegalArgumentException isn't supposed to be thrown");
        }

    }

    /**
     * Test {@code public static void argumentAny(Object val, String desc_templ, String conditions, Boolean... exprs)}
     * @see Require#argumentAny(Object, String, String, Boolean...)
     * */
    @org.junit.Test
    public void argumentAny_2() {
        try{
            int[] arg = new int[]{10, 20, 30, 40, 50};
            String desc_templ = "arg's length is %s";
            String conds = "arg.length == 2, arg.length == 4, arg.length == 6";
            Require.argumentAny(arg.length, desc_templ, conds, arg.length == 2, arg.length == 4, arg.length == 6);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: {@actual: arg's length is 5} doesn't meet any of these specified conditions{@prec: arg.length == 2, arg.length == 4, arg.length == 6}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int[] arg = new int[]{10, 20};
            String desc_templ = "arg's length is %s";
            String conds = "arg.length == 2, arg.length == 4, arg.length == 6";
            Require.argumentAny(arg.length, desc_templ, conds, arg.length == 2, arg.length == 4, arg.length == 6);
        }catch (IllegalArgumentException e){
            fail("An IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            int[] arg = new int[]{10, 20, 30, 40};
            String desc_templ = "arg's length is %s";
            String conds = "arg.length == 2, arg.length == 4, arg.length == 6";
            Require.argumentAny(arg.length, desc_templ, conds, arg.length == 2, arg.length == 4, arg.length == 6);
        }catch (IllegalArgumentException e){
            fail("An IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            int[] arg = new int[]{10, 20, 30, 40, 50, 60};
            String desc_templ = "arg's length is %s";
            String conds = "arg.length == 2, arg.length == 4, arg.length == 6";
            Require.argumentAny(arg.length, desc_templ, conds, arg.length == 2, arg.length == 4, arg.length == 6);
        }catch (IllegalArgumentException e){
            fail("An IllegalArgumentException isn't supposed to be thrown");
        }

    }


        /**
         * Test {@code public static void stateNotNull(Object ref)}
         * @see Require#stateNotNull(Object)
         * */
    @org.junit.Test
    public void stateNotNull_1() {
        // null argument
        try{
            Require.stateNotNull(null);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required Object is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // non-null argument
        try{
            Require.stateNotNull("");
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }

    }

    /**
     * Test {@code public static void stateNotNull(Object ref, String state_name)}
     * @see Require#stateNotNull(String, Object)
     * */
    @org.junit.Test
    public void stateNotNull_2() {
        // null argument
        try{
            Require.stateNotNull("Object obj", null);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required Object{@sig: Object obj} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // non-null argument
        try{
            Require.stateNotNull("Object obj", "");
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }

        // null argument, param not available ("" empty string)
        try{
            Require.stateNotNull("", null);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required Object{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // null argument, param not available (null value)
        try{
            Require.stateNotNull(null, null);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required Object{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void stateNotNull(Object... refs)}
     * @see Require#statesNotNull(Object...)
     * */
    @org.junit.Test
    public void statesNotNull_1() {
        // a batch of objects with a null value in it
        try{
            Require.statesNotNull("", "123", null, true);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required Object is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects with 2 null values in it
        try{
            Require.statesNotNull("", "123", null, null);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required Object is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects without null value in it
        try{
            Require.statesNotNull("", "123", 100, true);
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }

    }

    /**
     * Test {@code public static void stateNotNull(String[] state_names, Object... refs)}
     * @see Require#statesNotNull(String[], Object...)
     * */
    @org.junit.Test
    public void statesNotNull_2() {
        // a batch of objects to be checked, the first one is null
        try{
            Require.statesNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    null, "123", new Object(), false);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required Object{@sig: String s1} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects to be checked, the last one is null
        try{
            Require.statesNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", new Object(), null);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required Object{@sig: Boolean b} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects to be checked, the 3rd one is null
        try{
            Require.statesNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", null, true);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required Object{@sig: Object o} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects without null value
        try{
            Require.statesNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", 100, true);
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }
        // a batch of objects to be checked, the 3rd one is null and its corresponding sig is also null
        try{
            Require.statesNotNull(new String[]{"String s1", "String s2", null, "Boolean b"},
                    "", "123", null, true);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: Required Object{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void state(Object val, String prec_str, boolean prec_expr)}
     * @see Require#state(Object, String, boolean)
     * */
    @org.junit.Test
    public void state_1() {
        try{
            int arg = 0;
            Require.state(arg, "arg > 0", arg > 0);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: {@val: 0} doesn't meet the {@prec: arg > 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int arg = 1;
            Require.state(arg, "arg > 0", arg > 0);
        }catch (IllegalStateException e){
            fail("An IllegalStateException isn't supposed to be thrown");
        }
        try{
            int arg = 0;
            Require.state(null, null, arg > 0);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e) {
            assertEquals("[Problem]: {@val: [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void state(Object val, String desc_templ, String prec_str, boolean prec_expr)}
     * @see Require#state(Object, String, String, boolean)
     * */
    @org.junit.Test
    public void state_2() {
        try{
            Object[] objs = new Object[10];
            Require.state(objs.length, "The length of object array State is %s","objs.length > 10", objs.length > 10);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: {@actual: The length of object array State is 10} doesn't meet the {@prec: objs.length > 10}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[11];
            Require.state(objs.length, "The length of object array State is %s","objs.length > 10", objs.length > 10);
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }
        try{
            Object[] objs = new Object[10];
            Require.state(null, "The length of object array State is %s",null, objs.length > 10);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e) {
            assertEquals("[Problem]: {@actual: The length of object array State is [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[10];
            Require.state(null, null,null, objs.length > 10);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e) {
            assertEquals("[Problem]: {@actual: [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[10];
            Require.state(10, null,null, objs.length > 10);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e) {
            assertEquals("[Problem]: {@actual: 10} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void stateAll(Object[] vals, String[] prec_strs, Boolean... prec_exprs)}
     * @see Require#stateAll(Object, String[], Boolean...)
     * */
    @org.junit.Test
    public void statesAll_1() {
        try{
            int val = 10;
            String[] precs = new String[]{"val > 0", "val != 50", "val < 100"};
            Require.stateAll(val, precs, val > 0, val != 50, val < 100);
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }
        try{
            int val = 10;
            String[] precs = new String[]{"val > 10", "val != 50", "val < 100"};
            Require.stateAll(val, precs, val > 10, val != 50, val < 100);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: {@val: 10} doesn't meet the {@prec: val > 10}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int val = 50;
            String[] precs = new String[]{"val > 0", "val != 50", "val < 100"};
            Require.stateAll(val, precs, val > 0, val != 50, val < 100);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: {@val: 50} doesn't meet the {@prec: val != 50}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int val = 100;
            String[] precs = new String[]{"val > 0", "val != 50", "val < 100"};
            Require.stateAll(val, precs, val > 0, val != 50, val < 100);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: {@val: 100} doesn't meet the {@prec: val < 100}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        
    }

    /**
     * Test {@code public static void stateAll(Object[] vals, String[] desc_templs, String[] prec_strs, Boolean... prec_exprs)}
     * @see Require#stateAll(Object, String, String[], Boolean...)
     * */
    @org.junit.Test
    public void statesAll_2() {
        try{
            int[] arr = new int[]{10, 20, 30, 40};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 10", "arr.length != 3"};
            Require.stateAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 10, arr.length != 3);
        }catch (IllegalStateException e){
            fail("IllegalStateException isn't supposed to be thrown");
        }
        try{
            int[] arr = new int[]{};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 10", "arr.length != 3"};
            Require.stateAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 10, arr.length != 3);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: {@actual: arr's length is 0} doesn't meet the {@prec: arr.length > 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int[] arr = new int[]{10, 20, 30, 40, 50};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 5", "arr.length != 3"};
            Require.stateAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 5, arr.length != 3);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: {@actual: arr's length is 5} doesn't meet the {@prec: arr.length < 5}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int[] arr = new int[]{10, 20, 30, 40};
            String desc_templ = "arr's length is %s";
            String[] prec_strs = new String[]{"arr.length > 0", "arr.length < 10", "arr.length != 4"};
            Require.stateAll(arr.length, desc_templ, prec_strs, arr.length > 0, arr.length < 10, arr.length != 4);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: {@actual: arr's length is 4} doesn't meet the {@prec: arr.length != 4}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void stateAny(Object val, String conditions, Boolean... exprs)}
     * @see Require#stateAny(Object, String, Boolean...)
     * */
    @org.junit.Test
    public void stateAny_1() {
        try{
            int state = 50;
            String conds = "state < 30, state > 90, state == 60";
            Require.stateAny(state, conds, state < 30, state > 90, state == 60);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: {@val: 50} doesn't meet any of these specified conditions{@prec: state < 30, state > 90, state == 60}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int state = 10;
            String conds = "state < 30, state > 90, state == 60";
            Require.stateAny(state, conds, state < 30, state > 90, state == 60);
        }catch (IllegalStateException e){
            fail("An IllegalStateException isn't supposed to be thrown");
        }
        try{
            int state = 100;
            String conds = "state < 30, state > 90, state == 60";
            Require.stateAny(state, conds, state < 30, state > 90, state == 60);
        }catch (IllegalStateException e){
            fail("An IllegalStateException isn't supposed to be thrown");
        }
        try{
            int state = 60;
            String conds = "state < 30, state > 90, state == 60";
            Require.stateAny(state, conds, state < 30, state > 90, state == 60);
        }catch (IllegalStateException e){
            fail("An IllegalStateException isn't supposed to be thrown");
        }
        
    }

    /**
     * Test {@code public static void stateAny(Object val, String desc_templ, String conditions, Boolean... exprs)}
     * @see Require#stateAny(Object, String, String, Boolean...)
     * */
    @org.junit.Test
    public void stateAny_2() {
        try{
            int[] state = new int[]{10, 20, 30, 40, 50};
            String desc_templ = "state's length is %s";
            String conds = "state.length == 2, state.length == 4, state.length == 6";
            Require.stateAny(state.length, desc_templ, conds, state.length == 2, state.length == 4, state.length == 6);
            fail("An IllegalStateException is supposed to be thrown");
        }catch (IllegalStateException e){
            assertEquals("[Problem]: {@actual: state's length is 5} doesn't meet any of these specified conditions{@prec: state.length == 2, state.length == 4, state.length == 6}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int[] state = new int[]{10, 20};
            String desc_templ = "state's length is %s";
            String conds = "state.length == 2, state.length == 4, state.length == 6";
            Require.stateAny(state.length, desc_templ, conds, state.length == 2, state.length == 4, state.length == 6);
        }catch (IllegalStateException e){
            fail("An IllegalStateException isn't supposed to be thrown");
        }
        try{
            int[] state = new int[]{10, 20, 30, 40};
            String desc_templ = "state's length is %s";
            String conds = "state.length == 2, state.length == 4, state.length == 6";
            Require.stateAny(state.length, desc_templ, conds, state.length == 2, state.length == 4, state.length == 6);
        }catch (IllegalStateException e){
            fail("An IllegalStateException isn't supposed to be thrown");
        }
        try{
            int[] state = new int[]{10, 20, 30, 40, 50, 60};
            String desc_templ = "state's length is %s";
            String conds = "state.length == 2, state.length == 4, state.length == 6";
            Require.stateAny(state.length, desc_templ, conds, state.length == 2, state.length == 4, state.length == 6);
        }catch (IllegalStateException e){
            fail("An IllegalStateException isn't supposed to be thrown");
        }

    }
}