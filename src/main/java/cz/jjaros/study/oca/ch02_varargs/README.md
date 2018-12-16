# 2. Varargs #
* optional array input of method
* it is possible:
  * not use it or put `null` value - _see **#1** in example_
  * put one or more value ceparated with comma - _see **#2** in example_
  * use array - _see **#3** in example_
* method can have **exactly one varargs input argument and it must be last method argument**

```java
private void methodWithVarargs(String... varargs) {
}

methodWithVarargs();        // #1
methodWithVarargs(null);    // #1

methodWithVarargs("single value");          // #2
methodWithVarargs("value 1", "value 2");    // #2

methodWithVarargs(new String[]{});                      // #3
methodWithVarargs(new String[]{"value"});               // #3
methodWithVarargs("value 1", new String[]{"value 2"});  // #3
```