project structure 

calculator-app/
├── pom.xml
├── Dockerfile
├── Jenkinsfile
├── k8s/
│   ├── deployment.yaml
│   └── service.yaml
├── terraform/
│   └── main.tf
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── calculator
    │   │               ├── CalculatorApplication.java
    │   │               ├── controller
    │   │               │   └── CalculatorApiController.java
    │   │               └── model
    │   │                   └── CalculatorRequest.java
    │   └── resources
    │       └── templates
    │           └── index.html
    └── test
        └── java
            └── com
                └── example
                    └── calculator
                        └── CalculatorApplicationTests.java
