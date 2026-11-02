package eg.edu.alexu.csd.oop.circus.strategy;

public class HardDifficulty implements DifficultyStrategy {
    @Override 
    public int getSpawnInterval(){
        return 60;
    }
    @Override 
    public int getFallSpeed(){
        return 4;
    }
}
