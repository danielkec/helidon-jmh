# Helidon Reactive Streams JMH tests

Run:
```shell script
mvn install -Pmprs-comparison
```

Expected result:
```shell script
# Run complete. Total time: 00:48:42

Benchmark                                   Mode  Cnt   Score    Error  Units
HelidonRS.concat                           thrpt    5  25.227 ±  2.606  ops/s
HelidonRS.dropWhile                        thrpt    5  50.668 ±  1.202  ops/s
HelidonRS.filter                           thrpt    5  48.720 ±  7.498  ops/s
HelidonRS.flatMap                          thrpt    5   1.740 ±  0.036  ops/s
HelidonRS.flatMapIterable                  thrpt    5  10.589 ±  0.493  ops/s
HelidonRS.flatMapLoadOnPassedInPublisher   thrpt    5  22.910 ±  1.150  ops/s
HelidonRS.limit                            thrpt    5  46.115 ±  2.437  ops/s
HelidonRS.map                              thrpt    5  48.384 ±  0.845  ops/s
HelidonRS.peek                             thrpt    5  37.229 ± 13.032  ops/s
HelidonRS.skip                             thrpt    5  47.078 ±  6.440  ops/s
HelidonRS.takeWhile                        thrpt    5  48.105 ±  8.928  ops/s
HelidonRS.toList                           thrpt    5  27.314 ±  1.309  ops/s
MutinyRS.concat                            thrpt    5  12.150 ±  2.369  ops/s
MutinyRS.dropWhile                         thrpt    5  44.607 ±  3.207  ops/s
MutinyRS.filter                            thrpt    5  44.508 ±  6.667  ops/s
MutinyRS.flatMap                           thrpt    5   0.536 ±  0.014  ops/s
MutinyRS.flatMapIterable                   thrpt    5   2.108 ±  0.119  ops/s
MutinyRS.flatMapLoadOnPassedInPublisher    thrpt    5  11.664 ±  1.689  ops/s
MutinyRS.limit                             thrpt    5  46.247 ±  0.346  ops/s
MutinyRS.map                               thrpt    5  40.538 ± 14.183  ops/s
MutinyRS.peek                              thrpt    5  39.944 ± 16.756  ops/s
MutinyRS.skip                              thrpt    5  28.555 ±  2.626  ops/s
MutinyRS.takeWhile                         thrpt    5  40.689 ± 16.624  ops/s
MutinyRS.toList                            thrpt    5  26.605 ±  1.335  ops/s
SmallRyeRS.concat                          thrpt    5  12.097 ±  0.146  ops/s
SmallRyeRS.dropWhile                       thrpt    5  26.611 ±  2.609  ops/s
SmallRyeRS.filter                          thrpt    5  24.072 ±  1.209  ops/s
SmallRyeRS.flatMap                         thrpt    5   0.548 ±  0.047  ops/s
SmallRyeRS.flatMapIterable                 thrpt    5  14.258 ±  1.467  ops/s
SmallRyeRS.flatMapLoadOnPassedInPublisher  thrpt    5  10.991 ±  0.327  ops/s
SmallRyeRS.limit                           thrpt    5  25.612 ±  4.226  ops/s
SmallRyeRS.map                             thrpt    5  25.062 ±  2.949  ops/s
SmallRyeRS.peek                            thrpt    5  24.478 ±  2.548  ops/s
SmallRyeRS.skip                            thrpt    5  26.570 ±  1.434  ops/s
SmallRyeRS.takeWhile                       thrpt    5  24.602 ±  4.050  ops/s
SmallRyeRS.toList                          thrpt    5  16.294 ±  0.817  ops/s

               SmallRyeRS.flatMapIterable ████████████████████████████ 14.258
                HelidonRS.flatMapIterable █████████████████████ 10.589
                 MutinyRS.flatMapIterable ████ 2.108
                     SmallRyeRS.takeWhile █████████████████████████████████████████████████ 24.602
                      HelidonRS.takeWhile ███████████████████████████████████████████████████████████████████████████████████████████████ 48.105
                       MutinyRS.takeWhile ████████████████████████████████████████████████████████████████████████████████ 40.689
                     SmallRyeRS.dropWhile █████████████████████████████████████████████████████ 26.611
                      HelidonRS.dropWhile ████████████████████████████████████████████████████████████████████████████████████████████████████ 50.668
                       MutinyRS.dropWhile ████████████████████████████████████████████████████████████████████████████████████████ 44.607
                          SmallRyeRS.peek ████████████████████████████████████████████████ 24.478
                           HelidonRS.peek █████████████████████████████████████████████████████████████████████████ 37.229
                            MutinyRS.peek ███████████████████████████████████████████████████████████████████████████████ 39.944
                       SmallRyeRS.flatMap █ 0.548
                        HelidonRS.flatMap ███ 1.740
                         MutinyRS.flatMap █ 0.536
                           SmallRyeRS.map █████████████████████████████████████████████████ 25.062
                            HelidonRS.map ███████████████████████████████████████████████████████████████████████████████████████████████ 48.384
                             MutinyRS.map ████████████████████████████████████████████████████████████████████████████████ 40.538
                          SmallRyeRS.skip ████████████████████████████████████████████████████ 26.570
                           HelidonRS.skip █████████████████████████████████████████████████████████████████████████████████████████████ 47.078
                            MutinyRS.skip ████████████████████████████████████████████████████████ 28.555
SmallRyeRS.flatMapLoadOnPassedInPublisher ██████████████████████ 10.991
 HelidonRS.flatMapLoadOnPassedInPublisher █████████████████████████████████████████████ 22.910
  MutinyRS.flatMapLoadOnPassedInPublisher ███████████████████████ 11.664
                        SmallRyeRS.filter ████████████████████████████████████████████████ 24.072
                         HelidonRS.filter ████████████████████████████████████████████████████████████████████████████████████████████████ 48.720
                          MutinyRS.filter ████████████████████████████████████████████████████████████████████████████████████████ 44.508
                        SmallRyeRS.concat ████████████████████████ 12.097
                         HelidonRS.concat ██████████████████████████████████████████████████ 25.227
                          MutinyRS.concat ████████████████████████ 12.150
                         SmallRyeRS.limit ███████████████████████████████████████████████████ 25.612
                          HelidonRS.limit ███████████████████████████████████████████████████████████████████████████████████████████ 46.115
                           MutinyRS.limit ███████████████████████████████████████████████████████████████████████████████████████████ 46.247
                        SmallRyeRS.toList ████████████████████████████████ 16.294
                         HelidonRS.toList ██████████████████████████████████████████████████████ 27.314
                          MutinyRS.toList █████████████████████████████████████████████████████ 26.605
```