package yichong.base.dbc;

public class OtherPrecTests {
    public int getLength(String target){
        Preconditions.argumentNotNull("String target", target);

        return target.length();
    }

    private int month = 1;
    public void setMonth(int month){
        Preconditions.argumentAll(month, new String[]{"month > 0", "month < 13"}, month > 0, month < 13);

        this.month = month;
    }
    public float divide(float left, float right){
        Preconditions.argument(right, "right != 0", right != 0);

        return left / right;
    }


    @org.junit.Test
    public void test(){
        new OtherPrecTests().getLength(null);
        //new OtherPrecTests().setMonth(0);
        //new OtherPrecTests().divide(100, 0);
    }
}
