# SpringBoot-MyPortfolio-Creative

A personal portfolio website in the **Creative Personal** design, built with **Java, Spring Boot and Thymeleaf**.
All portfolio content (name, about text, skills, projects, contact details) is created in the Java controller and
rendered by Thymeleaf templates. There is no hard-coded content in the HTML.

This is my individual practical project for **SHEAT Skill Lab**.

## About the project

| | |
|---|---|
| **Developer** | Saurabh Rajbhar |
| **Course** | Bachelor of Computer Applications (BCA) |
| **College** | SHEAT College of Engineering and Management, Varanasi |
| **Goal** | Aspiring Java Backend Developer |
| **GitHub** | https://github.com/saurabhrajbhar100-rgb/MyPortfolio-Creative |

## Technologies used

- Java 17 or newer
- Spring Boot 4.1.2 (Spring Web MVC)
- Thymeleaf
- HTML5, CSS3, JavaScript
- Maven (Maven Wrapper included)
- Docker (for deployment on Render)

## Features

- `Skill` and `Project` model classes, Lists built in `PortfolioController`, rendered with `th:each`
- Reusable Thymeleaf fragments (`fragments/layout.html`): technology tags, footer, script include
- Responsive layout with a mobile menu (`script.js`)
- Placeholders for details that are not added yet (email, LinkedIn, batch years, repository links)
- Ready for GitHub and Render (Dockerfile + `PORT` support)

## Design: Creative Personal

Warm cream background, maroon and coral. Floating pill navbar, huge stacked name, arch photo frame, tilted skill stickers, alternating project rows and a bold contact block.

Routes: `/` and `/portfolio/creative` both show this portfolio.

## Project structure

```text
SpringBoot-MyPortfolio-Creative/
├── pom.xml
├── mvnw / mvnw.cmd
├── Dockerfile
├── README.md
├── .gitignore
├── .mvn/wrapper/maven-wrapper.properties
└── src/
    ├── main/
    │   ├── java/com/sheat/myportfolio/
    │   │   ├── MyPortfolioApplication.java
    │   │   ├── controller/PortfolioController.java
    │   │   └── model/ Skill.java  Project.java
    │   └── resources/
    │       ├── application.properties
    │       ├── templates/ creative.html  fragments/layout.html
    │       └── static/
    │           ├── css/ style.css  creative.css
    │           ├── js/script.js
    │           └── images/ profile-placeholder.svg  favicon.svg
    └── test/java/com/sheat/myportfolio/MyPortfolioApplicationTests.java
```

## Run locally

**Requirements:** JDK 17 or newer. Maven is optional because the Maven Wrapper is included.

```powershell
# Windows
.\mvnw.cmd spring-boot:run
```

```bash
# Linux / macOS
./mvnw spring-boot:run
```

Open http://localhost:8080

### Maven commands

```bash
./mvnw clean test       # run the tests
./mvnw clean package    # build target/myportfolio-creative-0.0.1-SNAPSHOT.jar
java -jar target/myportfolio-creative-0.0.1-SNAPSHOT.jar  # run the built jar
```

On Windows use `.\mvnw.cmd` instead of `./mvnw`.

## Update your information

Everything is in one method: `addPersonalData()` in
`src/main/java/com/sheat/myportfolio/controller/PortfolioController.java`.

- **Email:** replace `"Not provided yet"` with your real email.
- **LinkedIn:** replace `null` with your real profile URL. While it is `null`, the LinkedIn row is hidden.
- **Photo:** copy your photo into `src/main/resources/static/images/` and change `profileImage` to `"/images/your-photo.jpg"`.
- **Repository links:** replace the `null` in each `new Project(...)` with the real GitHub URL.
- **Batch years:** edit `educationPeriod`.
- **Project descriptions** are general student-level summaries. Edit them so they match what you actually built.

## Links

- GitHub repository: `https://github.com/roshangupta7755/SpringBoot-MyPortfolio-Creative` *(add after you create the repository)*
- Live website: `https://<your-render-service>.onrender.com` *(add after deployment)*

## Deployment

### 1. Push to GitHub

Create an empty repository on GitHub, then:

```bash
cd SpringBoot-MyPortfolio-Creative
git init
git add .
git commit -m "Initial commit: Creative Personal portfolio"
git branch -M main
git remote add origin https://github.com/roshangupta7755/SpringBoot-MyPortfolio-Creative.git
git push -u origin main
```

### 2. Deploy on Render

1. Sign in to https://render.com and click **New** > **Web Service**.
2. Connect GitHub and select the `SpringBoot-MyPortfolio-Creative` repository.
3. Set **Language / Runtime** to **Docker** (Render finds the `Dockerfile`).
4. Choose the **Free** instance type and click **Create Web Service**.
5. Open the `.onrender.com` URL when the build finishes.

No environment variables are needed: the app reads Render's `PORT` (`server.port=${PORT:8080}`).
Free instances sleep after inactivity, so the first visit can take about a minute.

---

*Developer: Roshan Gupta, BCA, SHEAT College of Engineering and Management.*
