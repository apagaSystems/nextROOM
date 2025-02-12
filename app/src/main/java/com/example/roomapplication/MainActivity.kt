package com.example.roomapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.roomapplication.db.Note
import com.example.roomapplication.db.NoteDatabase
import com.example.roomapplication.ui.theme.RoomApplicationTheme
import com.example.roomapplication.viewModel.CountViewModel
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    private lateinit var noteDatabase: NoteDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        noteDatabase = NoteDatabase.getDatabase(this)


        enableEdgeToEdge()
        setContent {
            RoomApplicationTheme {
//              CountAAAA()
                
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        modifier = Modifier.padding(innerPadding), noteDatabase
//                    )
//                }

            }
        }
    }
}


//@Composable
//fun CountAAAA(modifier: Modifier = Modifier, viewModel:CountViewModel= viewModel) {
//
//        val abc by viewModel.count.observeAsState(0)
//
//
//    Column {
//        Spacer(modifier = Modifier.height(48.dp))
//
//        Text(text = abc.toString())
//        Text(text = "Inc", Modifier.clickable { viewModel.countInc() })
//    }
//}






@Composable
fun Greeting(modifier: Modifier = Modifier, database: NoteDatabase) {
    var text by remember {

        mutableStateOf("")
    }
    var item by remember {
        mutableStateOf(listOf<Note>())
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.Gray
            )
    ) {
        val data by remember {
            mutableStateOf(
                setOf<String>()
            )
        }
        Text(text = text, modifier = modifier.padding(top = 32.dp))

        Button(onClick = {
            val newNote = Note(title = "My Note3", content = "This is a new note.")
            runBlocking {
                database.noteDao().insert(newNote)
                item = database.noteDao().getAllNotes()

            }

        }, modifier = Modifier.width(190.dp)) {
            Text(text = "Save")
        }
        LazyColumn {
            items(item.size) { index ->
                Text("${index}. ${item[index].title}-> ${item[index].content}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    RoomApplicationTheme {
//        Greeting("Android")
    }
}