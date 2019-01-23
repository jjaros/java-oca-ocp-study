# 5. Assertions #
* see [docs.oracle.com/javase/8/docs/technotes/guides/language/assert](https://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html)
* assertions (`assert` commands) are ignored by default
* failed assert (it mean `assert false;`) causes `java.lang.AssertionError`
* `assert condition : "custom error message"` (part of error message is optional)

## Enabling and disabling ##
* command line switches for enabling assertion/system assertions: `-ea`/`-esa` or `-enableassertions`/`-enablesystemassertions`
* command line switches for disabling assertion/system assertions: `-da`/`-dsa` or `-disableassertions`/`-disablesystemassertions`
* parameters of switches:
  * *no argument* = enables/disables in all classes except system classes
  * *packageName...* = enables/disables in named package and its subpackages
  * *...* = enables/disables in unnamed package in current working directory
  * *ClassName* = enables/disables in named class