# PG4200 Exam - Sorting Algorithms (Java)
A Java **Data Structures & Algorithms** exam project that loads two wine-quality datasets, extracts unique alcohol values, and benchmarks multiple sorting algorithms on both **original** and **shuffled** unput order.

## What it does
- Loads alcohol values from:
  - `src/main/resources/winequality-red.csv`
  - `src/main/resources/winequality-white.csv`
- Builds a **unique** list of alcohol values 
- Runs and prints timing + comparison stats for:
  - **Bubble Sort** (unoptimized & optimized)
  - **Insertion Sort**
  - **Merge Sort**
  - **Quick Sort** (first / last / random pivot)

## Algorithms included

- `BubbleSort` — `sort()` and `sortOptimized()`
- `InsertionSort`
- `MergeSort`
- `QuickSort` — pivot variants: first, last, random
- `DataLoader` — CSV parsing (extracts the `alcohol` column)

## Quick Start

### Prerequisites
- **Java**: openjdk-24
- **Maven** 

### Run (recommended)
Run `Main.java` 
