package com.example.nootkeeper_kotlin

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses(){
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "android_async", title = "Android Async Programing and Services")
        courses.set(course.courseId, course)

        course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang")
        courses.set(course.courseId, course)

        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
        courses.set(course.courseId, course)
    }

    private fun initializeNotes() {
        var note = NoteInfo(courses.getValue("android_intents"),
            "Dynamic intent resolution",
            "Wow, intents allow componenets to be resovled at runtime")
        notes.add(note)

        note = NoteInfo(courses.getValue("android_intents"),
            "Delegating intents",
            "PendingIntents are powerful: they delegate much more than just a component invocation")
        notes.add(note)

        note = NoteInfo(courses.getValue("android_intents"),
            "Service default threads",
            "Did you know that by default an Android Service will tie up the UI thread?")
        notes.add(note)

        note = NoteInfo(courses.getValue("android_intents"),
            "Long running operations",
            "Foreground Services can be tied to a notification icon")
        notes.add(note)

        note = NoteInfo(courses.getValue("java_lang"),
            "Parameters",
            "Leverage variable-length parameter lists")
        notes.add(note)

        note = NoteInfo(courses.getValue("java_lang"),
            "Anonymous classes",
            "Anonymous classes simplify implmenting one-use type")
        notes.add(note)

        note = NoteInfo(courses.getValue("java_lang"),
            "Compiler options",
            "The -jar option isn't compatible with the -cp option")
        notes.add(note)
    }


}