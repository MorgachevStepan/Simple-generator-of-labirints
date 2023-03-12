public class GeneratorOfLabirints {

    private final byte SIZEX = 15;
    private final byte SIZEY = 27;
    private final char[][] labirint;
    private boolean flagOfEnd;

    public GeneratorOfLabirints(){
        labirint = new char[SIZEX][SIZEY];
        for(int i = 0; i < SIZEX; i++)
            for(int j = 0; j < SIZEY; j++)
                labirint[i][j] = ' ';
        for(int i = 0; i < SIZEX; i++)
            for(int j = 0; j < SIZEY; j++){
               if((i + 1) % 2 == 1)
                   labirint[i][j] = '|';
               else if((j + 1) % 2 == 1)
                   labirint[i][j] = '|';
            }
        flagOfEnd = false;
    }

    public void showLabirintMatrix(){
        for(int i = 0; i < SIZEX; i++){
            for(int j = 0; j < SIZEY; j++)
                System.out.print(labirint[i][j]);
            System.out.println();
        }
    }

    public void generateLabirint(){
        for(int i = 1; i < SIZEX - 1; i+=2) {
            for (int j = 1; j < SIZEY - 1; j += 2) {
                if (i == 1) {
                    if (j == SIZEY - 2)
                        continue;
                    labirint[i][j + 1] = ' ';
                    continue;
                }
                if ((j) == SIZEY - 2) {
                    labirint[i - 1][j] = ' ';
                    continue;
                }
                int deleteWall = (int) (Math.random() * 2);
                switch (deleteWall) {
                    case (0) -> labirint[i - 1][j] = ' ';
                    case (1) -> labirint[i][j + 1] = ' ';
                }
            }
        }
        this.generateEnd();
    }

    public boolean setElement(int x, int y){
        if(labirint[x][y] == ' ' || labirint[x][y] == '+'){
            if(labirint[x][y] == '+'){
                this.showEnd();
            }
            labirint[x][y] = 'x';
            return true;
        }
        return false;
    }

    private void showEnd() {
        flagOfEnd = true;
    }

    public void deleteElement(int x, int y) {
        labirint[x][y] = ' ';
    }

    public boolean isFlagOfEnd() {
        return flagOfEnd;
    }

    private void generateEnd(){
        for(int j = 15; j > 1; j--)
            if (labirint[13][j - 1] == '|') {
                labirint[13][j] = '+';
                break;
            }
    }
}
