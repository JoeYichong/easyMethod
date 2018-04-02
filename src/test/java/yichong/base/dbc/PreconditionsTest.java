package yichong.base.dbc;


import static org.junit.Assert.*;

public class PreconditionsTest {
    /**
     * test private method
     * {@code private static <T> T valueInArray(T[] arr, int index)} in class {@code Preconditions},
     * its codes has been copied into {@code AutoRandomPrecTest} class as a public method for this test.
     * Random values used for testing are automatically generated.
     * */
    @org.junit.Test
    public void testValueInArray(){
        AutoRandomPrecTest.getInstance().testValueInArray(10);
    }

    /**
     * test private method
     * {@code private static <T> boolean checkArr(T[] arr)} in class {@code Preconditions},
     * its codes has been copied into {@code AutoRandomPrecTest} class as a public method for this test.
     * Random values used for testing are automatically generated.
     * */
    @org.junit.Test
    public void testCheckVarargs(){
        AutoRandomPrecTest.getInstance().testCheckVarargs(10);
    }

    /**
     * test method
     * {@code public static void assertNotNull(Object ref)}
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

        AutoRandomPrecTest.getInstance().testAssertNotNull_1(10);
    }

    /**
     * test method
     * {@code public static void assertNotNull(String param, Object ref)}
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
     * test method
     * {@code public static void assertNotNull(Object... refs)}
     * */
    @org.junit.Test
    public void testAssertNotNull_3() {
        // Varargs method test
        // null value passed into the Varargs method
        try{
            Preconditions.assertNotNull((Object[]) null);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("[Warning]: No Arguments or 'null' passed into the `assertXXX` method",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }
        // no argument passed into the Varargs method
        try{
            Preconditions.assertNotNull();
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("[Warning]: No Arguments or 'null' passed into the `assertXXX` method",
                    e.getMessage().replaceAll("[\r|\n]", ""));
        }

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
     * test method
     * {@code public static void assertNotNull(String[] params, Object... refs)}
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
    }

    /**
     * test method
     * {@code }
     * */
    @org.junit.Test
    public void assertTrue_1() {
        try{

        }catch (IllegalArgumentException e){

        }

        try{

        }catch (IllegalArgumentException e){

        }
    }

    /**
     * test method
     * {@code }
     * */
    @org.junit.Test
    public void assertTrue_2() {
        try{

        }catch (IllegalArgumentException e){

        }

        try{

        }catch (IllegalArgumentException e){

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