package fr.pages.todolist.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import fr.pages.todolist.R
import fr.pages.todolist.activities.MainActivity
import fr.pages.todolist.activities.TodoDescriptionActivity
import fr.pages.todolist.data.TodoSource
import fr.pages.todolist.model.Todo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_create_todo.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateTodoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateTodoFragment : Fragment() {

    /* Default state of todo. */
    private val DEFAULT_STATE: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cancel_create_todo_fragment.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

        valider_create_todo_fragment.setOnClickListener {
            if (checkValidTodo()) {
                alertDialogConfirmCreateTodo()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_todo, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment CreateTodoFragment.
         */
        @JvmStatic
        fun newInstance() =
                CreateTodoFragment().apply {}
    }

    /**
     * Checks if the todo creation is valid.
     */
    private fun checkValidTodo(): Boolean {
        if(editText_create_title_fragment.text.isNotEmpty()){
            return true
        }
        title_required_create_todo_fragment.text = getString(R.string.title_is_required)
        return false
    }

    /**
     * Alert dialog to confirm the creation of the todo.
     */
    private fun alertDialogConfirmCreateTodo(){
        val builder = context?.let { it1 -> AlertDialog.Builder(it1) }
        if (builder != null) {
            builder.setMessage(R.string.message_validation_create_todo_fragment)
                .setCancelable(false)
                .setPositiveButton(R.string.yes) { _, _ ->
                    TodoSource.addTodo(
                            Todo(editText_create_title_fragment.text.toString(),
                                editText_create_description_fragment.text.toString(),
                                DEFAULT_STATE
                            )
                    )
                    val intent = Intent(context, MainActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton(R.string.no) { dialog, _ ->
                    // Dismiss the dialog
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()
        }
    }
}