# 7. Comparators #

## Related interfaces ##
* **Comparator** - `int Comparator<T>#compare(T, T)`
* **Comparable** - `int Comparable<T>#compareTo(T)`

## Collection sorting before Java 8 ##
* with util class **Collections** -> methods `Collections#sort`
  * `void sort(List)` - list entities **must implement `Comparable`**
  * `void sort(List, Comparator)` - list entities not need implement `Comparable` because the second argument is `Comparator`

## Collection sorting since Java 8 ##
* exists method `void List#sort(Comparator)`
* Stream API provides the (stateful intermediate) operation `Stream Stream#sorted(Comparator)` 
* in both cases the input `Comparator` is possible to write as lambda expression
  * or better way is use the `Comparator#comparing` - see bellow

### Comparator#comparing ###
* are new static methods since Java 8
* provides great objects comparing support and better usage in Streams
* is possible to write as method reference
* existing methods are:
  * `Comparator#comparing(Function)`
  * `Comparator#comparing(Function, Comparator)`
  * `Comparator#comparing(ToIntFunction)` - `ToLongFunction` or `ToDoubleFunction` can be used instead of `ToIntFunction`
* is possible to write more complex comparison expressions in combination with methods:
  * `thenComparing(Comparator)`
  * `thenComparing(Function)`
  * `thenComparing(Function, Comparator)`
  * `reversed()`
