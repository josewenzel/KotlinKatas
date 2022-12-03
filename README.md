# Kotlin Katas

This is the place where I document my process of learning and practicing idiomatic Kotlin by working on TDD katas, also
they help me to develop better macro and micro design skills, and they also serve as a reference point whenever I want
to revisit or demo a particular pattern or snippet.

## Tools

I use IntelliJ in order to create the repositories, and gradle as my build tool, and the libraries I have been using
are:

- [Strikt:](https://strikt.io/) Assertions library that uses JUnit runner and provides more fluent assertion and some
  quality of life enhancements.
- [MockK:](https://mockk.io/) Mocking library that supports mocking for widely used libraries. It is also really easy to
  use.
- [KtLint:](https://pinterest.github.io/ktlint/) I'm using
  the [KtLint plugin for intelliJ](https://plugins.jetbrains.com/plugin/15057-ktlint-unofficial-/) which is an
  opinionated linter following the practice of "convention over configuration".

## Structure

I have created a branch for each kata I made, and I _hope_ to create small and frequent commits in case you want to
follow my thought process, I'll be using [Karma commits](https://karma-runner.github.io/6.4/dev/git-commit-msg.html) to
enforce some consistency in the git history.