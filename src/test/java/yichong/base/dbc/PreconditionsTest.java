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
    public void testValueInArray(){
        PrecTestAssitant.getInstance().testValueInArray(10);
    }

    /**
     * Test {@code private static <T> boolean checkVarargs(T[] arr)} in class {@code Preconditions}.
     * Its codes has been copied into {@code PrecTestAssitant} class as a public method for this test.
     * Random values used for testing are automatically generated.
     * @see Preconditions#checkVarargs(Object[])
     * */
    @org.junit.Test
    public void testCheckVarargs(){
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
     * Test {@code public static <T> void assertArrayNotEmpty(String sig, T[] arr)}
     * @see Preconditions#assertArrayNotEmpty(String, Object[])
     * */
    @org.junit.Test
    public void testAssertArrayNotEmpty(){
        // a null value passed into the method as an array
        try{
            Preconditions.assertArrayNotEmpty("Array arr", null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Array {@sig: Array arr} is Empty(or Null)",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // an empty array passed into the method
        try{
            Preconditions.assertArrayNotEmpty("Array arr", new Object[0]);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Array {@sig: Array arr} is Empty(or Null)",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // null. null
        try{
            Preconditions.assertArrayNotEmpty(null, null);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Array {@sig: [-]} is Empty(or Null)",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // "", new Object[0]
        try{
            Preconditions.assertArrayNotEmpty("", new Object[0]);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Array {@sig: [-]} is Empty(or Null)",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void assertNotNull(Object ref)}
     * @see Preconditions#assertNotNull(Object)
     * */
    @org.junit.Test
    public void testAssertNotNull_1() {
        // null argument
        try{
            Preconditions.assertNotNull((Object) null);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // non-null argument
        try{
            Preconditions.assertNotNull("");
        }catch (IllegalArgumentException e){
            fail();
        }

        PrecTestAssitant.getInstance().testAssertNotNull_1(10);
    }

    /**
     * Test {@code public static void assertNotNull(String param, Object ref)}
     * @see Preconditions#assertNotNull(String, Object)
     * */
    @org.junit.Test
    public void testAssertNotNull_2() {
        // null argument
        try{
            Preconditions.assertNotNull("Object obj", null);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: Object obj} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // non-null argument
        try{
            Preconditions.assertNotNull("Object obj", "");
        }catch (IllegalArgumentException e){
            fail();
        }

        // null argument, param not available ("" empty string)
        try{
            Preconditions.assertNotNull("", null);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // null argument, param not available (null value)
        try{
            Preconditions.assertNotNull((String) null, null);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

    }

    /**
     * Test {@code public static void assertNotNull(Object... refs)}
     * @see Preconditions#assertNotNull(Object...)
     * */
    @org.junit.Test
    public void testAssertNotNull_3() {

        // a batch of objects with a null value in it
        try{
            Preconditions.assertNotNull("", "123", null, true);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects with 2 null values in it
        try{
            Preconditions.assertNotNull("", "123", null, null);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects without null value in it
        try{
            Preconditions.assertNotNull("", "123", 100, true);
        }catch (IllegalArgumentException e){
            fail();
        }

    }

    /**
     * Test {@code public static void assertNotNull(String[] params, Object... refs)}
     * @see Preconditions#assertNotNull(String[], Object...)
     * */
    @org.junit.Test
    public void testAssertNotNull_4() {
        // a batch of objects to be checked, the first one is null
        try{
            Preconditions.assertNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    null, "123", new Object(), false);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: String s1} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects to be checked, the last one is null
        try{
            Preconditions.assertNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", new Object(), null);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: Boolean b} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects to be checked, the 3rd one is null
        try{
            Preconditions.assertNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", null, true);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: Object o} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // a batch of objects without null value
        try{
            Preconditions.assertNotNull(new String[]{"String s1", "String s2", "Object o", "Boolean b"},
                    "", "123", 100, true);
        }catch (IllegalArgumentException e){
            fail();
        }
        // a batch of objects to be checked, the 3rd one is null and its corresponding sig is also null
        try{
            Preconditions.assertNotNull(new String[]{"String s1", "String s2", null, "Boolean b"},
                    "", "123", null, true);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Required Argument{@sig: [-]} is NULL",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void assertTrue(Object val, String prec_str, boolean prec_expr)}
     * @see Preconditions#assertTrue(Object, String, boolean)
     * */
    @org.junit.Test
    public void assertTrue_1() {
        try{
            int arg = 0;
            Preconditions.assertTrue(arg, "arg > 0", arg > 0);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@val: 0} doesn't meet the {@prec: arg > 0}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            int arg = 1;
            Preconditions.assertTrue(arg, "arg > 0", arg > 0);
        }catch (IllegalArgumentException e){
            fail("An IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            int arg = 0;
            Preconditions.assertTrue(null, null, arg > 0);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e) {
            assertEquals("[Problem]: Argument {@val: [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * Test {@code public static void assertTrue(Object val, String desc_templ, String prec_str, boolean prec_expr)}
     * @see Preconditions#assertTrue(Object, String, String, boolean)
     * */
    @org.junit.Test
    public void assertTrue_2() {
        try{
            Object[] objs = new Object[10];
            Preconditions.assertTrue(objs.length, "The length of object array argument is %s","objs.length > 10", objs.length > 10);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e){
            assertEquals("[Problem]: Argument {@actual: The length of object array argument is 10} doesn't meet the {@prec: objs.length > 10}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[11];
            Preconditions.assertTrue(objs.length, "The length of object array argument is %s","objs.length > 10", objs.length > 10);
        }catch (IllegalArgumentException e){
            fail("An IllegalArgumentException isn't supposed to be thrown");
        }
        try{
            Object[] objs = new Object[10];
            Preconditions.assertTrue(null, "The length of object array argument is %s",null, objs.length > 10);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e) {
            assertEquals("[Problem]: Argument {@actual: The length of object array argument is [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[10];
            Preconditions.assertTrue(null, null,null, objs.length > 10);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e) {
            assertEquals("[Problem]: Argument {@actual: [-]} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        try{
            Object[] objs = new Object[10];
            Preconditions.assertTrue(10, null,null, objs.length > 10);
            fail("An IllegalArgumentException is supposed to be thrown");
        }catch (IllegalArgumentException e) {
            assertEquals("[Problem]: Argument {@actual: 10} doesn't meet the {@prec: [-]}",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
    }

    /**
     * test method
     * {@code }
     * */
    @org.junit.Test
    public void assertAllTrue() {
        try{

        }catch (IllegalArgumentException e){

        }

    }

    /**
     * test method
     * {@code }
     * */

    @org.junit.Test
    public void assertAllTrue1() {
        try{

        }catch (IllegalArgumentException e){

        }

    }

    /**
     * test method
     * {@code }
     * */

    @org.junit.Test
    public void assertStateNotNull() {
        try{

        }catch (IllegalStateException e){

        }

    }

    /**
     * test method
     * {@code }
     * */

    @org.junit.Test
    public void assertStateNotNull1() {
        try{

        }catch (IllegalStateException e){

        }

    }

    /**
     * test method
     * {@code }
     * */

    @org.junit.Test
    public void assertStateNotNull2() {
        try{

        }catch (IllegalStateException e){

        }

    }

    /**
     * test method
     * {@code }
     * */

    @org.junit.Test
    public void assertStateNotNull3() {
        try{

        }catch (IllegalStateException e){

        }

    }

    /**
     * test method
     * {@code }
     * */

    @org.junit.Test
    public void assertStateTrue() {
        try{

        }catch (IllegalStateException e){

        }

    }

    /**
     * test method
     * {@code }
     * */

    @org.junit.Test
    public void assertStateTrue1() {
        try{

        }catch (IllegalStateException e){

        }

    }

    /**
     * test method
     * {@code }
     * */

    @org.junit.Test
    public void assertStateAllTrue() {
        try{

        }catch (IllegalStateException e){

        }

    }

    /**
     * test method
     * {@code }
     * */

    @org.junit.Test
    public void assertStateAllTrue1() {
        try{

        }catch (IllegalStateException e){

        }

    }
}