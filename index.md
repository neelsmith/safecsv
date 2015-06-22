---
title: safecsv
layout: page
---

Coming soon.

Features:

- is not fast
- is not fancy
- parses CSV files by Unicode code points: safe to use with content outside the Basic Multilingual Plane

Planned usage

- delivers an ArrayList of rows, each containing an ArrayList of columns
- leading/trailing white space ignored
- user-specifiable delimiter value, may be any Unicode code point: default is comma
- column contents may optionally be delimted by double quotes

Planned deliverables:

- binary `.jar`
- stand-alone groovy script (using grapes) writes to standard output with user-defined output delimiter (default: tab). Useful for piping into other programs.
- groovy source code
- API docs

