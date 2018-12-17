# 3. Init blocks #
* static init blocks are processed at time the class is loaded/initialized
* instance init blocks are processed during the instance creation - before constructor is called
* order of processing (in case the class contains more init blocks of each one type) 
depends on order in which are block written (from top to bottom)

## Static init block ##
* **is processed exactly one time** - at the class initialization (= application startup time)
* checked exception should never be thrown - always must be handled with `try-catch`

## Instance init block ##
* **is processed during the each instance creation**
* the constructor is called after all instance init blocks
* possible (checked) exception handling
  * with `try-catch`
  * by adding `throws` to each constructor