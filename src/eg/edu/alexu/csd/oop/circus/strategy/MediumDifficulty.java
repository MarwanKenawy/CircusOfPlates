package eg.edu.alexu.csd.oop.circus.strategy;

public class MediumDifficulty implements DifficultyStrategy {
    @Override 
    public int getSpawnInterval(){
        return 100;
    }
    public int getFallSpeed(){
        return 2;
    }
}
