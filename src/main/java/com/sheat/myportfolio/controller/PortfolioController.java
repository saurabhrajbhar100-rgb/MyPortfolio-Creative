package com.sheat.myportfolio.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sheat.myportfolio.model.Project;
import com.sheat.myportfolio.model.Skill;

@Controller
public class PortfolioController {

    // ---------------------------------------------------------------
    // ROUTES  ("/" and "/portfolio/creative" show the same portfolio)
    // ---------------------------------------------------------------

    @GetMapping({"/", "/portfolio/creative"})
    public String creative(Model model) {
        addPersonalData(model);
        return "creative";
    }

    // ---------------------------------------------------------------
    // SHARED DATA - every design reads the same values from here.
    // Edit this method to update all three portfolios at once.
    // ---------------------------------------------------------------

    private void addPersonalData(Model model) {

        // ---- Hero ----
        model.addAttribute("name", "Saurabh Rajbhar");
        model.addAttribute("firstName", "Saurabh");
        model.addAttribute("lastName", "Rajbhar");
        model.addAttribute("title", "Aspiring Java Backend Developer");
        model.addAttribute("tagline",
                "BCA student from Varanasi learning to build reliable web applications "
                + "with Java, Spring Boot and MySQL.");

        // Put your photo in static/images and change this path to use it.
        model.addAttribute("profileImage", "/images/sss.jpg");

        // ---- About ----
        List<String> aboutParagraphs = List.of(
                "I am a Bachelor of Computer Applications (BCA) student at SHEAT College of "
                + "Engineering and Management in Varanasi. I enjoy understanding how software "
                + "works behind the screen, which is why Java and web development caught my interest.",
                "My programming journey started with C and C++, moved on to Java, and then to HTML, "
                + "CSS and JavaScript for the web. Now I am learning Spring Boot and MySQL by building "
                + "small applications, and I also like working on Arduino electronics projects.",
                "My goal is to start my career as a Java Backend Developer and keep improving through "
                + "real projects. Away from the keyboard, I like reading books, playing cricket and "
                + "hiking in the mountains.");
        model.addAttribute("aboutParagraphs", aboutParagraphs);
        model.addAttribute("hobbies",
                List.of("Reading books", "Playing cricket", "Hiking in the mountains"));
        model.addAttribute("careerGoal", "Java Backend Developer");

        // ---- Education ----
        model.addAttribute("degree", "Bachelor of Computer Applications (BCA)");
        model.addAttribute("college", "SHEAT College of Engineering and Management");
        model.addAttribute("educationPeriod", "BCA-3YEAR");

        // ---- Contact ----
        model.addAttribute("location", "Varanasi, Uttar Pradesh, India");
        model.addAttribute("email", "saurabhrajbhar100@gmail.com");
        model.addAttribute("github", "https://github.com/saurabhrajbhar100-rgb/MyPortfolio-Creative");
        model.addAttribute("githubUsername", "https://github.com/saurabhrajbhar100-rgb");
        // Add a real LinkedIn URL here to show it. While it is null it stays hidden.
        model.addAttribute("linkedin", null);

        // ---- Skills ----
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Java", "Languages", "Core language for backend development"));
        skills.add(new Skill("C", "Languages", "Programming fundamentals and logic building"));
        skills.add(new Skill("C++", "Languages", "Object-oriented programming practice"));

        skills.add(new Skill("HTML", "Web", "Page structure and semantic markup"));
        skills.add(new Skill("CSS", "Web", "Layouts, styling and responsive design"));
        skills.add(new Skill("JavaScript", "Web", "Page interactivity and Node.js basics"));

        skills.add(new Skill("Spring Boot", "Backend", "Controllers, Thymeleaf views and Maven builds"));
        skills.add(new Skill("MySQL", "Backend", "Relational tables and SQL queries"));

        skills.add(new Skill("Git", "Tools", "Version control for my projects"));
        skills.add(new Skill("GitHub", "Tools", "Hosting and sharing code repositories"));
        model.addAttribute("skills", skills);

        // Same skills grouped by category (used by the Minimal design)
        Map<String, List<Skill>> skillsByCategory = new LinkedHashMap<>();
        for (Skill skill : skills) {
            skillsByCategory.computeIfAbsent(skill.getCategory(), key -> new ArrayList<>()).add(skill);
        }
        model.addAttribute("skillsByCategory", skillsByCategory);

        // ---- Projects ----
        // repoUrl is null on purpose: add the real GitHub link when the repository is available.
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("Student Management System", "Web application",
                "A web application for managing student records. I built it to practise Spring Boot, "
                + "MVC structure and connecting an application to a MySQL database.",
                List.of("Java", "Spring Boot", "MySQL"), null));
        projects.add(new Project("FolioBase \u2013 Portfolio Maker", "Web application",
                "A portfolio maker that helps people create a personal portfolio page. "
                + "It is built with front-end technologies and a Node.js back end.",
                List.of("HTML", "CSS", "JavaScript", "Node.js"), null));
        projects.add(new Project("Smart Irrigation System", "Electronics project",
                "An Arduino-based project that automates watering for plants, "
                + "built to learn how electronic components and code work together.",
                List.of("Arduino", "Electronics"), null));
        projects.add(new Project("Home Automation System", "Electronics project",
                "An Arduino-based project for controlling home appliances automatically, "
                + "built to practise circuits and microcontroller programming.",
                List.of("Arduino", "Electronics"), null));
        model.addAttribute("projects", projects);

        // ---- Footer ----
        model.addAttribute("year", Year.now().getValue());
    }
}
