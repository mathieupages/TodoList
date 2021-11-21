package fr.pages.todolist.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import fr.pages.todolist.adapters.AdapterTodoList
import fr.pages.todolist.data.TodoSource
import fr.pages.todolist.databinding.ActivityMainBinding
import fr.pages.todolist.model.Todo
import kotlinx.android.synthetic.main.activity_main.*
import fr.pages.todolist.TodoClickListener


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    /* Create a list of Todo. */
    private val listTodo = TodoSource.createDataSet()
    /* Used for send the title to the second activity*/
    val TITLE_TODO = "title"
    /* Used for send the title to the second activity*/
    val DESCRIPTION_TODO = "description"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.addTodo.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        list_todo.apply{
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            val mAdapter = AdapterTodoList(listTodo)
            mAdapter.setOnTodoClickListener(object : TodoClickListener {
                override fun onTodoCheckBoxListener(position: Int, todo: Todo) {
                    /* Changes the item position. */
                    if (todo.state) {
                        listTodo.removeAt(position)
                        listTodo.add(listTodo.size - 1, todo)
                        adapter?.notifyItemMoved(position, listTodo.size - 1)
                    } else {
                        listTodo.removeAt(position)
                        listTodo.add(todo)
                        adapter?.notifyItemMoved(position,0)
                    }
                }

                override fun onTodoClickListener(position: Int, todo: Todo) {
                    val intent = Intent(applicationContext, TodoDescriptionActivity::class.java).apply {
                        putExtra(TITLE_TODO, todo.title)
                        putExtra(DESCRIPTION_TODO,todo.description)
                    }
                    startActivity(intent)
                }
            })
            adapter = mAdapter
        }
    }
}