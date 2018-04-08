# easyMethod#Preconditions

  Inspired by the concept of 'Design by Contract(DBC)', the methods in <code>Preconditions</code> class are designed primarily for checking preconditions of the calling methods or constructors before
executing the actual operations in them, e.g. as demonstrated below:
<pre>
public void foo(Bar bar, int size){
     Preconditions.argmentNotNull("Bar bar", bar);
     Preconditions.argument(size, "size > 0", size > 0);

     // actual operations of this method
     ...
}
</pre>
