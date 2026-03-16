# Skate Line Generator

## Description

The **Skate Line Generator** is a small Java program that generates a random skateboard trick line based on predefined tricks. Each trick has a **starting direction (`from`)** and an **ending direction (`to`)**, such as `REGULAR` or `FAKIE`.

The program ensures that the generated line follows logical skateboarding transitions:

* The **first trick must start in REGULAR**.
* Each following trick must start in the **same direction that the previous trick ended**.
* The **final trick must end in REGULAR**.

A random trick is selected from the valid list at each step, creating a consistent and random skate line.

---

## Requirements

* Java **17 or newer** 
* A Java compiler such as:

  * IntelliJ IDEA

Optional:

* Git (if cloning the repository)

---

## Setup

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/skate-line-generator.git

```

### 2. Run the project

Use an IDE, open the project folder and run the project.

---

## Usage

The program will:

1. Load a predefined trick list.
2. Ask you to enter a number of tricks for the skate-line.
3. Generate a random skate line with the specified number of tricks.
4. Print the generated line to the console.

Example output:

```
Please enter the number of tricks for the Skate-Line:
7
Your line with 7 tricks was generated as follows:
rocknRollBoardSlide
rockToFakie
fakieAxleStall
fsFiftyFifty
rockToFakie
fakieAxleStall
fsFiftyFifty

```

Each printed line represents a trick in the generated skate line.

---

## How It Works

1. The trick list is filtered into separate lists based on starting direction (`REGULAR` or `FAKIE`).
2. The first trick is randomly selected from tricks that start in `REGULAR`.
3. Additional tricks are chosen based on the ending direction of the previous trick.
4. The final trick is selected from tricks that end in `REGULAR`.
5. The completed line is printed to the console.

---

## Example Modification

Additional lists can be created and used for the Line generation

