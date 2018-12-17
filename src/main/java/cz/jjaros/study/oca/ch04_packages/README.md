# 4. Packages, imports #
* one `*.java` file can't contains two or more import of class with same name
  * as "workaround" is possible to import first class via package wildcard 
  and second class with import directly for it
* it is possible to import whole package via wildcard 
(see [`Ex04_PackagesImports.java`](Ex04_PackagesImports.java) for allowed variants)
  * usage of wildcard `*` is not possible to combine - is allowed to have 
  max one `*` and it must be at the end of import statement (e.g. `import java.util.*;`)