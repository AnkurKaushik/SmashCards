public class Smashcard {
    //the code for one individual smashcard

    private String tech;
    private Integer reps;

    public Smashcard(String t, Integer r){
        tech = t;
        reps = r;
    }

    String getTech(){
        return tech;
    }
    Integer getReps(){
        return reps;
    }

    void setTech(String newTech)
    {
        tech = newTech;
    }
    void setReps(Integer newReps)
    {
        reps = newReps;
    }


}
