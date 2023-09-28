# Test driven development


In layman’s terms, Test Driven Development (TDD) is a software development practice that focuses on creating unit test cases before developing the actual code. It is an iterative approach combining programming, unit test creation, and refactoring.

The TDD approach originates from the Agile manifesto principles and Extreme programming.
As the name suggests, the test process drives software development.
Moreover, it’s a structuring practice that enables developers and testers to obtain optimized code that proves resilient in the long term.
In TDD, developers create small test cases for every feature based on their initial understanding. The primary intention of this technique is to modify or write new code only if the tests fail. This prevents duplication of test scripts.

## Three Phases of Test Driven Development
1. **Create precise tests**: Developers need to create exact unit tests to verify the functionality of specific features. They must ensure that the test compiles so that it can execute. In most cases, the test is bound to fail. This is a meaningful failure as developers create compact tests based on their assumptions of how the feature will behave.
2. **Correcting the Code**: Once a test fails, developers must make the minimal changes required to update the code to run successfully when re-executed.
3. **Refactor the Code**: Once the test runs successfully, check for redundancy or any possible code optimizations to enhance overall performance. Ensure that refactoring does not affect the external behavior of the program.


Best Practices for Test Driven Development (TDD)
Test-driven development (TDD) is a software development practice that emphasizes writing tests before writing the actual code. It follows a cyclical process of writing a failing test, writing the minimum code to make the test pass, and then refactoring the code. Here are some best practices to consider when practicing TDD:

Start with a clear understanding of requirements: Begin by understanding the requirements or specifications of the feature you are developing. This will help you write focused and relevant tests.
* Write atomic tests: Each test should focus on a specific behavior or functionality. Keep your tests small and focused, addressing a single aspect of the code. This improves test readability, maintainability, and allows for easier debugging.
* Write the simplest test case first: Begin by writing the simplest possible test case that will fail. This helps you focus on the immediate task and avoids overwhelming yourself with complex scenarios upfront.
* Write tests for edge cases: Consider boundary conditions and edge cases when designing your tests. These are inputs or scenarios that lie at the extremes of the input domain and often reveal potential bugs or unexpected behavior.
* Refactor regularly: After a test passes, take time to refactor the code and improve its design without changing its behavior. This helps maintain clean and maintainable code as the project progresses.
* Maintain a fast feedback loop: Your test suite should execute quickly so that you can receive immediate feedback on the health of your code. Fast feedback allows for faster development iterations and catches issues early on.
* Automate your tests: Utilize test automation frameworks and tools to automate the execution of your tests. This enables you to run tests frequently, easily integrate them into your development workflow, and ensure consistent and reliable test results.
* Follow the Red-Green-Refactor cycle: Adhere to the core TDD cycle of writing a failing test (Red), implementing the minimum code to pass the test (Green), and then refactoring the code to improve its design (Refactor). Repeat this cycle for each new behavior or feature.
* Maintain a comprehensive test suite: Aim to achieve a good balance between unit tests, integration tests, and acceptance tests. Each test type serves a different purpose and provides different levels of confidence in the code.
* Continuously run tests: Integrate your test suite with your development environment and set up continuous integration (CI) pipelines to automatically execute tests whenever code changes are made. This ensures that tests are run consistently and helps catch regressions early.
* Test failures should guide development: When a test fails, it should guide your development efforts. Analyze the failure, identify the cause, and fix the code to address the issue. Test failures are valuable feedback for improving code quality.

---> Basic example 
---> Good example here https://github.com/rafaelspinto/workshop-tdd-java#aaa-pattern
