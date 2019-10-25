package com.sbt.javaschool.rnd.lesson1args;//                                                              /||\
import com.sbt.javaschool.rnd.lesson1args.args.ArgsParser;//                                             // || \\
//                                                                                                      //  ||  \\
public class Main {//                                                                                  //   ||   \\
    /*                                                                                                      ||
                                                                                                            ||
                                                                                                            ||
                                                                                                            ||
                                                                                                            ||
                                                                                                            ||
                                        you can edit args str "this is VovkaSOL test string" in run configuration
     */
    public static void main(String[] args) {
        ArgsParser ap= new ArgsParser();
        ap.ArgsToKebabStr(args).PrintResToStdOut();
        ap.ArgsToCamelStr(args).PrintResToStdOut();
        ap.ArgsToSnakeStr(args).PrintResToStdOut();
        ap.ArgsToPascalStr(args).PrintResToStdOut();
        ap.ArgsToUpperCaseSnakeCaseStr(args).PrintResToStdOut();
    }
}
