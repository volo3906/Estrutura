# main_maze.py
import time
from maze import Maze
from collections import deque

def solve_maze_backtracking(maze: Maze):
    stack = deque()
    visited = set()

    start = maze.get_init_pos_player()
    stack.append(start)

    while stack:
        current = stack.pop()

        if current in visited:
            continue
        visited.add(current)

        x, y = current

        if maze.find_prize(current):
            print("🏆 Prêmio encontrado na posição:", current)
            return True

        maze.mov_player(current)
        time.sleep(0.05) 

        neighbors = [
            (x-1, y), (x+1, y),
            (x, y-1), (x, y+1)
        ]

        for nx, ny in neighbors:
            if (0 <= nx < maze.M.shape[0] and
                0 <= ny < maze.M.shape[1] and
                maze.is_free((nx, ny)) and
                (nx, ny) not in visited):
                stack.append((nx, ny))

    print("❌ Caminho não encontrado.")
    return False

maze = Maze()
maze.load_from_csv("labirinto1.txt")
maze.run()
maze.init_player()
time.sleep(1) 

solve_maze_backtracking(maze)


