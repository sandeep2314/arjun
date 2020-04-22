package com.example.myapplication


2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
73
74
75
76
77
78
79
80
81
82
83
84
85
86
87
88
89
90
91
92
93
94
95
96
97
98
99
100
101
102
103
104
105
106
107
108
109
110
111
112
113
114
115
116
117
118
119
120
121
122
123
124
125
126
127
128
129
130
131
132
133
134
135
136
137
138
139
140
141
142
143
144
145
146
147
class Board {

    //Strings for PLAYER and COMPUTER
    companion object {
        const val PLAYER = "O"
        const val COMPUTER = "X"
    }

    //This is our internal board
    //and for this we used a 3 by 3 array of Strings
    val board = Array(3) { arrayOfNulls<String>(3) }

    //This property is giving us
    //a list of all the empty cells
    val availableCells: List<Cell>
        get() {
            val cells = mutableListOf<Cell>()
            for (i in board.indices) {
                for (j in board.indices) {
                    if (board[i][j].isNullOrEmpty()) {
                        cells.add(Cell(i, j))
                    }
                }
            }
            return cells
        }

    //this property will tell
    //if the game is over or not
    val isGameOver: Boolean
        get() = hasComputerWon() || hasPlayerWon() || availableCells.isEmpty()


    //These functions are checking
    //Weather the computer or player has won or not
    fun hasComputerWon(): Boolean {
        if (board[0][0] == board[1][1] &&
                board[0][0] == board[2][2] &&
                board[0][0] == COMPUTER ||
                board[0][2] == board[1][1] &&
                board[0][2] == board[2][0] &&
                board[0][2] == COMPUTER
        ) {
            return true
        }

        for (i in board.indices) {
            if (
                    board[i][0] == board[i][1] &&
                    board[i][0] == board[i][2] &&
                    board[i][0] == COMPUTER ||
                    board[0][i] == board[1][i] &&
                    board[0][i] == board[2][i] &&
                    board[0][i] == COMPUTER
            ) {
                return true
            }
        }

        return false
    }

    fun hasPlayerWon(): Boolean {

        if (board[0][0] == board[1][1] &&
                board[0][0] == board[2][2] &&
                board[0][0] == PLAYER ||
                board[0][2] == board[1][1] &&
                board[0][2] == board[2][0] &&
                board[0][2] == PLAYER
        ) {
            return true
        }

        for (i in board.indices) {
            if (
                    board[i][0] == board[i][1] &&
                    board[i][0] == board[i][2] &&
                    board[i][0] == PLAYER ||
                    board[0][i] == board[1][i] &&
                    board[0][i] == board[2][i] &&
                    board[0][i] == PLAYER
            ) {
                return true
            }
        }

        return false
    }


    //in this var we will store the computersMove
    var computersMove: Cell? = null

    //this is our minimax function to calculate
    //the best move for the computer
    fun minimax(depth: Int, player: String): Int {
        if (hasComputerWon()) return +1
        if (hasPlayerWon()) return -1

        if (availableCells.isEmpty()) return 0

        var min = Integer.MAX_VALUE
        var max = Integer.MIN_VALUE

        for (i in availableCells.indices) {
            val cell = availableCells[i]
            if (player == COMPUTER) {
                placeMove(cell, COMPUTER)
                val currentScore = minimax(depth + 1, PLAYER)
                max = Math.max(currentScore, max)

                if (currentScore >= 0) {
                    if (depth == 0) computersMove = cell
                }

                if (currentScore == 1) {
                    board[cell.i][cell.j] = ""
                    break
                }

                if (i == availableCells.size - 1 && max < 0) {
                    if (depth == 0) computersMove = cell
                }

            } else if (player == PLAYER) {
                placeMove(cell, PLAYER)
                val currentScore = minimax(depth + 1, COMPUTER)
                min = Math.min(currentScore, min)

                if (min == -1) {
                    board[cell.i][cell.j] = ""
                    break
                }
            }
            board[cell.i][cell.j] = ""
        }

        return if (player == COMPUTER) max else min
    }

    //this function is placing a move in the given cell
    fun placeMove(cell: Cell, player: String) {
        board[cell.i][cell.j] = player
    }

}