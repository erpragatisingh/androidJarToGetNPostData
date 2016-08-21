package comviva.mahendra.survey.com.sdktogetdatanpostdata.model;

/**
 * Created by pragati on 8/18/16.
 */
public final class SurveyResponseVO {
    public String getAnswer_one() {
        return answer_one;
    }

    public void setAnswer_one(String answer_one) {
        this.answer_one = answer_one;
    }

    public String getAnswer_two() {
        return answer_two;
    }

    public void setAnswer_two(String answer_two) {
        this.answer_two = answer_two;
    }

    public String getAnswer_three() {
        return answer_three;
    }

    public void setAnswer_three(String answer_three) {
        this.answer_three = answer_three;
    }

    public String getAnswer_four() {
        return answer_four;
    }

    public void setAnswer_four(String answer_four) {
        this.answer_four = answer_four;
    }

    private String   answer_one  ;
    private String   answer_two;
    private String   answer_three;
    private String   answer_four ;

    @Override
    public String toString() {
        return "SurveyResponseVO{" +
                "answer_one='" + answer_one + '\'' +
                ", answer_two='" + answer_two + '\'' +
                ", answer_three='" + answer_three + '\'' +
                ", answer_four='" + answer_four + '\'' +
                '}';
    }
}
