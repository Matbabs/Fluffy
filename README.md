
![fluffy](./assets/fluffy-alpha-256.png)

# Fluffy the Programming Language

![](https://img.shields.io/static/v1.svg?label=Script&message=Proramming&color=e760a3)
![](https://img.shields.io/static/v1.svg?label=Language&message=v1.0.0&color=edca9c)

Fluffy is a scripting language. It is an easy language and therefore the syntax style is closed to Lua. 
In order to keep a certain performance Fluffy is transpiled to C++.

> The goal of this project was to learn how to make a transpiler. In fact, this is the first attempt to create a programming language. 

## Contents

* [Dependencies and install](#dependencies-and-install)
    * [Compiler](#Compiler)
    * [Build and run](#build-and-run)
    * [Visual Studio Code Syntax highlight](#visual-studio-code-syntax-highlight)
* [Language syntax](#Language-syntax)
    * [Variables](#variables)
        * [int](#int)
        * [string](#string)
        * [bool](#bool)
    * [Expressions](#expressions)
        * [arithmetic](#arithmetic)
        * [boolean](#boolean)
    * [Print](#print)
    * [Conditions](#conditions)
        * [if](#if)
        * [else](#else)
        * [elsif](#elsif)
    * [Loops](#loops)
        * [for](#for)
        * [while](#while)
    * [Functions](#functions)
    
# Dependencies and install

## Compiler

First you need to use the `fluffy.jar` compiler located on this git repository: [fluffy.jar compiler](https://github.com/Matbabs/Fluffy/blob/main/fluffy.jar)

The compiler was written in __Kotlin__. Therefore it is necessary to be able to run `.jar` programs. 
Moreover Fluffy is a transpile language, so you need the __C++__ `g++` compiler.

### Build and run

The command below can be used to launch the compilation process: 

`java -jar fluffy.jar <file.fy>`

> you can ease the use by adding a bash alias 
>
> `alias fluffy="java -jar <path>/fluffy.jar"`
>
> and use instead `fluffy <file.fy>`

Run with:

`./a.out`

## Visual Studio Code Syntax highlight

A vscode extension is available : [Fluffy on vscode](https://marketplace.visualstudio.com/items?itemName=matbabs.fluffy). 

It allows to visualize the Fluffy language thanks to syntax highlighting.

# Language syntax

## Variables

Fluffy is a script programming language, so to simplify the syntax the typing of variables is dynamic.

We will see some examples of primitive types.

### int
```
myInt = 42
```
### string
```
myString = "fluffy"
```
### bool
```
myBool = true
myBool = false
```

## expressions

A fluffy expression is used to represent a calculation or an evaluation between several terms.

* __It is characterized by the absence of space between the terms.__

There are arithmetic expressions (mathematical calculation) and Boolean expressions (condition evaluation).

### arithmetic
```
expr_arithmetic = 5*(4/2)+1
```
All these symbols are readable:
* `+` plus
* `-` minus
* `*` multiplication 
* `/` division 
* `%` modulo

### boolean
```
expr_boolean = (x>=0)&&(x<5)||(x>=10)&&(x<15)
```
All these symbols are readable:
* `&&` and logic
* `||` or logic 
* `>=` greater or equal 
* `<=` smaller or equal
* `>` greater 
* `<` smaller
* `==` equal
* `!` not 

## Print

You can use the `<<` operator to concat results and print them.

`print <expr><<<expr>...`

```
print 42

x = 42
print x

print "x:"<<x

print "x+5:"<<(x+5)
```

## Conditions

### if

`if <expr> then ... end`

```
x = true
if x then print x end

y = 5
if (y>0)&&(y<10) then print y end

```

### else

`if <expr> then ... else ... end`

```
truth = true

if truth then
    print "true"
else
    print "false"
end
```

### elsif

`if <expr> then ... elsif <expr> then ... else ... end`

```
x = 42

if x<20 then
    print "<20"
elsif x<50 then
    print "<50"
else
    print "<inf"
end
```

## Loops

### for

`for <variable>,<start>,<end> do ... end`

```
for i,0,10 do
    print i
end
```

### while

`while <expr> do ... end`

```
i = 0
while i<10 do
    print i
    i = i+1 
end
```

## Functions

`fun <name> <param>,... do ... (return ...) end`

```
fun write x do
    print x
end

write "I'm not fat I'm just fluffy"

fun compute x,y do
    res = x+y
    return res
end

x = compute 1,2 
```
