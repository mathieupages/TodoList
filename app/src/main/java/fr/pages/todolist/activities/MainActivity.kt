package fr.pages.todolist.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import fr.pages.todolist.adapters.AdapterTodoList
import fr.pages.todolist.data.TodoSource
import fr.pages.todolist.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    /* Create a list of Todo */
    private val listTodo = TodoSource.createDataSet()

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
            adapter = AdapterTodoList(listTodo)
        }
    }
}