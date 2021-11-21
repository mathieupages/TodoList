package fr.pages.todolist.model

/**
 * Todo data class
 *
 * @param title name of the todo.
 * @param state true to be done, false it's done.
 */
data class Todo (val title : String, val state : Boolean)