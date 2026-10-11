# SudhaBelur

**A boutique tailoring and embroidery service platform based in Belur, Hassan, Karnataka, India.**

SudhaBelur is a web application designed to showcase tailoring services and clothing categories while allowing customers to request appointments online. It also provides an administrative workspace to manage products, availability, and appointment requests.

The platform focuses on a simple, elegant customer experience and a secure, maintainable backend.

## Table of Contents

- [Overview](#overview)
- [Objectives](#objectives)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Architecture](#architecture)
- [Product Categories](#product-categories)
- [Appointment Workflow](#appointment-workflow)
- [Database](#database)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Development Status](#development-status)
- [Security](#security)
- [Future Improvements](#future-improvements)

## Overview

SudhaBelur brings a traditional tailoring business online through a dedicated website.

Customers can explore clothing categories, view product details, check availability, and submit appointment requests. The administrator can manage the product catalogue and review appointment requests.

The platform is designed around **service appointments rather than conventional e-commerce transactions**.

### Business Model

- Service-based tailoring and embroidery business.
- Online product and service catalogue.
- Appointment requests submitted through the website.
- Manual appointment approval or rejection by the administrator.
- No online payment processing in the initial version.
- No automated delivery or shipping system in the initial version.

## Objectives

1. Establish a professional online presence for SudhaBelur.
2. Showcase available clothing and tailoring categories.
3. Simplify appointment requests for customers.
4. Provide centralized product and availability management.
5. Give the administrator a dedicated workspace for handling appointments.
6. Build a secure, maintainable application that can grow with the business.

## Features

### Customer Features

- Homepage introducing the brand and its services.
- Product catalogue organized by clothing category.
- Product details, descriptions, pricing, and availability.
- Support for multiple images per product.
- Appointment requests associated with selected products.
- Customer name and phone number collection during booking.
- Appointment status visibility, where implemented.
- Contact information and frequently asked questions.
- Responsive interface for desktop and mobile devices.

### Administrator Features

- Secure administrator authentication.
- Product creation, editing, and deletion.
- Product availability management.
- Product pricing and description management.
- Appointment request management.
- Ability to approve or reject appointment requests.
- Access to relevant appointment details through the administrative workspace.

### Product Availability

Each product has an availability status.

- **Available:** Customers can request an appointment.
- **Unavailable:** The product is marked unavailable in the catalogue.
- **Price not provided:** The price may remain blank rather than displaying an invented value.

### Account Management

The planned customer account functionality includes account deletion and removal of associated account information and appointment records, subject to the application's final data-retention rules.

## Technology Stack

| Component | Technology |
|---|---|
| Frontend | Next.js |
| Frontend language | TypeScript |
| Backend | Java |
| Backend framework | Spring Boot |
| Database | PostgreSQL |
| ORM | Spring Data JPA / Hibernate |
| Build tool | To be confirmed |
| Version control | Git and GitHub |

The frontend communicates with the backend through REST APIs. PostgreSQL stores application data, while Spring Data JPA and Hibernate provide persistence and database interaction.

## Architecture

The application follows a frontend-backend architecture.

```text
Customer / Administrator
          |
          v
     Next.js Frontend
          |
          | HTTP / REST API
          v
     Spring Boot Backend
          |
          v
      Spring Data JPA
          |
          v
       PostgreSQL
```

### Frontend

Responsible for:

- Rendering the homepage and catalogue.
- Displaying product details and availability.
- Collecting appointment requests.
- Presenting appointment status and administrative interfaces.
- Communicating with backend APIs.

### Backend

Responsible for:

- Processing REST API requests.
- Validating product and appointment data.
- Applying business rules.
- Managing product and appointment operations.
- Enforcing authentication and authorization.
- Persisting application data.

### Database

PostgreSQL stores structured information such as products, customer accounts, appointments, and administrative data as the relevant modules are implemented.

## Product Categories

The catalogue supports the following categories:

1. Blouse
2. Kurti
3. Lehenga
4. Gown
5. Saree
6. Salwar Suit
7. Women Wear

Category values are represented in the backend using a Java enum and are constrained by the database schema.

## Appointment Workflow

The intended appointment workflow is:

1. A customer browses the catalogue.
2. The customer selects a product.
3. The customer submits an appointment request with the required contact details.
4. The backend validates the request and stores it.
5. The administrator reviews the request.
6. The administrator approves or rejects it.
7. The customer can view the appointment status when that functionality is available.

Appointment requests are subject to manual confirmation. Submitting a request does not automatically guarantee a confirmed appointment.

## Database

### Products Table

The initial PostgreSQL schema contains a `products` table.

| Column | Type | Purpose |
|---|---|---|
| `id` | `BIGINT` | Primary key |
| `name` | `VARCHAR(255)` | Product name |
| `category` | `VARCHAR(255)` | Product category |
| `description` | `VARCHAR(255)` | Product description |
| `price` | `NUMERIC(38,2)` | Product price |
| `available` | `BOOLEAN` | Availability status |
| `created_at` | `TIMESTAMP` | Creation timestamp |
| `updated_at` | `TIMESTAMP` | Last update timestamp |

The `id` column uses an identity-based generation strategy. A database check constraint restricts the category to the supported values.

Additional tables for customers, appointments, authentication, and product images should be documented as their actual schemas are finalized.

## Getting Started

### Prerequisites

Install the following tools:

- Java Development Kit compatible with the project's Spring Boot version.
- Node.js and npm.
- PostgreSQL.
- Git.
- An IDE such as IntelliJ IDEA or Visual Studio Code.

### 1. Clone the Repository

```bash
git clone <YOUR_REPOSITORY_URL>
cd SudhaBelur
```

Replace the placeholder with the actual repository URL.

### 2. Configure PostgreSQL

Create or use the existing `sudhabelur` database.

Configure the backend database connection using environment variables or your local application configuration.

Example environment variables:

```env
DB_URL=jdbc:postgresql://localhost:5432/sudhabelur
DB_USERNAME=your_database_username
DB_PASSWORD=your_database_password
```

Use the actual environment variable names expected by your Spring Boot configuration. Do not commit database credentials to Git.

### 3. Run the Backend

Navigate to the backend directory:

```bash
cd backend
```

Run the application using the build tool configured in the project.

For a Maven project:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The wrapper commands assume that Maven Wrapper files exist in the backend directory.

### 4. Run the Frontend

Open a separate terminal and navigate to the frontend directory.

```bash
cd frontend
npm install
npm run dev
```

The frontend directory and scripts must match the actual repository structure. Configure the frontend's API base URL to point to the running backend.

## Project Structure

The intended logical structure is:

```text
SudhaBelur/
├── frontend/
│   ├── app/
│   ├── components/
│   ├── public/
│   └── package.json
│
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   └── resources/
│   │   └── test/
│   └── pom.xml
│
├── .gitignore
└── README.md
```

This is a proposed logical layout, not a verified listing of the current repository. Update it to reflect the actual folder structure before publishing.

## Development Status

### Implemented

- PostgreSQL installed and configured locally.
- `sudhabelur` database created and accessible.
- Spring Boot backend initialized and connected to PostgreSQL.
- Product entity created.
- Product category enum created.
- Product table generated and verified in PostgreSQL.
- Product repository created.

### Planned / Remaining

- Product service layer.
- Product REST controller and endpoint validation.
- Product catalogue integration with the frontend.
- Product image management.
- Appointment entity, repository, service, and controller.
- Customer account functionality.
- Administrator authentication and authorization.
- Appointment approval and rejection.
- Customer-facing appointment status.
- Input validation and error handling.
- Automated tests.
- Production deployment and environment configuration.

Update this section as each feature is completed. A feature should be marked implemented only after it has been built and tested.

## Security

Security is a core requirement for the administrative functionality.

Planned safeguards include:

- Secure password hashing.
- Server-side authentication and role-based authorization.
- Two-factor authentication for the administrator.
- Validation of incoming API requests.
- Protection against unauthorized product and appointment modifications.
- Secure handling of database credentials.
- Appropriate CORS configuration.
- Safe account deletion and data-retention handling.
- Production HTTPS and secure session or token management.

Security features should be verified through tests before the application is deployed publicly.

## Future Improvements

Potential improvements, depending on business needs, include:

- Enhanced product image galleries.
- Appointment reminders.
- Better appointment calendar management.
- Improved customer communication.
- Analytics for appointment activity.
- Additional language support.
- Production monitoring, backups, and recovery procedures.
- Additional services and catalogue categories.

These are possible extensions, not commitments to implement every feature.

## Contributing

This repository is currently under active development. Changes should be tested locally before being merged into the main branch.

## License

No license has been specified yet. Add an appropriate license before allowing external reuse or contributions.

---

**SudhaBelur**  
Belur, Hassan, Karnataka, India

*A digital presence for traditional tailoring and embroidery services.*
