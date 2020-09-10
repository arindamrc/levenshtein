# Levenshtein distance calculator

To run the jar:

`$ java -jar levenshtein.jar`

The above command displays the usage. The usage is also described below:

1. To run the performance tests:
    `java -jar levenshtein.jar -p`

2. To calculate unbounded levenshtein distance:
    `java -jar levenshtein.jar -u <string1> <string2>`

    Where `<string1>` and `<string2>` are placeholders for strings of any length.

3. To calculate bounded levenshtein distance:
    `java -jar levenshtein.jar -b <k> <string1> <string2>`

    Where `<string1>` and `<string2>` are placeholders for strings of any length and `<k>` is the bound (a positive integer).


JUnit functional tests are also included within the source.

## References:
1. [Wikipedia](https://en.wikipedia.org/wiki/Levenshtein_distance)
2. [Codeproject](https://www.codeproject.com/Articles/13525/Fast-memory-efficient-Levenshtein-algorithm-2)
3. [Blog](https://web.archive.org/web/20180612143641/https://bitbucket.org/clearer/iosifovich/)