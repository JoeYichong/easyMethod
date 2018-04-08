package yichong.base.dbc;

import java.util.Random;

import static org.junit.Assert.*;

public class PrecTestAssitant {
    public static final String Meta_Msg =
        "\r\n[Warning]: 0 Argument or 'null' passed into the `Preconditions` method";
    public static final String Msg_Template =
            "\r\n[Problem]: {@?: %s} doesn't meet the {@prec: %s}";
    public static final String NotNull_Template =
            "\r\n[Problem]: {@param: %s} is NULL";

    /**
     * a private method in {@code Preconditions} used by 'argument' methods to generate exception messages.
     * @see Preconditions#errorMsg(String, Object, String)
     * */
    public static String errorMsg(String template, Object value, String cond) {
        String templ = (template == null) ? Msg_Template : template;
        String val = (value == null) ? "[-]" : String.valueOf(value);
        String prec = (cond == null || "".equals(cond)) ? "[-]" : cond;

        return String.format(templ, val, prec);
    }
    /**
     * a private method in {@code Preconditions} used by 'argument' methods to generate exception messages.
     * @see Preconditions#errorMsg(String, String, Object, String)
     * */
    public static String errorMsg(String msg_templ, String desc_templ, Object value, String cond) {
        String templ = (msg_templ == null) ? Msg_Template : msg_templ;
        String val = (value == null) ? "[-]" : String.valueOf(value);
        String desc = (desc_templ == null || "".equals(desc_templ)) ? val : String.format(desc_templ, val);
        String prec = (cond == null || "".equals(cond)) ? "[-]" : cond;

        return String.format(templ, desc, prec);
    }
    /**
     * a private method in {@code Preconditions} used by 'argumentNotNull' methods to generate exception messages.
     * @see Preconditions#nullMsg(String, String)
     * */
    public static String nullMsg(String template, String param) {
        String templ = (template == null) ? NotNull_Template : template;
        String para_n = (param == null || "".equals(param)) ? "[-]" : param;

        return String.format(templ, para_n);
    }
    /**
     * a private method in {@code Preconditions} used by Varargs methods to
     * check that there is at least one argument passed in.
     * @see Preconditions#checkVarargs(Object[])
     * */
    public static <T> void checkVarargs(T[] arr) {
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException(Meta_Msg); // warning: empty method calling
    }
    /**
     * a private method used in {@code Preconditions} to fetch a value in a specified array.
     * @see Preconditions#valueInArray(Object[], int)
     * */
    public static <T> T valueInArray(T[] arr, int index) {
        if(arr != null && arr.length > index) {
            return arr[index];
        }
        return null;
    }

    private static PrecTestAssitant instance = null;
    private Random rand = null;
    /**
     * a private constructor to prevent instantiation using 'new' keyword
     * */
    private PrecTestAssitant(){
        rand = new Random();
    }

    /**
     * get an instance of {@code PrecTestAssitant} class
     * using singleton pattern and lazy instantiation strategy
     * */
    public static PrecTestAssitant getInstance(){
        if (instance == null){
            instance = new PrecTestAssitant();
        }
        return instance;
    }

    /**
     * @
     * */
    public String[] strs = {"Object o", "String str", "Boolean bo", "Byte by",
            "Short sh", "Integer i", "Long l", "Float f", "Double d"};
    public Object[] vals = {new Object(), "a String", true, (byte) 8,
            (short) 1, 12, 100L, 12.09f, 12.008d};
    public Object[][] arrs = {strs, vals, null, new String[]{}, null, new Object[]{}};
    public String[] arrs_desc = {"strs", "vals", "null", "new String[]{}", "null", "new Object[]{}"};

    /**
     * print a line of index & value pairs in an array
     * @param num line number.
     * @param index array index
     * @param val value in an array whose position is indicated by the {@code index} parameter
     * */
    public void printIndexAndValue(int num, int index, Object val){
        System.out.println((num + 1) + ". Index = " + index + ", Value = " + String.valueOf(val));
    }

    /**
     * @see PreconditionsTest#valueInArray()
     * @param times used to indicate how many times random value test will run.
     * */
    public void testValueInArray(int times){
        System.out.println(" - testValueInArray() start: ");
        int index = 0;
        Object val = null;
        for(int i = 0; i < times; i++){
            try{
                val = PrecTestAssitant.valueInArray(vals, (index = rand.nextInt(18)));
                printIndexAndValue(i, index, val);
                if(index > 8 && val != null)
                    fail("Value should be null if index out of boundary");
            }catch (IndexOutOfBoundsException e){
                fail("IndexOutOfBoundsException is not supposed to be thrown");
            }
        }
        System.out.println(" - testValueInArray() end.");
    }

    /**
     * @see PreconditionsTest#checkVarargs()
     * @param times used to indicate how many times random value test will run.
     * */
    public void testCheckVarargs(int times){
        System.out.println(" - testValueInArray() start: ");
        int index = -1;
        Object[] arr;
        for(int i = 0; i < times; i++){
            try{
                arr = arrs[(index = rand.nextInt(5))];
                PrecTestAssitant.checkVarargs(arr);
                printIndexAndValue(i, index, arrs_desc[index]);
                if(arr == null || arr.length == 0)
                    fail("fail to throw an IllegalArgumentException");
            }catch (IllegalArgumentException e){
                printIndexAndValue(i, index, arrs_desc[index]);
                assertEquals("[Warning]: 0 Argument or 'null' passed into the `Preconditions` method",
                        e.getMessage().replaceAll("[\r|\n]", ""));
                System.out.println((i + 1) + ". IllegalArgumentException caught, assertEquals(..) called");
            }
            index = -1;
        }
        System.out.println(" - testValueInArray() end.");
    }



    /**
     * @see PreconditionsTest#argNotNull_1()
     * @param times used to indicate how many times random value test will run.
     * */
    public void testAssertNotNull_1(int times){
        Object obj = null;
        int index = 0;
        System.out.println(" - PrecTestAssitant testAssertNotNull_1 start: ");
        for(int i = 0; i < times; i++){
            //obj = ((index = rand.nextInt(18)) < 9) ? vals[index] : null;
            obj = PrecTestAssitant.valueInArray(vals, index = rand.nextInt(18));
            System.out.println((i + 1) + ". Index = " + index + " , value = " + String.valueOf(obj));
            try{
                Preconditions.argumentNotNull(obj);
                if (obj == null)
                    fail("obj == null, fail to throw an IllegalArgumentException");
            }catch (IllegalArgumentException e){
                if (obj == null){
                    System.out.println("IllegalArgumentException caught, assertEquals(..) called");
                    assertEquals("[Problem]: Required Argument is NULL",
                            e.getMessage().replaceAll("[\r|\n]", ""));
                }
                else fail("obj != null, IllegalArgumentException is not supposed to be thrown");
            }
        }
        System.out.println(" - PrecTestAssitant testAssertNotNull_1 end.");
    }


}
