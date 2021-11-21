package fr.pages.todolist

import fr.pages.todolist.model.Todo

interface TodoClickListener {
        fun onTodoClickListener(position : Int, todo : Todo)
}
