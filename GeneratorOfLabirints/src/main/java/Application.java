public class Application {
    public static void main(String[] args) {
        HeroControl heroControl = new HeroControl();
        while(!heroControl.getLabirint().isFlagOfEnd())
            heroControl.moveHero();
        System.out.println("Вы справились");
    }
}
