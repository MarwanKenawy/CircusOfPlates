package eg.edu.alexu.csd.oop.circus.strategy;

public class EasyDifficulty implements DifficultyStrategy {
    @Override 
    public int getSpawnInterval(){
        return 150;
    }
    @Override 
    public int getFallSpeed(){
        return 1;
    }
}
