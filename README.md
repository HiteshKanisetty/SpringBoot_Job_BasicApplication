# Job Management Application

A simple Spring Boot web application for managing job postings. This application allows users to add, view, edit, and delete job listings through a web interface.

## Features

- 🏠 Home page with navigation
- ➕ Add new job postings
- 📋 View all job listings
- ✏️ Edit existing jobs
- ❌ Delete jobs
- Responsive web interface using Thymeleaf templates

## Tech Stack

- **Backend**: Spring Boot 4.0.5
- **Language**: Java 21
- **Database**: MySQL
- **ORM**: Spring Data JPA
- **Frontend**: Thymeleaf templates
- **Build Tool**: Maven
- **Dependencies**: Lombok for boilerplate code reduction

## Prerequisites

Before running this application, make sure you have the following installed:

- Java 21 or higher
- Maven 3.6+
- MySQL 8.0+
- Git (for cloning the repository)

## Database Setup

1. Install and start MySQL server
2. Create a database named `jobdb`:
   ```sql
   CREATE DATABASE jobdb;
   ```
3. Update the database credentials in `src/main/resources/application.properties` if needed:
   ```
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

## Installation & Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/job-management-app.git
   cd job-management-app
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

   Or run the JAR file:
   ```bash
   java -jar target/Basic-0.0.1-SNAPSHOT.jar
   ```

4. **Access the application**:
   Open your browser and navigate to `http://localhost:8080`

## Usage

### Navigation
- **Home**: Navigate to the home page
- **Add Job**: Create a new job posting
- **View Jobs**: See all existing job listings
- **Edit**: Modify job details
- **Delete**: Remove a job posting

### Job Fields
- **Title**: Job position title
- **Company**: Company name
- **Location**: Job location
- **Description**: Detailed job description
- **Job Type**: Type of employment (e.g., Full-time, Part-time)
- **Skills**: Required skills (multiple skills supported)

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/JobProj/Basic/
│   │       ├── BasicApplication.java          # Main application class
│   │       ├── Controller/
│   │       │   └── JobController.java         # Web controller
│   │       ├── model/
│   │       │   └── Job.java                   # JPA entity
│   │       ├── repo/
│   │       │   └── JobRepository.java         # Data repository
│   │       └── Service/
│   │           └── JobService.java            # Business logic
│   └── resources/
│       ├── application.properties             # Configuration
│       └── templates/                         # Thymeleaf templates
│           ├── home.html
│           ├── addJob.html
│           ├── viewJob.html
│           └── edit-job.html
└── test/
    └── java/
        └── com/JobProj/Basic/
            └── BasicApplicationTests.java     # Test class
```

## API Endpoints

- `GET /` - Home page
- `GET /addJob` - Add job form
- `POST /saveJob` - Save new job
- `GET /viewJobs` - View all jobs
- `GET /deleteJob/{id}` - Delete job by ID
- `GET /editJob/{id}` - Edit job form
- `POST /updateJob` - Update job

## Development

### Running Tests
```bash
mvn test
```

### Building for Production
```bash
mvn clean package
```

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Built with Spring Boot
- Uses Thymeleaf for server-side rendering
- MySQL for data persistence</content>
<parameter name="filePath">d:/Spring/Basic/README.md