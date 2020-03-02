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
# Run complete. Total time: 00:14:50

Benchmark                  Mode  Cnt         Score        Error  Units
NewMulti.distinct         thrpt   20  16763448.230 ± 187560.483  ops/s
NewMulti.dropWhile        thrpt   20  10566033.104 ± 161208.112  ops/s
NewMulti.filter           thrpt   20  19832232.259 ± 323666.876  ops/s
NewMulti.flatMap          thrpt   20    108589.325 ±   1777.737  ops/s
NewMulti.flatMapIterable  thrpt   20   8179669.647 ± 147939.753  ops/s
NewMulti.forEach          thrpt   20        40.224 ±      0.643  ops/s
NewMulti.limit            thrpt   20  17618167.965 ± 378326.695  ops/s
NewMulti.map              thrpt   20  17655577.679 ± 174923.015  ops/s
NewMulti.peek             thrpt   20  16254926.237 ± 275690.745  ops/s
NewMulti.skip             thrpt   20  10778641.443 ± 192864.497  ops/s
NewMulti.takeWhile        thrpt   20  17508131.943 ± 287995.300  ops/s
OldMulti.distinct         thrpt   20  16056285.049 ± 276359.217  ops/s
OldMulti.dropWhile        thrpt   20  10200470.840 ± 251592.578  ops/s
OldMulti.filter           thrpt   20  17774474.991 ± 230164.729  ops/s
OldMulti.flatMap          thrpt   20    103473.298 ±   2804.903  ops/s
OldMulti.flatMapIterable  thrpt   20   7822954.060 ± 154928.044  ops/s
OldMulti.forEach          thrpt   20        38.552 ±      0.785  ops/s
OldMulti.limit            thrpt   20  17300970.195 ± 254655.578  ops/s
OldMulti.map              thrpt   20  17257175.604 ± 367785.077  ops/s
OldMulti.peek             thrpt   20  15037568.982 ± 211882.386  ops/s
OldMulti.skip             thrpt   20  10289566.894 ± 254988.319  ops/s
OldMulti.takeWhile        thrpt   20  17180486.961 ± 344928.434  ops/s

OldMulti.flatMapIterable ███████████████████████████████████████ 7822954.060
NewMulti.flatMapIterable █████████████████████████████████████████ 8179669.647
      OldMulti.takeWhile ███████████████████████████████████████████████████████████████████████████████████████ 17180486.961
      NewMulti.takeWhile ████████████████████████████████████████████████████████████████████████████████████████ 17508131.943
      OldMulti.dropWhile ███████████████████████████████████████████████████ 10200470.840
      NewMulti.dropWhile █████████████████████████████████████████████████████ 10566033.104
        OldMulti.forEach  38.552
        NewMulti.forEach  40.224
           OldMulti.peek ████████████████████████████████████████████████████████████████████████████ 15037568.982
           NewMulti.peek ██████████████████████████████████████████████████████████████████████████████████ 16254926.237
        OldMulti.flatMap █ 103473.298
        NewMulti.flatMap █ 108589.325
            OldMulti.map ███████████████████████████████████████████████████████████████████████████████████████ 17257175.604
            NewMulti.map █████████████████████████████████████████████████████████████████████████████████████████ 17655577.679
           OldMulti.skip ████████████████████████████████████████████████████ 10289566.894
           NewMulti.skip ██████████████████████████████████████████████████████ 10778641.443
         OldMulti.filter ██████████████████████████████████████████████████████████████████████████████████████████ 17774474.991
         NewMulti.filter ████████████████████████████████████████████████████████████████████████████████████████████████████ 19832232.259
       OldMulti.distinct █████████████████████████████████████████████████████████████████████████████████ 16056285.049
       NewMulti.distinct █████████████████████████████████████████████████████████████████████████████████████ 16763448.230
          OldMulti.limit ███████████████████████████████████████████████████████████████████████████████████████ 17300970.195
          NewMulti.limit █████████████████████████████████████████████████████████████████████████████████████████ 17618167.965
```