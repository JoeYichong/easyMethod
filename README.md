# easyMethod

  Inspired by the concept of 'Design by Contract(DBC)', the methods in Preconditions class are designed primarily for checking preconditions of the calling methods or constructors before
executing the actual operations in them, e.g. as demonstrated below:
<pre>
public void foo(Bar bar, int size){
     Preconditions.assertNotNull("Bar bar", bar);
     Preconditions.assertTrue(size, "size > 0", size > 0);

     // actual operations of this method
     ...
 }
</pre>
<p>
