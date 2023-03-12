import java.util.Scanner;

public class HeroControl {
    private Dwarf hero;
    private GeneratorOfLabirints labirint;

    public HeroControl() {
        hero = new Dwarf();
        labirint = new GeneratorOfLabirints();
        labirint.generateLabirint();
        labirint.setElement(1, 1);
        labirint.showLabirintMatrix();
    }

    public void refreshBoard(int x, int y, int x0, int y0){
        if(labirint.setElement(y, x)){
            labirint.deleteElement(y0, x0);
            labirint.showLabirintMatrix();
        }
        else{
            hero.setPointX(x0);
            hero.setPointY(y0);
            System.out.println("Здесь стена!");
        }
    }

    public void moveHero(){
        Scanner scanner = new Scanner(System.in);
        char heroesMove = scanner.next().charAt(0);
        int lastPosX = hero.getPointX();
        int lastPosY = hero.getPointY();
        switch (heroesMove){
            case('w') -> {
                hero.setPointY(hero.getPointY() - 1);
                refreshBoard(hero.getPointX(), hero.getPointY(), lastPosX, lastPosY);
            }
            case('a') -> {
                hero.setPointX(hero.getPointX() - 1);
                refreshBoard(hero.getPointX(), hero.getPointY(), lastPosX, lastPosY);
            }
            case('s') -> {
                hero.setPointY(hero.getPointY() + 1);
                refreshBoard(hero.getPointX(), hero.getPointY(), lastPosX, lastPosY);
            }
            case('d') -> {
                hero.setPointX(hero.getPointX() + 1);
                refreshBoard(hero.getPointX(), hero.getPointY(), lastPosX, lastPosY);
            }
            default -> System.out.println("Wrong enter!");
            }
    }

    public GeneratorOfLabirints getLabirint() {
        return labirint;
    }
}
