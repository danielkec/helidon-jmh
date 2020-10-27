# Helidon Reactive Streams JMH tests

Run:
```shell script
mvn install -Pmprs-comparison
```

Expected result:
```shell script
# Run complete. Total time: 00:18:52
# Run complete. Total time: 00:40:30

Benchmark                                   Mode  Cnt   Score   Error  Units
HelidonRS.concat                           thrpt    5  23.933 ± 4.101  ops/s
HelidonRS.dropWhile                        thrpt    5  47.617 ± 0.773  ops/s
HelidonRS.filter                           thrpt    5  46.708 ± 5.700  ops/s
HelidonRS.flatMap                          thrpt    5   1.475 ± 0.514  ops/s
HelidonRS.flatMapIterable                  thrpt    5   8.282 ± 4.434  ops/s
HelidonRS.flatMapLoadOnPassedInPublisher   thrpt    5  22.316 ± 2.673  ops/s
HelidonRS.limit                            thrpt    5  44.923 ± 1.145  ops/s
HelidonRS.map                              thrpt    5  46.274 ± 7.837  ops/s
HelidonRS.peek                             thrpt    5  48.323 ± 1.391  ops/s
HelidonRS.skip                             thrpt    5  52.684 ± 2.965  ops/s
HelidonRS.takeWhile                        thrpt    5  47.355 ± 3.166  ops/s
HelidonRS.toList                           thrpt    5  27.188 ± 1.226  ops/s
SmallRyeRS.concat                          thrpt    5  11.510 ± 0.500  ops/s
SmallRyeRS.dropWhile                       thrpt    5  25.888 ± 1.961  ops/s
SmallRyeRS.filter                          thrpt    5  24.789 ± 1.291  ops/s
SmallRyeRS.flatMap                         thrpt    5   0.545 ± 0.009  ops/s
SmallRyeRS.flatMapIterable                 thrpt    5  14.460 ± 0.264  ops/s
SmallRyeRS.flatMapLoadOnPassedInPublisher  thrpt    5  11.664 ± 0.167  ops/s
SmallRyeRS.limit                           thrpt    5  25.099 ± 3.333  ops/s
SmallRyeRS.map                             thrpt    5  25.821 ± 0.980  ops/s
SmallRyeRS.peek                            thrpt    5  24.913 ± 0.276  ops/s
SmallRyeRS.skip                            thrpt    5  26.232 ± 1.457  ops/s
SmallRyeRS.takeWhile                       thrpt    5  24.004 ± 2.012  ops/s
SmallRyeRS.toList                          thrpt    5  16.642 ± 0.799  ops/s

               SmallRyeRS.flatMapIterable ███████████████████████████ 14.460
                HelidonRS.flatMapIterable ████████████████ 8.282
                     SmallRyeRS.takeWhile ██████████████████████████████████████████████ 24.004
                      HelidonRS.takeWhile ██████████████████████████████████████████████████████████████████████████████████████████ 47.355
                     SmallRyeRS.dropWhile █████████████████████████████████████████████████ 25.888
                      HelidonRS.dropWhile ██████████████████████████████████████████████████████████████████████████████████████████ 47.617
                          SmallRyeRS.peek ███████████████████████████████████████████████ 24.913
                           HelidonRS.peek ████████████████████████████████████████████████████████████████████████████████████████████ 48.323
                       SmallRyeRS.flatMap █ 0.545
                        HelidonRS.flatMap ███ 1.475
                           SmallRyeRS.map █████████████████████████████████████████████████ 25.821
                            HelidonRS.map ████████████████████████████████████████████████████████████████████████████████████████ 46.274
                          SmallRyeRS.skip ██████████████████████████████████████████████████ 26.232
                           HelidonRS.skip ████████████████████████████████████████████████████████████████████████████████████████████████████ 52.684
SmallRyeRS.flatMapLoadOnPassedInPublisher ██████████████████████ 11.664
 HelidonRS.flatMapLoadOnPassedInPublisher ██████████████████████████████████████████ 22.316
                        SmallRyeRS.filter ███████████████████████████████████████████████ 24.789
                         HelidonRS.filter █████████████████████████████████████████████████████████████████████████████████████████ 46.708
                        SmallRyeRS.concat ██████████████████████ 11.510
                         HelidonRS.concat █████████████████████████████████████████████ 23.933
                         SmallRyeRS.limit ████████████████████████████████████████████████ 25.099
                          HelidonRS.limit █████████████████████████████████████████████████████████████████████████████████████ 44.923
                        SmallRyeRS.toList ████████████████████████████████ 16.642
                         HelidonRS.toList ████████████████████████████████████████████████████ 27.188
```