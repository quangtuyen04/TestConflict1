import java.util.Scanner

class StudentManager {
    private val students = mutableListOf<Student>()
    private var nextId = 1

    fun viewAllStudents() {
        if (students.isEmpty()) {
            println("No students found.")
        } else {
            println("List of students:")
            students.forEach { println(it) }
        }
    }

    fun addStudents(count: Int) {
        val scanner = Scanner(System.`in`)
        for (i in 1..count) {
            println("Enter details for student $i:")
            println("Name:")
            val name = scanner.nextLine()
            println("Gender:")
            val gender = scanner.nextLine()
            println("Subject:")
            val subject = scanner.nextLine()
            val student = Student(id = nextId++, name = name, gender = gender, subject = subject)
            students.add(student)
            println("Student added: $student")
        }
    }

    fun updateStudent(id: Int) {
        val student = students.find { it.id == id }
        if (student != null) {
            val scanner = Scanner(System.`in`)
            println("Enter new name:")
            student.name = scanner.nextLine()
            println("Enter new gender:")
            student.gender = scanner.nextLine()
            println("Enter new subject:")
            student.subject = scanner.nextLine()
            println("Student updated: $student")
        } else {
            println("Student with ID $id not found.")
        }
    }

    fun deleteStudent(id: Int) {
        val removed = students.removeIf { it.id == id }
        if (removed) {
            println("Student with ID $id deleted.")
        } else {
            println("Student with ID $id not found.")
        }
    }
}