
![fluffy](./assets/fluffy-alpha-128.png)

# Fluffy the Programming Language

Fluffy is a scripting language. It is an easy language and therefore the syntax style is closed to Lua. 
In order to keep a certain performance Fluffy is transpiled to C++.

> The goal of this project was to learn how to make a transpiler. In fact, this is the first attempt to create a programming language. 

## Contents

* [Dependencies and install](#dependencies-and-install)
    * [Kotlin (jvm) and C++ (g++)](#kotlin-(jvm)-and-C++-(g++))
        * [Build and run](#build-and-run)
    * [Syntax highlight (vscode extension)](#Syntax-highlight-(vscode-extension))
* [Language syntax](#Language-syntax)
    * [Variables](#Variables)
        * [int](#int)
        * [string](#string)
        * [bool](#bool)
    * [Expressions](#expressions)
        * [arithmetic](#arithmetic)
        * [boolean](#boolean)
    * [Print](#Print)
    * [Conditions](#Conditions)
        * [if](#if)
        * [else](#else)
        * [elsif](#elsif)
    * [Loops](#Loops)
        * [for](#for)
        * [while](#while)
    * [Functions](#Functions)
    
# Dependencies and install

## Kotlin (jvm) and C++ (g++)

First you need to use the `fluffy.jar` compiler located on this git repository.

The compiler was written in Kotlin. Therefore it is necessary to be able to run `.jar` programs. 
Moreover Fluffy is a transpile language, so you need the C++ `g++` compiler.

### Build and run

The command below can be used to launch the compilation process: 

`java -jar fluffy.jar <file.fy>`

Run with:

`./a.out`

## Syntax highlight (vscode extension)

A vscode extension is available on this git repository. It allows to visualize the Fluffy language thanks to syntax highlighting.

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
