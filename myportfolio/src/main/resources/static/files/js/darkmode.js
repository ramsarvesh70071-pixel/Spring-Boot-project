function toggleTheme() {
    let body = document.getElementById("theme");

    if (body.classList.contains("bg-light")) {
        body.classList.remove("bg-light");
        body.classList.add("bg-dark", "text-white");
        localStorage.setItem("theme", "dark");
    } else {
        body.classList.remove("bg-dark", "text-white");
        body.classList.add("bg-light");
        localStorage.setItem("theme", "light");
    }
}

window.onload = () => {
    const saved = localStorage.getItem("theme");
    if (saved === "dark") {
        let body = document.getElementById("theme");
        body.classList.remove("bg-light");
        body.classList.add("bg-dark", "text-white");
    }
};
