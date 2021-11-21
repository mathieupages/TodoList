package fr.pages.todolist.data

import fr.pages.todolist.model.Todo
import java.util.*

/**
 *  Todo Data
*/
class TodoSource {

    companion object{

        fun createDataSet() : ArrayList<Todo> {

            val list = ArrayList<Todo>()
            list.add(
                Todo("Faire le todo",false)
            )
            list.add(
                Todo("Se faire embaucher",false)
            )
            list.add(
                Todo("Devenir millionaire",false)
            )
            list.add(
                Todo("Partir à la retraite",false)
            )
            list.add(
                Todo("Faire les courses",false)
            )

            return list
        }
    }
}