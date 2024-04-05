function showCourseOptions() {
    document.getElementById("courseOptions").style.display = "block";
}

function selectCourse(courseSelect) {
    var selectedCourse = courseSelect.options[courseSelect.selectedIndex].text;
    document.getElementById("courseInput").value = selectedCourse;
    document.getElementById("courseOptions").style.display = "none";
}