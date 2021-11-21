package fr.pages.todolist.adapters


import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.pages.todolist.R
import fr.pages.todolist.TodoClickListener
import fr.pages.todolist.model.Todo
import kotlinx.android.synthetic.main.item_todo.view.*
import java.util.*


class AdapterTodoList(arrayTodo: ArrayList<Todo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var arrayTodoList: ArrayList<Todo> = arrayTodo
    private lateinit var todoListener : TodoClickListener

    fun setOnTodoClickListener(todoClickListener: TodoClickListener){
        todoListener = todoClickListener
    }

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return TodoListViewHolder(itemView, todoListener)
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is TodoListViewHolder -> {
                holder.bind(arrayTodoList[position])
            }
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return arrayTodoList.size
    }

    class TodoListViewHolder(itemView : View, todoListener: TodoClickListener) : RecyclerView.ViewHolder(itemView) {
        private val nameTodo = itemView.name_event_list
        private val checkBoxTodo = itemView.checkox_todo

        init{
            itemView.checkox_todo.setOnCheckedChangeListener { buttonView, isChecked ->
                todoListener.onTodoClickListener(adapterPosition, Todo(nameTodo.text as String,isChecked))
            }
        }
        fun bind(todo: Todo) {
            nameTodo.text = todo.title
            checkBoxTodo.isChecked = todo.state
            checkBoxTodo.setOnClickListener {
                if (checkBoxTodo.isChecked) {
                    nameTodo.paintFlags = nameTodo.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                } else {
                        nameTodo.paintFlags = 0
                    }
                }
            }
        }
    }