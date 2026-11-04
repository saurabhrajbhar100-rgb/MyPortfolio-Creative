// Shared by all three designs.
// 1. Opens and closes the navigation menu on small screens.
// 2. Marks the navigation link of the section you are reading.
// Every query is checked first, so a design without these elements still works.

(function () {
  "use strict";

  var toggle = document.querySelector("[data-nav-toggle]");
  var links = document.querySelector("[data-nav-links]");

  function setMenu(open) {
    if (!toggle || !links) return;
    links.classList.toggle("is-open", open);
    toggle.setAttribute("aria-expanded", open ? "true" : "false");
  }

  if (toggle && links) {
    toggle.addEventListener("click", function () {
      setMenu(!links.classList.contains("is-open"));
    });

    // close the menu after tapping a link
    links.querySelectorAll("a").forEach(function (link) {
      link.addEventListener("click", function () {
        setMenu(false);
      });
    });

    // close the menu with the Escape key
    document.addEventListener("keydown", function (event) {
      if (event.key === "Escape") setMenu(false);
    });
  }

  // Highlight the link of the section that is currently on screen
  var navLinks = document.querySelectorAll("[data-nav-links] a[href^='#']");
  if (navLinks.length && "IntersectionObserver" in window) {
    var byId = {};
    navLinks.forEach(function (link) {
      byId[link.getAttribute("href").slice(1)] = link;
    });

    var observer = new IntersectionObserver(
      function (entries) {
        entries.forEach(function (entry) {
          if (!entry.isIntersecting) return;
          navLinks.forEach(function (link) {
            link.classList.remove("is-active");
          });
          var active = byId[entry.target.id];
          if (active) active.classList.add("is-active");
        });
      },
      { rootMargin: "-40% 0px -55% 0px" }
    );

    Object.keys(byId).forEach(function (id) {
      var section = document.getElementById(id);
      if (section) observer.observe(section);
    });
  }
})();
