package ru.levelp.at.kotlin.sample

class SomeClass {

    fun m() {
        println("m")
    }

    fun m(s: String): String {
        return if (s.contains("ssss")) {
            s.substring(10)
        } else {
            s
        }
    }

    fun mm(s: String): String =
        if (s.contains("ssss")) {
            s.substring(10)
        } else {
            s
        }
}
