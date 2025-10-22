# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview
This is a LeetCode practice repository containing data structures and algorithms implementations in Java and Kotlin. The project is organized as a Gradle multi-module build with a focus on algorithmic problem-solving and educational content.

## Project Structure
- `code/` - Main module containing all algorithm implementations
  - `array/` - Array manipulation problems (two-pointers, sliding window)
  - `hashmap/` - Hash table problems and collision resolution techniques
  - `linklist/` - Linked list operations (reversal, cycle detection, merging)
  - `string/` - String manipulation algorithms
  - `tree/` - Binary trees, BST, heap implementations
  - `sort/` - Sorting algorithms (comparison-based and linear)
  - `stack/` - Stack data structure and applications
  - `queue/` - Queue implementations (array-based, linked)
  - `search/` - Search algorithms including binary search
  - `recursive/` - Recursive problem solutions
  - `nowcoder/` - HuaWei online judge problems (HJ series)
- `app/` - Android application module (currently commented out in settings)

## Build System
The project uses Gradle with Kotlin DSL:
- **Build**: `./gradlew build`
- **Clean**: `./gradlew clean` 
- **Compile**: `./gradlew classes`
- **Test**: `./gradlew test`
- **Run individual files**: Use IDE run configurations or compile specific classes

## Code Conventions
- **Languages**: Mixed Java and Kotlin codebase
- **Java version**: 17 (both source and target compatibility)
- **Kotlin target**: JVM 17
- **Package structure**: `com.hsicen.code.<category>`
- **Naming**: Solution classes typically follow pattern `Solution{ProblemNumber}` or descriptive names
- **Documentation**: Each solution includes problem description, examples, and constraints in comments
- **Main methods**: Most solution classes include main() methods with test cases

## Common Patterns
- **Two-pointer technique**: Used extensively in array and string problems
- **Object declarations**: Kotlin solutions often use `object` for singleton pattern
- **Test cases**: Included directly in main() methods with sample inputs/outputs
- **Algorithm categories**: Clearly separated by data structure type and problem category

## Key Files
- `code/src/main/java/com/hsicen/code/hashmap/readMe.md` - Hash table theory and collision resolution
- `code/src/main/java/com/hsicen/code/sort/compare/readMe.md` - Comparison sorting algorithms overview
- Various `Test.java` files in each category for running multiple solutions

## Running Solutions
Individual algorithm solutions can be executed through their main() methods. The codebase is designed for educational purposes with comprehensive examples and explanations embedded in the code.