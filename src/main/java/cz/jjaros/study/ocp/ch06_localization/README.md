# 6. Localization #

## Locale ##
* class `java.util.Locale`
* `Locale#getDefault` returns value (order by highest priority) that is:
  * set directly in application via `Locale#setDefault`
  * set at the startup time via command line parameters (or JAVA_OPTS)
    * `-Duser.language` 
    * `-Duser.country` 
    * `-Duser.variant`
  * initialized to JVM (from host system)

## ResourceBundle ##
* class `java.util.ResourceBundle`
* provides easily way to write localized code
* access to non-existing bundle or message key causes `MissingResourceException`