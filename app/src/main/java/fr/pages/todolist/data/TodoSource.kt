package fr.pages.todolist.data

import fr.pages.todolist.model.Todo
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 *  Todo Data class
*/
class TodoSource {
    companion object{

        /* list of Todo. */
        val list = ArrayList<Todo>()

        /**
         * Create a list of Todo.
         */
        fun createDataSet() : ArrayList<Todo> {


            list.add(
                Todo("Faire le todo","Faire le todo pour pouvoir passer l'entretien technique et essayer de faire bonne impression",false)
            )
            list.add(
                Todo("Se faire embaucher","Se faire embaucher afin de gagner plein d'argent et pour pouvoir en dépenser plein",false)
            )
            list.add(
                Todo("Devenir millionaire","Devenir millionnaire pour ne plus à avoir besoin de travailler",false)
            )
            list.add(
                Todo("Partir à la retraite","Profiter de la retraite pour partir en voyage et faire beaucoup de choses",false)
            )
            list.add(
                Todo("Faire les courses","Faire les courses pour faire des cookies",false)
            )

            return list
        }

        /**
         * Add an element.
         */
        fun addTodo(todo : Todo){
            list.add(todo)
        }

        /**
         * Get the list of Todo.
         */
        fun getListTodo(): ArrayList<Todo>{
            return list
        }
    }
}