package fr.pages.todolist

import fr.pages.todolist.model.Todo

interface TodoClickListener {
        fun onTodoCheckBoxListener(position : Int, todo : Todo)
        fun onTodoClickListener(position : Int, todo : Todo)

}
