package fr.pages.todolist.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.pages.todolist.R
import fr.pages.todolist.TodoClickListener
import fr.pages.todolist.adapters.AdapterTodoList
import fr.pages.todolist.data.TodoSource
import fr.pages.todolist.databinding.ActivityMainBinding
import fr.pages.todolist.fragment.CreateTodoFragment
import fr.pages.todolist.model.Todo
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    /* Create a list of Todo. */
    var listTodo = TodoSource.createDataSet()
    /* Used for send the title to the second activity*/
    private val TITLE_TODO = "title"
    /* Used for send the title to the second activity*/
    private val DESCRIPTION_TODO = "description"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)



        binding.addTodo.setOnClickListener {
            create_todo_container.visibility = View.VISIBLE
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.create_todo_container, CreateTodoFragment.newInstance())
                commit()
            }
            listTodo.clear()
            listTodo = TodoSource.getListTodo()
            list_todo.adapter?.notifyDataSetChanged()
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
                        adapter?.notifyItemMoved(position, 0)
                    }
                }

                override fun onTodoClickListener(position: Int, todo: Todo) {
                    val intent =
                        Intent(applicationContext, TodoDescriptionActivity::class.java).apply {
                            putExtra(TITLE_TODO, todo.title)
                            putExtra(DESCRIPTION_TODO, todo.description)
                        }
                    startActivity(intent)
                }
            })
            adapter = mAdapter
        }
    }
}