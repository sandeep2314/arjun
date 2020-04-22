package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    internal inner class MainActivity
    internal constructor() {

        //Creating a 2D Array of ImageViews
        val boardCells = Array(3)
        run(
        {
            3
        })

        val `fun`: override
        onCreate(savedInstanceState)
        if (Bundle);
        run(
        {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            //calling the function to load our tic tac toe board
            loadBoard()
        })


        /*
         * This function is generating the tic tac toe board
         * */
        val loadBoard: `fun`
        ()
        run(
        {

            val `in`: i
            while (boardCells.indices) {
                run {
                    val `in`: j
                    while (boardCells.indices) {
                        boardCells[i][j] = ImageView(this)
                        if (boardCells[i][j]);
                        layoutParams = GridLayout.LayoutParams().apply
                        run {
                            rowSpec = GridLayout.spec(i)
                            columnSpec = GridLayout.spec(j)
                            width = 250
                            height = 230
                            bottomMargin = 5
                            topMargin = 5
                            leftMargin = 5
                            rightMargin = 5
                        }
                        if (boardCells[i][j]);
                        setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
                        layout_board.addView(boardCells[i][j])
                    }
                }
            }
        })
    }
}
inner class CellClickListener(
        val i: Int,
        val j: Int
) : View.OnClickListener {

    override fun onClick(p0: View?) {
        //here we will code the move
    }


    class MainActivity : AppCompatActivity() {

        //Creating a 2D Array of ImageViews
        private val boardCells = Array(3) { arrayOfNulls<ImageView>(3) }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            //calling the function to load our tic tac toe board
            loadBoard()
        }


        /*
        * This function is generating the tic tac toe board
        * */
        private fun loadBoard() {

            for (i in boardCells.indices) {
                for (j in boardCells.indices) {
                    boardCells[i][j] = ImageView(this)
                    boardCells[i][j]?.layoutParams = GridLayout.LayoutParams().apply {
                        rowSpec = GridLayout.spec(i)
                        columnSpec = GridLayout.spec(j)
                        width = 250
                        height = 230
                        bottomMargin = 5
                        topMargin = 5
                        leftMargin = 5
                        rightMargin = 5
                    }
                    boardCells[i][j]?.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))

                    //attached a click listener to the board
                    boardCells[i][j]?.setOnClickListener(CellClickListener(i, j))

                    layout_board.addView(boardCells[i][j])
                }
            }
        }

        inner class CellClickListener(
                val i: Int,
                val j: Int
        ) : View.OnClickListener {

            override fun onClick(p0: View?) {
                //here we will code the
            }

        }
    }

}


