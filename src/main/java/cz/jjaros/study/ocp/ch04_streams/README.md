# 4. Stream API #
* provides sequential or parallel aggregation functions over source data (array, collection, I/O channel, ...)
* streams have `close()`
  * in most cases this method doesn't have to be called explicit because streams implement `AutoClosable` interface
  * in fact, close the stream is only needed of it's a I/O channel as source
* as well as common `Stream` for any object are provided three specific streams for primitive types:
  * `IntStream`
  * `LongStream`
  * `DoubleStream`

## Stream creation ##
* `Stream#empty()`, `Stream#of()`, `Stream#concat()`
* `Stream#generate()`, `Stream#iterate()`
  * provides infinite streams
  * should be terminated by throwing exception 
  or clever usage e.g. `anyMatch()` operation
  
### Builder ###
* `Stream.Builder<T> add(T t)`
* `void accept(T t)`
* `Stream<T> build()`


## Stream pipeline ##
* set of operations that Stream will do
* can contain **0..n intermediate operations** 
and **exactly one terminal operation**
* source data can be array, collection, I/O channel, ...
* Stream will do only if terminal operation was called
* input argument of operations is always implementation of functional interface

### Terminal operations ###  
* `reduce()`, `min()`, `max()`, `count()`, `forEach()`, `forEachOrdered()`, `collect()`, `toArray()`, `iterator()`, `spliterator()`
### Short-circuiting terminal operations ###
* `findFirst()`, `findAny()`, `allMatch()`, `anyMatch()`, `noneMatch()`
### Intermediate operations ###
* `peek()`, `map()`, `flatMap()`, `filter()`, `parallel()`, `sequential()`, `onClose()`, `unordered()`
### Stateful intermediate operations ###
* `distinct()`, `sorted()`
### Short-circuiting intermediate operations ###
* `limit()`, `skip()` 

**...TBD...**