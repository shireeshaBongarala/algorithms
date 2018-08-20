package com.fun.learning.Search;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;

public class GridSearch {

  public static void main(String[] args) {
    int[][] inputGrid = new int[][] {
        {1, 2, 3}, {5, 0, 4}
    };

    GridSearch gridSearch = new GridSearch();
    System.out.println(gridSearch.getLevelOf(inputGrid));

  }

  private int getLevelOf(int[][] inputGrid) {
    Queue<Grid> grids = new ArrayDeque<>();
    grids.add(new Grid(inputGrid, 0));
    Grid desiredGrid = new Grid(new int[][]{{1,2, 3}, {4, 5, 0}}, 0);
    while (!grids.isEmpty()){
      Grid currentGrid = grids.poll();
      if(currentGrid.equals(desiredGrid)) return currentGrid.getLevel();
      grids.addAll(getNeighbors(currentGrid));
    }

  }

  private Collection<? extends Grid> getNeighbors(Grid currentGrid) {


      return null;
  }


  private class Grid {
    private int[][] gridState;
    private int level;

     Grid(int[][] gridState, int level) {
      this.gridState = gridState;
      this.level = level;
    }

    public int[][] getGridState() {
      return gridState;
    }

    public void setGridState(int[][] gridState) {
      this.gridState = gridState;
    }

    public int getLevel() {
      return level;
    }

    public void setLevel(int level) {
      this.level = level;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Grid grid = (Grid) o;
      return Arrays.equals(gridState, grid.gridState);
    }

    @Override
    public int hashCode() {
      return Arrays.hashCode(gridState);
    }
  }
}
