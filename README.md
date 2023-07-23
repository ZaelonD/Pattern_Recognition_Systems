# This repository contains labs discipline "Image recognition systems"

## Contents

1. [LABORATORY WORK №1](#laboratory-work-1) \
   1.1. [INITIAL DATA](#11-initial-data)  
   1.2. [TEST SAMPLE](#TS)  
   1.3. [RESULTS](#RES)
2. [LABORATORY WORK №2](#LW2) \
   2.1. [INITIAL DATA](#ID)  
   2.2. [PROGRESS](#PR)  
   2.3. [RESULTS](#RES)
3. [LABORATORY WORK №3](#LW3) \
   3.1. [INITIAL DATA](#ID)  
   3.2. [OPERATION OF THE ALGORITHM](#OPALG)  
   3.3. [RESULTS](#RES)
4. [LABORATORY WORK №4](#LW4)  
   4.1. [INITIAL DATA](#ID)  
   4.2. [PROGRESS](#PR)  
   4.3. [RESULTS](#RES)

<div align="center">

## LABORATORY WORK №1

</div>

**"Statistical recognition. Bayesian classification"**  
Write a program and solve a similar Bayesian classification problem. Assess recognition accuracy.

### 1.1. INITIAL DATA

Let there be a training set of letters "B" and "Z", given in Capture 1. Each object is represented as an 8×8 black and
white image.

<div align="center">

![Capture 1](resources/trainingSet.svg)
</div>

<div align="center">
Picture 1. Training set
</div>

The features are the average sizes of 2 × 2 image fragments (Picture 2), i.e. the feature vector has the form:
x = (x₁, x₂, x₃, x₄, x₅, x₆, x₇, x₈, x₉, x₁₀, x₁₁, x₁₂, x₁₃, x₁₄, x₁₅, x₁₆).

<div align="center">

![Arrow](resources/arrow.svg)

</div>

<!DOCTYPE html>
<html lang="en">
<head>
  <style>
    body {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    table {
      border-collapse: collapse;
    }
    td {
      width: 30px;
      height: 30px;
      border: 1px solid black;
    }
  </style>
</head>
<body>
  <table>
    <tbody>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <!-- Repeat the above row for each row in the table -->
    </tbody>
  </table>
</body>
</html>

