## Project Structure

This project follows a layered architecture, using the Hexagonal Architecture pattern. The project structure is outlined below:

```bash
src/
├── main/
│   ├── java/
│   │   ├── com/
│   │   │   └── codeinbook/
│   │   │       ├── application/
│   │   │       │   ├── adapter/
│   │   │       │   │   ├── in/
│   │   │       │   │   │   └── [Input Adapters (APIs, controllers)]
│   │   │       │   │   └── out/
│   │   │       │   │       └── [Output Adapters (repository implementations, external services)]
│   │   │       │   └── configuration/
│   │   │       ├── domain/
│   │   │       │   ├── service/
│   │   │       │   │   └── [Application services]
│   │   │       │   └── port/
│   │   │       │       ├── in/
│   │   │       │       │   └── [Input ports (use cases, interfaces)]
│   │   │       │       └── out/
│   │   │       │           └── [Output ports (repository interfaces, gateways)]
│   │   │       ├── infrastructure/
│   │   │       │   ├── model/
│   │   │       │   │   └── [Domain entities]
│   │   │       │   ├── repository/
│   │   │       │   │   └── [Repository interfaces]
│   │   │       │   └── configuration/
│   │   │       │       └── [Infrastructure configurations]
│   │   │       └── common/
│   │   │           └── [Common components and utilities]
│   └── resources/
│       └── [Resources, configuration files]
└── test/
    └── [Unit and integration tests]
