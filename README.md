# Solvd Laba Test Automation Fall-Winter 2023

Uses:

- IntelliJ IDEA 2023.2.3 (Community Edition)
- openjdk 11.0.21 2023-10-17
- OpenJDK Runtime Environment Homebrew (build 11.0.21+0)
- OpenJDK 64-Bit Server VM Homebrew (build 11.0.21+0, mixed mode)

## Assignments:

1. QuickSort

### 1. Assignment 1: QuickSort

#### Task:

Given sorting algorithm = quick sort

1. "Implement given sorting algorithm for integer numbers"
2. "Implement given sorting algorithm for char letters"

*_Constraints_: Use for, if else, switch or any default java operators, please do not use
Arrays.sort for example

#### Directions for executing completed task:

##### Execution:

`javac` and `java` commands

```shell
 # run from the root folder
 cd /path/to/project-root/src

# compile
javac utils/Sort.java
javac Data.java
javac Main.java

# run
java Main


```

Alternatively:

```shell
# if using bash
cd /path/to/project-root/src
bash scripts/run_quicksort.zsh
```

```shell
# if using zsh
cd /path/to/project-root/src
zsh scripts/run_quicksort.zsh
```

##### Expected results of sorted arrays in ascending and descending order:

```shell
ascending:
[-2, 2, 3, 3, 4, 4, 4, 5, 32, 32, 34, 34, 35, 43, 67, 75, 75, 232, 232, 453, 546, 4342]
[-43, -35, -4, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 23, 23, 23, 23, 32, 32, 32, 32, 34, 34, 34, 34, 34, 34, 34, 34, 35, 35, 35, 43, 43, 43, 232, 232, 232, 232, 232, 232, 232, 232]
[1, 2]
[2, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546]
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 156]
[1]
[a, a, b, c, d, e, e, f, g, h, i, i, j, k, l, m, n, o, o, p, q, r, s, t, u, u, v, w, x, y, y, z]
[a, a, a, a, b, e, e, e, f, g, g, i, i, k, m, m, n, o, o, q, s, s, t, t, u, u, u, v, y, y, y, y, z]
[a, z, z, z, z, z, z, z, z, z, z, z, z, z, z, z, z, z, z]
[a, b]
[a]


descending:
[4342, 546, 453, 232, 232, 75, 75, 67, 43, 35, 34, 34, 32, 32, 5, 4, 4, 4, 3, 3, 2, -2]
[232, 232, 232, 232, 232, 232, 232, 232, 43, 43, 43, 35, 35, 35, 34, 34, 34, 34, 34, 34, 34, 34, 32, 32, 32, 32, 23, 23, 23, 23, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, -4, -35, -43]
[2, 1]
[2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2]
[156, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
[1]
[z, y, y, x, w, v, u, u, t, s, r, q, p, o, o, n, m, l, k, j, i, i, h, g, f, e, e, d, c, b, a, a]
[z, y, y, y, y, v, u, u, u, t, t, s, s, q, o, o, n, m, m, k, i, i, g, g, f, e, e, e, b, a, a, a, a]
[z, z, z, z, z, z, z, z, z, z, z, z, z, z, z, z, z, z, a]
[b, a]
[a]
```

##### Additional details:

Below are the relevant files in the project:

```
solvd-laba
└── src
    ├── Data.java # contains arrays of unsorted data to be sorted
    ├── Main.java # contains loop for executing numbers and letters arrays
    ├── scripts
    │   ├── run_quicksort.ps1 # powershell script, may need to change '/' to '\' for Windows users
    │   └── run_quicksort.sh # Unix-style shell script
    └── utils
        └── Sort.java # class that contains quick(), the quick sort function, and its subordinate functions

```

Data before sorting:

```java
// src/Data.java
public class Data {
    public static Integer[] numbers1 = {
            4, 3, 5, 3, 43, 232, 4, 34, 232, 32, 4, 35, 34, -2, 2,
            453, 546, 75, 75, 67, 4342, 32
    };

    public static Integer[] numbers2 = {
            4, 3, 5, 3, 43, 232, 4, 34, 232, 32, 4, 35, 34, 23, 2,
            4, 3, 5, 3, 43, 232, -4, 34, 232, 32, 4, -35, 34, 23, 2,
            4, 3, 5, 3, 43, 232, 4, 34, 232, 32, 4, 35, 34, 23, 2,
            4, 3, 5, 3, -43, 232, 4, 34, 232, 32, 4, 35, 34, 23, 2
    };

    public static Integer[] numbers3 = {2, 1};

    public static Integer[] numbers4 = {
            2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546, 2546,
            2546, 2546, 2546, 2546, 2546, 2546, 2546, 2
    };

    public static Integer[] numbers5 = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 156
    };

    public static Integer[] numbers6 = {1};

    public static Integer[][] allNumbersArrays = {
            numbers1,
            numbers2,
            numbers3,
            numbers4,
            numbers5,
            numbers6
    };

    public static Character[] letters1 = {
            'k', 'i', 'u', 'q', 'n', 'z', 'v', 'b', 'i', 'f', 'e',
            's', 'g', 'y', 'y', 'a', 'o', 'a', 't', 'u', 'm', 'e',
            'l', 'r', 'c', 'd', 'j', 'w', 'o', 'h', 'p', 'x'
    };

    public static Character[] letters2 = {
            's', 'g', 'y', 'y', 'a', 'o', 'a', 't', 'u', 'm', 'e',
            'k', 'i', 'u', 'q', 'n', 'z', 'v', 'b', 'i', 'f', 'e',
            's', 'g', 'y', 'y', 'a', 'o', 'a', 't', 'u', 'm', 'e',
    };

    public static Character[] letters3 = {
            'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z',
            'a', 'z', 'z', 'z', 'z', 'z', 'z', 'z'
    };

    public static Character[] letters4 = {'b', 'a'};

    public static Character[] letters5 = {'a'};

    public static Character[][] allLettersArrays = {
            letters1,
            letters2,
            letters3,
            letters4,
            letters5
    };
}

```
