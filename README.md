# Helidon Reactive Streams JMH tests

Run:
```shell script
mvn clean install -Pmprs-comparison
```

Expected result:
```shell script
# Run complete. Total time: 00:18:52

Benchmark                                   Mode  Cnt   Score   Error  Units
HelidonRS.concat                           thrpt   20  15.241 ± 0.063  ops/s
HelidonRS.dropWhile                        thrpt   20  27.519 ± 0.194  ops/s
HelidonRS.filter                           thrpt   20  28.932 ± 0.250  ops/s
HelidonRS.flatMap                          thrpt   20   0.274 ± 0.003  ops/s
HelidonRS.flatMapIterable                  thrpt   20   4.670 ± 0.029  ops/s
HelidonRS.flatMapLoadOnPassedInPublisher   thrpt   20  27.717 ± 0.237  ops/s
HelidonRS.limit                            thrpt   20  27.653 ± 0.143  ops/s
HelidonRS.map                              thrpt   20  25.015 ± 0.565  ops/s
HelidonRS.peek                             thrpt   20  28.859 ± 0.204  ops/s
HelidonRS.skip                             thrpt   20  28.160 ± 0.292  ops/s
HelidonRS.takeWhile                        thrpt   20  28.575 ± 0.367  ops/s
HelidonRS.toList                           thrpt   20  25.533 ± 0.331  ops/s
SmallRyeRS.concat                          thrpt   20  12.703 ± 0.037  ops/s
SmallRyeRS.dropWhile                       thrpt   20  27.283 ± 0.101  ops/s
SmallRyeRS.filter                          thrpt   20  25.340 ± 1.468  ops/s
SmallRyeRS.flatMap                         thrpt   20   0.592 ± 0.006  ops/s
SmallRyeRS.flatMapIterable                 thrpt   20  16.077 ± 0.279  ops/s
SmallRyeRS.flatMapLoadOnPassedInPublisher  thrpt   20  11.847 ± 0.059  ops/s
SmallRyeRS.limit                           thrpt   20  27.732 ± 0.100  ops/s
SmallRyeRS.map                             thrpt   20  26.026 ± 0.131  ops/s
SmallRyeRS.peek                            thrpt   20  26.013 ± 0.150  ops/s
SmallRyeRS.skip                            thrpt   20  26.157 ± 0.036  ops/s
SmallRyeRS.takeWhile                       thrpt   20  26.139 ± 0.074  ops/s
SmallRyeRS.toList                          thrpt   20  17.966 ± 0.507  ops/s

               SmallRyeRS.flatMapIterable ████████████████████████████████████████████████████████ 16.077
                HelidonRS.flatMapIterable ████████████████ 4.670
                     SmallRyeRS.takeWhile ██████████████████████████████████████████████████████████████████████████████████████████ 26.139
                      HelidonRS.takeWhile ███████████████████████████████████████████████████████████████████████████████████████████████████ 28.575
                     SmallRyeRS.dropWhile ██████████████████████████████████████████████████████████████████████████████████████████████ 27.283
                      HelidonRS.dropWhile ███████████████████████████████████████████████████████████████████████████████████████████████ 27.519
                          SmallRyeRS.peek ██████████████████████████████████████████████████████████████████████████████████████████ 26.013
                           HelidonRS.peek ████████████████████████████████████████████████████████████████████████████████████████████████████ 28.859
                       SmallRyeRS.flatMap ██ 0.592
                        HelidonRS.flatMap █ 0.274
                           SmallRyeRS.map ██████████████████████████████████████████████████████████████████████████████████████████ 26.026
                            HelidonRS.map ██████████████████████████████████████████████████████████████████████████████████████ 25.015
                          SmallRyeRS.skip ██████████████████████████████████████████████████████████████████████████████████████████ 26.157
                           HelidonRS.skip █████████████████████████████████████████████████████████████████████████████████████████████████ 28.160
SmallRyeRS.flatMapLoadOnPassedInPublisher █████████████████████████████████████████ 11.847
 HelidonRS.flatMapLoadOnPassedInPublisher ████████████████████████████████████████████████████████████████████████████████████████████████ 27.717
                        SmallRyeRS.filter ████████████████████████████████████████████████████████████████████████████████████████ 25.340
                         HelidonRS.filter ████████████████████████████████████████████████████████████████████████████████████████████████████ 28.932
                        SmallRyeRS.concat ████████████████████████████████████████████ 12.703
                         HelidonRS.concat █████████████████████████████████████████████████████ 15.241
                         SmallRyeRS.limit ████████████████████████████████████████████████████████████████████████████████████████████████ 27.732
                          HelidonRS.limit ████████████████████████████████████████████████████████████████████████████████████████████████ 27.653
                        SmallRyeRS.toList ██████████████████████████████████████████████████████████████ 17.966
                         HelidonRS.toList ████████████████████████████████████████████████████████████████████████████████████████ 25.533
```

Run:
```shell script
mvn clean install -Pmulti-comparison
```

Expected result:
```shell script
# Run complete. Total time: 00:15:18

Benchmark                  Mode  Cnt   Score   Error  Units
NewMulti.collectList      thrpt   20  27.412 ± 0.653  ops/s
NewMulti.distinct         thrpt   20   6.797 ± 0.704  ops/s
NewMulti.dropWhile        thrpt   20  37.046 ± 0.216  ops/s
NewMulti.filter           thrpt   20  48.151 ± 0.345  ops/s
NewMulti.flatMap          thrpt   20   2.777 ± 0.057  ops/s
NewMulti.flatMapIterable  thrpt   20   6.968 ± 0.116  ops/s
NewMulti.limit            thrpt   20  45.405 ± 0.338  ops/s
NewMulti.map              thrpt   20  48.275 ± 0.515  ops/s
NewMulti.peek             thrpt   20  47.491 ± 0.296  ops/s
NewMulti.skip             thrpt   20  49.114 ± 0.279  ops/s
NewMulti.takeWhile        thrpt   20  45.821 ± 0.777  ops/s
OldMulti.collectList      thrpt   20  27.879 ± 1.150  ops/s
OldMulti.distinct         thrpt   20   7.119 ± 0.686  ops/s
OldMulti.dropWhile        thrpt   20  36.744 ± 0.214  ops/s
OldMulti.filter           thrpt   20  48.114 ± 0.280  ops/s
OldMulti.flatMap          thrpt   20   2.732 ± 0.048  ops/s
OldMulti.flatMapIterable  thrpt   20   7.013 ± 0.115  ops/s
OldMulti.limit            thrpt   20  45.716 ± 0.276  ops/s
OldMulti.map              thrpt   20  47.988 ± 0.627  ops/s
OldMulti.peek             thrpt   20  44.684 ± 5.586  ops/s
OldMulti.skip             thrpt   20  44.785 ± 1.552  ops/s
OldMulti.takeWhile        thrpt   20  48.285 ± 0.411  ops/s

OldMulti.flatMapIterable ██████████████ 7.013
NewMulti.flatMapIterable ██████████████ 6.968
      OldMulti.takeWhile ██████████████████████████████████████████████████████████████████████████████████████████████████ 48.285
      NewMulti.takeWhile █████████████████████████████████████████████████████████████████████████████████████████████ 45.821
      OldMulti.dropWhile ███████████████████████████████████████████████████████████████████████████ 36.744
      NewMulti.dropWhile ███████████████████████████████████████████████████████████████████████████ 37.046
           OldMulti.peek ███████████████████████████████████████████████████████████████████████████████████████████ 44.684
           NewMulti.peek █████████████████████████████████████████████████████████████████████████████████████████████████ 47.491
        OldMulti.flatMap ██████ 2.732
        NewMulti.flatMap ██████ 2.777
            OldMulti.map ██████████████████████████████████████████████████████████████████████████████████████████████████ 47.988
            NewMulti.map ██████████████████████████████████████████████████████████████████████████████████████████████████ 48.275
           OldMulti.skip ███████████████████████████████████████████████████████████████████████████████████████████ 44.785
           NewMulti.skip ████████████████████████████████████████████████████████████████████████████████████████████████████ 49.114
         OldMulti.filter ██████████████████████████████████████████████████████████████████████████████████████████████████ 48.114
         NewMulti.filter ██████████████████████████████████████████████████████████████████████████████████████████████████ 48.151
       OldMulti.distinct ██████████████ 7.119
       NewMulti.distinct ██████████████ 6.797
          OldMulti.limit █████████████████████████████████████████████████████████████████████████████████████████████ 45.716
          NewMulti.limit ████████████████████████████████████████████████████████████████████████████████████████████ 45.405
    OldMulti.collectList █████████████████████████████████████████████████████████ 27.879
    NewMulti.collectList ████████████████████████████████████████████████████████ 27.412
```