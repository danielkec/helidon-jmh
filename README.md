# helidon-jmh

Run:
```shell script
mvn clean install -Pengine-comparison
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