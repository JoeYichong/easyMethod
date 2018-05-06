<h1>easyMethod#Require</h1>

  Inspired by the concept of 'Design by Contract(DBC)' and coding practice, the methods in <code>Require</code> class are designed primarily for checking the preconditions of calling methods or constructors before their actual operations begin to execute, e.g. as demonstrated below:

<h3>Example 1</h3>
<pre>
public int getLength(String target){
     Require.argumentNotNull(target);
     // Or specify which parameter is examinated if there is more than one parameter.
     // Require.argumentNotNull(target, "String target");
     
     return target.length();
}
new OtherPrecTests().getLength(null);
</pre>
Test output:
<pre>
java.lang.IllegalArgumentException: 
[Problem]: Required Object is NULL

	at yichong.base.dbc.Require.argumentNotNull(Require.java:239)
	at yichong.base.dbc.OtherPrecTests.getLength(OtherPrecTests.java:5)
	at yichong.base.dbc.OtherPrecTests.test(OtherPrecTests.java:25)
</pre>
<h3>Example 2</h3>
<pre>
public float divide(float left, float right){
    Require.argument(right != 0, right, "right != 0");
    return left / right;
}
new OtherPrecTests().divide(100, 0);
</pre>
Test output:
<pre>
java.lang.IllegalArgumentException: 
[Problem]: {@val: 0.0} doesn't meet the {@prec: right != 0}

	at yichong.base.dbc.Require.argument(Require.java:287)
	at yichong.base.dbc.OtherPrecTests.divide(OtherPrecTests.java:11)
	at yichong.base.dbc.OtherPrecTests.test(OtherPrecTests.java:20)
</pre>
<h3>Example 3</h3>
<pre>
public void setMonth(int month){
    Require.argumentAll(G.a(month > 0, month < 13), month, G.a("month > 0", "month < 13"));
    // Or make it faster by separating it.
    // Require.argument(month > 0, month, "month > 0");
    // Require.argument(month < 13, month, "month < 13");
    // Or make it faster by providing less precise exception message.
    // Require.argument(month > 0 && month < 13, month, "0 < month < 13");

    this.month = month;
}
new OtherPrecTests().setMonth(0);
</pre>
Test output:
<pre>
java.lang.IllegalArgumentException: 
[Problem]: {@val: 0} doesn't meet the {@prec: month > 0}

	at yichong.base.dbc.Require.argumentAll(Require.java:319)
	at yichong.base.dbc.OtherPrecTests.setMonth(OtherPrecTests.java:6)
	at yichong.base.dbc.OtherPrecTests.test(OtherPrecTests.java:14)
</pre>
<h3>Example 4</h3>
<pre>
public void process(byte[] bytes){
    Require.argumentNotNull(bytes);
    Require.argument(bytes.length == 2 || bytes.length == 4,
            bytes.length, "%s bytes input", "2 bytes or 4 bytes only");
    String result = new String(bytes);
    System.out.println(result);
}
new OtherPrecTests().process(new byte[3]);
</pre>
Test output:
<pre>
java.lang.IllegalArgumentException: 
[Problem]: {@actual: 3 bytes input} doesn't meet any of these specified conditions{@prec: 2 bytes or 4 bytes}

	at yichong.base.dbc.Require.argumentAny(Require.java:377)
	at yichong.base.dbc.OtherPrecTests.process(OtherPrecTests.java:24)
	at yichong.base.dbc.OtherPrecTests.test(OtherPrecTests.java:36)

</pre>