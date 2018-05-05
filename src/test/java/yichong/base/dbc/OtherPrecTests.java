package yichong.base.dbc;

public class OtherPrecTests {
    public int getLength(String target){
        Require.argumentNotNull(target, "String target");

        return target.length();
    }

    private int month = 1;
    public void setMonth(int month){
        Require.argumentAll(new boolean[]{month > 0, month < 13}, month, new String[]{"month > 0", "month < 13"});

        this.month = month;
    }

    public float divide(float left, float right){
        Require.argument(right != 0, right, "right != 0");

        return left / right;
    }

    public void process(byte[] bytes){
        Require.argumentNotNull(bytes, "byte[] bytes");
        Require.argumentAny(new boolean[]{bytes.length == 2, bytes.length == 4},
                bytes.length, "%s bytes input", "2 bytes or 4 bytes only");
        String result = new String(bytes);
        System.out.println(result);
    }


    @org.junit.Test
    public void test() {
        //new OtherPrecTests().getLength(null);
        //new OtherPrecTests().setMonth(0);
        //new OtherPrecTests().divide(100, 0);
        //new OtherPrecTests().process(new byte[3]);

    }
}
