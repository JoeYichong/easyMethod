<h1>easyMethod#Preconditions</h1>

  Inspired by the concept of 'Design by Contract(DBC)' and coding practice, the methods in <code>Preconditions</code> class are designed primarily for checking preconditions of the calling methods or constructors before their actual operations begin to execute, e.g. as demonstrated below:

<h3>Example 1</h3>
<pre>
public int getLength(String target){
     Preconditions.argumentNotNull("String target", target);
     return target.length();
}
new OtherPrecTests().getLength(null);
</pre>
Test output:
<pre>
java.lang.IllegalArgumentException: 
[Problem]: Required Argument{@sig: String target} is NULL

	at yichong.base.dbc.Preconditions.argumentNotNull(Preconditions.java:239)
	at yichong.base.dbc.OtherPrecTests.getLength(OtherPrecTests.java:5)
	at yichong.base.dbc.OtherPrecTests.test(OtherPrecTests.java:25)
</pre>
<h3>Example 2</h3>
<pre>
public float divide(float left, float right){
    Preconditions.argument(right, "right != 0", right != 0);
    return left / right;
}
new OtherPrecTests().divide(100, 0);
</pre>
Test output:
<pre>
java.lang.IllegalArgumentException: 
[Problem]: Argument{@val: 0.0} doesn't meet the {@prec: right != 0}

	at yichong.base.dbc.Preconditions.argument(Preconditions.java:287)
	at yichong.base.dbc.OtherPrecTests.divide(OtherPrecTests.java:11)
	at yichong.base.dbc.OtherPrecTests.test(OtherPrecTests.java:20)
</pre>
<h3>Example 3</h3>
<pre>
public void setMonth(int month){
    Preconditions.argumentAll(month, new String[]{"month > 0", "month < 13"}, month > 0, month < 13);
    this.month = month;
}
new OtherPrecTests().setMonth(0);
</pre>
Test output:
<pre>
java.lang.IllegalArgumentException: 
[Problem]: Argument{@val: 0} doesn't meet the {@prec: month > 0}

	at yichong.base.dbc.Preconditions.argumentAll(Preconditions.java:319)
	at yichong.base.dbc.OtherPrecTests.setMonth(OtherPrecTests.java:6)
	at yichong.base.dbc.OtherPrecTests.test(OtherPrecTests.java:14)
</pre>
<h3>Example 4</h3>
<pre>
public void process(byte[] bytes){
    Preconditions.argumentNotNull("byte[] bytes", bytes);
    Preconditions.argumentAny(bytes.length, "%s bytes input", "2 bytes or 4 bytes only",
            bytes.length == 2, bytes.length == 4);
    String result = new String(bytes);
    System.out.println(result);
}
new OtherPrecTests().process(new byte[3]);
</pre>
Test output:
<pre>
java.lang.IllegalArgumentException: 
[Problem]: Argument{@actual: 3 bytes input} doesn't meet any of these specified conditions{@prec: 2 bytes or 4 bytes only}

	at yichong.base.dbc.Preconditions.argumentAny(Preconditions.java:377)
	at yichong.base.dbc.OtherPrecTests.process(OtherPrecTests.java:24)
	at yichong.base.dbc.OtherPrecTests.test(OtherPrecTests.java:36)

</pre>