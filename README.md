# Helidon Reactive Streams JMH tests

Run:
```shell script
mvn clean install -Pmprs-comparison
```

Expected result:
```shell script
# Run complete. Total time: 00:16:44

Benchmark                                   Mode  Cnt   Score   Error  Units
HelidonRS.dropWhile                        thrpt   20  29.501 ± 1.111  ops/s
HelidonRS.filter                           thrpt   20  31.085 ± 0.644  ops/s
HelidonRS.flatMap                          thrpt   20   0.382 ± 0.007  ops/s
HelidonRS.flatMapIterable                  thrpt   20   2.723 ± 0.079  ops/s
HelidonRS.flatMapLoadOnPassedInPublisher   thrpt   20  28.505 ± 0.308  ops/s
HelidonRS.limit                            thrpt   20  29.724 ± 0.306  ops/s
HelidonRS.map                              thrpt   20  25.854 ± 0.428  ops/s
HelidonRS.peek                             thrpt   20  32.131 ± 0.403  ops/s
HelidonRS.skip                             thrpt   20  30.572 ± 0.178  ops/s
HelidonRS.takeWhile                        thrpt   20  29.404 ± 0.588  ops/s
HelidonRS.toList                           thrpt   20  21.661 ± 0.423  ops/s
SmallRyeRS.dropWhile                       thrpt   20  30.953 ± 0.292  ops/s
SmallRyeRS.filter                          thrpt   20  31.068 ± 0.127  ops/s
SmallRyeRS.flatMap                         thrpt   20   0.575 ± 0.007  ops/s
SmallRyeRS.flatMapIterable                 thrpt   20  15.669 ± 0.836  ops/s
SmallRyeRS.flatMapLoadOnPassedInPublisher  thrpt   20  11.311 ± 0.051  ops/s
SmallRyeRS.limit                           thrpt   20  30.955 ± 0.189  ops/s
SmallRyeRS.map                             thrpt   20  31.066 ± 0.077  ops/s
SmallRyeRS.peek                            thrpt   20  31.084 ± 0.089  ops/s
SmallRyeRS.skip                            thrpt   20  31.106 ± 0.067  ops/s
SmallRyeRS.takeWhile                       thrpt   20  31.086 ± 0.078  ops/s
SmallRyeRS.toList                          thrpt   20  17.254 ± 0.402  ops/s

               SmallRyeRS.flatMapIterable █████████████████████████████████████████████████ 15.669
                HelidonRS.flatMapIterable ████████ 2.723
                     SmallRyeRS.takeWhile █████████████████████████████████████████████████████████████████████████████████████████████████ 31.086
                      HelidonRS.takeWhile ████████████████████████████████████████████████████████████████████████████████████████████ 29.404
                     SmallRyeRS.dropWhile ████████████████████████████████████████████████████████████████████████████████████████████████ 30.953
                      HelidonRS.dropWhile ████████████████████████████████████████████████████████████████████████████████████████████ 29.501
                          SmallRyeRS.peek █████████████████████████████████████████████████████████████████████████████████████████████████ 31.084
                           HelidonRS.peek ████████████████████████████████████████████████████████████████████████████████████████████████████ 32.131
                       SmallRyeRS.flatMap ██ 0.575
                        HelidonRS.flatMap █ 0.382
                           SmallRyeRS.map █████████████████████████████████████████████████████████████████████████████████████████████████ 31.066
                            HelidonRS.map ████████████████████████████████████████████████████████████████████████████████ 25.854
                          SmallRyeRS.skip █████████████████████████████████████████████████████████████████████████████████████████████████ 31.106
                           HelidonRS.skip ███████████████████████████████████████████████████████████████████████████████████████████████ 30.572
SmallRyeRS.flatMapLoadOnPassedInPublisher ███████████████████████████████████ 11.311
 HelidonRS.flatMapLoadOnPassedInPublisher █████████████████████████████████████████████████████████████████████████████████████████ 28.505
                        SmallRyeRS.filter █████████████████████████████████████████████████████████████████████████████████████████████████ 31.068
                         HelidonRS.filter █████████████████████████████████████████████████████████████████████████████████████████████████ 31.085
                         SmallRyeRS.limit ████████████████████████████████████████████████████████████████████████████████████████████████ 30.955
                          HelidonRS.limit █████████████████████████████████████████████████████████████████████████████████████████████ 29.724
                        SmallRyeRS.toList ██████████████████████████████████████████████████████ 17.254
                         HelidonRS.toList ███████████████████████████████████████████████████████████████████ 21.661
```

Run:
```shell script
mvn clean install -Pmulti-comparison
```

Expected result:
```shell script
# Run complete. Total time: 00:15:15

Benchmark                  Mode  Cnt   Score   Error  Units
NewMulti.distinct         thrpt   20   7.311 ± 0.779  ops/s
NewMulti.dropWhile        thrpt   20  54.036 ± 0.436  ops/s
NewMulti.filter           thrpt   20  61.136 ± 0.567  ops/s
NewMulti.flatMap          thrpt   20   2.911 ± 0.072  ops/s
NewMulti.flatMapIterable  thrpt   20   5.629 ± 0.041  ops/s
NewMulti.forEach          thrpt   20  27.840 ± 0.706  ops/s
NewMulti.limit            thrpt   20  61.595 ± 1.009  ops/s
NewMulti.map              thrpt   20  59.549 ± 0.454  ops/s
NewMulti.peek             thrpt   20  59.978 ± 0.538  ops/s
NewMulti.skip             thrpt   20  38.109 ± 0.580  ops/s
NewMulti.takeWhile        thrpt   20  38.531 ± 0.744  ops/s
OldMulti.distinct         thrpt   20   7.394 ± 0.595  ops/s
OldMulti.dropWhile        thrpt   20  53.863 ± 0.317  ops/s
OldMulti.filter           thrpt   20  60.174 ± 0.477  ops/s
OldMulti.flatMap          thrpt   20   2.855 ± 0.020  ops/s
OldMulti.flatMapIterable  thrpt   20   6.159 ± 0.016  ops/s
OldMulti.forEach          thrpt   20  28.286 ± 0.886  ops/s
OldMulti.limit            thrpt   20  59.323 ± 0.414  ops/s
OldMulti.map              thrpt   20  60.380 ± 0.349  ops/s
OldMulti.peek             thrpt   20  59.375 ± 0.286  ops/s
OldMulti.skip             thrpt   20  38.591 ± 0.661  ops/s
OldMulti.takeWhile        thrpt   20  38.033 ± 0.303  ops/s

OldMulti.flatMapIterable ██████████ 6.159
NewMulti.flatMapIterable █████████ 5.629
      OldMulti.takeWhile ██████████████████████████████████████████████████████████████ 38.033
      NewMulti.takeWhile ███████████████████████████████████████████████████████████████ 38.531
      OldMulti.dropWhile ███████████████████████████████████████████████████████████████████████████████████████ 53.863
      NewMulti.dropWhile ████████████████████████████████████████████████████████████████████████████████████████ 54.036
        OldMulti.forEach ██████████████████████████████████████████████ 28.286
        NewMulti.forEach █████████████████████████████████████████████ 27.840
           OldMulti.peek ████████████████████████████████████████████████████████████████████████████████████████████████ 59.375
           NewMulti.peek █████████████████████████████████████████████████████████████████████████████████████████████████ 59.978
        OldMulti.flatMap █████ 2.855
        NewMulti.flatMap █████ 2.911
            OldMulti.map ██████████████████████████████████████████████████████████████████████████████████████████████████ 60.380
            NewMulti.map █████████████████████████████████████████████████████████████████████████████████████████████████ 59.549
           OldMulti.skip ███████████████████████████████████████████████████████████████ 38.591
           NewMulti.skip ██████████████████████████████████████████████████████████████ 38.109
         OldMulti.filter ██████████████████████████████████████████████████████████████████████████████████████████████████ 60.174
         NewMulti.filter ███████████████████████████████████████████████████████████████████████████████████████████████████ 61.136
       OldMulti.distinct ████████████ 7.394
       NewMulti.distinct ████████████ 7.311
          OldMulti.limit ████████████████████████████████████████████████████████████████████████████████████████████████ 59.323
          NewMulti.limit ████████████████████████████████████████████████████████████████████████████████████████████████████ 61.595
```