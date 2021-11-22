package fr.pages.todolist.model

/**
 * Todo data class
 *
 * @param title name of the Todo.
 * @param description description of the Todo.
 * @param state true to be done, false it's done.
 */
data class Todo (val title : String, val description : String, val state : Boolean)