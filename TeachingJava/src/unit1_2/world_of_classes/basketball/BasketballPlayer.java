package unit1_2.world_of_classes.basketball;

/**
 * Represents a basketball player
 */
public class BasketballPlayer {
    /* Beneath this comment are the class properties.
        Each property holds an access modifier, type and name (sometimes called 'literal').
        We'll get used to (until further notice) always write `private` as the property's access modifier. */
    private String name;
    private char gender;
    private double height;
    private int age;
    private String nationality;
    private String team;
    private int careerPoints;
    private boolean isInjured;

    /**
     * This is a constructor (sometimes called c'tor) for the `BasketballPlayer` class.
     * It's also called the full c'tor because it receives arguments for all the properties.
     * @param name
     * @param gender
     * @param height
     * @param age
     * @param nationality
     * @param team
     * @param careerPoints
     * @param isInjured
     */
    public BasketballPlayer(String name, char gender, double height, int age, String nationality, String team,
                            int careerPoints, boolean isInjured) {
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.age = age;
        this.nationality = nationality;
        this.team = team;
        this.careerPoints = careerPoints;
        this.isInjured = isInjured;
    }

    /* Setters */
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    /**
     * Updates the player's team.
     * @param team the new team.
     */
    // טענת כניסה: שם הקבוצה החדשה
    // טענת יציאה: עדכון הקבוצה בה משחק השחקן
    public void setTeam(String team) {
        this.team = team;
    }
    public void setCareerPoints(int careerPoints) {
        this.careerPoints = careerPoints;
    }
    public void setIsInjured(boolean isInjured) {
        this.isInjured = isInjured;
    }

    /* Getters */


    /* Other Class Methods */

    /**
     * This method gets information on the player's last game, update his properties and print a message according to
     * his total points scored.
     * @param pointsScored amount of points scored during the previous game.
     * @param isInjured was the player injured during the last game.
     * @return if the player had scored over 1000 during his career.
     */
    // טענת כניסה: כמות הנקודות שהשחקן קלע במשחק האחרון והאם נפצע במהלכו
    // טענת יציאה: עדכון התכונות 'pointsScored' ו-'isInjured'. בנוסף הפעולה מחזירה האם השחקן קלע מעל 1000 נק' במצטבר במהלך הקריירה שלו
    public boolean playGame(int pointsScored, boolean isInjured) {
        this.careerPoints += pointsScored;
        this.isInjured = isInjured;

        return (this.careerPoints > 1000);
    }

    public boolean betterShotThan(BasketballPlayer other) {
        return this.careerPoints > other.careerPoints;
    }
}
