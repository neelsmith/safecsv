---
title: safecsv
layout: page
---



## Features

- is not fast
- is not fancy
- parses CSV files by Unicode code points: safe to use with content outside the Basic Multilingual Plane
- delivers an ArrayList of rows, each containing an ArrayList of columns
- leading/trailing white space ignored
- user-specifiable column-delimiter value, may be any Unicode code point: default is comma
- column contents may optionally be quoted by user-specifiable quotation value, may be any Unicode code point: default is double quote

## Get it

- from github: <http://neelsmith.github.io/safecsv/>
- using maven coordinates: group `edu.holycross.shot`, name `safecsv`, current version `0.0.1`, publicly released from the Nexus server at `http://beta.hpcc.uh.edu/nexus/index.html`


## Planned additions

- real documentation
- stand-alone groovy script (using grapes) writes to standard output with user-defined output delimiter (default: tab). Useful for piping into other programs.
- concordion specifications
- API docs
- groovy source code prepackaged for download
