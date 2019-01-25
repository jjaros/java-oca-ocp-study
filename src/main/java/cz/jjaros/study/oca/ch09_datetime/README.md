# 9. DateTime API #
* object of `java.util.Date` has attribute that holds count of seconds from _01-01-1970 01:00:00.000_
* Java 8 comes with new API (should be in `java.time.*` package) inspired by Joda-Time
* objects from new date/time API have attributes as `year`, `month`, `day`, ... with explicit value
* objects of `LocalDateTime*` **NOT contains zoned information** - for this purpose should be used `ZonedDateTime*` classes
* new API provides more new methods, e.g.: `format(...)`, `parse(...)`, `now()`, ...

## Conversion ##
* `java.sql.Date#toLocalDate`, resp. `java.sql.Time#toLocalTime` or `java.sql.Timestamp#toLocalDateTime`
* from `java.util.Date` is possible to get object of `java.time.Instant` and after then use `LocalDateTime#ofInstant()` (**Beware:** it provides only `LocalDateTime` class)

## Others ##

### Duration ###
* class `java.time.Duration`
* is time-based
* units granularity is _nanoseconds .. days_
* `#between()` returns **HOURS** by default
* `#equal()` compares only attributes `nanos` and `seconds`

### Period ###
* class `java.time.Period`
* is date-based
* units granularity is _days .. years_
* `#between()` returns **YEARS** by default
* `#equal()` compares only attributes `yaers`, `months` and `days`

### ChronoUnit ###
* class `java.time.temporal.ChronoUnit`
* units granularity is _nanoseconds .. forever_
* it provides easy conversion to `Duration` which is internally used by `ChronoUnit`
* see `ChronoUnit#getDuration`