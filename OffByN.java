import java.lang.Math;

public class OffByN implements CharacterComparator{
    private int off;
    
    public OffByN(int n){
        off = n;
    }

    @Override
    public boolean equalChars(char x, char y){
        int comparison = Math.abs(x - y);
        if (comparison == off){
            return true;
        }else{
            return false;
        }
    }
}