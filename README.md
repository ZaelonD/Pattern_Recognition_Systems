# This repository contains labs discipline "Image recognition systems"

## Contents

1. [LABORATORY WORK №1](#laboratory-work-1) \
   1.1. [INITIAL DATA](#11-initial-data)  
   1.2. [TEST SAMPLE](#12-test-sample)  
   1.3. [RESULTS](#13-results)
2. [LABORATORY WORK №2](#laboratory-work-2) \
   2.1. [INITIAL DATA](#21-initial-data)  
   2.2. [PROGRESS](#22-progress)  
   2.3. [RESULTS](#23-results)
3. [LABORATORY WORK №3](#LW3) \
   3.1. [INITIAL DATA](#ID)  
   3.2. [OPERATION OF THE ALGORITHM](#OPALG)  
   3.3. [RESULTS](#RES)
4. [LABORATORY WORK №4](#LW4)  
   4.1. [INITIAL DATA](#ID)  
   4.2. [PROGRESS](#PR)  
   4.3. [RESULTS](#RES)

## LABORATORY WORK №1

**"Statistical recognition. Bayesian classification"**  

Write a program and solve a similar Bayesian classification problem. Assess recognition accuracy.

### 1.1. INITIAL DATA

Let there be a training set of letters "B" and "Z", given in Capture 1. Each object is represented as an 8×8 black and
white image.

<div align="center">

![Capture 1](resources/lab1/trainingSet.svg)  

Picture 1.1.1. Training set
</div>

<br>

The features are the average sizes of 2 × 2 image fragments (Picture 2), i.e. the feature vector has the form:
x = (x₁, x₂, x₃, x₄, x₅, x₆, x₇, x₈, x₉, x₁₀, x₁₁, x₁₂, x₁₃, x₁₄, x₁₅, x₁₆).

<div align="center">

![Formation of signs](resources/lab1/formationOfSigns.svg)

Picture 1.1.2. Formation of signs
</div>

<br>

The training sample contains the following data:

```
static int[] b1 = {3, 2, 2, 2, 3, 2, 2, 2, 2, 0, 0, 2, 3, 2, 2, 3};
static int[] b2 = {3, 2, 2, 2, 3, 2, 2, 0, 2, 0, 0, 2, 3, 2, 2, 3};
static int[] b3 = {3, 2, 2, 3, 3, 2, 2, 2, 2, 0, 0, 2, 3, 2, 2, 3};
static int[] b4 = {3, 2, 2, 2, 3, 2, 2, 0, 2, 0, 0, 2, 3, 2, 2, 3};
static int[] b5 = {3, 2, 1, 0, 3, 2, 1, 0, 2, 0, 2, 0, 2, 2, 1, 0};
static int[] b6 = {1, 2, 2, 2, 2, 1, 2, 1, 3, 1, 0, 2, 1, 2, 2, 2};
static int[] b7 = {3, 2, 2, 2, 3, 2, 2, 0, 2, 0, 0, 2, 3, 2, 2, 1};
static int[] b8 = {3, 2, 2, 0, 3, 2, 2, 0, 2, 0, 0, 2, 3, 2, 2, 1};
static int[] b9 = {0, 2, 2, 1, 0, 2, 0, 0, 0, 3, 2, 2, 0, 3, 2, 2};
static int[] b10 = {2, 2, 2, 2, 2, 2, 2, 0, 2, 0, 0, 2, 1, 2, 2, 1};

static int[] z1 = {1, 2, 2, 1, 0, 0, 0, 2, 0, 0, 2, 1, 1, 2, 2, 1};
static int[] z2 = {1, 2, 2, 1, 0, 0, 2, 1, 0, 0, 2, 1, 1, 2, 2, 1};
static int[] z3 = {1, 2, 2, 2, 0, 0, 2, 1, 0, 0, 2, 1, 1, 2, 2, 2};
static int[] z4 = {1, 2, 2, 2, 0, 0, 2, 1, 0, 0, 2, 1, 1, 2, 2, 2};
static int[] z5 = {1, 2, 2, 1, 0, 1, 2, 1, 0, 0, 0, 2, 1, 2, 2, 1};
static int[] z6 = {1, 2, 3, 0, 1, 2, 3, 1, 0, 0, 0, 2, 2, 2, 2, 2};
static int[] z7 = {1, 2, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 1, 2, 2, 1};
static int[] z8 = {2, 2, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 2, 2, 2, 1};
static int[] z9 = {1, 2, 1, 0, 0, 2, 3, 0, 1, 2, 3, 0, 0, 0, 0, 0};
static int[] z10 = {1, 2, 2, 2, 0, 0, 2, 1, 0, 1, 2, 1, 1, 2, 2, 2};
```

### 1.2. TEST SAMPLE

<div align="center">

![Test Sample](resources/lab1/testSample.svg)

Picture 1.2.1 Test sample
</div>

<br>

We chose 4 images, based on them, we will check the operation of the program.
```
Y₁ = (3, 2, 2, 3, 3, 2, 2, 0, 2, 0, 2, 0, 3, 2, 3, 0);
Y₂ = (0, 0, 3, 0, 0, 0, 3, 1, 0, 0, 0, 2, 0, 0, 2, 2);
Y₃ = (1, 2, 0, 0, 2, 2, 0, 0, 2, 3, 0, 0, 0, 0, 0, 0);
Y₄ = (1, 2, 2, 2, 0, 2, 2, 2, 0, 0, 0, 2, 1, 2, 2, 1).
```

### 1.3. RESULTS

The program was developed in the Java programming language using the IntelliJ IDEA development environment. Picture 4 shows the results of the program.

<div align="center">

![Results](resources/lab1/results.svg)

Picture 1.3.1 The result of the program after 4 experiments
</div>

## LABORATORY WORK №2

**"Logical recognition. Dead End Test"**  

The task is to write a program and solve the recognition problem by calculating scores based on dead-end tests. Assess recognition accuracy.

### 2.1. INITIAL DATA

A training sample consisting of the following features:

```
private static final String[] AGE = {"Пожилой", "Средний", "Молодой"};
private static final String[] SEX = {"Мужской", "Женский"};
private static final String[] DISEASE_STAGE = {"Поздняя", "Начальная", "Средняя"};
private static final String[] SORE_SPOT = {"Голова", "Спина", "Живот", "Руки", "Ноги", "Отсутствует"};
private static final String[] TEMPERATURE = {"Пониженная", "Нормальная", "Незначительно повышенная", "Значительно повышенная"};
private static final String[] OTHER_SENSATIONS = {"Озноб", "Отсутствие аппетита", "Тошнота", "Отсутствуют"};
```

### 2.2. PROGRESS

Prepare a training sample of at least eight objects divided into two classes. Use as signs: age, gender, stage of the disease, sore spot, temperature, other sensations.  
To solve this problem, it was decided to write a small program that, for a specified number of patients, will select random feature values. The program code is part of the entire solution.  

The result of the code when the number of patients = 14 (Picture 2.2.1)

<div align="center">

![Training set](resources/lab2/trainingSet.svg)

Picture 2.2.1 Training set
</div>

<br>

Below is a comparison table (Picture 2.2.2.). For each patient from the first class (y1), a patient from the second class (y2) is matched (paired) and their factors are compared. If the factors match, then the corresponding cell is filled with zero.

<div align="center">

![Comparison table](resources/lab2/comparisonTable.svg)

Picture 2.2.2 Comparison table
</div>

<br>

Next, we define a list of dead-end tests (Picture 2.2.3.). To find them, we need to compare the columns of the comparison matrix in pairs. This can be done by generating combinations without repetitions 6 by 2. Then we cycle through each pair, comparing the two columns obtained by substituting both elements of the pair into array indices and see if there are no identical zero rows in both columns, then the indices of these columns are a dead end test.

<div align="center">

![Dead-end tests](resources/lab2/deadEndTests.svg)

Picture 2.2.3 Dead-end tests
</div>

<br>

Next, we enter the number of test patients (Picture 2.2.4.), for which the factors will also be randomly determined and, in accordance with the identified dead-end tests, each test patient is assigned to the first or second group (Picture 2.2.5).

<div align="center">

![Test sample](resources/lab2/testSample.svg)

Picture 2.2.4 Table of test patients
</div>

<br>

<div align="center">

![Patient prediction by group](resources/lab2/patientPrediction.svg)

Picture 2.2.5 Patient Prediction by Group
</div>

<br>

### 2.3. RESULTS