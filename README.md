# Helidon Reactive Streams JMH tests

Run:
```shell script
mvn clean install -Pmprs-comparison
```

Expected result:
```shell script
# Run complete. Total time: 00:18:52

Benchmark                                   Mode  Cnt   Score   Error  Units
HelidonRS.concat                           thrpt   20  12.867 ± 0.203  ops/s
HelidonRS.dropWhile                        thrpt   20  24.931 ± 0.365  ops/s
HelidonRS.filter                           thrpt   20  25.241 ± 0.588  ops/s
HelidonRS.flatMap                          thrpt   20   0.284 ± 0.004  ops/s
HelidonRS.flatMapIterable                  thrpt   20   4.183 ± 0.144  ops/s
HelidonRS.flatMapLoadOnPassedInPublisher   thrpt   20  22.574 ± 0.463  ops/s
HelidonRS.limit                            thrpt   20  23.440 ± 0.602  ops/s
HelidonRS.map                              thrpt   20  20.834 ± 0.305  ops/s
HelidonRS.peek                             thrpt   20  25.059 ± 0.137  ops/s
HelidonRS.skip                             thrpt   20  24.493 ± 0.478  ops/s
HelidonRS.takeWhile                        thrpt   20  23.649 ± 0.670  ops/s
HelidonRS.toList                           thrpt   20  23.106 ± 0.418  ops/s
SmallRyeRS.concat                          thrpt   20  12.238 ± 0.100  ops/s
SmallRyeRS.dropWhile                       thrpt   20  26.959 ± 0.223  ops/s
SmallRyeRS.filter                          thrpt   20  25.586 ± 0.389  ops/s
SmallRyeRS.flatMap                         thrpt   20   0.545 ± 0.012  ops/s
SmallRyeRS.flatMapIterable                 thrpt   20  14.211 ± 0.380  ops/s
SmallRyeRS.flatMapLoadOnPassedInPublisher  thrpt   20  11.174 ± 0.067  ops/s
SmallRyeRS.limit                           thrpt   20  26.190 ± 0.527  ops/s
SmallRyeRS.map                             thrpt   20  24.712 ± 0.444  ops/s
SmallRyeRS.peek                            thrpt   20  24.192 ± 0.293  ops/s
SmallRyeRS.skip                            thrpt   20  24.584 ± 0.618  ops/s
SmallRyeRS.takeWhile                       thrpt   20  25.112 ± 0.339  ops/s
SmallRyeRS.toList                          thrpt   20  16.769 ± 0.460  ops/s

               SmallRyeRS.flatMapIterable █████████████████████████████████████████████████████ 14.211
                HelidonRS.flatMapIterable ████████████████ 4.183
                     SmallRyeRS.takeWhile █████████████████████████████████████████████████████████████████████████████████████████████ 25.112
                      HelidonRS.takeWhile ████████████████████████████████████████████████████████████████████████████████████████ 23.649
                     SmallRyeRS.dropWhile ████████████████████████████████████████████████████████████████████████████████████████████████████ 26.959
                      HelidonRS.dropWhile ████████████████████████████████████████████████████████████████████████████████████████████ 24.931
                          SmallRyeRS.peek ██████████████████████████████████████████████████████████████████████████████████████████ 24.192
                           HelidonRS.peek █████████████████████████████████████████████████████████████████████████████████████████████ 25.059
                       SmallRyeRS.flatMap ██ 0.545
                        HelidonRS.flatMap █ 0.284
                           SmallRyeRS.map ████████████████████████████████████████████████████████████████████████████████████████████ 24.712
                            HelidonRS.map █████████████████████████████████████████████████████████████████████████████ 20.834
                          SmallRyeRS.skip ███████████████████████████████████████████████████████████████████████████████████████████ 24.584
                           HelidonRS.skip ███████████████████████████████████████████████████████████████████████████████████████████ 24.493
SmallRyeRS.flatMapLoadOnPassedInPublisher █████████████████████████████████████████ 11.174
 HelidonRS.flatMapLoadOnPassedInPublisher ████████████████████████████████████████████████████████████████████████████████████ 22.574
                        SmallRyeRS.filter ███████████████████████████████████████████████████████████████████████████████████████████████ 25.586
                         HelidonRS.filter ██████████████████████████████████████████████████████████████████████████████████████████████ 25.241
                        SmallRyeRS.concat █████████████████████████████████████████████ 12.238
                         HelidonRS.concat ████████████████████████████████████████████████ 12.867
                         SmallRyeRS.limit █████████████████████████████████████████████████████████████████████████████████████████████████ 26.190
                          HelidonRS.limit ███████████████████████████████████████████████████████████████████████████████████████ 23.440
                        SmallRyeRS.toList ██████████████████████████████████████████████████████████████ 16.769
                         HelidonRS.toList ██████████████████████████████████████████████████████████████████████████████████████ 23.106
```

Run:
```shell script
mvn clean install -Pmulti-comparison
```

Expected result:
```shell script
# Run complete. Total time: 00:15:26

Benchmark                  Mode  Cnt   Score   Error  Units
NewMulti.collectList      thrpt   20  25.106 ± 2.274  ops/s
NewMulti.distinct         thrpt   20   6.536 ± 0.732  ops/s
NewMulti.dropWhile        thrpt   20  38.701 ± 1.164  ops/s
NewMulti.filter           thrpt   20  42.715 ± 0.175  ops/s
NewMulti.flatMap          thrpt   20   2.732 ± 0.039  ops/s
NewMulti.flatMapIterable  thrpt   20   5.343 ± 0.118  ops/s
NewMulti.limit            thrpt   20  43.957 ± 0.473  ops/s
NewMulti.map              thrpt   20  40.629 ± 1.468  ops/s
NewMulti.peek             thrpt   20  43.594 ± 0.138  ops/s
NewMulti.skip             thrpt   20  29.530 ± 0.254  ops/s
NewMulti.takeWhile        thrpt   20  30.724 ± 0.209  ops/s
OldMulti.collectList      thrpt   20  26.838 ± 0.563  ops/s
OldMulti.distinct         thrpt   20   6.585 ± 0.837  ops/s
OldMulti.dropWhile        thrpt   20  36.723 ± 0.204  ops/s
OldMulti.filter           thrpt   20  42.026 ± 0.323  ops/s
OldMulti.flatMap          thrpt   20   2.574 ± 0.047  ops/s
OldMulti.flatMapIterable  thrpt   20   5.061 ± 0.112  ops/s
OldMulti.limit            thrpt   20  41.425 ± 0.665  ops/s
OldMulti.map              thrpt   20  40.717 ± 1.030  ops/s
OldMulti.peek             thrpt   20  41.929 ± 0.764  ops/s
OldMulti.skip             thrpt   20  43.442 ± 0.238  ops/s
OldMulti.takeWhile        thrpt   20  26.705 ± 0.265  ops/s

OldMulti.flatMapIterable ████████████ 5.061
NewMulti.flatMapIterable ████████████ 5.343
      OldMulti.takeWhile █████████████████████████████████████████████████████████████ 26.705
      NewMulti.takeWhile ██████████████████████████████████████████████████████████████████████ 30.724
      OldMulti.dropWhile ████████████████████████████████████████████████████████████████████████████████████ 36.723
      NewMulti.dropWhile ████████████████████████████████████████████████████████████████████████████████████████ 38.701
           OldMulti.peek ███████████████████████████████████████████████████████████████████████████████████████████████ 41.929
           NewMulti.peek ███████████████████████████████████████████████████████████████████████████████████████████████████ 43.594
        OldMulti.flatMap ██████ 2.574
        NewMulti.flatMap ██████ 2.732
            OldMulti.map █████████████████████████████████████████████████████████████████████████████████████████████ 40.717
            NewMulti.map ████████████████████████████████████████████████████████████████████████████████████████████ 40.629
           OldMulti.skip ███████████████████████████████████████████████████████████████████████████████████████████████████ 43.442
           NewMulti.skip ███████████████████████████████████████████████████████████████████ 29.530
         OldMulti.filter ████████████████████████████████████████████████████████████████████████████████████████████████ 42.026
         NewMulti.filter █████████████████████████████████████████████████████████████████████████████████████████████████ 42.715
       OldMulti.distinct ███████████████ 6.585
       NewMulti.distinct ███████████████ 6.536
          OldMulti.limit ██████████████████████████████████████████████████████████████████████████████████████████████ 41.425
          NewMulti.limit ████████████████████████████████████████████████████████████████████████████████████████████████████ 43.957
    OldMulti.collectList █████████████████████████████████████████████████████████████ 26.838
    NewMulti.collectList █████████████████████████████████████████████████████████ 25.106
```