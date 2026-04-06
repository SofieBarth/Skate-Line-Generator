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

## Usage and Feature Overview

1. **Open the Generator UI**  
   To access the interface start the program.

2. **Select Trick Source**  
   Choose between:
   - a predefined trick list  
   - a custom-built trick list

3. **Predefined List Option**  
   Select the list for your Skate-line.

4. **Custom List Option**  
   Browse all available tricks and select your own set.

5. **Define Line Length**  
   Enter the number of tricks to include in the skate line.

6. **Generate Line**  
   The system creates a randomized sequence based on your selection.

7. **Display Result**  
   The generated skate line is presented in the UI.

---

## How It Works

1. The trick list is filtered into separate lists based on starting direction (`REGULAR` or `FAKIE`).
2. The first trick is randomly selected from tricks that start in `REGULAR`.
3. Additional tricks are chosen based on the ending direction of the previous trick.
4. The final trick is selected from tricks that end in `REGULAR`.
5. The completed line is given in the UI


