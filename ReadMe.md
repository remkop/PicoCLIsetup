# Min example project for Picocli annotationProcessor module problem

This demonstrates the error I described on [StackOverflow](https://stackoverflow.com/questions/64205037/set-up-picocli-annotation-processor-in-intellij-maven-project-with-modules?noredirect=1#comment113557737_64205037)

## Structure

    parent Pom: pom.xml
        module1     src/core/pom.xml
        module2     src/util/pom.xml

## Problem
I want to use the picocli annotationProcessorPaths for compile time err checking. But as soon as I enable the annotationProcessor configuration (is in comments in all poms) the whole IntelliJ project becomes invalid.

IntelliJ pics up the pom configuration and shows them in the annotationProcessor settings. But somehow I produces an invalid configuration. Maybe because of IntelliJ or because the use of modules.

I followed [this](https://immutables.github.io/apt.html) instruction that are linked in the official dokumentation. (By the way, one picture on the side is broken)

The maven example project on the official picocli repro WORKS. So hopefly this eliminates erros in my sytem

## Infos
    IntelliJ IDEA 2020.2.2 (Ultimate Edition)
    Build #IU-202.7319.50, built on September 15, 2020
    Licensed to Henrik Gerdes
    Subscription is active until March 18, 2021
    For educational use only.
    Runtime version: 11.0.8+10-b944.31 amd64
    VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
    Windows 10 10.0
    GC: ParNew, ConcurrentMarkSweep
    Memory: 1961M
    Cores: 8
    Non-Bundled Plugins: org.jetbrains.kotlin