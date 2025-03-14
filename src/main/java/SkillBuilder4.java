
/**
 * SkillBuilder5 is a class for completing the Skill
 * Builder 5 assignment in Java.
 *
 * @author <You>
 * @version 1.0
 */

public class SkillBuilder4 {

    public static final String tChars = "tT";
    public static final String yChars = "yY";

    enum State {
        START_STATE, NEXT_CHARACTER, SUBSTRING_START,  IN_SUBSTRING, SUBSTRING_END
    }


    public static String findTYPattern(String s)
    {
        // replace this line with your code
        State state = State.START_STATE;
        char ch = '\u0000';
        String substring = "";
        int max = s.length();

        for (int len = 0; len < max; len++){
            ch = s.charAt(len);

            if (state == State.START_STATE){

                if (tChars.indexOf(ch) != -1){
                    state = State.SUBSTRING_START;
                    substring += ch;
                }
                else{
                    state = State.NEXT_CHARACTER;
                }

            }

            else if (state == State.NEXT_CHARACTER){
                if (tChars.indexOf(ch) != -1){
                    state = State.SUBSTRING_START;
                    substring += ch;
                }
                else{
                    state = State.NEXT_CHARACTER;
                }
            }

            else if (state == State.SUBSTRING_START){
                if (yChars.indexOf(ch) != -1){
                    state = State.SUBSTRING_END;
                    substring += ch;
                }
                else{
                    state = State.IN_SUBSTRING;
                    substring += ch;
                }
            }

            else if (state == State.IN_SUBSTRING){
                if (yChars.indexOf(ch) != -1){
                    state = State.SUBSTRING_END;
                    substring += ch;
                }
                else{
                    state = State.IN_SUBSTRING;
                    substring += ch;
                }
            }

        }

        if (state != State.SUBSTRING_END){
            return "";
        }

        return substring;

    }
}
