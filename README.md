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
# Run complete. Total time: 00:17:10

Benchmark                                   Mode  Cnt   Score   Error  Units
HelidonRS.concat                           thrpt   20  25.753 ± 0.379  ops/s
HelidonRS.dropWhile                        thrpt   20  51.603 ± 0.890  ops/s
HelidonRS.filter                           thrpt   20  51.536 ± 0.283  ops/s
HelidonRS.flatMap                          thrpt   20   1.494 ± 0.015  ops/s
HelidonRS.flatMapIterable                  thrpt   20   9.253 ± 0.108  ops/s
HelidonRS.flatMapLoadOnPassedInPublisher   thrpt   20  22.809 ± 0.283  ops/s
HelidonRS.limit                            thrpt   20  50.658 ± 0.944  ops/s
HelidonRS.map                              thrpt   20  48.201 ± 0.770  ops/s
HelidonRS.peek                             thrpt   20  51.032 ± 1.233  ops/s
HelidonRS.skip                             thrpt   20  50.997 ± 0.907  ops/s
HelidonRS.takeWhile                        thrpt   20  50.407 ± 0.416  ops/s
HelidonRS.toList                           thrpt   20  28.722 ± 0.599  ops/s
SmallRyeRS.concat                          thrpt   20  11.657 ± 0.158  ops/s
SmallRyeRS.dropWhile                       thrpt   20  26.516 ± 0.328  ops/s
SmallRyeRS.filter                          thrpt   20  25.027 ± 0.522  ops/s
SmallRyeRS.flatMap                         thrpt   20   0.585 ± 0.012  ops/s
SmallRyeRS.flatMapIterable                 thrpt   20   8.727 ± 0.152  ops/s
SmallRyeRS.flatMapLoadOnPassedInPublisher  thrpt   20  11.750 ± 0.086  ops/s
SmallRyeRS.limit                           thrpt   20  26.916 ± 0.423  ops/s
SmallRyeRS.map                             thrpt   20  24.568 ± 0.190  ops/s
SmallRyeRS.peek                            thrpt   20  25.211 ± 0.099  ops/s
SmallRyeRS.skip                            thrpt   20  25.329 ± 0.415  ops/s
SmallRyeRS.takeWhile                       thrpt   20  26.594 ± 0.215  ops/s
SmallRyeRS.toList                          thrpt   20  16.986 ± 0.295  ops/s

               SmallRyeRS.flatMapIterable █████████████████ 8.727
                HelidonRS.flatMapIterable ██████████████████ 9.253
                     SmallRyeRS.takeWhile ████████████████████████████████████████████████████ 26.594
                      HelidonRS.takeWhile ██████████████████████████████████████████████████████████████████████████████████████████████████ 50.407
                     SmallRyeRS.dropWhile ███████████████████████████████████████████████████ 26.516
                      HelidonRS.dropWhile ████████████████████████████████████████████████████████████████████████████████████████████████████ 51.603
                          SmallRyeRS.peek █████████████████████████████████████████████████ 25.211
                           HelidonRS.peek ███████████████████████████████████████████████████████████████████████████████████████████████████ 51.032
                       SmallRyeRS.flatMap █ 0.585
                        HelidonRS.flatMap ███ 1.494
                           SmallRyeRS.map ████████████████████████████████████████████████ 24.568
                            HelidonRS.map █████████████████████████████████████████████████████████████████████████████████████████████ 48.201
                          SmallRyeRS.skip █████████████████████████████████████████████████ 25.329
                           HelidonRS.skip ███████████████████████████████████████████████████████████████████████████████████████████████████ 50.997
SmallRyeRS.flatMapLoadOnPassedInPublisher ███████████████████████ 11.750
 HelidonRS.flatMapLoadOnPassedInPublisher ████████████████████████████████████████████ 22.809
                        SmallRyeRS.filter ████████████████████████████████████████████████ 25.027
                         HelidonRS.filter ████████████████████████████████████████████████████████████████████████████████████████████████████ 51.536
                        SmallRyeRS.concat ███████████████████████ 11.657
                         HelidonRS.concat ██████████████████████████████████████████████████ 25.753
                         SmallRyeRS.limit ████████████████████████████████████████████████████ 26.916
                          HelidonRS.limit ██████████████████████████████████████████████████████████████████████████████████████████████████ 50.658
                        SmallRyeRS.toList █████████████████████████████████ 16.986
                         HelidonRS.toList ███████████████████████████████