package fr.pages.todolist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.pages.todolist.R
import kotlinx.android.synthetic.main.activity_todo_description.*

class TodoDescriptionActivity : AppCompatActivity() {

    /* Used for receive the title to the second activity*/
    val TITLE_TODO = "title"
    /* Used for receive the title to the second activity*/
    val DESCRIPTION_TODO = "description"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_description)

        val titleTodo = intent.getStringExtra(TITLE_TODO)
        val descriptionTodo = intent.getStringExtra(DESCRIPTION_TODO)

        title_todo_description.text = titleTodo
        description_todo_description.text = descriptionTodo


    }
}