package yichong.base.dbc;

public class OtherPrecTests {
    public int getLength(String target){
        Require.argumentNotNull("String target", target);

        return target.length();
    }

    private int month = 1;
    public void setMonth(int month){
        Require.argumentAll(month, new String[]{"month > 0", "month < 13"}, month > 0, month < 13);

        this.month = month;
    }

    public float divide(float left, float right){
        Require.argument(right, "right != 0", right != 0);

        return left / right;
    }

    public void process(byte[] bytes){
        Require.argumentNotNull("byte[] bytes", bytes);
        Require.argumentAny(bytes.length, "%s bytes input", "2 bytes or 4 bytes only",
                bytes.length == 2, bytes.length == 4);
        String result = new String(bytes);
        System.out.println(result);
    }


    @org.junit.Test
    public void test(){
        //new OtherPrecTests().getLength(null);
        //new OtherPrecTests().setMonth(0);
        //new OtherPrecTests().divide(100, 0);
        new OtherPrecTests().process(new byte[3]);

    }
}
