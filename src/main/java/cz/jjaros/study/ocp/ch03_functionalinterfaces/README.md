# 3. Functional interfaces #
* functional interface is possible to write as lambda expression or method reference
* basic points of lambda expressions are mentioned 
in [OCA, chapter 12 Lambda expressions](../../oca/ch12_lambda)
* JDK provides some functional interface which are generally used internally, 
but are available to be used by user code as well
  * functional interfaces are most times used together with Stream API
  * these are stored in package `java.util.function`
  * the main functional interfaces and its abstract method see table below
  * for three basic functional interfaces exists similar binary functional interfaces (see table below)

## Functional API
### Basic unary functional interfaces ###

| Unary Functional interface | Abstract method signature | Description |
| ------------- | ------------- | ----- |
| `Function<T, R>` | `R apply(T t);` | Unary function from `T` to `R`. |
| `Consumer<T>` | `void accept(T t);` | Unary function from `T` to `void`. |
| `Predicate<T>` | `boolean test(T t);` | Unary function from `T` to `boolean`. |
| `Supplier<R>` | `T get();` | Nilary function to `R`. |
| ------------- | ------------- | ------------- |
| `java.lang.Runnable` | `void run();` |  |
| `java.lang.Callable<V>` | `V call();` |  |


### Binary functional interfaces ###

| Binary Functional interface | Abstract method signature | Description |
| ------------- | ------------- | ----- |
| `BiFunction<T,U, R>` | `R apply(T t, U u);` | Binary function from `T` and `U` to `R`. |
| `BiConsumer<T, U>` | `void accept(T t, U u);` | Binary function from `T` and `U` to `void`. |
| `BiPredicate<T, U>` | `boolean test(T t, U u);` | Binary function from `T` and `U` to `boolean`. |

### Advanced methods ###
* `java.util.function.Function<T, R>`
  * `<V> Function<T, V> andThen(Function<? super R, ? extends V>)` - called after
  * `<V> Function<V, R> compose(Function<? super V, ? extends T>)` - called before
* `java.util.function.Consumer<T>`
  * `Consumer<T> andThen(Consumer<? super T>)`
* `java.util.function.Predicate<T>`
  * `Predicate<T> negate()`
  * `Predicate<T> and(Predicate<? super T>)`
  * `Predicate<T> or(Predicate<? super T>)`
* `java.util.function.Supplier<T>` - only abstract `get()` method


## Lambda expression ##
* is implementation of functional interface
* special type is method reference (method is referenced via operator `::`)
* inside the lambda expression that implements interface provided by JDK is not allowed to throw checked exception
* variables used inside the lambda expression and defined outside must be mark as `final` or effectively final   

### Method reference ###
* special type of lambda expression
* via method reference can be called:
  * instance method with no input argument
  * static method with one input argument
  * instance method called at object `T` that pass `U` as input argument (in case of `Bi*` interfaces)
    * it means e.g. `BiConsumer<T, U>#accept(T t, U u)` is possible to write as `(t, u) -> t.method(u)` or `T::method`  