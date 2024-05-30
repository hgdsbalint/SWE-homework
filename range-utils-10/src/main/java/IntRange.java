public class IntRange {
    public static final IntRange EMPTY =
            new IntRange(Integer.MAX_VALUE, Integer.MIN_VALUE);
    private final int min;
    private final int max;

    private IntRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public static IntRange of(int min, int max){
        if(min <= max){

            return new IntRange(min,max);

        }
        else{
            return new IntRange(max,min);
        }
    }

    public boolean isEmpty(){
        return min == Integer.MAX_VALUE && max == Integer.MIN_VALUE;
    }

    public boolean contains(int value){
        return min <= value && value <= max;
    }

    public boolean containsRange(IntRange range){
        return contains(range.min) && contains(range.max);
    }

    public boolean isOverlapping(IntRange range){
        return contains(range.min) || contains(range.max)
                || range.contains(min) || range.contains(max);
    }

    public boolean isDisjoint(IntRange range){
        return !isOverlapping(range);
    }

    public IntRange intersect(IntRange range){
        if(this == range){
            return this;
        }

        if(!isDisjoint(range)){
            return EMPTY;
        }

        return new IntRange(Integer.max(min,range.min), Integer.min(max, range.max));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntRange intRange = (IntRange) o;

        if (min != intRange.min) return false;
        return max == intRange.max;
    }

    @Override
    public int hashCode() {
      int result = 5;
      result = 17 * result + min;
      result = 17 * result + max;
      return result;
    }

    @Override
    public String toString() {
        return isEmpty()
                ? "[EMPTY]"
                :String.format("[%d,%d]", min, max);
    }
}
