package source;

public class Tray
{
    int row, column, current_row, current_column;
    int capacity;
    boolean isFull;

    Tray(int row, int column)
    {
        this.current_row = this.current_column = 0;
        this.row = row;
        this.column = column;
        this.capacity = this.row * this.column;
        this.isFull = false;
    }

}
